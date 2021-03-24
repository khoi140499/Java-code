package MyThread;

public class Test {

	public static void main(String[] args) {
		MyThread1 tt1=new MyThread1();
		tt1.setName("Tiến trình 1");
		tt1.start();//kich hoat tien trinh
		MyThread1 tt2=new MyThread1();
		tt2.setName("Tiến trình 2");
		tt2.start();
	}

}
