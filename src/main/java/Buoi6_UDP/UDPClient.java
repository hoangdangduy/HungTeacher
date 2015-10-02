package Buoi6_UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Scanner;

public class UDPClient {
	// khai bao socket cho client, cong gui va nhan du lieu
	static DatagramSocket mySocket = null;
	static int port = 9980;

	// Tao ket noi
	public static void connection() {
		try {
			mySocket = new DatagramSocket(port);
		} catch (SocketException e) {
			System.err.println(e);
		}
	}

	// gui du lieu den server
	public static void send(String str) {
		if (mySocket != null) {
			byte[] sendData = new byte[1024]; // bo dem gui dl
			try {
				InetAddress IPAddress = InetAddress.getByName("127.0.0.1");
				sendData = str.getBytes();
				DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 9900);
				mySocket.send(sendPacket);
			} catch (SocketException e) {
				System.err.println(e);
			} catch (IOException e) {
				System.err.println(e);
			}
		}
	}

	// nhan du lieu tra ve tu server
	public static String receive() {
		if (mySocket != null) {
			byte[] receiveData = new byte[1024]; // bo dem nhan dl
			try {
				DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
				mySocket.receive(receivePacket);
				return new String(receivePacket.getData());
			} catch (SocketException e) {
				System.err.println(e);
			} catch (IOException e) {
				System.err.println(e);
			}
		}
		return null;
	}

	// dong cac ket noi
	public static void close() {
		if (mySocket != null) {
			try {
				mySocket.close();
			} catch (Exception e) {
				System.err.println(e);
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhap vao string = ");
		String str = sc.nextLine();
		connection();
		send(str);
		System.out.println(receive());
		
	}
}