package basic.io.File;

import java.io.File;

/**
 * Created by xjlin on 2018/9/11.
 *
 * 获取本地硬盘各分区名
 */
public class FileDemo5{
    public static void main(String[] args){
        File[] files = File.listRoots();
        for(File file : files) {
            String name = file.getAbsolutePath();
            System.out.println(name);
        }
    }
}
