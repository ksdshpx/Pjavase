package cn.ksdshpx.javase.day11;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2018/4/24
 * Time: 10:41
 * Description:异常处理
 *             1.异常体系
 *                      Throwable
 *                             |--Error
 *                             |--Exception
 *                                  |--编译时检测的异常
 *                                  |--编译时不受检测的异常（RuntimeException）
 *             2.注意事项
 *                  编译时检测的异常：
 *                       ①函数内出现异常，函数上必须声明
 *                       ②处理异常的方式，要么try,要么抛
 *                  运行时异常：
 *                       无需处理
 *
 *             3.throws和throw关键字的区别
 *                  位置不同：throws用在函数上，throw用在函数内
 *                  后面不同：throws后面跟随异常类，throw后面跟随异常对象
 *
 */
//自定义异常
class FuShuException extends Exception{
    public FuShuException(String message) {
        super(message);
    }
}

class Demo{
    public int method(int[] arr,int index) throws FuShuException{
        if (index < 0) {
            throw new FuShuException("负数角标异常！");
        }
        return arr[index];
    }
}

public class ExceptionDemo {
    public static void main(String[] args) {
        int[] arr = {1,2,3};
        Demo d = new Demo();
        try {
            int num = d.method(arr, -2);
            System.out.println("num:" + num);
        } catch (FuShuException e) {
            e.printStackTrace();
        }
    }
}
