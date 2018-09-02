import cn.ksdshpx.javase.jdbc.JdbcUtils;
import cn.ksdshpx.javase.jdbc.domain.Account;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.*;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2018/9/2
 * Time: 14:54
 * Description:结果集元数据
 */
public class ResultSetMetaDataTest {
    public static void main(String[] args) {
        String sql = "SELECT id as Id,name as Name,balance as Balance FROM t_account WHERE name = ? AND balance > ?";
        Object[] params = new Object[]{"zhangSan", 30};
        Account account = read(sql, params, Account.class);
        System.out.println(account);
    }

    public static <T> T read(String sql, Object[] params, Class<T> clazz) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        T t = null;
        try {
            conn = JdbcUtils.getConnection();
            pstmt = conn.prepareStatement(sql);
            ParameterMetaData parameterMetaData = pstmt.getParameterMetaData();
            int parameterCount = parameterMetaData.getParameterCount();
            for (int i = 1; i <= parameterCount; i++) {
//                System.out.println(parameterMetaData.getParameterClassName(i));
//                System.out.println(parameterMetaData.getParameterType(i));
//                System.out.println(parameterMetaData.getParameterTypeName(i));
                pstmt.setObject(i, params[i - 1]);
            }
            rs = pstmt.executeQuery();
            ResultSetMetaData rsMetaData = rs.getMetaData();
            Method[] methods = clazz.getMethods();
            if (rs.next()) {
                t = clazz.newInstance();
                int columnCount = rsMetaData.getColumnCount();
                for (int i = 1; i <= columnCount; i++) {
//                    System.out.print(rsMetaData.getColumnClassName(i) + "\t");
//                    System.out.print(rsMetaData.getColumnName(i) + "\t");
//                    System.out.println(rsMetaData.getColumnLabel(i));
                    String methodName = "set" + rsMetaData.getColumnLabel(i);
                    for (Method method : methods) {
                        if (methodName.equals(method.getName())) {
                            method.invoke(t, rs.getObject(rsMetaData.getColumnLabel(i)));
                        }
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.close(conn, pstmt, rs);
        }
        return t;
    }
}
