package basic.File.Java7NewFile;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import static com.google.common.base.Charsets.UTF_8;

/**
 * Created by xjlin on 2017/9/1.
 */
public class FilesTest1 {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        Path path = Paths.get("d:", "test.txt");
        // 得到path的绝对路径
        System.out.println(path.toAbsolutePath());
        // 复制文件
        Files.copy(Paths.get("d:\\test", "test.txt"), new FileOutputStream("text1.txt"));
        // 将读取到的内容添加List集合中
        /*List<String> lists = Files.readAllLines(Paths.get("d:", "est.java"), UTF_8);
        System.out.println("读取到的文件：" + lists);
        System.out.println("是否可写?  --->" + Files.isWritable(Paths.get("d:", "test.txt")));
        // 创建一个集合，用于添加到文件中
        List<String> list = new ArrayList<>();
        list.add("adsf");
        list.add("测试1");
        list.add("测试2");
        // 将多个字符串写入到文件中
        Files.write(Paths.get("d:", "test.txt"), list, Charset.forName("gbk"));
        // 判断指定文件的大小
        System.out.println("test.txt文件的大小为：" + Files.size(Paths.get("d:", "test.txt")));
        // 判断是否为隐藏文件
        System.out.println("test.txt是否为隐藏文件 ？" + Files.isHidden(Paths.get("d:", "test.txt")));
        // 得到一个Calendar实例，用于设置文件修改的时间
        Calendar ca = Calendar.getInstance();
        // 设置时间为2014年5月23日
        ca.set(2014, 4, 23);
        // 设置文件最后修改的时间
        Files.setLastModifiedTime(path, FileTime.fromMillis(ca.getTimeInMillis()));*/
    }
}

