package cn.ksdshpx.javase.juc;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2018/5/29
 * Time: 17:44
 * Description:传统线程互斥技术
 */
public class TraditionalThreadSynDemo {
    static class Outputer{
        private void output(String name){
            synchronized (Outputer.class){
                for (int i = 0; i < name.length(); i++) {
                    System.out.print(name.charAt(i));
                }
                System.out.println();
            }
        }
    }
    public static void main(String[] args) {
        final Outputer outputer = new Outputer();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    outputer.output("hanshunping");
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    outputer.output("tonggang");
                }
            }
        }).start();
    }
}
