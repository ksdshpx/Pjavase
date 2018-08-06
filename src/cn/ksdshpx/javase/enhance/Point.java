package cn.ksdshpx.javase.enhance;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2018/8/6
 * Time: 15:18
 * Description:Point类
 */
public class Point {
    private String name;
    private int age;
    private String accout;
    private String animalLike;

    public Point() {
    }

    public Point(String name, int age, String accout, String animalLike) {
        this.name = name;
        this.age = age;
        this.accout = accout;
        this.animalLike = animalLike;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAccout() {
        return accout;
    }

    public void setAccout(String accout) {
        this.accout = accout;
    }

    public String getAnimalLike() {
        return animalLike;
    }

    public void setAnimalLike(String animalLike) {
        this.animalLike = animalLike;
    }

    @Override
    public String toString() {
        return "Point{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", accout='" + accout + '\'' +
                ", animalLike='" + animalLike + '\'' +
                '}';
    }
}
