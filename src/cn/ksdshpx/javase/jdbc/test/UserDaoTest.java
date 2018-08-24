package cn.ksdshpx.javase.jdbc.test;

import cn.ksdshpx.javase.jdbc.dao.UserDao;
import cn.ksdshpx.javase.jdbc.dao.impl.UserDaoImpl;
import cn.ksdshpx.javase.jdbc.domain.User;
import org.junit.Test;

import java.util.Date;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2018/8/24
 * Time: 14:31
 * Description:UserDao测试类
 */
public class UserDaoTest {
    private UserDao userDao = new UserDaoImpl();

    @Test
    public void testCreate() {
        User user = new User();
        user.setName("zhangSan");
        user.setBirthday(new Date());
        user.setMoney(18000.0f);
        userDao.add(user);
    }

    @Test
    public void testGetUser() {
        User user = userDao.getUser("1");
        System.out.println(user);
    }

    @Test
    public void testLogin() {
        User user = userDao.login("zhangSan", null);
        System.out.println(user);
    }

    @Test
    public void testUpdate() {
        User user = userDao.getUser("1");
        user.setMoney(20000.0f);
        userDao.update(user);
    }

    @Test
    public void testDelete() {
        User user = userDao.getUser("1");
        userDao.delete(user);
    }
}
