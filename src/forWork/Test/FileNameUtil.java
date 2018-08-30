package forWork.Test;

import java.io.File;

/**
 * Created by xjlin on 2017/8/23.
 */
public class FileNameUtil {
    public static void main(String[] args) {
        String fileName = "d:\\programs\\tt\\tt.xls";
    }

    /**
     * 从绝对路径中获取带后缀的文件名
     * @param fileNameWithPath
     * @return
     */
    public static String getFileNameWithExtensionFromFullPath(String fileNameWithPath)  {
        int index = fileNameWithPath.lastIndexOf(File.separator);  // 以字符串中的最后一个"/"或者"\"为分隔符
        if(index == -1) {
            System.out.println("从绝对路径中获取带后缀的文件名错误");
        }

        return fileNameWithPath.substring(index+1);
    }

    /**
     * 从文件名中获取后缀名
     * @param fileNameWithExtension
     * @return
     * @ 
     */
    public static String getExtensionFromFileName(String fileNameWithExtension)  {
        int index = fileNameWithExtension.lastIndexOf(".");
        if(index == -1) {
            System.out.println("从文件名中获取后缀名错误");
        }

        return fileNameWithExtension.substring(index+1);
    }

    /**
     * 从带后缀的文件名中去掉后缀
     * @param fileNameWithExtension
     * @return
     * @ 
     */
    public static String getPureFileName(String fileNameWithExtension)  {
        int index = fileNameWithExtension.lastIndexOf(".");
        if(index == -1) {
            System.out.println("从带后缀的文件名中去掉后缀错误");

        }

        return fileNameWithExtension.substring(0,index);
    }
}
