package DesignPattern.SGG.adapter;

/**
 * Created by xjlin on 2018/12/18.
 */
public class Computer{
    private int numOfDevices = 0;
    private Device[] devices = new Device[6]; //最大容量
    Computer(){}

    Computer(Device... d) {
        if(d.length > 6) {
            throw new RuntimeException("太多设备了！！！");
        }

        for(int i = 0; i < d.length; i++) {
            devices[i] = d[i];
            numOfDevices++;
        }
    }

    public Device[] getDevices(){
        return devices;
    }

    public void setDevices(Device[] devices){
        this.devices = devices;
    }

    public int getNumOfDevices(){
        return numOfDevices;
    }

    public void setNumOfDevices(int numOfDevices){
        this.numOfDevices = numOfDevices;
    }

    public void showAllDiveces() {
        if(numOfDevices == 0) {
            System.out.println("没有任何设备");
        }
        for(int i = 0; i < numOfDevices; i++) {
            System.out.println(devices[i].getDeviceName());
        }
    }


    public static void main(String[] args){
        Device a = new USBKeyBoard();
        Device b = new PS2KeyBoard();
        Computer computer = new Computer(a,b);
        computer.showAllDiveces();
    }




}
