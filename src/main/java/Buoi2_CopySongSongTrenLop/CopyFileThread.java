package Buoi2_CopySongSongTrenLop;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class CopyFileThread extends Thread {
	private String s1, s2;

	public CopyFileThread(String s1, String s2) {
		this.s1 = s1;
		this.s2 = s2;
	}

	public void copyFile(String s1, String s2) {
		try {
			BufferedInputStream input = new BufferedInputStream(new FileInputStream(s1));
			BufferedOutputStream output = new BufferedOutputStream(new FileOutputStream(s2));
			byte[] in = new byte[1024];
			int byteReads;
			while ((byteReads = input.read(in)) != -1) {
				output.write(in, 0, byteReads);
			}
			input.close();
			output.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	@Override
	public void run() {
		copyFile(s1, s2);
		this.stop();
	}

}
