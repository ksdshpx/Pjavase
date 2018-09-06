package cn.ksdshpx.javase.jdbc.dao.impl.refactor;

import cn.ksdshpx.javase.jdbc.Exception.DaoException;
import cn.ksdshpx.javase.jdbc.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2018/9/6
 * Time: 13:58
 * Description:抽象Dao类
 */
public abstract class AbstractDao {
    public int update(String sql, Object[] params) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = JdbcUtils.getConnection();
            pstmt = conn.prepareStatement(sql);
            for (int i = 0; i < params.length; i++) {
                pstmt.setObject(i + 1, params[i]);
            }
            return pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException(e.getMessage(), e);
        } finally {
            JdbcUtils.close(conn, pstmt, rs);
        }
    }
}
