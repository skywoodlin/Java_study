package DesignPattern.SGG.adapter;

/**
 * Created by xjlin on 2018/12/18.
 */
public abstract class PS2 implements Device{
    private String name;
    @Override
    public void run() {
        PS2Run();
    }

    abstract void PS2Run();

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    @Override
    public String getDeviceName() {
        return this.getName();
    }
}
