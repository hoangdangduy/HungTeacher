package Buoi5_TCPIp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class TCPClient {
	// khai bao socket cho client, luong vao-ra
	static Socket mySocket = null;
	static DataOutputStream os = null;
	static DataInputStream is = null;

	// Tao ket noi
	public static void connection() {
		try {
			mySocket = new Socket("localhost", 9999);
			os = new DataOutputStream(mySocket.getOutputStream());
			is = new DataInputStream(mySocket.getInputStream());
		} catch (UnknownHostException e) {
			System.err.println(e);
		} catch (IOException e) {
			System.err.println(e);
		}
	}

	public static void send(String str) { // gui du lieu den server
		if (mySocket != null && os != null) {
			try {
				os.writeBytes(str);
				System.out.println("in ra min hinh");
			} catch (UnknownHostException e) {
				System.err.println(e);
			} catch (IOException e) {
				System.err.println(e);
			}
		}
	}

	public static String receive() { // nhan du lieu tra ve tu server
		if (mySocket != null && is != null) {
			try {
				String responseStr;
				if ((responseStr = is.readLine()) != null) {
					System.out.println(responseStr);
					return responseStr;					
				}
			} catch (UnknownHostException e) {
				System.err.println(e);
			} catch (IOException e) {
				System.err.println(e);
			}
		}
		return null;
	}

	// dong cac ket noi
	public static void close() {
		if (mySocket != null && os != null && is != null) {
			try {
				os.close();
				is.close();
				mySocket.close();
			} catch (UnknownHostException e) {
				System.err.println(e);
			} catch (IOException e) {
				System.err.println(e);
			}
		}
	}

	public static void main(String[] args) {
	//	System.out.println("connection");
		connection();
	//	System.out.println("send");
		send("dang duy hoang");
	//	System.out.println("receive");
		String str = receive();
		System.out.println(str);
	}
}
