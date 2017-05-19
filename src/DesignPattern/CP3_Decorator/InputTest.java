package DesignPattern.CP3_Decorator;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by xjlin on 2017/3/22.
 */
public class InputTest {
    public static void main(String[] args) throws IOException {
        int c;
        String folderPath = "D:\\project_study\\Java_study\\src\\DesignPattern\\CP3_Decorator\\";
        try {
            InputStream inputStream = new LowerCaseInputStream(new BufferedInputStream(new FileInputStream(folderPath + "test.txt")));

            while ((c = inputStream.read()) >= 0) {
                System.out.println((char) c);
            }

            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
