package Buoi2_DongHo;

public class Test_hour {
	public static void main(String[] args) {

		TimeFrame tf = new TimeFrame();
		tf.setVisible(true);
		HourThread htd = new HourThread(tf);
		MinuteThread mtd = new MinuteThread(tf, htd);
		SecondThread std = new SecondThread(tf, mtd);
		htd.start();
		mtd.start();
		std.start();
	}
}
