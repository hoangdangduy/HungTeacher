package Buoi2_CopySongSong;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class CopyFileThread extends Thread {
	//
	// private File folderIN;
	// private File folderOUT;
	// private String fileIN;
	//
	// public CopyFileThread(File folderIN, File folderOut, String fileIN) {
	// this.folderIN = folderIN;
	// this.folderOUT = folderOut;
	// this.fileIN = fileIN;
	// }
	//
	// public void copy() {
	// try {
	// int position = folderIN.toString().length();
	//
	// String fileTarge = fileIN.substring(position);
	//
	// BufferedInputStream input = new BufferedInputStream(new
	// FileInputStream(fileIN));
	// BufferedOutputStream output = new BufferedOutputStream(new
	// FileOutputStream(folderOUT + "/" + fileTarge));
	// byte[] in = new byte[1024];
	// int readbytes;
	// while ((readbytes = input.read(in)) != -1) {
	// // output.write(in);
	// output.write(in, 0, readbytes);
	// }
	// input.close();
	// output.close();
	// } catch (Exception e) {
	// System.err.println(e);
	// }
	// }
	//
	// public void run() {
	// copy();
	// }

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
