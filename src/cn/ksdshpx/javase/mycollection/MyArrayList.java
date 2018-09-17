package cn.ksdshpx.javase.mycollection;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2018/9/17
 * Time: 20:10
 * Description:自定义ArrayList
 */
public class MyArrayList<E> {
    private Object[] elements;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;

    public MyArrayList() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    public MyArrayList(int capacity) {
        elements = new Object[capacity];
    }

    public void add(E element) {
        //数组扩容
        if (size == elements.length) {
            Object[] newElements = new Object[elements.length + (elements.length >> 1)];
            System.arraycopy(elements, 0, newElements, 0, elements.length);
            elements = newElements;
        }
        elements[size++] = element;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        for (int i = 0; i < size; i++) {
            if (i == size - 1) {
                stringBuilder.append(elements[i]);
            } else {
                stringBuilder.append(elements[i] + ",");
            }
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        MyArrayList<String> arrayList = new MyArrayList<>();
        for (int i = 0; i < 100; i++) {
            arrayList.add("sxt" + i);
        }
        System.out.println(arrayList);
    }
}
