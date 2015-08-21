package Buoi2_DongHo;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.Writer;
import java.util.Calendar;
import java.util.Random;

public class LogWriter extends Thread {
	private String filename;
	private long time;

	public LogWriter(String name, String filename, long time) {
		super(name);
		this.filename = filename;
		this.time = time;
	}

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			try {
				Writer wr = new BufferedWriter(new FileWriter(filename, true));
				
				this.sleep(time);
				wr.append(getName() + "[" + Calendar.getInstance().getTime() + "]: Log-" + i + "\r\n");
				wr.close();
			} catch (Exception e) {
				System.out.println(e.getStackTrace());
			}
		}
	}
}
