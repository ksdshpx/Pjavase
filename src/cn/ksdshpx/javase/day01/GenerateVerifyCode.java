package cn.ksdshpx.javase.day01;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.FileOutputStream;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2018/1/9
 * Time: 22:08
 * Description:用java生成图片
 */
public class GenerateVerifyCode {
    public static void main(String[] args) throws Exception {
        //得到图片缓冲区
        BufferedImage bi = new BufferedImage(120,35,BufferedImage.TYPE_INT_RGB);
        //得到它的绘制环境（这张图片的画笔）
        Graphics2D g2 = (Graphics2D) bi.getGraphics();
        g2.setColor(Color.WHITE);//设置颜色
        g2.fillRect(0,0,120,35);//填充整张图片（其实就是填充背景色）
        g2.setFont(new Font("宋体",Font.BOLD,25));//设置字体
        g2.setColor(Color.BLACK);//设置颜色
        g2.drawString("80fF3g",22,25);//向图片上写字符串
        ImageIO.write(bi,"JPEG",new FileOutputStream("E:\\a.jpg"));
    }
}
