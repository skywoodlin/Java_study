package DesignPattern.SGG.adapter;

/**
 * Created by xjlin on 2018/12/18.
 */
public class USBKeyBoard extends USB{
    USBKeyBoard() {
        super();
        this.setName("USBKeyBoard");
    }

    @Override
    void USBRun(){
        System.out.println("USBKeyBoard run");
    }
}
