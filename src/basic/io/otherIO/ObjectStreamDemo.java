package basic.io.otherIO;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * Created by xjlin on 2018/10/19.
 *
 */
public class ObjectStreamDemo{
    private static final String path = "d:\\test\\ObjectStreamDemo.txt";
    public static void main(String[] args) throws IOException{
        /**
         * 将一个对象写到持久化（硬盘）设备上
         */
        writeObj();

    }

    public static void writeObj() throws IOException {

        FileOutputStream fos = new FileOutputStream(path);

        ObjectOutputStream oos = new ObjectOutputStream(fos);

        oos.writeObject(new PersonForObjectStreamDemo("skywoodlin", 20));

        oos.close();

    }
}
