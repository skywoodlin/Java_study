package basic.io.File;

import java.io.File;

/**
 * Created by xjlin on 2018/9/11.
 */
public class FileDemo3{
    public static void main(String[] args){
        File dir = new File("D:\\project_study\\Java_study\\src\\basic\\io");

        //列出当前目录下的所有文件和文件夹， 包含隐藏文件
        //局限： 只获取名称
        if(dir.isDirectory()){
            String[] fileList = dir.list();
            if(fileList != null){
                for(String file : fileList){
                    System.out.println(file);
                }
            }
        }

        //返回File[]
        if(dir.isDirectory()){
            File[] files = dir.listFiles();
            if(files != null && files.length != 0){
                for(File file : files){
                    System.out.println(file.getAbsolutePath() + "|"+ file.length() + "bytes");
                }
            }
        }

        //能否得到文件夹的大小？ 很不幸返回的是d盘的大小
        System.out.println(dir.getTotalSpace());
    }
}
