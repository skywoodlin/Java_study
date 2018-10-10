package basic.io.FileInputStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by xjlin on 2018/9/17.
 * 读取文件字节流
 *
 * 标准写法
 */
public class FileInputStreamDemo2{
    private static final String FILE_STR = "d:\\test\\data.txt";
    private static final int DEFAULT_SIZE = 8192;

    public static void main(String[] args) throws IOException{
        //保证对象文件的存在性
        File file = new File(FILE_STR);
        if(!file.exists()){
            throw new RuntimeException("要读取得文件不存在");
        }

        FileInputStream fis = null;
        try{
            //创建文件字节读取流对象时， 必须明确与之关联的数据源
            fis = new FileInputStream(file);

            //第二种读取方式, 一般用这种方式，
            int len;
            byte[] bytes_buffer = new byte[DEFAULT_SIZE];  //一般缓存字节数是1024的n辈
            while((len = fis.read(bytes_buffer)) != -1){
            /*for(byte byteContent : bytes_buffer ) {
                System.out.println("btyes: "+  (char)byteContent);
            }*/
//                for(int i = 0; i < len; i++){
//                    System.out.println("btyes " + i + ": " + (char) bytes_buffer[i]);
//                }
                System.out.println(len + "..." + new String(bytes_buffer, 0, len));
            }
        }catch(IOException e){
            e.printStackTrace();
        }finally{
            //关闭资源
            if(fis != null){
                fis.close();
            }
        }


    }

}
