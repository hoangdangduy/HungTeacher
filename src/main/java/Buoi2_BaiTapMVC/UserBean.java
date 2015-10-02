package Buoi2_BaiTapMVC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class UserBean {
	private String username;
	private String password;
	private int age;
	private String address;
	private String fullname;

	public UserBean() {
	}

	public UserBean(String username, String password, int age, String address, String fullname) {
		super();
		this.username = username;
		this.password = password;
		this.age = age;
		this.address = address;
		this.fullname = fullname;
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public void addUser() {
		String dbUrl = "jdbc:mysql://localhost:3306/hotel";
		String dbClass = "com.mysql.jdbc.Driver";
		String sql = "INSERT INTO users(username, password, age, address, fullname) VALUES(?,?,?,?,?)";
		try {
			Class.forName(dbClass);
			Connection con = DriverManager.getConnection(dbUrl, "root", "");
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, getUsername());
			ps.setString(2, getPassword());
			ps.setInt(3, getAge());
			ps.setString(4, getAddress());
			ps.setString(5, getFullname());
			ps.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			;
		}
	}

	public void editUser() {
		// update tblUser set username = ?, password = ? where id = ?
		String dbUrl = "jdbc:mysql://localhost:3306/hotel";
		String dbClass = "com.mysql.jdbc.Driver";
		String sql = "UPDATE users set username = ?, password = ?, age = ?, address = ?, fullname = ? where username = ?";
		try {
			Class.forName(dbClass);
			Connection con = DriverManager.getConnection(dbUrl, "root", "");
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, getUsername());
			ps.setString(2, getPassword());
			ps.setInt(3, getAge());
			ps.setString(4, getAddress());
			ps.setString(5, getFullname());
			ps.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			;
		}
	}

	public UserBean searchUser(String us) {

		String dbUrl = "jdbc:mysql://localhost:3306/hotel";
		String dbClass = "com.mysql.jdbc.Driver";
		String query = "Select * From users where username = \"" + us + "\"";
		UserBean userBean = null;
		try {
			Class.forName(dbClass);
			Connection con = DriverManager.getConnection(dbUrl, "root", "");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {
				username = rs.getString("username");
				password = rs.getString("password");
				age = rs.getInt("age");
				address = rs.getString("address");
				fullname = rs.getString("fullname");
				userBean = new UserBean(username, password, age, address, fullname);
				return userBean;
			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage() + " Error");
		}
		return null;
	}

}
