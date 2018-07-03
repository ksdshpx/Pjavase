package cn.ksdshpx.javase.log4j;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2018/6/28
 * Time: 22:35
 * Description:测试Log4j
 */
public class MyTest {
    public static void main(String[] args) {
        //Logger logger = Logger.getLogger(MyTest.class);
        Logger logger = LogManager.getLogger(MyTest.class);
        logger.fatal("fatal msg");
        logger.error("error msg");
        logger.warn("warn msg");
        logger.info("info msg");
        logger.debug("debug msg");
        logger.trace("trace msg");
    }
}
