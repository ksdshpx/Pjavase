package cn.ksdshpx.javase.jdbc;

import cn.ksdshpx.javase.jdbc.domain.User;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.CallableStatementCallback;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;
import java.util.Map;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2018/9/8
 * Time: 14:29
 * Description:JdbcTemplate测试
 */
public class JdbcTemplateTest {
    private static JdbcTemplate template = new JdbcTemplate(JdbcUtils.getDataSource());

    public static void main(String[] args) throws DataAccessException {
        User user = findUser2("liSi");
        System.out.println(user);
        System.out.println("====================");
        List<User> list = findUsers("3");
        System.out.println(list);
        System.out.println("User Count:" + getUserCount());
        System.out.println("UserName:" + findUserNameById("3"));
        Map<String, Object> map = findUsersForMap("3");
        System.out.println("map:" + map);

        List<Map<String, Object>> mapList = findUsersForMapList("3");
        System.out.println("mapList:" + mapList);

        Stu stu = new Stu();
        stu.setSname("JdbcTemplate");
        stu.setAge(88);
        stu.setGender("male");
        //addStu(stu);
        String stuName = findStuNameById("10001");
        System.out.println("stuName:" + stuName);
    }

    public static User findUser(String username) throws DataAccessException {
        String sql = "SELECT id,name,birthday,money FROM t_useruser WHERE name = ?";
        Object[] params = new Object[]{username};
        User user = template.queryForObject(sql, params, new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet resultSet, int i) throws SQLException {
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setBirthday(resultSet.getDate("birthday"));
                user.setMoney(resultSet.getFloat("money"));
                return user;
            }
        });
        return user;
    }

    public static User findUser2(String username) throws DataAccessException {
        String sql = "SELECT id,name,birthday,money FROM t_useruser WHERE name = ?";
        Object[] params = new Object[]{username};
        User user = template.queryForObject(sql, params, new BeanPropertyRowMapper<>(User.class));
        return user;
    }

    public static List<User> findUsers(String id) throws DataAccessException {
        String sql = "SELECT id,name,birthday,money FROM t_useruser WHERE id < ?";
        Object[] params = new Object[]{id};
        List<User> list = template.query(sql, params, new BeanPropertyRowMapper<>(User.class));
        return list;
    }

    public static int getUserCount() {
        String sql = "SELECT COUNT(*) FROM t_useruser";
        return template.queryForObject(sql, Integer.class);
    }

    public static String findUserNameById(String id) throws DataAccessException {
        String sql = "SELECT name FROM t_useruser WHERE id = ?";
        Object[] params = new Object[]{id};
        return template.queryForObject(sql, params, String.class);
    }

    public static Map<String, Object> findUsersForMap(String id) {
        String sql = "SELECT id,name,birthday,money FROM t_useruser WHERE id = ?";
        Object[] params = new Object[]{id};
        Map<String, Object> map = template.queryForMap(sql, params);
        return map;
    }

    public static List<Map<String, Object>> findUsersForMapList(String id) {
        String sql = "SELECT id,name,birthday,money FROM t_useruser WHERE id < ?";
        Object[] params = new Object[]{id};
        List<Map<String, Object>> maps = template.queryForList(sql, params);
        return maps;
    }

    public static void addStu(final Stu stu) {
        String callSql = "{call addStu(?,?,?,?)}";
        template.execute(callSql, new CallableStatementCallback<Object>() {
            @Override
            public Object doInCallableStatement(CallableStatement callableStatement) throws SQLException, DataAccessException {
                callableStatement.registerOutParameter(1, Types.INTEGER);
                callableStatement.setString(2, stu.getSname());
                callableStatement.setInt(3, stu.getAge());
                callableStatement.setString(4, stu.getGender());
                callableStatement.executeUpdate();
                return null;
            }
        });
    }

    public static String findStuNameById(final String id) {
        String callSql = "{call findStuNameById(?,?)}";
        String stuName = template.execute(callSql, new CallableStatementCallback<String>() {
            @Override
            public String doInCallableStatement(CallableStatement callableStatement) throws SQLException, DataAccessException {
                callableStatement.setString(1, id);
                callableStatement.registerOutParameter(2, Types.VARCHAR);
                callableStatement.execute();
                return callableStatement.getString(2);
            }
        });
        return stuName;
    }
}
