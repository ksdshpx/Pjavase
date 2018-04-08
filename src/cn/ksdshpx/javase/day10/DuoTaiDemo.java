package cn.ksdshpx.javase.day10;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2018/4/8
 * Time: 21:00
 * Description:多态的演示
 */
abstract class Animal{
    public abstract void eat();
}

class Cat extends Animal{

    @Override
    public void eat() {
        System.out.println("吃鱼！");
    }

    public void catchMouse(){
        System.out.println("抓老鼠！");
    }
}

class Dog extends Animal{
    @Override
    public void eat() {
        System.out.println("啃骨头！");
    }

    public void gongDi(){
        System.out.println("拱地！");
    }
}

public class DuoTaiDemo {
    public static void main(String[] args) {
        /*Animal animal = new Dog();//向上转型
        animal.eat();*/
        //animal.gongDi();//错误，不能访问子类的特有功能
       /* Dog dog = (Dog) animal;
        dog.gongDi();*/
       method(new Dog());
       method(new Cat());
    }

    public static void method(Animal animal){
        animal.eat();
        if(animal instanceof Dog){
            Dog dog = (Dog) animal;
            dog.gongDi();
        }else if(animal instanceof Cat){
            Cat cat = (Cat) animal;
            cat.catchMouse();
        }
    }
}
