package basic.io.homework2;

import java.io.IOException;
import java.io.Reader;

public class MyLineNumberReader extends MyBufferedReader {

	//����һ����������
	private int lineNumber;
	
	public MyLineNumberReader(Reader r) {
		super(r);
		
	}
	
	/**
	 * ���Ǹ���Ķ�һ�еķ�����
	 * @throws IOException 
	 * 
	 */
	public String myReadLine() throws IOException{
		
		lineNumber++;//ÿһ�У��к�������
		return super.myReadLine();
		
	}

	public int getLineNumber() {
		return lineNumber;
	}

	public void setLineNumber(int lineNumber) {
		this.lineNumber = lineNumber;
	}
	
	
}
