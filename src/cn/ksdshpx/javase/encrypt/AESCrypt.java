package cn.ksdshpx.javase.encrypt;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2018/9/25
 * Time: 22:18
 * Description:AES加密解密
 */
public class AESCrypt {
    private static final String ALGORITHM = "AES";

    public static void main(String[] args) {
        String input = "欢迎来到上海期货交易所";
        String password = "1234567812345678";
        byte[] encrypt = encrypt(input, password);
        System.out.println("AES加密:" + new String(encrypt));
        String decrypt = decrypt(encrypt, password);
        System.out.println("AES解密:" + decrypt);
    }

    /**
     * AES加密
     *
     * @param input
     * @param password
     * @return
     */
    private static byte[] encrypt(String input, String password) {
        byte[] encryptBytes = null;
        try {
            //1.创建Cipher对象
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            SecretKey key = new SecretKeySpec(password.getBytes(), ALGORITHM);
            //2.初始化加密解密模式
            cipher.init(Cipher.ENCRYPT_MODE, key);
            //3.加密解密
            encryptBytes = cipher.doFinal(input.getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Base64.getEncoder().encode(encryptBytes);
    }

    private static String decrypt(byte[] input, String password) {
        byte[] decryptBytes = Base64.getDecoder().decode(input);
        String decrypt = null;
        try {
            //1.创建Cipher对象
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            SecretKey key = new SecretKeySpec(password.getBytes(), ALGORITHM);
            //2.初始化加密解密模式
            cipher.init(Cipher.DECRYPT_MODE, key);
            //3.加密解密
            decrypt = new String(cipher.doFinal(decryptBytes));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return decrypt;
    }
}
