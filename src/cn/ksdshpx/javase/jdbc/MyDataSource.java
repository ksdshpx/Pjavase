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
public class MyDataSource {
    private static String driverName;
    private static String url;
    private static String username;
    private static String password;
    private static int initSize = 1;
    private static int maxSize = 1;
    int currSize = 0;
    LinkedList<Connection> connectionsPool;

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
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("加载驱动失败!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public MyDataSource() {
        try {
            connectionsPool = new LinkedList<>();
            for (int i = 0; i < initSize; i++) {
                connectionsPool.addLast(createConnection());
            }
        } catch (SQLException e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    public Connection createConnection() throws SQLException {
        currSize++;
        Connection realConnection = DriverManager.getConnection(url, username, password);
        MyConnection myConnection = new MyConnection(this, realConnection);
        return myConnection;
    }

    public Connection getConnection() throws SQLException {
        synchronized (connectionsPool) {
            if (currSize <= maxSize) {
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
        for (int i = 0; i < 30; i++) {
            Connection conn = MyJdbcUtils.getConnection();
            System.out.println(conn);
            conn.close();
        }
    }
}
