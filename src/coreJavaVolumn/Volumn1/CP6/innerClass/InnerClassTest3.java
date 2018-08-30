package coreJavaVolumn.Volumn1.CP6.innerClass;

/**
 * Created by xjlin on 2018/8/29.
 *
 * 局部类
 * 
 * 同InnerClassTest1相比， 内部类变成了局部类
 *
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

/**
 * This program demonstrates the use of inner classes.
 * @version 1.10 2004-02-27
 * @author Cay Horstmann
 */
public class InnerClassTest3
{
    public static void main(String[] args)
    {
        TalkingClock3 clock = new TalkingClock3(1000, true);
        clock.start();

        // keep program running until user selects "Ok"
        JOptionPane.showMessageDialog(null, "Quit program?");
        System.exit(0);
    }
}

/**
 * A clock that prints the time in regular intervals.
 */
class TalkingClock3
{
    private int interval;
    private boolean beep;

    /**
     * Constructs a talking clock
     * @param interval the interval between messages (in milliseconds)
     * @param beep true if the clock should beep
     */
    public TalkingClock3(int interval, boolean beep)
    {
        this.interval = interval;
        this.beep = beep;
    }

    /**
     * Starts the clock.
     */
    public void start()
    {
        class TimePrinter implements ActionListener
        {
            public void actionPerformed(ActionEvent event)
            {
                Date now = new Date();
                System.out.println("At the tone, the time is " + now);
                if (beep) {
                    System.out.println(interval);
                    Toolkit.getDefaultToolkit().beep();
                }
            }
        }

        ActionListener listener = new TimePrinter();
        Timer t = new Timer(interval, listener);
        t.start();
    }


}
