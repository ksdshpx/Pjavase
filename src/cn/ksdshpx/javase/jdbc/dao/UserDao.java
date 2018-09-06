package cn.ksdshpx.javase.jdbc.dao;

import cn.ksdshpx.javase.jdbc.domain.User;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2018/8/24
 * Time: 10:46
 * Description:Dao层
 */
public interface UserDao {
    public abstract void add(User user);

    public abstract User getUser(String id);

    public abstract User findUser(String username, String password);

    public abstract int update(User user);

    public abstract int delete(User user);
}
