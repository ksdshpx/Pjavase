package cn.ksdshpx.javase.jdbc.dao;

import cn.ksdshpx.javase.jdbc.domain.Account;

import java.sql.Connection;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2018/8/26
 * Time: 10:32
 * Description:AccountDao接口
 */
public interface AccountDao {
    public abstract void updateBalance(Connection conn,Account account, int money);
    public abstract void updateBalanceByThreadLocal(Account account, int money);
    public abstract Account findAccountById(Connection conn,Integer id);
}
