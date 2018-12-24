package cn.ksdshpx.javase.day23;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.SequenceInputStream;
import java.util.Vector;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2018/12/24
 * Time: 14:15
 * Description:序列流SequenceInputStream
 */
public class SequenceInputStreamDemo {
    public static void main(String[] args) throws IOException {
        Vector<FileInputStream> vector = new Vector<>();
        vector.add(new FileInputStream("d:\\1.txt"));
        vector.add(new FileInputStream("d:\\2.txt"));
        vector.add(new FileInputStream("d:\\3.txt"));
        SequenceInputStream sis = new SequenceInputStream(vector.elements());
        FileOutputStream fos = new FileOutputStream("d:\\4.txt");
        byte[] bys = new byte[1024];
        int len = 0;
        while ((len = sis.read(bys)) != -1) {
            fos.write(bys, 0, len);
        }
        fos.close();
        sis.close();
    }
}
