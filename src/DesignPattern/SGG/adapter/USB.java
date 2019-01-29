package DesignPattern.SGG.adapter;

/**
 * Created by xjlin on 2018/12/18.
 */
public abstract class USB implements Device{
    private String name;

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    @Override
    public void run() {
        USBRun();
    }

    abstract void USBRun();

    @Override
    public String getDeviceName() {
        return this.getName();
    }
}
