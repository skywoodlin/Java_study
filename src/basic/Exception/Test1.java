package basic.Exception;

/**
 * Created by xjlin on 2017/9/7.
 * 这个测试说明， 异常产生以后被catch后， 后续的代码还是可以正常执行的。
 */
public class Test1 {
    public static void main(String[] args) {
        int result = 0;

        for(int i = 0; i < 10; i++) {
            try{
                result = 10 / i;
            }catch (Exception e) {
                System.out.println("in exception: ");
                e.printStackTrace();
            }
        }
        System.out.println(result);
    }
}
