package cn.ksdshpx.javase.jdbc.domain;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2018/8/26
 * Time: 10:30
 * Description:Account实体类
 */
public class Account {
    private Integer id;
    private String name;
    private Float balance;

    public Account() {
    }

    public Account(Integer id, String name, Float balance) {
        this.id = id;
        this.name = name;
        this.balance = balance;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getBalance() {
        return balance;
    }

    public void setBalance(Float balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", balance=" + balance +
                '}';
    }
}
