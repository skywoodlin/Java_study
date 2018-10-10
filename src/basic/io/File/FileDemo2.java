package basic.io.File;

import java.io.File;
import java.io.IOException;

/**
 * Created by xjlin on 2018/9/11.
 * <p>
 * 那么不存在的可否用file的功能创建呢？
 * * 		 * 创建功能。
 * * 		 * 	createNewFile()
 * * 		 * 删除功能。
 * * 		 * 	delete();
 * * 		 * 6，一个File对象封装的文件或者文件加到底是否存在呢？
 * * 		 * 判断存在功能。
 * * 		 * 	exists()
 * * 		 *
 * * 		 * 7，getFreeSpace() 方法是什么意思？用Demo验证。getTotalSpace() getUsableSpace()
 * * 		 *
 * * 		 *
 * * 		 * 8，获取指定文件夹中的所有文件和文件夹的名称。能不能只获取.java文件呢？
 */
public class FileDemo2{
    public static void main(String[] args) throws IOException{
        File file = new File("d:" + File.separator + "test" + File.separator + "test22.txt");
        //创建
        if(!file.createNewFile()){//如果文件不存在， 返回false
            System.out.println("文件已存在");
        }

        //文件是否存在
        if(file.exists()){
            System.out.println("文件存在");
        }else{
            System.out.println("文件不存在");
        }


        //删除， 注意， 不走回收站， 要很小心
        if(file.delete()){
            System.out.println("文件成功删除");
        }else{
            System.out.println("删除失败或者没有此文件");
        }


        //创建删除文件夹
        File file2 = new File("d:" + File.separator + "test" + File.separator + "test22.txt");
        //创建失败， 因为test里头没有test文件夹， 不可以创建第二个test文件夹下的目录
//        File file2 = new File("d:" + File.separator + "test" + File.separator + "test" + File.separator + "test22.txt");
        if(file2.mkdir()){ //创建单级目录， 上级目录必须存在
            System.out.println("创建文件夹成功");
        }else{
            System.out.println("创建文件夹失败");
        }

        if(file2.exists()){
            if(file2.isDirectory()){
                if(file2.delete()){
                    System.out.println("删除文件夹成功");
                }else{
                    System.out.println("删除文件夹失败");
                }
            }else{
                if(file2.delete()){
                    System.out.println("删除文件成功");
                }else{
                    System.out.println("删除文件失败");
                }
            }
        }

        //创建多级目录
        File file4 = new File("C:\\test\\test\\test\\test\\");
        if(file4.mkdirs()) {
            System.out.println("多级目录创建成功");
        }else{
            System.out.println("多级目录创建失败");
        }

        //想直接删除多级目录中的根目录： 不可以
        //删除文件夹时，必须保证该文件夹没有内容。有内容，必须先把内容删除后，才可以删除当前文件夹。
        File file5 = new File("C:\\test\\test");
        if(file5.exists()) {
            if(file5.delete()) {
                System.out.println("删除多级目录中比较上层的目录成功");
            }else{
                System.out.println("删除多级目录中比较上层的目录失败");
            }
        }

        //获取分区大小
        File file6 = new File("c:\\");
        System.out.println(file6.getTotalSpace());

        //获取分区剩余空间大小
        System.out.println(file6.getFreeSpace());

        //获取分区可用空间大小
        System.out.println(file6.getUsableSpace());





    }
}
