package coreJavaVolumn.Volumn1.CP6.innerClass;

/**
 * Created by xjlin on 2018/8/27.
 * 使用ReflectionTest程序对TalkingClock.class进行解析如下：
 *
 * Enter class name (e.g. java.util.Date):
 * coreJavaVolumn.Volumn1.CP6.innerClass.TalkingClock
 *
 * class coreJavaVolumn.Volumn1.CP6.innerClass.TalkingClock
 * {
 *    public coreJavaVolumn.Volumn1.CP6.innerClass.TalkingClock(int, boolean);
 *
 * //经过测试， 在内部类（TimePrinter）用了哪些内部私有数据， 在这里都会有一份相应的代码生成
 *    static int access$100(coreJavaVolumn.Volumn1.CP6.innerClass.TalkingClock);
 *    static boolean access$000(coreJavaVolumn.Volumn1.CP6.innerClass.TalkingClock);
 *    public void start();
 *
 *    private int interval;
 *    private boolean beep;
 * }
 *
 *
 */
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.Timer;

/**
 * This program demonstrates the use of inner classes.
 * @version 1.10 2004-02-27
 * @author Cay Horstmann
 */
public class InnerClassTest
{
    public static void main(String[] args)
    {
        TalkingClock clock = new TalkingClock(1000, true);
        clock.start();

        // keep program running until user selects "Ok"
        JOptionPane.showMessageDialog(null, "Quit program?");
        System.exit(0);
    }
}

/**
 * A clock that prints the time in regular intervals.
 */
class TalkingClock
{
    private int interval;
    private boolean beep;

    /**
     * Constructs a talking clock
     * @param interval the interval between messages (in milliseconds)
     * @param beep true if the clock should beep
     */
    public TalkingClock(int interval, boolean beep)
    {
        this.interval = interval;
        this.beep = beep;
    }

    /**
     * Starts the clock.
     */
    public void start()
    {
        ActionListener listener = new TimePrinter();
        Timer t = new Timer(interval, listener);
        t.start();
    }

    public class TimePrinter implements ActionListener
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
}
