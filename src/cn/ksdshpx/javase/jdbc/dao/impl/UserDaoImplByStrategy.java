package cn.ksdshpx.javase.jdbc.dao.impl;

import cn.ksdshpx.javase.jdbc.dao.UserDao;
import cn.ksdshpx.javase.jdbc.dao.impl.refactor.MyDaoTemplate;
import cn.ksdshpx.javase.jdbc.dao.impl.refactor.RowMapper;
import cn.ksdshpx.javase.jdbc.domain.User;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2018/8/24
 * Time: 10:49
 * Description:使用策略模式对模板方法模式进行改进
 */
public class UserDaoImplByStrategy implements UserDao{
    private MyDaoTemplate template = new MyDaoTemplate();
    @Override
    public void add(User user) {

    }

    @Override
    public User getUser(String id) {
        return null;
    }

    @Override
    public User findUser(String username, String password) {
        String sql = "SELECT id,name,birthday,money FROM t_useruser WHERE name = ?";
        Object[] params = new Object[]{username};
        User user = (User) this.template.find(sql, params, new RowMapper() {
            @Override
            public Object mapRow(ResultSet rs) throws SQLException {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setBirthday(rs.getDate("birthday"));
                user.setMoney(rs.getFloat("money"));
                return user;
            }
        });
        return user;
    }

    @Override
    public String findUserName(String id) {
        String sql = "SELECT nameFROM t_useruser WHERE id = ?";
        Object[] params = new Object[]{id};
        String username = (String)this.template.find(sql, params, new RowMapper() {
            @Override
            public Object mapRow(ResultSet rs) throws SQLException {
                return rs.getString("name");
            }
        });
        return username;
    }

    @Override
    public int update(User user) {
        return 0;
    }

    @Override
    public int delete(User user) {
        return 0;
    }
}
