package cn.ksdshpx.javase.jdbc.test;

import cn.ksdshpx.javase.jdbc.domain.Account;
import cn.ksdshpx.javase.jdbc.service.AccountService;
import org.junit.Test;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2018/8/26
 * Time: 10:54
 * Description:测试银行转账
 */
public class AccountServiceTest {
    private AccountService accountService = new AccountService();

    @Test
    public void test() {
        Account from = new Account();
        from.setId(1);
        from.setName("zhangSan");
        Account to = new Account();
        to.setName("liSi");
        accountService.zhuanZhang2(from, to, 10);
    }
}
