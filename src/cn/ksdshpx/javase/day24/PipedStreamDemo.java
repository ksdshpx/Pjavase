package cn.ksdshpx.javase.day24;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2019/2/15
 * Time: 16:50
 * Description:管道流
 */
public class PipedStreamDemo {
    public static void main(String[] args) throws IOException {
        PipedInputStream in = new PipedInputStream();
        PipedOutputStream out = new PipedOutputStream();
        in.connect(out);
        new Thread(new Input(in)).start();
        new Thread(new Output(out)).start();
    }
}

class Input implements Runnable {
    private PipedInputStream in;

    public Input(PipedInputStream in) {
        this.in = in;
    }

    @Override
    public void run() {
        try {
            byte[] bys = new byte[1024];
            int len = in.read(bys);
            String s = new String(bys, 0, len);
            System.out.println(s);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class Output implements Runnable {
    private PipedOutputStream out;

    public Output(PipedOutputStream out) {
        this.out = out;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(5000);
            out.write("hi,管道流来了！".getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
