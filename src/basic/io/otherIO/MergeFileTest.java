package basic.io.otherIO;

import basic.io.File.FilenameFilterBySuffix;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/*
 * 文件合并器。
 * 要求：
 * 1. 文件夹中含有一个properties文件， 参数为filename, partcount(一共几个文件)
 * 2. 后缀名为.part, 文件名从1到partcount
 * 3. 合并后的文件放在相同的文件夹中
 */

public class MergeFileTest{
    private static final String srcFolder = "D:\\test\\splitFileTest";

    /**
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException{

        /*
         * 文件合并器。
         * 要求：
         * 1. 文件夹中含有一个properties文件， 参数为filename, partcount(一共几个文件)
         * 2. 后缀名为.part, 文件名从1到partcount
         * 3. 合并后的文件放在相同的文件夹中
         * 一个读取流，对应多个输出流。而且生成的碎片文件都有有序的编号。
         */

        File srcFileDir = new File(srcFolder);
//		File destDir = new File("D:\\test\\splitFileTest");
        mergeFile(srcFileDir);

    }

    public static void mergeFile(File srcFileDir) throws IOException{

        if(!srcFileDir.exists()){
            throw new RuntimeException(srcFileDir.getAbsolutePath() + "文件夹不存在");
        }

        String[] names = srcFileDir.list(new FilenameFilterBySuffix(".properties"));
        if(names.length == 0){
            throw new RuntimeException("文件夹中没有properties文件");
        }
        if(names.length > 1){
            throw new RuntimeException("properties文件数超过1");
        }

        String propertiesFileName = names[0];
        //获取配置文件信息
        File configFile = new File(srcFolder + File.separator + propertiesFileName);
        Properties prop = new Properties();

        FileInputStream fis = new FileInputStream(configFile);
        prop.load(fis);

        String destFileName = prop.getProperty("filename");
        int partCount = Integer.parseInt(prop.getProperty("partcount"));
        fis.close();

        //
        String destFileFullName = srcFileDir + File.separator + destFileName;
        File destFile = new File(destFileFullName);
        if(destFile.exists()){
            throw new RuntimeException("目标文件已经存在");
        }

        FileOutputStream fos = null;
        byte[] buf = new byte[1024 * 1024 * 4];//4M
        int len = 0;
        fos = new FileOutputStream(destFile);

        for(int i = 1; i <= partCount; i++){
            String tmpFileStr = srcFileDir + File.separator + i + ".part";
            File tmpFile = new File(tmpFileStr);

            if(!tmpFile.exists()){
                throw new RuntimeException("源文件: " + tmpFileStr + "不存在！");
            }

            FileInputStream fis2 = new FileInputStream(tmpFile);

            while((len = fis2.read(buf)) != -1){
                fos.write(buf, 0, len);
            }
            fis2.close();
        }
        fos.close();
    }
}
