package medium.classLoader;

import java.net.URL;

/**
 * Created by xjlin on 2018/8/30.
 */
public class BootstrapClassloaderTest{
    public static void main(String[] args){
        URL[] urls = sun.misc.Launcher.getBootstrapClassPath().getURLs();
        for(int i = 0; i < urls.length; i++){
            System.out.println(urls[i].toExternalForm());
        }
    }
}
