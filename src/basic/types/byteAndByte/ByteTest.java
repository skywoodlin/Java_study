package basic.types.byteAndByte;

/**
 * Created by xjlin on 2018/10/11.
 *
 *总结： Byte
 *
 */
public class ByteTest {
    public static void main(String args[])
    {
        Byte by1 = new Byte("123");
        Byte by2 = new Byte("123");
        int length = by1.SIZE;   //8, 代表8位

        int max = by2.MAX_VALUE; //127
        int min = by2.MIN_VALUE; //-128

        if(by1 == by2)
        {
            System.out.println("Operation '=' compares the reference of Byte objects and equal");
        }else {
            System.out.println("Operation '=' compares the objects of Byte objects and not equal");
        }

        if(by1.equals(by2))
        {
            System.out.println("Function 'equals()' compares the value of Byte objects and equal");
        }else {
            System.out.println("Function 'equals()' compares the value of Byte objects and not equal");
        }

        Byte by3 = by1;
        if(by3 == by1)
        {
            System.out.println("Operation '=' compares the reference of Byte objects and equal");
        }else {
            System.out.println("Operation '=' compares the reference of Byte objects and not equal");
        }

        System.out.println(by1); //123
        System.out.println(by2); //123

        byte by4 = by1.byteValue();
        System.out.println(by4);  //123

        byte by5 = 123;
        System.out.println(by5);  //123

        Byte by6 = 123;
        System.out.println(by6); //123

        byte by7 = by6.byteValue();
        System.out.println(by7); //123

        int by8 = by6.intValue();
        System.out.println(by8); //123

        byte by9 = (byte)1024;
        System.out.println(by9); //0  //截取了最低8位

        byte[] bytes = "12".getBytes();
        System.out.println(bytes[0]); //49
        System.out.println(bytes[1]); //50

        System.out.println(new String(bytes)); //12


        byte by10 = 50;
        System.out.println((char)by10);  //2


        System.out.println("The length is "+length);  //8
        System.out.println("MAX:"+max+" MIN"+min);
        byte temp = (byte)241; // 241的二进制表示为11110001（补码），其中第一位为符号位，那么剩余的计算结果为15，最终结果为-15
        System.out.println(temp); //-15

//        byte by6 = 1024;

    }

}
