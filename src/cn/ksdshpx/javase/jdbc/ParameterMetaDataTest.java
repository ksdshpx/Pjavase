package cn.ksdshpx.javase.jdbc;

import java.sql.*;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2018/9/1
 * Time: 21:55
 * Description:参数元数据
 */
public class ParameterMetaDataTest {
    public static void main(String[] args) {
        String sql = "SELECT * FROM t_account WHERE name = ? AND balance > ?";
        Object[] params = new Object[]{"zhangSan", 30};
        read(sql, params);
    }

    public static void read(String sql, Object[] params) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
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
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                float balance = rs.getFloat("balance");
                System.out.println(id + "--" + name + "--" + balance);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.close(conn, pstmt, rs);
        }
    }
}
