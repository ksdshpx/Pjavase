package cn.ksdshpx.javase.redis;

import redis.clients.jedis.Jedis;

import java.util.Iterator;
import java.util.Set;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2018/7/15
 * Time: 22:17
 * Description:测试Jedis的API
 */
public class TestJedisAPI {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("192.168.190.130",6379);
        jedis.set("k1","v1");
        jedis.set("k2","v2");
        jedis.set("k3","v3");
        System.out.println(jedis.get("k3"));
        Set<String> keysSet = jedis.keys("*");
        for(Iterator<String> iterator = keysSet.iterator();iterator.hasNext();){
            System.out.println(iterator.next());
        }
    }
}
