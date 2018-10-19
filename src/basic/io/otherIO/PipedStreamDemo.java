package basic.io.otherIO;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class PipedStreamDemo {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {

		//创建管道对象。
		PipedInputStream pis = new PipedInputStream();
		PipedOutputStream pos = new PipedOutputStream();
		//将两个流连接上。
		pis.connect(pos);
		
		new Thread(new Input(pis)).start();
		new Thread(new Output(pos)).start();
		
		
	}

}


//定义输入任务。
class Input implements Runnable{

	private PipedInputStream pis;
	
	public Input(PipedInputStream pis) {
		super();
		this.pis = pis;
	}

	@Override
	public void run() {
		
		byte[] buf = new byte[1024];
		int len;
		try {
			len = pis.read(buf);
			String str = new String(buf,0,len);
			System.out.println(str);
			
			pis.close();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}
	
	
}
//定义输出任务。
class Output implements Runnable{

	private PipedOutputStream pos;
	
	public Output(PipedOutputStream pos) {
		super();
		this.pos = pos;
	}

	@Override
	public void run() {
		
		//通过write写方法完成。
		try {
			pos.write("hi,管道来了！".getBytes());
			
			pos.close();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}
	
	
}

