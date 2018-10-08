package cn.ksdshpx.javase.mycollection;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2018/10/8
 * Time: 19:54
 * Description:自定义HashMap
 */
public class MyHashMap {
    public class Node {
        private int hash;
        private Object key;
        private Object value;
        private Node next;
    }

    private Node[] table;//位桶数组
    private int size;

    public MyHashMap() {
        this.table = new Node[16];
    }

    public void put(Object key, Object value) {
        Node newNode = new Node();
        newNode.hash = myHash(key.hashCode(), table.length);
        newNode.key = key;
        newNode.value = value;
        Node tmp = table[newNode.hash];
        if (tmp == null) {
            table[newNode.hash] = newNode;
        } else {

        }
    }

    private int myHash(int h, int length) {
        return h & (length - 1);
    }

    public static void main(String[] args) {
        MyHashMap hashMap = new MyHashMap();
        hashMap.put(10, "aa");
        hashMap.put(20, "bb");
        hashMap.put(30, "cc");
        System.out.println(hashMap);
    }
}
