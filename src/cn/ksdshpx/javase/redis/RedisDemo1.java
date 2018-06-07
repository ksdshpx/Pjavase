package cn.ksdshpx.javase.redis;

import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2018/6/7
 * Time: 12:14
 * Description:java操作Redis
 */
public class RedisDemo1 {
    /**
     * 单实例连接redis数据库
     */
    @Test
    public void test() {
        Jedis jedis = new Jedis("192.168.190.130", 6379);
        //jedis.set("company","sfit");
        String value = jedis.get("company");
        System.out.println("company:" + value);
    }

    /**
     * jedis连接池连接redis数据库
     */
    @Test
    public void test2() {
        //获取连接池配置对象,并设置相关的参数
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxIdle(10);
        //获取连接池对象
        JedisPool jedisPool = new JedisPool(config, "192.168.190.130", 6379);
        //获取Jedis对象
        Jedis jedis = jedisPool.getResource();
        jedis.set("address", "上海");
        String value = jedis.get("address");
        System.out.println("address:" + value);
    }

    /**
     * 使用JedisUtils工具类操作连接池连接redis数据库
     */
    @Test
    public void test3() {
        //获取Jedis对象
        Jedis jedis = JedisUtils.getJedis();
        jedis.set("road", "乐昌路");
        String value = jedis.get("road");
        System.out.println("road:" + value);
    }
}
