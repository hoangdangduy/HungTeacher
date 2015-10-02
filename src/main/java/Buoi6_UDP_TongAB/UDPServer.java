package Buoi6_UDP_TongAB;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class UDPServer {
	static DatagramSocket myServer = null;
	static String input;
	static int port = 9900;

	// Mo mot server socket
	public static void openServer() {
		try {
			myServer = new DatagramSocket(port);
		} catch (SocketException e) {
			System.out.println(e);
		}
	}

	// Chap nhan ket noi va xu li du lieu
	public static void listening() {
		byte[] receiveData = new byte[1024];
		byte[] sendData = new byte[1024];
		while (true) {
			try {
				// Nhan du lieu
				DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
				myServer.receive(receivePacket);
				input = new String(receivePacket.getData());

				// Xu li du lieu ,Dong goi thong tin du lieu can tra lai
				InetAddress IPAddress = receivePacket.getAddress();
				int port = receivePacket.getPort();
				sendData = String.valueOf(sum(input)).getBytes();
				DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, port);
				// Gui du lieu ve client
				myServer.send(sendPacket);
			} catch (SocketException e) {
				System.out.println(e);
			} catch (IOException e) {
				System.out.println(e);
			}
		}
	}

	public static int sum(String str) {
		int a;
		int b;
		str = str.trim();
		String[] part = str.split(" ");
		a = Integer.parseInt(part[0]);
		b = Integer.parseInt(part[1]);
		return (a + b);
	}

	public static void main(String[] args) {
		openServer();
		listening();
	}
}