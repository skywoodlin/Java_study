package coreJavaVolumn.Volumn1.CP5.reflection.usbTest;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class NoteBookMain {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {

		NoteBook book = new NoteBook();
		
		book.run();
		book.useUSB(null);
		//因为有了鼠标。所在需要在源程序中，创建鼠标对象并传到给笔记本。
		//希望后期出现了设备以后，可不可以不用修改NoteBookMain的代码。还可以不断的加入新设备。
//		book.useUSB(new MouseByUSB());通过反射来解决问题。
		
		
		//对外提供配置文件。。
		File configFile = new File("d:\\test\\usb.properties");
		if(!configFile.exists()){
			configFile.createNewFile();
		}
		
		//读取流和配置文件关联。
		FileInputStream fis = new FileInputStream(configFile);
		Properties prop = new Properties();
		//将流中的数据加载到prop。
		prop.load(fis);
		
		for(int x=1; x<=prop.size(); x++){
			String className = prop.getProperty("usb"+x);
			//对指定的类进行加载。
			Class clazz = Class.forName(className);
			USB usb = (USB)clazz.newInstance();
			book.useUSB(usb);
		}
		fis.close();
	}

}
