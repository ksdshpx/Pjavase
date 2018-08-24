package cn.ksdshpx.javase.jdbc.dao.impl;

import cn.ksdshpx.javase.jdbc.Exception.DaoException;
import cn.ksdshpx.javase.jdbc.JdbcUtils;
import cn.ksdshpx.javase.jdbc.dao.UserDao;
import cn.ksdshpx.javase.jdbc.domain.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2018/8/24
 * Time: 10:49
 * Description:Dao层实现
 */
public class UserDaoImpl implements UserDao {
    @Override
    public void add(User user) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = JdbcUtils.getConnection();
            String sql = "INSERT INTO t_useruser(name,birthday,money) VALUES(?,?,?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, user.getName());
            pstmt.setDate(2, new java.sql.Date(user.getBirthday().getTime()));
            pstmt.setFloat(3, user.getMoney());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException(e.getMessage(), e);
        } finally {
            JdbcUtils.close(conn, pstmt, rs);
        }
    }

    @Override
    public void delete(User user) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = JdbcUtils.getConnection();
            String sql = "DELETE FROM t_useruser WHERE id = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, user.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException(e.getMessage(), e);
        } finally {
            JdbcUtils.close(conn, pstmt, rs);
        }
    }

    @Override
    public User getUser(String id) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        User user = null;
        try {
            conn = JdbcUtils.getConnection();
            String sql = "SELECT id,name,birthday,money FROM t_useruser WHERE id = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, Integer.parseInt(id));
            rs = pstmt.executeQuery();
            user = new User();
            while (rs.next()) {
                mappingUser(rs, user);
            }
        } catch (SQLException e) {
            throw new DaoException(e.getMessage(), e);
        } finally {
            JdbcUtils.close(conn, pstmt, rs);
        }
        return user;
    }

    @Override
    public User login(String username, String password) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        User user = null;
        try {
            conn = JdbcUtils.getConnection();
            String sql = "SELECT id,name,birthday,money FROM t_useruser WHERE name = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, username);
            rs = pstmt.executeQuery();
            user = new User();
            while (rs.next()) {
                mappingUser(rs, user);
            }
        } catch (SQLException e) {
            throw new DaoException(e.getMessage(), e);
        } finally {
            JdbcUtils.close(conn, pstmt, rs);
        }
        return user;
    }

    @Override
    public void update(User user) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = JdbcUtils.getConnection();
            String sql = "UPDATE t_useruser SET name = ?,birthday = ?,money = ? WHERE id = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, user.getName());
            pstmt.setDate(2, new java.sql.Date(user.getBirthday().getTime()));
            pstmt.setFloat(3, user.getMoney());
            pstmt.setInt(4, user.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException(e.getMessage(), e);
        } finally {
            JdbcUtils.close(conn, pstmt, rs);
        }
    }

    private void mappingUser(ResultSet rs, User user) throws SQLException {
        user.setId(rs.getInt("id"));
        user.setName(rs.getString("name"));
        user.setBirthday(rs.getDate("birthday"));
        user.setMoney(rs.getFloat("money"));
    }
}
