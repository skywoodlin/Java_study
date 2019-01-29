package basic.io.File;

import java.io.File;

/**
 * Created by xjlin on 2018/9/11.
 */
public class FileFilterDemo{
    /**
     * 文件过滤器：只显示文件
     */
    private static final String DIR = "c:\\";
    public static void main(String[] args){
        File dir = new File(DIR);
        File[] files = dir.listFiles(new FilterByFile());
        for(File file: files) {
            System.out.println(file.getAbsolutePath() +" "+ file.length());
        }
        System.out.println(dir.getName()); //根目录没有名字
        if("".equals(dir.getName())){
            System.out.println("根目录的名字是空字符串"); //输出“根目录的名字是空字符串”
            System.out.println(dir.getAbsolutePath());
        }
    }
}
