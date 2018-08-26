package cn.ksdshpx.javase.jdbc.dao.impl;

import cn.ksdshpx.javase.jdbc.Exception.DaoException;
import cn.ksdshpx.javase.jdbc.dao.AccountDao;
import cn.ksdshpx.javase.jdbc.domain.Account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2018/8/26
 * Time: 10:34
 * Description:AccountDao实现类
 */
public class AccountDaoImpl implements AccountDao {
    @Override
    public void updateBalance(Connection conn, Account account, int money) {
        PreparedStatement pstmt = null;
        try {
            String sql = "UPDATE t_account SET balance = balance + ? WHERE name = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, money);
            pstmt.setString(2, account.getName());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException(e.getMessage(), e);
        } finally {
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public Account findAccountById(Connection conn, Integer id) {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Account account = null;
        try {
            String sql = "SELECT id,name,balance FROM t_account WHERE id = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();
            account = new Account();
            while (rs.next()) {
                account.setId(rs.getInt("id"));
                account.setName(rs.getString("name"));
                account.setBalance(rs.getFloat("balance"));
            }
        } catch (SQLException e) {
            throw new DaoException(e.getMessage(), e);
        } finally {
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return account;
    }
}
