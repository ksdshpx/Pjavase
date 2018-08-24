package cn.ksdshpx.javase.jdbc.Exception;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2018/8/24
 * Time: 13:38
 * Description:Dao层异常
 */
public class DaoException extends RuntimeException {
    public DaoException() {
    }

    public DaoException(String message) {
        super(message);
    }

    public DaoException(String message, Throwable cause) {
        super(message, cause);
    }

    public DaoException(Throwable cause) {
        super(cause);
    }

    public DaoException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
