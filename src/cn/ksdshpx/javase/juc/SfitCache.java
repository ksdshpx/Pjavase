package cn.ksdshpx.javase.juc;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2018/6/12
 * Time: 15:57
 * Description:java5读写锁的应用-->设计一个缓存系统
 */
public class SfitCache {
    private Map<String, Object> cache = new HashMap<>();
    private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    public Object get(String key) {
        readWriteLock.readLock().lock();
        Object value = cache.get(key);
        try {
            if (value == null) {
                readWriteLock.readLock().unlock();
                readWriteLock.writeLock().lock();
                if (value == null) {
                    System.out.println("从数据库加载数据!");
                    value = "abc";//实际上从数据库取得，这里只是模拟
                    cache.put(key, value);
                }
                readWriteLock.writeLock().unlock();
                readWriteLock.readLock().lock();
            }
        } finally {
            readWriteLock.readLock().unlock();
        }
        return value;
    }

    public static void main(String[] args) {
        SfitCache cache = new SfitCache();
        Object value = cache.get("ccc");
        System.out.println(value);
        System.out.println("--------------");
        Object value2 = cache.get("ccc");
        System.out.println(value2);
    }
}
