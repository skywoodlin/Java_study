package medium.thread.thread_homework;

/**
 * Created by xjlin on 2018/9/4.
 */
public class BankSavingTest{
    public static void main(String[] args){
        try{
            Bank bank = Bank.getBank();

            //开户
            Account a = Account.accountFactory("skywoodlin", 100);
            bank.addAccount(a);
            Account b = Account.accountFactory("gotjwen");
            bank.addAccount(b);

            for(int i = 0; i < 10; i++) {

            }


        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}

