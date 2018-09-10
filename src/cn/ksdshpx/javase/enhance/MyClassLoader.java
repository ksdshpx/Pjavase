package cn.ksdshpx.javase.enhance;

import java.io.*;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2018/9/10
 * Time: 14:55
 * Description:自定义类加载器
 */
public class MyClassLoader extends ClassLoader {
    private String classDir;

    public MyClassLoader() {

    }

    public MyClassLoader(String classDir) {
        this.classDir = classDir;
    }

    public static void main(String[] args) throws IOException {
        String srcPath = args[0];
        String destPath = args[1] + File.separator + srcPath.substring(srcPath.lastIndexOf(File.separator) + 1);
        FileInputStream in = new FileInputStream(srcPath);
        FileOutputStream out = new FileOutputStream(destPath);
        encrypt(in, out);
        in.close();
        out.close();
    }

    private static void encrypt(InputStream in, OutputStream out) throws IOException {
        int by = 0;
        while ((by = in.read()) != -1) {
            out.write(by ^ 0xff);
        }
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        String classFileName = classDir + File.separator + name + ".class";
        System.out.println(classFileName);
        try {
            FileInputStream in = new FileInputStream(classFileName);
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            encrypt(in,out);
            byte[] bytes = out.toByteArray();
            return defineClass(bytes,0,bytes.length);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return super.findClass(name);
    }
}
