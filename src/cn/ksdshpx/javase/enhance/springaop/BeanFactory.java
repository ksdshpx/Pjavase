package cn.ksdshpx.javase.enhance.springaop;

import cn.ksdshpx.javase.enhance.Advice;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2018/9/13
 * Time: 10:30
 * Description:Bean工厂类
 */
public class BeanFactory {
    private Properties props = new Properties();

    public BeanFactory(InputStream inputStream) {
        try {
            props.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Object getBean(String name) {
        String className = props.getProperty(name);
        Object bean = null;
        try {
            bean = Class.forName(className).newInstance();
            if (bean instanceof ProxyBeanFactory) {
                ProxyBeanFactory proxyBeanFactory = (ProxyBeanFactory) bean;
                Object target = Class.forName(props.getProperty(name + ".target")).newInstance();
                Advice advice = (Advice)(Class.forName(props.getProperty(name + ".advice")).newInstance());
                proxyBeanFactory.setTarget(target);
                proxyBeanFactory.setAdvice(advice);
                Object proxyBean = proxyBeanFactory.getProxy();
                return proxyBean;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;
    }
}
