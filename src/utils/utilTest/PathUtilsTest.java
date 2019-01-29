package utils.utilTest;

import org.junit.Test;
import utils.RegexUtils;

/**
 * Created by xjlin on 2018/11/26.
 */
public class PathUtilsTest{
    @Test
    public void testGetPath() {
        System.out.println(RegexUtils.getPathFromFullPathForWindows("L:\\Webstorm_Project\\基础知识测试程序\\abc.txt"));
    }

    @Test
    public void testGetFileName() {
        System.out.println(RegexUtils.getfileNameFromFullPathForWindows("L:\\Webstorm_Project\\基础知识测试程序\\abc.txt"));
    }
}
