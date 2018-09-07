package medium.thread.thread_homework;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xjlin on 2018/9/4.
 */
public class Bank{
    private static Bank bank;
    private double totalAmount = 0; // 银行总钱数
    private List<Account> accountList = new ArrayList<>();
    private Bank(double initAmount) {
        this.totalAmount = initAmount;
    }

    //单例模式
    public static Bank getBank() {
        if(bank == null) {
            return new Bank(1000.0);
        }
        return bank;
    }

    //增加储户
    public void addAccount(Account account) throws Exception{
        int accountId = account.getId();
        if(checkAccountExist(account)) {
            throw new Exception("储户Id: " + account.getId() + "姓名： " + account.getUserName()+"已存在！");
        }
        accountList.add(account);
    }

    // 用户存钱
    public void accountDeposit(Account account, double amount) throws Exception{
        if(!checkAccountExist(account)) {
            throw new Exception("用户不存在， 请开户后再存钱！");
        }
        try {
            account.depositMoney(amount);
        }catch(Exception e) {
            throw e;
        }

        totalAmount += amount;
    }

    // 用户取钱
    public void accountDraw(Account account, double amount) throws Exception{
        if(!checkAccountExist(account)) {
            throw new Exception("用户不存在， 请开户后再存钱！");
        }
        try {
            account.drawMoney(amount);
        }catch(Exception e) {
            throw e;
        }

        if(totalAmount - amount < 0) {
            throw new Exception("银行准备金不够了， 请择日来取！");
        }
        totalAmount -= amount;
    }

    //checkAccount
    private boolean checkAccountExist(Account account) {
        int accountId = account.getId();
        String accountName = account.getUserName();
        for(Account a : accountList) {
            if(a.getId() == accountId) {
                if(a.getUserName().equals(accountName)) {
                    return true;
                }else {
                    return false;
                }
            }
        }
        return false;
    }
}
