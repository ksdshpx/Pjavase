package cn.ksdshpx.javase.day23;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2018/12/23
 * Time: 11:35
 * Description:Properties练习（软件试用次数）
 */
public class PropertiesTest {
    public static void main(String[] args) throws IOException {
        File configFile = new File("d:\\count.properties");
        if (!configFile.exists()) {
            configFile.createNewFile();
        }
        FileInputStream fis = new FileInputStream(configFile);
        Properties props = new Properties();
        props.load(fis);
        String value = props.getProperty("count");
        int count = 0;
        if (value != null) {
            count = Integer.valueOf(value);
            if (count >= 5) {
                throw new RuntimeException("试用次数已经达到5次，请购买正版授权！");
            }
        }
        count++;
        props.setProperty("count", String.valueOf(count));
        FileOutputStream fos = new FileOutputStream(configFile);
        props.store(fos, "");
        fos.close();
        fis.close();
    }
}
