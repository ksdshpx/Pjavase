package cn.ksdshpx.javase.jdbc;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.*;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2018/8/28
 * Time: 13:31
 * Description:测试DBUtils工具类
 */
public class DBUtilsTest {
    private ComboPooledDataSource dataSource = new ComboPooledDataSource();

    /**
     * 使用QueryRunner完成增加、删除、修改
     *
     * @throws SQLException
     */
    @Test
    public void update() throws SQLException {
        QueryRunner queryRunner = new QueryRunner(dataSource);
        String sql = "INSERT INTO t_stu(sid,sname,age,gender) VALUES(?,?,?,?)";
        Object[] params = {2, "liSi", 28, "female"};
        queryRunner.update(sql, params);
    }

    /**
     * 使用QueryRunner完成查询
     * BeanHandler(单行):将一行记录转换为一个JavaBean
     *
     * @throws SQLException
     */
    @Test
    public void queryByBeanHanlder() throws SQLException {
        QueryRunner queryRunner = new QueryRunner(dataSource);
        String sql = "SELECT * FROM t_stu WHERE sid = ?";
        Object[] params = {2};
        Stu stu = queryRunner.query(sql, new BeanHandler<Stu>(Stu.class), params);
        System.out.println(stu);
    }

    /**
     * 使用QueryRunner完成查询
     * BeanListHandler(多行):将每一行记录转换为一个JavaBean,多行记录就成为了List<JavaBean>
     *
     * @throws SQLException
     */
    @Test
    public void queryByBeanListHanlder() throws SQLException {
        QueryRunner queryRunner = new QueryRunner(dataSource);
        String sql = "SELECT * FROM t_stu";
        List<Stu> beanList = queryRunner.query(sql, new BeanListHandler<Stu>(Stu.class));
        System.out.println(beanList);
    }

    /**
     * 使用QueryRunner完成查询
     * MapHandler(单行):将一行记录转换为一个Map
     *
     * @throws SQLException
     */
    @Test
    public void queryByMapHanlder() throws SQLException {
        QueryRunner queryRunner = new QueryRunner(dataSource);
        String sql = "SELECT * FROM t_stu WHERE sid = ?";
        Object[] params = {2};
        Map stuMap = queryRunner.query(sql, new MapHandler(), params);
        System.out.println(stuMap);
    }

    /**
     * 使用QueryRunner完成查询
     * MapListHandler(多行):将每一行记录转换为一个Map,多行记录就成为了List<Map>
     *
     * @throws SQLException
     */
    @Test
    public void queryByMapListHanlder() throws SQLException {
        QueryRunner queryRunner = new QueryRunner(dataSource);
        String sql = "SELECT * FROM t_stu";
        List<Map<String, Object>> mapList = queryRunner.query(sql, new MapListHandler());
        System.out.println(mapList);
    }

    /**
     * 使用QueryRunner完成查询
     * ScalarHandler(单行单列)
     *
     * @throws SQLException
     */
    @Test
    public void queryByScalarHanlder() throws SQLException {
        QueryRunner queryRunner = new QueryRunner(dataSource);
        String sql = "SELECT count(*) FROM t_stu";
        Object obj = queryRunner.query(sql, new ScalarHandler());
        System.out.println(obj);
    }
}
