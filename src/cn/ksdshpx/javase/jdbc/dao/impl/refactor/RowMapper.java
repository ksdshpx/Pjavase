package cn.ksdshpx.javase.jdbc.dao.impl.refactor;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2018/9/7
 * Time: 10:24
 * Description:行映射器
 */
public interface RowMapper {
    public abstract Object mapRow(ResultSet rs) throws SQLException;
}
