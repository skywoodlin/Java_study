package basic.File;

import com.sun.deploy.util.ArrayUtil;

import java.io.File;
import java.io.FilenameFilter;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by xjlin on 2017/1/19.
 */
public class GetAllFolderNamesUnderFolder {
    public static void main(String[] args) {
        List<String> folderNameList = new ArrayList<String>();

        String path = "d:/test"; // 路径
        File f = new File(path);
        if (!f.exists()) {
            System.out.println(path + " not exists");
        }

        File fa[] = f.listFiles();

        for (int i = 0; i < fa.length; i++) {
//            File fs = fa[i];
            if(fa[i].isDirectory()) {
                folderNameList.add(fa[i].getName());
            }
        }

        Object [] folderNameArray = folderNameList.toArray();
        Arrays.sort(folderNameArray);
        System.out.println(folderNameArray[folderNameArray.length - 1].toString());
/*        for(int i = 0; i<folderNameArray.length; i++) {
            System.out.println(folderNameArray[i].toString());
        }*/
    }

/*    public String getFileName() {
        List<String> folderNameList = new ArrayList<String>();

        String path = "d:/test"; // 路径
        File f = new File(path);
        if (!f.exists()) {
            System.out.println(path + " not exists");
        }

        File fa[] = f.listFiles();

        for (int i = 0; i < fa.length; i++) {
//            File fs = fa[i];
            if(fa[i].isDirectory()) {
                folderNameList.add(fa[i].getName());
            }
        }

        String [] folderNameArray = (String[])  folderNameList.toArray();
        Arrays.sort(folderNameArray);
        for(int i = 0; i<folderNameArray.length; i++) {
            System.out.println(folderNameArray[i]);
        }

        return folderNameArray[0];
    }*/
}
