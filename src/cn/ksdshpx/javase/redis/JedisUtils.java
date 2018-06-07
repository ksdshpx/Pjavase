package cn.ksdshpx.javase.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2018/6/7
 * Time: 14:07
 * Description:Jedis工具类
 */
public class JedisUtils {
    private static final JedisPool POOL;

    static {
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxIdle(10);
        POOL = new JedisPool(config, "192.168.190.130", 6379);
    }

    public static Jedis getJedis(){
        return POOL.getResource();
    }

}
