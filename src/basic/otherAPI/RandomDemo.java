package basic.otherAPI;

import java.util.Random;

/**
 * Created by xjlin on 2018/9/11.
 */
public class RandomDemo{
    public static void main(String[] args){
        Random random = new Random();

        //正态分布， 均值为0， 标准差为1.0
//        for(int i = 0; i< 10; i++) {
//            System.out.println(random.nextGaussian());
//        }

        //随即填充byte数组
        byte[] bytes = new byte[100];
        random.nextBytes(bytes);
//        for(int i = 0; i < 100; i++) {
//            System.out.println(bytes[i]);
//        }

        //生成[0,n)中的伪均匀分部的随机int
        for(int i = 0; i< 100; i++) {
            System.out.println(random.nextInt(100));
        }
    }
}
