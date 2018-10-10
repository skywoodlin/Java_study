package basic.io.File;

import java.io.File;
import java.text.DateFormat;
import java.util.Date;

/**
 * Created by xjlin on 2018/9/11.
 * /*
 * 		 * File方法。：
 * 		 *
 * 		 * 1，获取文件的绝对路径。
 * 		 * 	String getAbsolutePath
 * 		 * 2，获取文件的路径。
 * 		 * 	String getPath();
 * 		 * 3，获取文件最后一次修改的时间，要求是x年x月x日。时间。
 * 		 *  long lastModified()
 * 		 * 4，文件是否是隐藏的。
 * 		 * 	boolean isHidden()
 * 		 * 5，发现File对象封装的文件或者文件夹是可以存在的也可以是不存在。
 * 		 *
 *                  */
public class FileDemo{
//    File类已经帮我们做了这个事
//    private static final String FILE_SEPARATOR = System.getProperty("file.separator");

    public static void main(String[] args) throws Exception{

        File file = new File("tt.txt"); //相对路径

        //绝对路径
        File file1 = new File("d:" + File.separator + "test" + File.separator + "data.txt");
//        File file1 = new File("d:" + FILE_SEPARATOR + "test" + FILE_SEPARATOR + "data.txt");

        // 文件夹
//        File file2 = new File("d:" + FILE_SEPARATOR + "test" + FILE_SEPARATOR);
        File file2 = new File("d:" + File.separator + "test" + File.separator);

        //另一种方式
        File file3 = new File(file2, "data.txt");

        /**
         * File类， 常见方法
         *
         */
        //1. 名字， 获取名称
        System.out.println(file.getName());   //tt.txt

        //2. 获取大小
        long len = file.length();
        System.out.println(len); //0

        long len2 = file2.length();
        System.out.println(len2);  //0

        //3. 获取所在目录
        System.out.println(file3.getParent());  //d:\test
        System.out.println(file.getParent());  //相对路径初始化的文件的目录是？ null

        //文件的绝对路径， 说明相对路径是工程的根目录文件夹
        //获取文件对象的绝对路径，即使封装的是相对的，获取到的也是绝对的。
        System.out.println("file.getAbsolutePath : "  + file.getAbsolutePath());   //D:\project_study\Java_study\tt.txt

        //获取的是file对象中的封装的路径。封装的是什么，获取到的就是什么。
        System.out.println("file.getPath : " + file.getPath()); //tt.txt

        //获取文件最后一次修改的时间，要求是x年x月x日。时间。
        long time = file3.lastModified();
        Date date = new Date(time);
        String str_date  = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG).format(date);
        System.out.println("file3最后修改时间: " + str_date);

        //文件是否隐藏
        boolean b = file3.isHidden();
        System.out.println("file3 isHidden: " + b);

        //
    }
}
