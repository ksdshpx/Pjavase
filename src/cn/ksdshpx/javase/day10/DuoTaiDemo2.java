package cn.ksdshpx.javase.day10;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2018/4/12
 * Time: 14:46
 * Description:多态中子父类中成员的特点
 *             1.成员变量
 *                  编译运行都看左边
 *             2.成员方法（非静态）
 *                  编译看左边，运行看右边
 *             3.静态方法
 *                  （其实静态方法不涉及多态，直接用类名调用静态方法即可）-->编译运行都看左边
 */
class Fu{
    int num = 3;

    void show(){
        System.out.println("Fu Show()!");
    }

    static void method(){
        System.out.println("Static Fu Method()!");
    }
}

class Zi extends Fu{
    int num = 4;

    void show(){
        System.out.println("Zi Show()!");
    }

    static void method(){
        System.out.println("Static Zi Method()!");
    }
}

public class DuoTaiDemo2 {
    public static void main(String[] args) {
        Zi z = new Zi();
        System.out.println(z.num);//4
        Fu f = new Zi();
        System.out.println(f.num);//3
        f.show();//Zi Show()!
        f.method();//Static Fu Method()!
    }
}
