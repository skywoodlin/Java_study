package basic.io.File;

import java.io.File;
import java.io.FilenameFilter;

/**
 * Created by xjlin on 2018/9/11.
 * 根据文件名称后缀名的过滤器
 */
public class FilterByContent implements FilenameFilter{
    private String content;
    public FilterByContent(String content) {
        super();
        this.content = content;
    }
    @Override
    public boolean accept(File dir, String name){
        return name.contains(content);
    }
}
