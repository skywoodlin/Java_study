package DesignPattern.SGG.adapter;

/**
 * Created by xjlin on 2018/12/18.
 */
public class PS2KeyBoard extends PS2{

    PS2KeyBoard() {
        super();
        this.setName("PS2KeyBoard");
    }
    @Override
    void PS2Run(){
        System.out.println("PS2KeyBoard run");
    }
}
