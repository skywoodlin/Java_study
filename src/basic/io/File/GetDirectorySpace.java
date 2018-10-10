package basic.io.File;

import java.io.File;

/**
 * Created by xjlin on 2018/9/11.
 * 获取一个文件夹大小
 */
public class GetDirectorySpace{
    private static final String DIR = "M:\\";
    public static void main(String[] args){
        File dir = new File(DIR);
        double folderSize = GetDirectorySpace.getDirectorySpace(dir);
        System.out.println(folderSize + "B");
        System.out.println(folderSize/1024 + "K");
        System.out.println(folderSize/1024/1024 + "M");
        System.out.println(folderSize/1024/1024/1024 + "G");
    }

    public static double getDirectorySpace (File file) {
        double totalUsedSpace = 0;
        if(file == null) {
            System.out.println("文件夹路径错误！");
            System.exit(1); //惯例商， 非0表示非正常
        }

        if(!file.isDirectory()) {
            System.out.println("路径不是一个文件夹！");
            System.exit(1);
        }

//        File dir = new File(DIR);
        File[] files = file.listFiles();

        if(files == null || files.length == 0) {
            return 0;
        }

        for(File fileTmp: files) {
            if(fileTmp.isDirectory()) {
                double tempDirUsedSpace = GetDirectorySpace.getDirectorySpace(fileTmp);
                totalUsedSpace += tempDirUsedSpace;
            }else if(fileTmp.isFile()){
                totalUsedSpace += fileTmp.length();
            }
        }

        return totalUsedSpace;
    }
}
