package forWork.Test;

import java.io.File;

/**
 * Created by xjlin on 2017/8/22.
 */
public class SubStringTest {
    public static void main(String[] args) {
        String sourceFile = "test/kk/kk.jj";
        int index = sourceFile.lastIndexOf("/");
        String fileName = sourceFile.substring(index + 1);
        System.out.println(fileName);

        int index2 = fileName.lastIndexOf(".");
        String fileName2 = fileName.substring(0, index2);
        System.out.println(fileName2);
        System.out.println(File.separator);
    }
}
