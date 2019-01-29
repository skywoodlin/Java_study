package DesignPattern.SGG.adapter;

/**
 * Created by xjlin on 2018/12/18.
 */
public class xjlinAdapterTest1{
    public static void main(String[] args){
        Device device1 = new USBKeyBoard();
        device1.run();

        Device device2 = new PS2KeyBoard();
        device2.run();
    }
}
