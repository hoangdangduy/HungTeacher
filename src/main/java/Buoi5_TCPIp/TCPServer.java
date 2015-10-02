package Buoi5_TCPIp;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
	// Khai bao server socket, luong vao-ra, va doi tuong socket
	static ServerSocket myServer = null;
	static String input;
	static DataInputStream is;
	static PrintStream os;
	static Socket clientSocket = null;

	// Mo mot server socket
	public static void openServer() {
		try {
			myServer = new ServerSocket(9999);
		} catch (IOException e) {
			System.out.println(e);
		}
	}

	// Chap nhan ket noi va xu li du lieu
	public static void listening() {
		try {
			clientSocket = myServer.accept();
			is = new DataInputStream(clientSocket.getInputStream());
			os = new PrintStream(clientSocket.getOutputStream());
			// Xu li du lieu nhan duoc va tra ve
			while (true) {
				// doc du lieu vao
				input = is.readLine();
				// xu li du lieu
				System.out.println("sai a");
				System.out.println(input);
				ReverseString str = new ReverseString(input);
				str.reverse();
				System.out.println(str);
				// tra ve du lieu
				os.println(str.get_string());
			}
		} catch (IOException e) {
			System.out.println(e);
		}
	}

	public static void main(String[] args) {
		System.out.println("open");
		openServer();
		System.out.println("listening");
		listening();
	}
}