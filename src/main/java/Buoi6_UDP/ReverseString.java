package Buoi6_UDP;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

public class ReverseString {
	private String _string;

	public ReverseString() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ReverseString(String _string) {
		super();
		this._string = _string;
	}

	public String get_string() {
		return _string;
	}

	public void set_string(String _string) {
		this._string = _string;
	}

	public String reverse() {
		String tmp = "";
		for (int i = _string.length(); i > 0; i--) {
			tmp += _string.substring(i-1, i);
		}
		return tmp;
	}

}
