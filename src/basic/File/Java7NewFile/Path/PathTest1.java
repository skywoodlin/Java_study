package basic.File.Java7NewFile.Path;

import java.nio.file.FileSystems;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by xjlin on 2017/9/1.
 * 需要申明的是， 只是路径操作， 并不需要文件或者路径真实存在
 *
 * 示例中FileSystems的getDefault方法，会由JVM返回一个代表了当前文件系统的FileSystem对象，
 * 我们可以通过FileSystem来获得Path对象。一个Path可以由多个子Path组成，子Path可以可通用过subpath方法来获得
 *
 * FileSystems.getDefault(): 返回一个代表了当前文件系统的FileSystem对象
 * 我们可以通过FileSystem来获得Path对象。一个Path可以由多个子Path组成，子Path可以可通用过subpath方法来获得
 *
 * path.getFileName()： 得到文件名
 * path.getRoot(): 得到根目录
 * path.getNameCount()： 得到除了根目录以外的每一层路径（包含文件， 文件是最后一个）
 * path.getName(index): 得到各级文件夹， 最后一个是文件名
 * path.subPath(begin, end): 获取从[begin, end)层的路径， 包含中间的分隔符
 * path.getParent(): 获取文件路径， 包含根目录， 但不包含文件
 */
public class PathTest1 {
    public static void main(String[] args) {

        Path path = FileSystems.getDefault().getPath("d:\\test\\test.txt");
        System.out.println("toString: " + path.toString());
        System.out.printf("getFileName: %s\n", path.getFileName());
        System.out.printf("getRoot: %s\n", path.getRoot());
        System.out.printf("getNameCount: %d\n", path.getNameCount());

        for (int index = 0; index < path.getNameCount(); index++) {
            System.out.printf("getName(%d): %s\n", index, path.getName(index));
        }

        System.out.printf("subpath(0,2): %s\n", path.subpath(0, 2));
        System.out.printf("getParent: %s\n", path.getParent());
        System.out.println(path.isAbsolute());

        /*try {
            path = Paths.get("Home", "projects", "users.txt");
            System.out.printf("Absolute path: %s", path.toAbsolutePath());
        } catch (InvalidPathException ex) {
            System.out.printf("Bad path: [%s] at position %s", ex.getInput(), ex.getIndex());
        }*/


    }
}
