package basic.io.File;

import java.io.File;
import java.io.FileFilter;

/**
 * Created by xjlin on 2018/9/11.
 * 重点掌握
 */
public class FilterByFolder implements FileFilter{
    @Override
    public boolean accept(File pathname){
        return !pathname.isHidden() && pathname.isDirectory();
    }
}
