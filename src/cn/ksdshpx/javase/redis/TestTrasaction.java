package cn.ksdshpx.javase.redis;

import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2018/7/17
 * Time: 14:11
 * Description:测试Redis事务
 */
public class TestTrasaction {
    @Test
    public void test() {
        Jedis jedis = new Jedis("192.168.190.130", 6379);
        Transaction transaction = jedis.multi();
        transaction.set("k4", "v44");
        transaction.set("k5", "v55");
//        transaction.exec();
        transaction.discard();
    }

    @Test
    public void test2() {
        Jedis jedis = new Jedis("192.168.190.130", 6379);
        int balance;//可用余额
        int debt;//欠款
        int costMoney = 10;//消费金额
        jedis.watch("balance");
        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        balance = Integer.parseInt(jedis.get("balance"));
        debt = Integer.parseInt(jedis.get("debt"));
        if (balance < costMoney) {
            jedis.unwatch();
            System.out.println("modify");
        }else{
            Transaction transaction = jedis.multi();
            transaction.decrBy("balance",costMoney);
            transaction.incrBy("debt",costMoney);
            transaction.exec();
        }
    }
}
