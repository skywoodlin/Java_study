package basic.io.Homework1;

import java.io.File;
import java.io.FileFilter;

/**
 * Created by xjlin on 2018/9/12.
 */
public class FilterByFile_IsDirectory implements FileFilter{
    @Override
    public boolean accept(File pathname){
        return pathname.isDirectory() && !pathname.isHidden();
    }
}