package coreJavaVolumn.Volumn1.CP5.reflection.usbTest;

public class KeyByUSB implements USB {

	@Override
	public void close() {
		System.out.println("key close");
	}

	@Override
	public void open() {
		System.out.println("key open");
	}
}
