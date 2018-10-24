package utils;

import basic.io.File.FilenameFilterBySuffix;
import basic.io.File.FilterByFolder;
import org.apache.commons.lang.StringUtils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * Created by xjlin on 2018/10/23.
 * <p>
 * 批量转换文件编码从GBK转成UTF-8
 * 1. 可以指定一个文件夹， 会递归转换文件夹中的文件夹
 * 2. 文件原始编码和目标编码可以设置
 * 3. 可以根据后缀名来筛选需要转换的文件
 * <p>
 * 注意： 要非常注意！！！
 */
public class EncodingConverter{
    private static final String SUFFIX = ".java";
    private static final String FILENAME = "N:\\百度云下载\\2、java web mysql jdbc ajax jquery（非常重要必须重点学习）\\day03";


    public static void main(String[] args) throws IOException{
        File file = new File(FILENAME);
        try{
            convertFileWithEncoding2(file, "GBK", "UTF-8", ".java");
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    /**
     * @param file         要转换的文件或目录
     * @param oriEncoding  文件的原始编码
     * @param destEncoding 文件的目标编码
     * @param suffix       指定要转换的文件后缀，不指定的话传入null或空字符串
     * @throws IOException
     */
    public static void convertFileWithEncoding(File file, String oriEncoding, String destEncoding, String suffix) throws
            IOException{
        if(file.exists()){
            //文件夹
            if(file.isDirectory()){
                File[] files = null;
                if(StringUtils.isNotEmpty(suffix)){
                    files = file.listFiles(new FilenameFilterBySuffix(SUFFIX));
                }else{
                    files = file.listFiles();
                }

                for(File tmpFile : files){
                    convertFileWithEncoding(tmpFile, oriEncoding, destEncoding, suffix);
                }

                //递归获取文件夹中的文件夹
                File[] folders = file.listFiles(new FilterByFolder());
                if(folders.length > 0){
                    for(File tmpFolder : folders){
                        EncodingConverter.convertFileWithEncoding(tmpFolder, oriEncoding, destEncoding, suffix);
                    }
                }
            }else{
                //文件转换， 注意写法
                BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), oriEncoding));
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file + "." + destEncoding),
                        destEncoding));

                String line = null;
                while((line = br.readLine()) != null){
//                    System.out.println(line);
                    bw.write(line);
                    //注意这边要显示加上换行符， 因为BufferedWriter不会自动给你加
                    bw.write(System.lineSeparator());
                    //注意要flush
                    bw.flush();
                }

                br.close();
                bw.close();
            }
        }
    }

    public static void convertFileWithEncoding2(File file, String oriEncoding, String destEncoding, String suffix) throws
            IOException{
        if(file.exists()){
            //文件夹
            if(file.isDirectory()){
                File[] files = null;
                if(StringUtils.isNotEmpty(suffix)){
                    files = file.listFiles(new FilenameFilterBySuffix(SUFFIX));
                }else{
                    files = file.listFiles();
                }

                for(File tmpFile : files){
                    convertFileWithEncoding2(tmpFile, oriEncoding, destEncoding, suffix);
                }

                //递归获取文件夹中的文件夹
                File[] folders = file.listFiles(new FilterByFolder());
                if(folders.length > 0){
                    for(File tmpFolder : folders){
                        EncodingConverter.convertFileWithEncoding2(tmpFolder, oriEncoding, destEncoding, suffix);
                    }
                }
            }else{
                InputStreamReader fr = null;
                OutputStreamWriter fw = null;
                try {
                    fr = new InputStreamReader(new FileInputStream(file),oriEncoding);//读
                    fw = new OutputStreamWriter(new FileOutputStream(file + "." + destEncoding), destEncoding);//写
                    char[] buf = new char[1024];//缓冲区
                    int len;
                    while ((len = fr.read(buf)) != -1) {
                        fw.write(buf, 0, len);//读几个写几个
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    if (fr != null) {
                        try {
                            fr.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if (fw != null) {
                        try {
                            fw.flush();
                            fw.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }
}
