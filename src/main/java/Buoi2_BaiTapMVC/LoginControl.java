package Buoi2_BaiTapMVC;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class LoginControl {
	private LoginModel model;
	private LoginView view;

	public LoginControl(LoginView view) {
		this.view = view;
		view.addLoginListener(new LoginListener());
	}

	class LoginListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			try {
				model = view.getUser();
				if (checkUser(model)) {
					view.showMessage("Login succesfully!");
				} else {
					view.showMessage("Invalid username and/or password!");
				}
			} catch (Exception e2) {
				view.showMessage(e2.getMessage().toString());
//				view.showMessage("co loi");
			}
		}
	}

	public boolean checkUser(LoginModel user) throws Exception {

		String dbUrl = "jdbc:mysql://localhost/hotel";
		String dbClass = "com.mysql.jdbc.Driver";
		String query = "SELECT * FROM users WHERE username = \"" + user.getUserName() + "\" AND password = \""
				+ user.getPassword() +"\"";
		System.out.println(query);

		try {
			Class.forName(dbClass);
			Connection con = DriverManager.getConnection(dbUrl,"root","");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);

			if (rs.next()) {
				return true;
			}

			con.close();

		} catch (Exception e) {
			throw e;
		}
		return false;
	}
}