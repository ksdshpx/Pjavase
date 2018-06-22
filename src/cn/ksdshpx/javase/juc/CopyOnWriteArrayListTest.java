package cn.ksdshpx.javase.juc;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2018/6/22
 * Time: 16:11
 * Description:CopyOnWriteArrayList类
 *              写入并复制，适合大量遍历，少量写入的情况
 */
public class CopyOnWriteArrayListTest {
    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newCachedThreadPool();
        //Collection<String> list = Collections.synchronizedCollection(new ArrayList<>());//ConcurrentModificationException
        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();
        list.add("AAA");
        list.add("BBB");
        list.add("CCC");
        for (int i = 0; i < 2; i++) {
            threadPool.execute(new Runnable() {
                @Override
                public void run() {
                    Iterator<String> iterator = list.iterator();
                    while (iterator.hasNext()){
                        System.out.println(iterator.next());
                        list.add("AAA");
                    }
                }
            });
        }
        threadPool.shutdown();
    }
}
