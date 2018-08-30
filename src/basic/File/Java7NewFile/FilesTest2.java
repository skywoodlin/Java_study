package basic.File.Java7NewFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by xjlin on 2017/9/1.
 */
public class FilesTest2 {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        try {
            Path path = Paths.get(new URI("file:///C:/home/docs/users.txt"));
            File file = new File("C:\\home\\docs\\users.txt");
            Path toPath = file.toPath();
            System.out.println(toPath.equals(path));
        } catch (URISyntaxException e) {
            System.out.println("Bad URI");
        }
    }
}

