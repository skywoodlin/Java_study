package basic.io.File;

import java.io.File;

/**
 * Created by xjlin on 2018/9/11.
 */
public class FileDemo4{
    private static final String DIR = "D:\\project_study\\Java_study\\src\\basic\\io";
    private static final String SUFFIX = ".java";

    public static void main(String[] args){

        //第一种方式， 返回文件夹下所有非隐藏的后缀名为SUFFIX文件
        File dir = new File(DIR);
        if(!dir.isDirectory()){
            System.out.println("不是文件夹！");
            System.exit(1);
        }

        File[] files = dir.listFiles();
        if(files == null || files.length == 0){
            System.out.println("文件夹中没有任何文件");
            System.exit(0);
        }

        for(File file : files){
            if(file.isFile() && !file.isHidden() && file.getName().toLowerCase().endsWith(SUFFIX)){
//                System.out.println(file.getName());
            }
        }

        //第二种方式, 传入过滤器, 返回文件夹下所有非隐藏的后缀名为SUFFIX文件
        String[] names = dir.list(new FilenameFilterBySuffix(".java"));
        for(String name : names){
            System.out.println(name);
        }


        /**
         * 返回文件名中含有某字符串的文件名
         */
        String[] names2 = dir.list(new FilterByContent("Demo"));
        System.out.println("--------------按照文件名包含demo---------------");
        for(String name : names2){
            System.out.println(name);
        }


    }
}
