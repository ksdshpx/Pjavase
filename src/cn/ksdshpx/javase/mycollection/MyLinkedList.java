package cn.ksdshpx.javase.mycollection;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2018/10/1
 * Time: 11:57
 * Description:自定义LinkedList
 */
public class MyLinkedList {
    public class Node {
        private Node previous;
        private Object data;
        private Node next;

        public Node() {

        }

        public Node(Object data) {
            this.data = data;
        }
    }

    private Node first;
    private Node last;
    private int size;

    public void add(Object data) {
        Node node = new Node(data);
        if (first == null) {//第一次添加
            first = node;
            last = node;
        } else {
            node.previous = last;
            node.next = null;
            last.next = node;
            last = node;
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("[");
        Node tmp = this.first;
        while (tmp.next != null) {
            stringBuilder.append(tmp.data + ",");
            tmp = tmp.next;
        }
        stringBuilder.append(this.last.data);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.add("a");
        linkedList.add("b");
        linkedList.add("c");
        System.out.println(linkedList);
    }
}
