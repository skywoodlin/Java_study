package coreJavaVolumn.Volumn1.CP5.reflection.usbTest;

public class NoteBook{

    /**
     * 运行功能。
     */
    public void run(){
        System.out.println("notebook run 我");
    }

    /**
     * 使用usb设备。
     */
    public void useUSB(USB usb){
        if(usb != null){
            usb.open();
            usb.close();
        }
    }
}
