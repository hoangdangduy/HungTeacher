package Buoi2_BaiTapMVC;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AddUserFrm extends JFrame implements ActionListener {

	private JTextField txtUsername;
	private JTextField txtPassword;
	private JTextField txtAge;
	private JTextField txtAddress;
	private JTextField txtFullname;
	private JButton btnRegister;
	private JButton btnReset;

	public AddUserFrm() {

		super("Register MVC");
		txtUsername = new JTextField();
		txtPassword = new JTextField();
		txtAge = new JTextField();
		txtAddress = new JTextField();
		txtFullname = new JTextField();
		btnRegister = new JButton("Register");
		btnReset = new JButton("Reset");

		JPanel panel = new JPanel(new GridLayout(6, 2));
		panel.add(new JLabel("Username:"));
		panel.add(txtUsername);
		panel.add(new JLabel("Password"));
		panel.add(txtPassword);
		panel.add(new JLabel("Fullname:"));
		panel.add(txtFullname);
		panel.add(new JLabel("Address"));
		panel.add(txtAddress);
		panel.add(new JLabel("Age:"));
		panel.add(txtAge);
		panel.add(btnReset);
		panel.add(btnRegister);
		btnRegister.addActionListener(this);
		btnReset.addActionListener(this);

		this.setContentPane(panel);
		this.pack();

		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

	}

	public void actionPerformed(ActionEvent e) {
		JButton btn = (JButton) e.getSource();
		if (btn.equals(btnRegister)) {
			btnRegister_actionperformed();
		} else {
			btnReset_actionperformed();
		}
	}

	public void btnRegister_actionperformed() {
		UserBean user = new UserBean();
		user.setUsername(txtUsername.getText());
		user.setPassword(txtPassword.getText());
		user.setAge(Integer.parseInt(txtAge.getText()));
		user.setAddress(txtAddress.getText());
		user.setFullname(txtFullname.getText());

		user.addUser();
		JOptionPane.showMessageDialog(this, "Add user successfully!");
	}

	public void btnReset_actionperformed() {
		txtUsername.setText("");
		txtPassword.setText("");
		txtAge.setText("");
		txtAddress.setText("");
		txtFullname.setText("");
	}

}
