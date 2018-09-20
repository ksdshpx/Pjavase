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
        if (capacity < 0) {
            throw new RuntimeException("容器容量不能为负数！");
        } else if (capacity == 0) {
            elements = new Object[DEFAULT_CAPACITY];
        } else {
            elements = new Object[capacity];
        }
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

    public void remove(int index) {
        checkRange(index);
        int movedCount = elements.length - index - 1;
        if (movedCount > 0) {
            System.arraycopy(elements, index + 1, elements, index, movedCount);
        }
        elements[--size] = null;
    }

    public void remove(E element) {
        for (int i = 0; i < elements.length; i++) {
            if (elements[i].equals(element)) {
                remove(i);
                return;
            }
        }
    }

    public void checkRange(int index) {
        if (index < 0 || index > size - 1) {
            throw new RuntimeException("索引值不合法:" + index);
        }
    }

    public void set(int index, E element) {
        checkRange(index);
        elements[index] = element;
    }

    public E get(int index) {
        checkRange(index);
        return (E) elements[index];
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
        System.out.println(arrayList.get(99));
        System.out.println(arrayList);
        arrayList.remove(3);
        arrayList.remove("sxt11");
        System.out.println(arrayList);
    }
}
