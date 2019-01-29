package basic.io.File;

import org.apache.commons.lang.StringUtils;

import java.io.File;
import java.io.FilenameFilter;

/**
 * Created by xjlin on 2018/9/11.
 * 根据文件名称后缀名的过滤器, 只处理文件， 不包含文件夹
 */
public class FilenameFilterBySuffix implements FilenameFilter{
    private String suffix;
    public FilenameFilterBySuffix(String suffix) {
        super();
        this.suffix = suffix;
    }
    @Override
    public boolean accept(File dir, String name){
        String dirName = dir.getAbsolutePath();
        System.out.println(dirName);
        String filePath = dirName + File.separator + name;
        File file = new File(filePath);

        if(StringUtils.isEmpty(suffix)) {
            return !file.isHidden() && file.isFile();
        }

        return !file.isHidden() && file.isFile() && name.endsWith(suffix);
    }
}
