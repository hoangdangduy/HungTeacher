package Buoi2_GhiLog;

public class Test {
	public static void main(String[] args) {
		LogWriter lw1 = new LogWriter("thread1", "log.txt", 3000);
		LogWriter lw2 = new LogWriter("thread2", "log.txt", 2000);
		lw1.start();
		lw2.start();
	}
}
