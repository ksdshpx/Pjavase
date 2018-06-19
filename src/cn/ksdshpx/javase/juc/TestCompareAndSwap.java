package cn.ksdshpx.javase.juc;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2018/6/19
 * Time: 10:41
 * Description:模拟CAS算法
 */
public class TestCompareAndSwap {
    public static void main(String[] args) {
        final CompareAndSwap cas = new CompareAndSwap();
        for (int i = 0; i < 1000; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    //1.获取内存值
                    int expectedValue = cas.get();
                    //3.设置
                    System.out.println(cas.compareAndSet(expectedValue, (int) (Math.random() * 100)));
                }
            }).start();
        }
    }
}

class CompareAndSwap {
    //内存值
    private int value;

    /**
     * 获取内存值
     *
     * @return
     */
    public synchronized int get() {
        return this.value;
    }

    /**
     * 比较
     *
     * @param expectedValue
     * @param newValue
     * @return
     */
    public synchronized int compareAndSwap(int expectedValue, int newValue) {
        if (expectedValue == this.value) {
            this.value = newValue;
        }
        return this.value;
    }

    /**
     * 设置
     *
     * @param expectedValue
     * @param newValue
     * @return
     */
    public synchronized boolean compareAndSet(int expectedValue, int newValue) {
        return expectedValue == compareAndSwap(expectedValue, newValue);
    }
}
