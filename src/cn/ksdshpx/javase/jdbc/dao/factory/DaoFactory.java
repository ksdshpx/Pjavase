package cn.ksdshpx.javase.jdbc.dao.factory;

import cn.ksdshpx.javase.jdbc.dao.UserDao;

import java.io.InputStream;
import java.util.Properties;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2018/8/24
 * Time: 20:29
 * Description:Dao工厂模式
 */
public class DaoFactory {
    private DaoFactory() {

    }

    private static DaoFactory instance = new DaoFactory();
    private static Properties props;
    private static UserDao userDao;

    public static DaoFactory getInstance() {
        return instance;
    }

    static {
        try {
            InputStream in = DaoFactory.class.getClassLoader().getResourceAsStream("daoconfig.properties");
            props = new Properties();
            props.load(in);
            String userDaoClass = props.getProperty("userDaoClass");
            Class clazz = Class.forName(userDaoClass);
            userDao = (UserDao) clazz.newInstance();
        } catch (Exception e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    public UserDao getUserDao() {
        return userDao;
    }
}
