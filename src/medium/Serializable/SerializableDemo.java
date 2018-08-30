package medium.Serializable;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Created by xjlin on 2018/8/23.
 */
public class SerializableDemo{
    public static void main(String[] args){
        writeObj();
//        readObj();
    }

    public static void writeObj(){
        Student s = new Student();
        s.setId(8);
        s.setName("张三");
        s.countryName = "USA";
        try{
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("D:/project_study/Temp/serializable/obj.txt"));
            oos.writeObject(s);
            oos.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public static void readObj(){
        try{
            ObjectInputStream ooi = new ObjectInputStream(new FileInputStream("D:/project_study/Temp/serializable/obj.txt"));
            try{
                Object obj = ooi.readObject();
                Student s = (Student) obj;
                //person s=(person)obj;
                System.out.println("id:" + s.getId() + ",name:" + s.getName() + s.countryName);
            }catch(ClassNotFoundException e){
                e.printStackTrace();
            }
            ooi.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
