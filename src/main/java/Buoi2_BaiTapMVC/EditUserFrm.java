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
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JTextPane;

public class EditUserFrm extends JFrame implements ActionListener {

	private JTextField txtUsername;
	private JPasswordField txtPassword;
	private JTextField txtAge;
	private JTextField txtAddress;
	private JTextField txtFullname;
	private JTextField txtSearch;
	private JButton btnEdit;
	private JButton btnSearch;

	public EditUserFrm() {
		super("Edit MVC");

		txtUsername = new JTextField();
		txtPassword = new JPasswordField();
		txtAge = new JTextField();
		txtAddress = new JTextField();
		txtFullname = new JTextField();
		txtSearch = new JTextField();
		btnEdit = new JButton("Edit");
		btnSearch = new JButton("Search");

		JPanel panel = new JPanel(new GridLayout(8, 2));
		panel.add(new JLabel("Tim kiem"));
		panel.add(txtSearch);
		panel.add(new JLabel("xxx"));
		panel.add(btnSearch);
		panel.add(new JLabel("Username"));
		panel.add(txtUsername);
		panel.add(new JLabel("Password"));
		panel.add(txtPassword);
		panel.add(new JLabel("Age"));
		panel.add(txtAge);
		panel.add(new JLabel("Address"));
		panel.add(txtAddress);
		panel.add(new JLabel("Fullname"));
		panel.add(txtFullname);
		panel.add(new JLabel("xxx"));
		panel.add(btnEdit);
		btnEdit.addActionListener(this);
		btnSearch.addActionListener(this);

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
		if (btn.equals(btnSearch)) {
			btnSearch_actionperformed();
		} else {
			btnEdit_actionperformed();
		}
	}

	public void btnSearch_actionperformed() {
		System.out.println("OK");
		UserBean user = new UserBean().searchUser(txtSearch.getText());

		user = user.searchUser("hoanghoang3009");
		txtUsername.setText(user.getUsername());
		txtPassword.setText(user.getPassword());
		txtAge.setText("" + user.getAge());
		txtAddress.setText(user.getAddress());
		txtFullname.setText(user.getFullname());

	}

	public void btnEdit_actionperformed() {
		UserBean user = new UserBean();
		user.setUsername(txtUsername.getText());
		user.setPassword(txtPassword.getText());
		user.setAge(Integer.parseInt(txtAge.getText()));
		user.setAddress(txtAddress.getText());
		user.setFullname(txtFullname.getText());

		user.editUser();
		JOptionPane.showMessageDialog(this, "Add user successfully!");
	}
}
