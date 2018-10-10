package basic.io.Homework1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by xjlin on 2018/9/12.
 *
 * 获取一个文件夹下的结构和每个文件夹及文件的大小
 */
public class DisplayAllFilesUnderFolder2{
    private static final String FILE_SEPARATOR = System.getProperty("file.separator");
    private static final String LINE_SEPARATOR = System.getProperty("line.separator");
    private static final String LEAD_STRING = "|--";
    private static int currentSeq = 0;

    public static void main(String[] args){
        String dirName = "IDM下载";
        String dir = "N:" + FILE_SEPARATOR + dirName + FILE_SEPARATOR;
//        String dir = "N:" + FILE_SEPARATOR;
        String targetFile = "D:" + FILE_SEPARATOR + "test" + FILE_SEPARATOR + dirName + "文件夹结构2.txt";
        DisplayAllFilesUnderFolder2.getFilesHierachy(dir, targetFile);
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
            FileInfo rootFolderInfo = new FileInfo(0, file, 0.0, 0, 0);
            Map<Integer, FileInfo> map = new HashMap<>();
            writeToList(map, rootFolderInfo);

            //输出
            writeToTxtFile(fos, map);
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

    public static void writeToTxtFile(FileOutputStream fos, Map<Integer, FileInfo> map){
        for(int i = 0; ; i++){
            FileInfo fileInfo = map.get(i);
            if(fileInfo == null){
                return;
            }

            int fileLevel = fileInfo.getLevel();
            File file = fileInfo.getFile();
            int parentSeq = fileInfo.getParentSeq();
            int fileSeq = fileInfo.getSeq();
            double fileSize = fileInfo.getFileSize();
            String fileSizeInfo = "    文件大小： " + fileSize + "B";
//            String fileSizeInfo = "    文件大小： " + fileSize / 1024 / 1024 + "M";
            try{
                fos.write((fileSeq + ". ").getBytes());
                if(fileLevel == 0){
                    //判断是否是磁盘分区的根目录
                    if("".equals(file.getName())){
                        fos.write(file.getAbsolutePath().getBytes());
                        fos.write(fileSizeInfo.getBytes());
                        fos.write(LINE_SEPARATOR.getBytes());
                    }else{
                        fos.write(file.getName().getBytes());
                        fos.write(fileSizeInfo.getBytes());
                        fos.write(LINE_SEPARATOR.getBytes());
                    }
                }else{
                    int numOfSpace = 2 + (fileLevel - 1) * 6;
                    for(int j = 0; j < numOfSpace; j++){
                        fos.write(" ".getBytes());
                    }

                    fos.write(LEAD_STRING.getBytes());
                    fos.write(file.getName().getBytes());
                    fos.write(fileSizeInfo.getBytes());
                    fos.write(LINE_SEPARATOR.getBytes());
                }
            }catch(IOException e){
                e.printStackTrace();
            }
        }
    }

    public static void writeToList(Map<Integer, FileInfo> map, FileInfo dirFileInfo/*, int currentDirSeq*/){
        if(!dirFileInfo.getFile().isDirectory()){
            System.out.println(dirFileInfo.getFile().getAbsolutePath() + "不是一个文件夹");
            System.exit(1);
        }

        //输出当前目录名称
//            if(currentDirSeq == 0){
        //判断是否是磁盘分区的根目录
//                FileInfo fileInfo = new FileInfo(0, dirFileInfo.getFile(), 0.0, 0, 0);
        map.put(dirFileInfo.getSeq(), dirFileInfo);

        File dir = dirFileInfo.getFile();
        int currentDirSeq = dirFileInfo.getSeq();
        double dirSize = 0.0;
        int fileLevel = dirFileInfo.getLevel() + 1;

        //先获取文件夹下的所有文件， 输出信息
        int currentFileSeq = currentDirSeq;
        File[] files = dir.listFiles(new FilterByFile_IsFile());
        if(files != null && files.length > 0){
            for(File file : files){
                double fileSize = (double) file.length();
                dirSize += fileSize;
                FileInfo fileInfo = new FileInfo(++currentFileSeq, file, fileSize, fileLevel, currentDirSeq);
                map.put(currentFileSeq, fileInfo);
            }
        }

        currentSeq = currentFileSeq;
        //在获取文件夹中的文件夹
        File[] folders = dir.listFiles(new FilterByFile_IsDirectory());
        if(folders != null && folders.length > 0){
            for(File folder : folders){
                FileInfo folderInfo = new FileInfo(++currentSeq, folder, 0, fileLevel, currentDirSeq);
                writeToList(map, folderInfo);
                double folderSize = folderInfo.getFileSize();
                dirSize += folderSize;
            }
        }

        dirFileInfo.setFileSize(dirSize);
    }
}

class FileInfo{
    int seq;
    File file;
    double fileSize;
    int level;
    int parentSeq;

    public int getParentSeq(){
        return parentSeq;
    }

    public void setParentSeq(int parentSeq){
        this.parentSeq = parentSeq;
    }

    public FileInfo(int seq, File file, double fileSize, int level, int parentSeq){
        this.seq = seq;
        this.file = file;
        this.fileSize = fileSize;
        this.level = level;
        this.parentSeq = parentSeq;
    }

    public int getSeq(){
        return seq;
    }

    public void setSeq(int seq){
        this.seq = seq;
    }

    public File getFile(){
        return file;
    }

    public void setFile(File file){
        this.file = file;
    }

    public double getFileSize(){
        return fileSize;
    }

    public void setFileSize(double fileSize){
        this.fileSize = fileSize;
    }

    public int getLevel(){
        return level;
    }

    public void setLevel(int level){
        this.level = level;
    }
}