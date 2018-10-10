package basic.io.FileOutputStream;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by xjlin on 2018/9/12.
 * 文件操作的异常处理
 *
 * 1. 打开文件时有可能失败， 要try/catch
 * 2. finally里里头一定要关闭fos， 关闭前要检查fos是否时空指针
 */
public class IOExceptionDemo{
    private static final String rootDir = "d:" + File.separator + "test" + File.separator + "streamTest" + File.separator;

    public static void main(String[] args){
        FileOutputStream fos = null;
        try{
            //可能找不到路径
            fos = new FileOutputStream(rootDir + "fos2.txt");
            fos.write("abcdf".getBytes());
        }catch(IOException e){
            System.out.println(e.toString() + "---------------------");
        }finally{
            //关闭之前一定要检查fos是否创建成功了
            if(fos != null){
                try{
                    fos.close();
                }catch(IOException e){
                    throw new RuntimeException("文件关闭失败" + e);
                }
            }
        }
    }
}
