package cn.ksdshpx.javase.mycollection;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2018/10/1
 * Time: 11:57
 * Description:自定义LinkedList
 */
public class MyLinkedList<E> {
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

    public void add(E element) {
        Node node = new Node(element);
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

    public void insert(int index, E element) {
        if (index < 0 || index > size) {
            throw new RuntimeException("索引值不合法:" + index);
        }
        Node newNode = new Node(element);
        Node nextNode = getNode(index);
        Node preNode = nextNode.previous;
        if (index == size) {
            preNode = getNode(index - 1);
            last = newNode;
            preNode.next = newNode;
            newNode.previous = preNode;
        } else {
            if (preNode != null) {
                preNode.next = newNode;
                newNode.previous = preNode;
                newNode.next = nextNode;
                nextNode.previous = newNode;
            } else {
                first = newNode;
                newNode.next = nextNode;
                nextNode.previous = newNode;
            }
        }
        size++;
    }

    public E get(int index) {
        checkIndex(index);
        Node tmp = getNode(index);
        return tmp != null ? (E) tmp.data : null;
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
        linkedList.insert(1, "中国");
        System.out.println(linkedList);
        linkedList.insert(0, "编程");
        System.out.println(linkedList);
        linkedList.insert(5, "上期技术");
        System.out.println(linkedList);
        linkedList.insert(5, "中金所");
        System.out.println(linkedList);
    }
}
