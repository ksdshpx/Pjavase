package cn.ksdshpx.javase.day1617;

import java.util.LinkedList;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2018/7/12
 * Time: 10:51
 * Description:使用LinkedList模拟队列
 * 队列(FIFO)：First In First Out
 */
public class MyQueue {
    private LinkedList linkedList;

    public MyQueue(LinkedList linkedList) {
        this.linkedList = linkedList;
    }

    /**
     * 添加元素
     *
     * @param obj
     */
    public void add(Object obj) {
        linkedList.addFirst(obj);
    }

    /**
     * 获取元素
     *
     * @return
     */
    public Object get() {
        return linkedList.removeLast();
    }

    public boolean isEmpty(){
        return linkedList.isEmpty();
    }
}
