package cn.ksdshpx.javase.jdbc.dao.impl;

import cn.ksdshpx.javase.jdbc.Exception.DaoException;
import cn.ksdshpx.javase.jdbc.JdbcUtils;
import cn.ksdshpx.javase.jdbc.dao.UserDao;
import cn.ksdshpx.javase.jdbc.dao.impl.refactor.AbstractDao;
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
public class UserDaoImpl extends AbstractDao implements UserDao {
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
    public int delete(User user) {
        String sql = "DELETE FROM t_useruser WHERE id = ?";
        Object[] params = new Object[]{user.getId()};
        return super.update(sql, params);
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
    public User findUser(String username, String password) {
        String sql = "SELECT id,name,birthday,money FROM t_useruser WHERE name = ?";
        Object[] params = new Object[]{username};
        return (User) super.find(sql, params);
    }

    @Override
    public int update(User user) {
        String sql = "UPDATE t_useruser SET name = ?,birthday = ?,money = ? WHERE id = ?";
        Object[] params = new Object[]{user.getName(), user.getBirthday(), user.getMoney(), user.getId()};
        return super.update(sql, params);
    }

    private void mappingUser(ResultSet rs, User user) throws SQLException {
        user.setId(rs.getInt("id"));
        user.setName(rs.getString("name"));
        user.setBirthday(rs.getDate("birthday"));
        user.setMoney(rs.getFloat("money"));
    }

    @Override
    protected Object rowMapping(ResultSet rs) throws SQLException {
        User user = new User();
        user.setId(rs.getInt("id"));
        user.setName(rs.getString("name"));
        user.setBirthday(rs.getDate("birthday"));
        user.setMoney(rs.getFloat("money"));
        return user;
    }
}
