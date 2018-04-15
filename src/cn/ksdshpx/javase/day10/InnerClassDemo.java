package cn.ksdshpx.javase.day10;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2018/4/15
 * Time: 21:38
 * Description:内部类
 *             访问特点：1,内部类可以访问外部类中的所有成员(包括私有的)，因为内部类持有外部类的引用--->外部类名.this
 *                      2,外部类要访问内部类的成员，必须创建内部类的引用
 *                      3,如果内部类中有静态成员，该内部类必须被静态修饰
 *                      4,内部类在局部位置上之只能访问被final修饰的局部变量--->扩展，匿名内部类
 *                        只能访问被final修饰的局部变量
 */
class Outer{
    private static int num = 3;

    static class Inner{
        public void show(){
            System.out.println("show()..."+num);
        }

        public static void function(){
            System.out.println("function()..."+num);
        }

    }

    public void method(){
        Inner in = new Inner();
        in.show();
    }
}
public class InnerClassDemo {
    public static void main(String[] args) {
//        Outer out = new Outer();
//        out.method();
        //直接访问外部类中的内部类成员
//        Outer.Inner in = new Outer().new Inner();
//        in.show();
        //如果内部类是静态的，相当于一个外部类
//        Outer.Inner in = new Outer.Inner();
//        in.show();
        //如果内部类是静态的，且成员是静态的
        Outer.Inner.function();
    }
}
