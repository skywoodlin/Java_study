package basic.File;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * Created by xjlin on 2017/1/19.
 */
public class CopyFilesUnderOneFolderToAnother {
    public static void main(String[] args) {
        try {
            CopyFilesUnderOneFolderToAnother.copyFilesUnderOneFolderToAnother("d:\\a\\", "d:\\b\\");
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void copyFilesUnderOneFolderToAnother(String sourceFolderPath, String targetFolderPath) throws Exception{
        File sourceFolder = new File(sourceFolderPath);
        File targetFolder = new File(targetFolderPath);

        if(!sourceFolder.isDirectory()) {
            throw new Exception("原路径不是一个文件夹！");
        }
        if(!targetFolder.isDirectory()) {
            throw new Exception("目标路径不是一个文件夹！");
        }

        //源文件夹下所有文件
        File [] files = sourceFolder.listFiles();
        if(files != null && files.length > 0) {
            for (int i = 0; i < files.length; i++) {
                //只复制文件
                if(files[i].isFile()) {
                    copyFileToFolderWithSameName(files[i].getAbsolutePath(),targetFolderPath);
                }
            }
        }else {
//            logger.error("升级包根目录下没有找到文件夹！路径： " + upgradePackageRoot);
//            throw new Exception("升级包根目录下没有找到文件夹！路径： " + upgradePackageRoot);
        }
    }

    public static void copyFileToFolderWithSameName(String sourceFile, String targetFolderPath) throws Exception {
        File srcFile = new File(sourceFile);
        if(!srcFile.isFile()) {
            throw new Exception(sourceFile + "不是一个文件");
        }

        File targetFolder = new File(targetFolderPath);
        if(!targetFolder.isDirectory()) {
            throw new Exception(targetFolderPath + "不是一个文件夹");
        }

        // 目标文件名
        String targetFile = targetFolderPath + "\\" + srcFile.getName();

        FileInputStream input=new FileInputStream(srcFile);//可替换为任何路径何和文件名
        FileOutputStream output=new FileOutputStream(targetFile);//可替换为任何路径何和文件名

        // 复制操作
        int in=input.read();
        while(in!=-1){
            output.write(in);
            in=input.read();
        }
    }
}
