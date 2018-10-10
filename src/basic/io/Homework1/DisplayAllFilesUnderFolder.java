package basic.io.Homework1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by xjlin on 2018/9/12.
 */
public class DisplayAllFilesUnderFolder{
    private static final String FILE_SEPARATOR = System.getProperty("file.separator");
    private static final String LINE_SEPARATOR = System.getProperty("line.separator");
    private static final String LEAD_STRING = "|--";

    public static void main(String[] args){
        String dirName = "IDM下载";
//        String dir = "N:" + FILE_SEPARATOR + dirName + FILE_SEPARATOR;
        String dir = "N:" + FILE_SEPARATOR;
        String targetFile = "D:" + FILE_SEPARATOR + "test" + FILE_SEPARATOR + dirName + "文件夹结构.txt";
        DisplayAllFilesUnderFolder.getFilesHierachy(dir, targetFile);
    }

    public static void getFilesHierachy(String dirPath, String targetFile){
        File file = new File(dirPath);
        if(file == null){
            System.out.println("打开文件夹失败， 请确认文件夹路径是否正确！");
            System.exit(1);
        }

        if(!file.isDirectory()){
            System.out.println("目标路径不是一个文件夹， 请确认！");
            System.exit(1);
        }

        FileOutputStream fos = null;
        try{
            fos = new FileOutputStream(targetFile);
            writeToFile(fos,file,0);
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }finally{
            if(fos != null){
                try{
                    fos.close();
                }catch(IOException e){
                    e.printStackTrace();
                }
            }
        }


    }

    public static void writeToFile(FileOutputStream fos, File dir, int step){
        if(!dir.isDirectory()){
            System.out.println(dir.getAbsolutePath() + "不是一个文件夹");
            System.exit(1);
        }

        try{
            //输出当前目录名称
            if(step == 0){
                //判断是否是磁盘分区的根目录
                if("".equals(dir.getName())){
                    fos.write(dir.getAbsolutePath().getBytes());
                    fos.write(LINE_SEPARATOR.getBytes());
                }else{
                    fos.write(dir.getName().getBytes());
                    fos.write(LINE_SEPARATOR.getBytes());
                }
            }else{
                int numOfSpace = 2 + (step - 1) * 6;
                for(int i = 0; i < numOfSpace; i++){
                    fos.write(" ".getBytes());
                }

                fos.write(LEAD_STRING.getBytes());
                fos.write(dir.getName().getBytes());
                fos.write(LINE_SEPARATOR.getBytes());
            }

            //先获取文件夹下的所有文件， 输出信息
            File[] files = dir.listFiles(new FilterByFile_IsFile());
            if(files != null && files.length > 0){
                for(File file : files){
                    int numOfSpace = 2 + step * 6;
                    for(int i = 0; i < numOfSpace; i++){
                        fos.write(" ".getBytes());
                    }
                    fos.write(LEAD_STRING.getBytes());
                    String fileInfo = file.getName() + "    " + "文件大小: " + (double)file.length() / 1024 / 1024 + "M" +
                            LINE_SEPARATOR;
                    fos.write(fileInfo.getBytes());
                }
            }

            //在获取文件夹中的文件夹
            File[] folders = dir.listFiles(new FilterByFile_IsDirectory());
            if(folders != null && folders.length > 0){
                for(File folder : folders){
                    writeToFile(fos, folder, step + 1);
                }
            }

        }catch(IOException e){
            e.printStackTrace();
        }

    }
}