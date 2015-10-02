package Buoi6_UDP_QuanLyNguoiDung;

import java.io.Serializable;

public class Number implements Serializable {
	private int a;
	private int b;
	private int tong;

	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}

	public int getB() {
		return b;
	}

	public void setB(int b) {
		this.b = b;
	}

	public int getTong() {
		return tong;
	}

	public void setTong(int tong) {
		this.tong = tong;
	}

	public Number(int a, int b) {
		super();
		this.a = a;
		this.b = b;
	}

}
