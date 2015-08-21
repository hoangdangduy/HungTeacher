package Buoi2_DongHo;

public class MinuteThread extends Thread {
	private TimeFrame tf;
	private HourThread htd;
	private int count;

	public MinuteThread(TimeFrame tf, HourThread htd) {
		super();
		this.tf = tf;
		this.htd = htd;
		count = 0;
	}

	public void increase() {
		count++;
		if (count == 60) {
			htd.increase();
			count = 0;
		}
		tf.setMinute(count);
	}

	public void run() {
		while (true) {
			try {
				tf.setMinute(count);
			} catch (Exception e) {
				System.out.println(e.getStackTrace());
			}
		}
	}
}
