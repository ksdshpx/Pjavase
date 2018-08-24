package cn.ksdshpx.javase.jdbc.service;

import cn.ksdshpx.javase.jdbc.dao.UserDao;
import cn.ksdshpx.javase.jdbc.dao.factory.DaoFactory;
import cn.ksdshpx.javase.jdbc.domain.User;

import java.util.Date;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2018/8/24
 * Time: 13:40
 * Description:UserService层代码
 */
public class UserService {
    private UserDao userDao = DaoFactory.getInstance().getUserDao();

    public void regist(User user) {
        userDao.add(user);
    }

    public static void main(String[] args) {
        User user = new User();
        user.setName("liSi");
        user.setBirthday(new Date());
        user.setMoney(21000.0f);
        new UserService().regist(user);
    }
}
