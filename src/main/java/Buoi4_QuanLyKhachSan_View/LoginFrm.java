package Buoi4_QuanLyKhachSan_View;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Buoi4_QuanLyKhachSan_Bean.UserBean;

public class LoginFrm extends JFrame implements ActionListener {
	private JTextField txtUsername;
	private JPasswordField txtPassword;
	private JButton btnLogin;

	public LoginFrm() {
		super("Login");
		txtUsername = new JTextField();
		txtPassword = new JPasswordField();
		btnLogin = new JButton("Login");

		JPanel content = new JPanel();
		content.setLayout(new GridLayout(3, 2));
		content.add(new JLabel("Username"));
		content.add(txtUsername);
		content.add(new JLabel("Password"));
		content.add(txtPassword);
		content.add(btnLogin);
		btnLogin.addActionListener(this);
		this.setContentPane(content);
		this.pack();
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (int) ((dimension.getWidth() - this.getWidth()) / 2);
		int y = (int) ((dimension.getHeight() - this.getHeight()) / 2);
		this.setLocation(x, y);
		

		// this.addWindowFocusListener(new WindowAdapter() {
		// public void windowClosing(WindowEvent e) {
		// System.exit(0);
		// }
		// });

		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

	}

	public void actionPerformed(ActionEvent e) {
		JButton btn = (JButton) e.getSource();
		if (btn.equals(btnLogin)) {
			btnLogin_actionperformed();

		}
	}

	public void btnLogin_actionperformed() {
		UserBean userBean = new UserBean();
		userBean.setUsername(txtUsername.getText());
		userBean.setPassword(txtPassword.getText());

		userBean.login();
		// JOptionPane.showMessageDialog(this, "Chuyen sang control");
	}

}
