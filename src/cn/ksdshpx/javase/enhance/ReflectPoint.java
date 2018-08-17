package cn.ksdshpx.javase.enhance;

import java.util.Objects;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2018/8/17
 * Time: 23:56
 * Description:反射用的Point类
 */
public class ReflectPoint {
    private int x;
    private int y;

    public ReflectPoint() {
    }

    public ReflectPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReflectPoint that = (ReflectPoint) o;
        return x == that.x &&
                y == that.y;
    }

    @Override
    public int hashCode() {

        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "ReflectPoint{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
