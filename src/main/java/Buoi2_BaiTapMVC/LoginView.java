package Buoi2_BaiTapMVC;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.sun.glass.events.WindowEvent;

public class LoginView extends JFrame implements ActionListener {

	private JTextField txtUsername;
	private JPasswordField txtPassword;
	private JButton btnLogin;
	private LoginModel model;

	public LoginView() {
		super("Login MVC");

		txtUsername = new JTextField();
		txtPassword = new JPasswordField(15);
		txtPassword.setEchoChar('*');
		btnLogin = new JButton("Login");

		JPanel content = new JPanel();
		content.setLayout(new GridLayout(3, 2));
		content.add(new JLabel("Username:"));
		content.add(txtUsername);
		content.add(new JLabel("Password:"));
		content.add(txtPassword);
		content.add(btnLogin);

		this.setContentPane(content);
		this.pack();

		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	}

	public LoginModel getUser() {
		model = new LoginModel(txtUsername.getText(), txtPassword.getText());
		return model;
	}

	public void showMessage(String msg) {
		JOptionPane.showMessageDialog(this, msg);
	}

	public void addLoginListener(ActionListener log) {
		btnLogin.addActionListener(log);
	}

}
