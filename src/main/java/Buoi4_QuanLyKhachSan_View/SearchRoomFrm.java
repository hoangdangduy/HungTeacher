package Buoi4_QuanLyKhachSan_View;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;

import com.toedter.calendar.JDateChooser;

public class SearchRoomFrm extends JFrame {

	final private String[] listTypeRoom = { "thường", "hạng trung", "VIP" };

	private JDateChooser txtStartDate;
	private JDateChooser txtEndDate;
	private JComboBox cbTypeRoom;
	private JButton btnSearchRoom;
	private JTable tbRoom;
	private JButton btnXong;

	public SearchRoomFrm() {
		super("Search Room");
		txtStartDate = new JDateChooser();
		txtEndDate = new JDateChooser();
		cbTypeRoom = new JComboBox(listTypeRoom);
		btnSearchRoom = new JButton("Search");
		tbRoom = new JTable();
		btnXong = new JButton("Xong");

		JPanel content = new JPanel();
		content.setLayout(new GridBagLayout());

		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;
		c.insets = new Insets(5, 5, 5, 5);

		//Row 1
		c.gridx = 0;
		c.gridy = 0;
		content.add(new JLabel(""), c);
		c.gridx = 1;
		c.gridy = 0;
		content.add(new JLabel("     Search Free Room          "), c);
		
		// Row 2
		c.gridx = 0;
		c.gridy = 1;
		content.add(new JLabel("Start date: "), c);

		c.gridx = 1;
		content.add(txtStartDate, c);

		c.gridx = 3;
		c.gridwidth = 2;
		content.add(btnSearchRoom, c);

		// Row 3
		c.gridx = 0;
		c.gridy = 2;		
		content.add(new JLabel("End date: "), c);

		c.gridx = 1;
		c.gridwidth = 2;
		content.add(txtEndDate, c);
		

		// Row 4
		c.gridx = 0;
		c.gridy = 3;
		content.add(new JLabel("Type room: "), c);

		c.gridx = 1;
		content.add(cbTypeRoom, c);

		// Row 5
		c.gridx = 3;
		c.gridy = 4;
		content.add(tbRoom, c);

		this.setContentPane(content);
		this.pack();
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (int) ((dimension.getWidth() - this.getWidth()) / 2);
		int y = (int) ((dimension.getHeight() - this.getHeight()) / 2);
		this.setLocation(x, y);

	}

	public static void main(String[] args) {
		SearchRoomFrm frm = new SearchRoomFrm();
		frm.setVisible(true);
	}
}
