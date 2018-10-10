package basic.io.homework2;

import java.io.IOException;
import java.io.Reader;

public class MyLineNumberReader extends MyBufferedReader {

	//定义一个计数器。
	private int lineNumber;
	
	public MyLineNumberReader(Reader r) {
		super(r);
		
	}
	
	/**
	 * 覆盖父类的读一行的方法。
	 * @throws IOException 
	 * 
	 */
	public String myReadLine() throws IOException{
		
		lineNumber++;//每一行，行号自增。
		return super.myReadLine();
		
	}

	public int getLineNumber() {
		return lineNumber;
	}

	public void setLineNumber(int lineNumber) {
		this.lineNumber = lineNumber;
	}
	
	
}
