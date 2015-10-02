package Buoi6_UDP_QuanLyNguoiDung;

public class ServerRun {
	public static void main(String[] args) {
		ServerView view = new ServerView();
		ServerControl control = new ServerControl(view);
	}
}