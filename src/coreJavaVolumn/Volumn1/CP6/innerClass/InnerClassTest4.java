package coreJavaVolumn.Volumn1.CP6.innerClass;

/**
 * Created by xjlin on 2018/8/29.
 *
 * 匿名内部类， 注意new ActionListener()的语法
 *
 *
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class InnerClassTest4
{
    public static void main(String[] args)
    {
        TalkingClock4 clock = new TalkingClock4(1000, true);
        clock.start();

        // keep program running until user selects "Ok"
        JOptionPane.showMessageDialog(null, "Quit program?");
        System.exit(0);
    }
}

/**
 * A clock that prints the time in regular intervals.
 */
class TalkingClock4
{
    private int interval;
    private boolean beep;

    /**
     * Constructs a talking clock
     * @param interval the interval between messages (in milliseconds)
     * @param beep true if the clock should beep
     */
    public TalkingClock4(int interval, boolean beep)
    {
        this.interval = interval;
        this.beep = beep;
    }

    /**
     * Starts the clock.
     */
    public void start()
    {
        /**
         * 以下的语法确实费解， 它的含义是，
         * 创建一个实现了ActionListener接口的类的新对象， 需要实现的方法
         * actionPerformed定义在括号{}内
         * 通常的语法格式为：
         *
         * new SuperType(construction parameters){
         *  inner class methods and data
         * }
         */
        ActionListener listener = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                Date now = new Date();
                System.out.println("At the tone, the time is " + now);
                if (beep) {
                    System.out.println(interval);
                    Toolkit.getDefaultToolkit().beep();
                }
            }
        };
        Timer t = new Timer(interval, listener);
        t.start();
    }


}
