package basic.path;

import java.net.URL;

/**
 * Created by xjlin on 2018/11/16.
 *
 * 1. 对于Class.getResource(String path)
 * path不以’/'开头时，默认是从此类所在的包下取资源；
 * path  以’/'开头时，则是从ClassPath根下获取；
 *
 *
 * 2. Class.getClassLoader（）.getResource(String path)
 * path不能以’/'开头
 * path是从ClassPath根下获取；
 */
public class PathTest1{
    public static void main(String[] args){

        /**
         *  * 1. 对于Class.getResource(String path)
         *  * path不以’/'开头时，默认是从此类所在的包下取资源；
         *  * path  以’/'开头时，则是从ClassPath根下获取；
         */
        ///D:/project_study/Java_study/out/production/Java_study/
        URL url3 = PathTest1.class.getResource("/");
        String path3 = url3.getPath();
        System.out.println(path3);

        ///D:/project_study/Java_study/out/production/Java_study/basic/path/
        URL url4 = PathTest1.class.getResource("");
        String path4 = url4.getPath();
        System.out.println(path4);


        /**
         *  * 2. Class.getClassLoader（）.getResource(String path)
         *  * path不能以’/'开头
         *  * path是从ClassPath根下获取；
         */
        PathTest1 t = new PathTest1();
        System.out.println(t.getClass()); //class basic.path.PathTest1
        System.out.println(t.getClass().getClassLoader());//sun.misc.Launcher$AppClassLoader@18b4aac2

        //file:/D:/project_study/Java_study/out/production/Java_study/
        System.out.println(t.getClass().getClassLoader().getResource(""));

        //null
        System.out.println(t.getClass().getClassLoader().getResource("/"));
    }
}
