package cn.ksdshpx.javase.redis;

import redis.clients.jedis.Jedis;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2018/7/15
 * Time: 22:14
 * Description:测试Jedis连通性
 */
public class TestPing {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("192.168.190.130", 6379);
        System.out.println(jedis.ping());
    }
}
