package cn.ksdshpx.javase.jdbc.domain;

import java.util.Date;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2018/8/24
 * Time: 10:38
 * Description:User实体类
 */
public class User {
    private int id;
    private String name;
    private Date birthday;
    private float money;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public float getMoney() {
        return money;
    }

    public void setMoney(float money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthday=" + birthday +
                ", money=" + money +
                '}';
    }
}
