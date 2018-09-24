package cn.ksdshpx.javase.encrypt;

import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.security.Key;
import java.security.spec.KeySpec;
import java.util.Base64;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2018/9/19
 * Time: 16:24
 * Description:对称加密-->DES加密和解密
 */
public class DESCrypt {
    private static final String ALGORITHM = "DES";

    public static void main(String[] args) {
        //加密原文
        String input = "欢迎来到上海期货交易所";
        //秘钥
        String password = "12345678";
        byte[] encryptBytes = encrypt(input, password);
        System.out.println("加密:" + new String(encryptBytes));
        byte[] decryptBytes = decrypt(encryptBytes, password);
        System.out.println("解密:" + new String(decryptBytes));
    }

    /**
     * DES加密
     *
     * @param input
     * @param password
     * @return
     */
    private static byte[] encrypt(String input, String password) {
        byte[] encrypt = null;
        try {
            //加密算法三部曲
            //1.创建Cipher对象
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            //2.初始化模式:加密/解密
            SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance(ALGORITHM);//秘钥工厂
            KeySpec keySpec = new DESKeySpec(password.getBytes());//秘钥规则对象
            Key key = secretKeyFactory.generateSecret(keySpec);//秘钥对象
            cipher.init(Cipher.ENCRYPT_MODE, key);
            //3.加密
            encrypt = cipher.doFinal(input.getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Base64.getEncoder().encode(encrypt);
    }

    /**
     * DES解密
     *
     * @param input
     * @param password
     * @return
     */
    private static byte[] decrypt(byte[] input, String password) {
        byte[] decrypt = null;
        try {
            //加密算法三部曲
            //1.创建Cipher对象
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            //2.初始化模式:加密/解密
            SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance(ALGORITHM);//秘钥工厂
            KeySpec keySpec = new DESKeySpec(password.getBytes());//秘钥规则对象
            Key key = secretKeyFactory.generateSecret(keySpec);//秘钥对象
            cipher.init(Cipher.DECRYPT_MODE, key);
            //3.解密
            decrypt = cipher.doFinal(Base64.getDecoder().decode(input));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return decrypt;
    }
}
