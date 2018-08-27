package cn.ksdshpx.javase.enhance;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2018/8/27
 * Time: 15:58
 * Description:定义注解类
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD,ElementType.TYPE})
public @interface Ksdshpx {
}
