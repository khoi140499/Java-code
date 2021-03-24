package MyThread;

public class TestChiaSeBien {

	public static void main(String[] args) {
		MyThread2 a=new MyThread2();
		Thread v=new Thread(a);
		v.setName("tt1 ");
		v.start();
		Thread b=new Thread(a);
		b.setName("tt2 ");
		b.start();
		Thread c=new Thread(a);
		c.setName("tt3 ");
		c.start();
		System.out.println(" X bay gio lay ra: "+a.getX());
	}

}
