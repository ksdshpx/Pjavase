package cn.ksdshpx.javase.jdbc;

import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2018/8/25
 * Time: 9:50
 * Description:批处理
 */
public class BatchTest {
    @Test
    public void testBatch() {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = JdbcUtils.getConnection();
            String sql = "insert into t_stu(sid,sname,age,gender) values(?,?,?,?)";
            pstmt = conn.prepareStatement(sql);
            //使用批处理插入10000条数据
            for (int i = 0; i < 10000; i++) {
                pstmt.setInt(1, i + 1);
                pstmt.setString(2, "stu_" + (i + 1));
                pstmt.setInt(3, i + 1);
                pstmt.setString(4, i % 2 == 0 ? "男" : "女");
                pstmt.addBatch();
            }
            long startTime = System.currentTimeMillis();
            pstmt.executeBatch();
            long endTime = System.currentTimeMillis();
            System.out.println("costs:" + (endTime - startTime));//22599-->158
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.close(conn, pstmt, rs);
        }
    }
}
