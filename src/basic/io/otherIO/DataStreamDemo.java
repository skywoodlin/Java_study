package basic.io.otherIO;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataStreamDemo {
    private static final String PATH = "d:\\test\\DataStreamDemo.txt";


    /**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {

//		writeData();
		readData();
		
	}

	public static void readData() throws IOException {
		FileInputStream fis = new FileInputStream(PATH);
		DataInputStream dis = new DataInputStream(fis);
		
		boolean  b = dis.readBoolean();
		
		System.out.println(b);
		dis.close();
		
	}

	public static void writeData() throws IOException {
		
		//写入一些基本数据值。存储到文件。
		FileOutputStream  fos = new FileOutputStream(PATH);
		DataOutputStream dos = new DataOutputStream(fos);
		
		dos.writeBoolean(true);
		
		dos.close();
	}

}
