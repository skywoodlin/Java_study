package basic.io.File;

import java.io.File;
import java.io.FilenameFilter;

/**
 * Created by xjlin on 2018/9/11.
 * 根据文件名称后缀名的过滤器
 */
public class FilterBySuffix implements FilenameFilter{
    private String suffix;
    public FilterBySuffix(String suffix) {
        super();
        this.suffix = suffix;
    }
    @Override
    public boolean accept(File dir, String name){
        return name.endsWith(suffix);
    }
}
