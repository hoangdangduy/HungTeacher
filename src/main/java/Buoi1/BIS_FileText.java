package Buoi1;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.charset.Charset;

public class BIS_FileText {
	public static void main(String[] args) {
		try {
			
			BufferedInputStream input = new BufferedInputStream(new FileInputStream("/home/hoang/Downloads/Session01/Case study 1.pdf"));
			BufferedOutputStream output = new BufferedOutputStream(new FileOutputStream("/home/hoang/Desktop/folder out/Case study 1.pdf"));
			byte[] in = new byte[1024];
			while ((input.read(in)) != -1) {
			//	System.out.println(in.length);
				String s = new String(in);
				output.write(in);
			}
			input.close();
			output.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
