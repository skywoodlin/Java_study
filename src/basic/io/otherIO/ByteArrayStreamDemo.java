package basic.io.otherIO;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

public class ByteArrayStreamDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		//用io的读写思想操作数组。
		//1,确定源。
		ByteArrayInputStream bis = new ByteArrayInputStream("abcde".getBytes());
		//2,确定目的。内置了一个byte数组。
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		
		int by = 0;
		
		while((by=bis.read())!=-1){
			bos.write(by);
		}
		
		System.out.println(bos.toString());
	}

}
