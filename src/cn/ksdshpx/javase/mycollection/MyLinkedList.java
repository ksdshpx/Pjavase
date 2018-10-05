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
        size++;
    }

    public Object get(int index) {
        checkIndex(index);
        Node tmp = getNode(index);
        return tmp != null ? tmp.data : null;
    }

    private void checkIndex(int index) {
        if (index < 0 || index > size - 1) {
            throw new RuntimeException("索引值不合法:" + index);
        }
    }

    private Node getNode(int index) {
        Node tmp = null;
        if (index <= (size >> 1)) {
            tmp = first;
            for (int i = 0; i < index; i++) {
                tmp = tmp.next;
            }
        } else {
            tmp = last;
            for (int i = size - 1; i > index; i++) {
                tmp = tmp.previous;
            }
        }
        return tmp;
    }

    public void remove(int index) {
        checkIndex(index);
        Node removeNode = getNode(index);
        Node preNode = removeNode.previous;
        Node nextNode = removeNode.next;
        if (preNode != null) {
            preNode.next = nextNode;
        } else {
            first = nextNode;
        }
        if (nextNode != null) {
            nextNode.previous = preNode;
        } else {
            last = preNode;
        }
        size--;
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
        linkedList.add("d");
        linkedList.add("e");
        linkedList.add("f");
        System.out.println(linkedList);
        System.out.println(linkedList.get(5));
        linkedList.remove(3);
        System.out.println(linkedList);
        linkedList.remove(0);
        System.out.println(linkedList);
        linkedList.remove(3);
        System.out.println(linkedList);
    }
}
