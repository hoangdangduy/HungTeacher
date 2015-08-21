package Buoi2_CopySongSongTrenLop;

public class Main {
	public static void main(String[] args) {
		CopyFileThread cft = new CopyFileThread("/home/hoang/Downloads/b02-1 LTM Thread trong Java.pdf",
				"/home/hoang/Desktop/folder out/b02-1 LTM Thread trong Java.pdf");
		cft.start();
	}
}
