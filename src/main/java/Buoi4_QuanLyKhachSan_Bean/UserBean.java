package Buoi4_QuanLyKhachSan_Bean;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Connection;

public class UserBean {
	private String username;
	private String password;

	public UserBean(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public UserBean() {
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void login() {
		String dbUrl = "jdbc:mysql://localhost:3306/hotel";
		String dbClass = "com.mysql.jdbc.Driver";
		String sql = "SELECT COUNT(username) FROM tbluser WHERE username = ? and password = ?";
		try {
			Class.forName(dbClass);
			Connection con = (Connection) DriverManager.getConnection(dbUrl, "root", "");
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				if (rs.getInt(1) > 0) {
//					AddRoomFrm frm = new AddRoomFrm();
//					frm.setVisible(true);
				} else {
					JOptionPane.showMessageDialog(null, "Khong tim thay username trong CSDL");
				}
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
