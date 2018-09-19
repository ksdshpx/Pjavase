package cn.ksdshpx.javase.encrypt;

import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.security.Key;
import java.security.spec.KeySpec;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2018/9/19
 * Time: 16:24
 * Description:对称加密-->DES加密和解密
 */
public class DESCrypt {
    private static final String ALGORITHM = "algorithm";

    public static void main(String[] args) {
        //加密原文
        String input = "欢迎来到上海期货交易所";
        //秘钥
        String password = "12345678";
        encrypt(input, password);
    }

    private static void encrypt(String input, String password) {
        try {
            //加密算法三部曲
            //1.创建Cipher对象
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            //2.初始化模式:加密/解密
            SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance(ALGORITHM);//秘钥工厂
            KeySpec keySpec = new DESKeySpec(password.getBytes());//秘钥规则对象
            Key key = secretKeyFactory.generateSecret(keySpec);//秘钥对象
            cipher.init(Cipher.ENCRYPT_MODE, key);
            //3.加密/解密
            byte[] encrypt = cipher.doFinal(input.getBytes());
            System.out.println("DES加密：" + new String(encrypt));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void decrypt(String input, String password) {
        try {
            //加密算法三部曲
            //1.创建Cipher对象
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            //2.初始化模式:加密/解密
            SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance(ALGORITHM);//秘钥工厂
            KeySpec keySpec = new DESKeySpec(password.getBytes());//秘钥规则对象
            Key key = secretKeyFactory.generateSecret(keySpec);//秘钥对象
            cipher.init(Cipher.DECRYPT_MODE, key);
            //3.加密/解密
            byte[] decrypt = cipher.doFinal(input.getBytes());
            System.out.println("DES加密：" + new String(decrypt));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
