package medium.Serializable;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Created by xjlin on 2018/8/23.
 *
 * https://www.cnblogs.com/wangg-mail/p/4354709.html
 *
 * 1. 测试： 继承关系在序列化过程中的影响？
 * 当父类Living没有实现serializable时， 没有任何父类属性的内容
 *
 * 修改父类Living，使之实现java.io.Serialazable接口后，
 * 从文件中也可以清楚的看到父类Living中的environment属性被成功的序列化。
 *
 * 2. 测试： 序列化后， 类新增属性后， 能不能从原序列化后的文件中反序列化
 * 结果： 运行结果表明还是能正常的反序列化，只是新添加的属性为默认值。
 *
 * 3. 测试， 序列化后， 类删除属性后， 会怎样
 * 结果： 运行结果表时还是能正常的反序列化。
 *      由此可知，类的属性的增删并不能对对象的反序列化造成影响。
 *
 * 4. 测试： serialVersionUID改变后， 无法反序列号
 * 其中的一个用途： 升级时变动这个值， 则无法反序列化， 抛出异常后捕捉， 强制用户升级。
 *
 */
public class SerializableTest1{
    public static void main(String[] args){
//        writeObj();
        readObj();
    }

    public static void writeObj(){
        Human human = new Human();
        human.setName("xjlin");
//        human.setWeight(65);
        try{
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream
                    ("D:/project_study/Temp/serializable/human1.dat"));
            oos.writeObject(human);
            oos.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public static void readObj(){
        try{
            ObjectInputStream ooi = new ObjectInputStream(new FileInputStream("D:/project_study/Temp/serializable/human1.dat"));
            try{
                Object obj = ooi.readObject();
                Human h = (Human) obj;
                //person s=(person)obj;
                System.out.println("Human:" + h.toString());
            }catch(ClassNotFoundException e){
                e.printStackTrace();
            }
            ooi.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
