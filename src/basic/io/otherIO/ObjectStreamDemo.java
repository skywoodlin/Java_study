package basic.io.otherIO;

import Vo.Person;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Created by xjlin on 2018/10/19.
 *
 */
public class ObjectStreamDemo{
    private static final String path = "d:\\test\\ObjectStreamDemo.object";
    public static void main(String[] args) throws IOException, ClassNotFoundException{
        /**
         * 将一个对象写到持久化（硬盘）设备上
         */
//        writeObj();//对象序列化

        readObj();//对象反序列化
    }

    /**
     *
     * @throws IOException
     */
    public static void writeObj() throws IOException {

        FileOutputStream fos = new FileOutputStream(path);

        ObjectOutputStream oos = new ObjectOutputStream(fos);

        oos.writeObject(new PersonForObjectStreamDemo("skywoodlin", 20));

        oos.close();
    }

    public static void readObj() throws IOException, ClassNotFoundException{
        FileInputStream fis = new FileInputStream(path);
        ObjectInputStream ois = new ObjectInputStream(fis);

        PersonForObjectStreamDemo objectStreamDemo = (PersonForObjectStreamDemo) ois.readObject();

        System.out.println(objectStreamDemo.toString());
    }
}
