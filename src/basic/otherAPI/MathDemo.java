package basic.otherAPI;

/**
 * Created by xjlin on 2018/9/10.
 */
public class MathDemo{
    public static void main(String[] args){
        double d1 = Math.ceil(12.34);  //13.0
        double d2 = Math.floor(12.34); //12.0
        double d3 = Math.round(12.34); //12.0
        double d4 = Math.round(12.5); //13.0
        System.out.println(d1);
        System.out.println(d2);
        System.out.println(d3);
        System.out.println(d4);

        double d5 = Math.pow(10,3);
        System.out.println(d5);

        double d6 = Math.sqrt(10);
        System.out.println(d6);


        //伪随机数
        for(int i = 0; i < 10; i++) {
            double d = Math.random();
            System.out.println(d);
        }


        double d7 = 0.0;
        System.out.println(Math.ceil(d7));  //0

        //模拟摇骰子随机数
        for(int i = 0; i < 6; i++) {
            int d8 = (int)Math.ceil(Math.random()*6);
            if(d8 == 0) { //随机数有可能为0.0
                d8 = 1;
            }
            System.out.println(d8);
        }
    }



}
