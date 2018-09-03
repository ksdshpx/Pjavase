package cn.ksdshpx.javase.jdbc;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.Properties;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2018/9/3
 * Time: 13:45
 * Description:自定义数据库连接池
 */
public class MyConnectionPool {
    private static String driverName;
    private static String url;
    private static String username;
    private static String password;
    private static int initSize = 5;
    private static int maxSize = 10;
    private static int currSize = 0;
    private static LinkedList<Connection> connectionsPool;

    static {
        try {
            //加载db.properties的参数信息
            Properties prop = new Properties();
            InputStream in = JdbcUtils.class.getClassLoader().getResourceAsStream("db.properties");
            prop.load(in);
            driverName = prop.getProperty("driverName");
            url = prop.getProperty("url");
            username = prop.getProperty("username");
            password = prop.getProperty("password");
            //加载驱动(只需要加载一次，所以放在静态代码块中)
            Class.forName(driverName);
            connectionsPool = new LinkedList<>();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("加载驱动失败!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public MyConnectionPool() {
        try {
            for (int i = 0; i < initSize; i++) {
                connectionsPool.addLast(createConnection());
            }
        } catch (SQLException e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    public Connection createConnection() throws SQLException {
        currSize++;
        return DriverManager.getConnection(url, username, password);
    }

    public Connection getConnection() throws SQLException {
        synchronized (connectionsPool) {
            if (currSize < maxSize) {
                if (connectionsPool.size() > 0) {
                    return connectionsPool.removeFirst();
                } else {
                    return createConnection();
                }
            }
            throw new SQLException("连接已经使用完毕！");
        }
    }

    public void freeConnection(Connection conn) {
        connectionsPool.addLast(conn);
    }

    public static void main(String[] args) throws SQLException {
        MyConnectionPool pool = new MyConnectionPool();
        for (int i = 0; i < 30; i++) {
            Connection conn = pool.getConnection();
            System.out.println(conn);
            pool.freeConnection(conn);
        }
    }
}
