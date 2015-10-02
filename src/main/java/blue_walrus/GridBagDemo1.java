package blue_walrus;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class GridBagDemo1 extends JFrame {

	public GridBagDemo1() {
		initGUI();
	}

	public void initGUI() {

		setTitle("Title");

		JPanel panel = new JPanel(new GridBagLayout());
		this.getContentPane().add(panel);

		JTable t = new JTable(null);

		JLabel label = new JLabel("My Things");

		JPanel tableButtonPanel = new JPanel();
		tableButtonPanel.add(new JButton("Add Thing"));
		tableButtonPanel.add(new JButton("Delete Thing"));
		tableButtonPanel.add(new JButton("Modify Thing"));

		JPanel buttonPanel = new JPanel();
		buttonPanel.add(new JButton("Print"));
		buttonPanel.add(new JButton("History"));
		buttonPanel.add(new JButton("Preferences"));
		buttonPanel.add(new JButton("Another Button"));
		buttonPanel.add(new JButton("Add Another"));
		buttonPanel.add(new JButton("Yet Another"));

		JPanel detailsPanel = new JPanel();
		detailsPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.anchor = GridBagConstraints.WEST;

		gbc.gridx = 0;
		gbc.gridy = 0;

		panel.add(label, gbc);

		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;
		panel.add(new JScrollPane(t), gbc);

		gbc.gridx = 0;
		gbc.gridy = 2;
		panel.add(tableButtonPanel, gbc);

		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.gridwidth = 2;
		panel.add(buttonPanel, gbc);

		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		gbc.gridheight = 2;
		// panel.add(detailsPanel, gbc);
		gbc.anchor = GridBagConstraints.NORTH;
		panel.add(createDetailsPanel(), gbc);

		this.pack();

		this.setVisible(true);
	}

	private JPanel createDetailsPanel() {

		JPanel panel = new JPanel();

		JLabel thingNameLabel = new JLabel("Thing Name");
		JLabel anAttributeLabel = new JLabel("An Attribute");
		JLabel dateFieldLabel = new JLabel("Date Field");
		JLabel anAttLabel = new JLabel("An Att");
		JLabel anotherAttLabel = new JLabel("Another Att");
		JLabel anotherAtt2Label = new JLabel("Another Att");

		JTextField thingNameField = new JTextField("Thing Name");
		JTextField anAttributeField = new JTextField("An Attribute");
		JTextField dateFieldField = new JTextField("Date Field");
		JTextField anAttField = new JTextField("");
		JTextArea anotherAttField = new JTextArea(3, 1);
		JTextField anotherAtt2Field = new JTextField("", 10);

		JCheckBox checkbox1 = new JCheckBox("A Checkbox1");
		JCheckBox checkbox2 = new JCheckBox("A Checkbox2");

		panel.setLayout(new GridBagLayout());

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(2, 2, 2, 2);
		gbc.anchor = GridBagConstraints.NORTHEAST;

		int i = 0;

		gbc.gridx = 0;
		gbc.gridy = i;		
		panel.add(thingNameLabel, gbc);

		gbc.gridx = 1;
		gbc.gridy = i;
		gbc.gridwidth = 2;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		panel.add(thingNameField, gbc);
		
		i++;

		gbc.gridx = 1;
		gbc.gridy = i;
		panel.add(checkbox1, gbc);
		
		i++;

		gbc.gridx = 0;
		gbc.gridy = i;
		gbc.gridwidth = 1;
//		gbc.fill = GridBagConstraints.NONE;
		panel.add(anAttributeLabel, gbc);

		gbc.gridx = 1;
		gbc.gridy = i;
		gbc.gridwidth = 2;
//		gbc.fill = GridBagConstraints.HORIZONTAL;
		panel.add(anAttributeField, gbc);

		i++;

		gbc.gridx = 0;
		gbc.gridy = i;
		panel.add(dateFieldLabel, gbc);

		gbc.gridx = 1;
		gbc.gridy = i;
		panel.add(dateFieldField, gbc);

		i++;

		gbc.gridx = 0;
		gbc.gridy = i;
		panel.add(anAttLabel, gbc);

		gbc.gridx = 1;
		gbc.gridy = i;
		panel.add(anAttField, gbc);

		i++;

		gbc.gridx = 0;
		gbc.gridy = i;
		panel.add(anotherAttLabel, gbc);

		gbc.gridx = 1;
		gbc.gridy = i;
		panel.add(anotherAttField, gbc);

		i++;
		gbc.gridx = 0;
		gbc.gridy = i;
		panel.add(anotherAtt2Label, gbc);

		gbc.gridx = 1;
		gbc.gridy = i;
		panel.add(anotherAtt2Field, gbc);

		i++;
		
		gbc.gridx = 1;
		gbc.gridy = i;
		panel.add(checkbox2, gbc);

		return panel;
	}

	public static void main(String[] args) {
		GridBagDemo1 frame = new GridBagDemo1();

		frame.pack();		
		frame.setVisible(true);
	}
}