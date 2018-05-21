package cn.ksdshpx.javase.day13;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2018/5/21
 * Time: 15:34
 * Description:线程间通讯
 */
//资源
class Resource {
    private String name;
    private String sex;
    private boolean flag;

    public Resource() {
    }

    public Resource(String name, String sex) {
        this.name = name;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    @Override
    public String toString() {
        return "Resource{" +
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }
}

//Input
class Input implements Runnable {
    private Resource resource;

    public Input(Resource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        int x = 0;
        while (true) {
            synchronized (resource){
                if(resource.isFlag()){//资源池中已经有资源
                    try {
                        resource.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if (x == 0) {
                    resource.setName("mike");
                    resource.setSex("nan");
                } else {
                    resource.setName("丽丽");
                    resource.setSex("女女女女");
                }
                x = (x + 1) % 2;
                resource.setFlag(true);
                resource.notify();
            }
        }

    }
}

//Output
class Output implements Runnable {
    private Resource resource;

    public Output(Resource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (resource){
                if(!resource.isFlag()){//资源池中没有资源
                    try {
                        resource.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(resource.getName() + "..." + resource.getSex());
                resource.setFlag(false);
                resource.notify();
            }
        }
    }
}

public class ResourceDemo {
    public static void main(String[] args) {
        Resource resource = new Resource();
        Input in = new Input(resource);
        Output out = new Output(resource);
        Thread t1 = new Thread(in);
        Thread t2 = new Thread(out);
        t1.start();
        t2.start();
    }
}
