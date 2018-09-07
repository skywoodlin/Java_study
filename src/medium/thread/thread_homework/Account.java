package medium.thread.thread_homework;

/**
 * Created by xjlin on 2018/9/4.
 */
public class Account{
    private static int nextIdToBeAllocated = 0; //下一个待分配的id
    private int id;
    private String userName;
    private double savings;

    public double getSavings(){
        return savings;
    }

    private void setSavings(double savings){
        this.savings = savings;
    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getUserName(){
        return userName;
    }

    public void setUserName(String userName){
        this.userName = userName;
    }

    public static Account accountFactory(String userName) {
        return new Account(Account.nextIdToBeAllocated ++, userName, 0);
    }

    public static Account accountFactory(String userName, double initAmount) throws Exception{
        if(initAmount < 0) {
            throw new Exception("初始存款不可以小于0");
        }
        return new Account(Account.nextIdToBeAllocated ++, userName, initAmount);
    }

    private Account(int id, String userName, double savings){
        this.id = id;
        this.userName = userName;
        this.savings = savings;
    }

    public void depositMoney(double depositAmount) throws Exception {
        if(depositAmount <= 0) {
            throw new Exception("存款数量不对");
        }
        double newSavings = this.getSavings() + depositAmount;
        this.setSavings(newSavings);
    }

    public void drawMoney(double drawAmount) throws Exception {
        if(drawAmount <= 0) {
            throw new Exception("取款数量不对");
        }

        if(drawAmount - this.getSavings() > 0) {
            throw new Exception("没有那么多存款");
        }

        this.setSavings(this.getSavings() - drawAmount);
    }
}

