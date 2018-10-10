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

    public Object get(Object key) {
        Object value = null;
        int hash = myHash(key.hashCode(), table.length);
        Node node = table[hash];
        while (node != null) {
            if(node.key.equals(key)){
                value = node.value;
                break;
            }else{
                node = node.next;
            }
        }
        return value;
    }

    public void put(Object key, Object value) {
        Node newNode = new Node();
        newNode.hash = myHash(key.hashCode(), table.length);
        newNode.key = key;
        newNode.value = value;
        Node tmp = table[newNode.hash];
        Node lastNode = null;
        boolean keyRepeated = false;
        if (tmp == null) {//数组元素为空，直接将新节点放进去
            table[newNode.hash] = newNode;
        } else {//数组元素不为空，遍历对应链表
            while (tmp != null) {
                if (tmp.key.equals(key)) {//键重复，需要覆盖
                    keyRepeated = true;
                    tmp.value = value;
                    break;
                } else {//键不重复
                    lastNode = tmp;
                    tmp = tmp.next;
                }
            }
            if (!keyRepeated) {
                lastNode.next = newNode;
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("{");
        for (int i = 0; i < table.length; i++) {
            Node node = table[i];
            while (node != null) {
                stringBuilder.append(node.key + ":" + node.value + ",");
                node = node.next;
            }
        }
        stringBuilder.setCharAt(stringBuilder.length() - 1, '}');
        return stringBuilder.toString();
    }

    private int myHash(int h, int length) {
        return h & (length - 1);
    }

    public static void main(String[] args) {
        MyHashMap hashMap = new MyHashMap();
        hashMap.put(10, "aa");
        hashMap.put(20, "bb");
        hashMap.put(30, "cc");
        hashMap.put(20, "ddyy");
        hashMap.put(53, "gg");
        hashMap.put(69, "ff");
        hashMap.put(85, "ee");
        System.out.println(hashMap);
        System.out.println(hashMap.get(20));
    }
}
