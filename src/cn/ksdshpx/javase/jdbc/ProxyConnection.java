package cn.ksdshpx.javase.jdbc;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2018/9/4
 * Time: 21:37
 * Description:动态代理Connection的close()方法
 */
public class ProxyConnection{
    private Connection realConnection;
    private MyDataSource dataSource;
    private int maxUseCount = 5;
    private int currUseCount = 0;

    ProxyConnection(MyDataSource dataSource, Connection realConnection) {
        this.dataSource = dataSource;
        this.realConnection = realConnection;
    }

    public Connection getConnection(){
        return (Connection) Proxy.newProxyInstance(this.getClass().getClassLoader(), new Class[]{Connection.class}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                if("close".equals(method.getName())){
                    currUseCount++;
                    if (currUseCount < maxUseCount) {
                        dataSource.connectionsPool.addLast((Connection)proxy);
                    } else {
                        dataSource.currSize--;
                        realConnection.close();
                    }
                }
                return method.invoke(realConnection,args);
            }
        });
    }
}
