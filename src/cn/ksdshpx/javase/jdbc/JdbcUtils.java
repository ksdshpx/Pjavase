package cn.ksdshpx.javase.jdbc;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2018/8/21
 * Time: 19:32
 * Description:JdbcUtils工具类
 */
public final class JdbcUtils {
    private static String driverName;
    private static String url;
    private static String username;
    private static String password;
    private static ComboPooledDataSource dataSource;

    private JdbcUtils() {
    }

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
            dataSource = new ComboPooledDataSource();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("加载驱动失败!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
//        return DriverManager.getConnection(url, username, password);
        return dataSource.getConnection();
    }

    public static void close(Connection conn, Statement stmt, ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                if (stmt != null) {
                    try {
                        stmt.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    } finally {
                        if (conn != null) {
                            try {
                                conn.close();
                            } catch (SQLException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        }
    }

    public static void close(Connection conn, Statement stmt) {
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                if (conn != null) {
                    try {
                        conn.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

}
