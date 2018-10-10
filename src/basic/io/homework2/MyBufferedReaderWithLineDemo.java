package basic.io.homework2;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MyBufferedReaderWithLineDemo{

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {

        InputStreamReader fr = new InputStreamReader(new FileInputStream
                ("D:\\project_study\\Java_study\\src\\basic\\io\\homework2\\IO_3.txt"), "GBK");
		MyLineNumberReader myBufr = new MyLineNumberReader(fr);
		String line = null;
		while((line=myBufr.myReadLine())!=null){
			System.out.println(myBufr.getLineNumber()+":"+line);
		}
		myBufr.myClose();

	}

}
