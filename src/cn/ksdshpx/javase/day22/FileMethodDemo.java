package cn.ksdshpx.javase.day22;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2018/12/14
 * Time: 10:22
 * Description:文件对象的常用方法
 */
public class FileMethodDemo {
    public static void main(String[] args) throws IOException{
        //1.文件对象的获取功能
        //getDemo();
        //2.文件的创建与删除
        createAndDeleteDemo();
    }

    private static void createAndDeleteDemo() throws IOException {
        File file = new File("d:\\aaa.txt");
        if(!file.exists()){
            file.createNewFile();
        }
        if(file.exists()){
            file.delete();
        }
    }

    private static void getDemo() {
        File file = new File("D:\\icode\\Pjavase\\src\\cn\\ksdshpx\\javase\\day22\\SystemInDemo.java");
        //输出文件的名称
        System.out.println("文件名称：" + file.getName());//SystemInDemo.java
        //输出文件的绝对路径
        System.out.println("文件绝对路径：" + file.getAbsolutePath());//D:\icode\Pjavase\src\cn\ksdshpx\javase\day22\SystemInDemo.java
        //输出文件的相对路径
        System.out.println("文件相对路径：" + file.getPath());//D:\icode\Pjavase\src\cn\ksdshpx\javase\day22\SystemInDemo.java
        //输出文件的父目录
        System.out.println("文件的父目录：" + file.getParent());//D:\icode\Pjavase\src\cn\ksdshpx\javase\day22
        //输出文件大小
        System.out.println("文件的大小："+file.length());
        //输出文件最后修改时间
        System.out.println("文件最后修改时间："+new SimpleDateFormat("yyyy-MM-dd hh:mm:ss SSS").format(new Date(file.lastModified())));
    }
}
