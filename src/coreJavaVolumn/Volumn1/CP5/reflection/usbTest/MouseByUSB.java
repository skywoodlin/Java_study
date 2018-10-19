package coreJavaVolumn.Volumn1.CP5.reflection.usbTest;

public class MouseByUSB implements USB {

	@Override
	public void close() {
		System.out.println("mouse close");
	}

	@Override
	public void open() {
		System.out.println("mouse open");
	}

}
