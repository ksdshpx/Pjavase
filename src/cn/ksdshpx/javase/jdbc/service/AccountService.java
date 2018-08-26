package cn.ksdshpx.javase.jdbc.service;

import cn.ksdshpx.javase.jdbc.JdbcUtils;
import cn.ksdshpx.javase.jdbc.dao.AccountDao;
import cn.ksdshpx.javase.jdbc.dao.impl.AccountDaoImpl;
import cn.ksdshpx.javase.jdbc.domain.Account;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2018/8/26
 * Time: 10:42
 * Description:AccountService类
 */
public class AccountService {
    private AccountDao accountDao = new AccountDaoImpl();

    /**
     * 银行转账
     *
     * @param from
     * @param to
     * @param money
     */
    public void zhuanZhang(Account from, Account to, int money) {
        Connection conn = null;
        try {
            conn = JdbcUtils.getConnection();
            //开启事务
            conn.setAutoCommit(false);
            accountDao.updateBalance(conn, from, -money);
            Account account = accountDao.findAccountById(conn, from.getId());
            if (account.getBalance() <= 60) {
                throw new Exception("余额必须大于60才能转账！");
            }
            accountDao.updateBalance(conn, to, money);
            //提交事务
            conn.commit();
        } catch (Exception e) {
            //事务回滚
            try {
                conn.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            throw new RuntimeException(e);
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
