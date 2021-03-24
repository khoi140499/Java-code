package MyThread;

public class Test2 {

	public static void main(String[] args) {
		Thread tt1=new Thread(new MyThread2());
		tt1.setName("Tiến trình 3 ");
		tt1.start();
		Thread tt2=new Thread(new MyThread2());
		tt2.setName("Tiến trình 4 ");
		tt2.start();

	}

}
