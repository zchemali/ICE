package windowSetup;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;

import eventsHandler.loginActions;

import java.awt.Insets;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.CardLayout;

public class LoginTerminal {

	private JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginTerminal window = new LoginTerminal();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the application.
	 */
	public LoginTerminal() {
		initialize();
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		
		
		JPanel loginTerminal_panel = new JPanel();
		
		GridBagLayout gbl_loginTerminal_panel = new GridBagLayout();
		gbl_loginTerminal_panel.columnWidths = new int[]{0, 0, 0};
		gbl_loginTerminal_panel.rowHeights = new int[]{0, 0, 0, 0};
		gbl_loginTerminal_panel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_loginTerminal_panel.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		loginTerminal_panel.setLayout(gbl_loginTerminal_panel);
		
		JLabel userName_label = new JLabel("User Name");
		userName_label.setFont(new Font("Times New Roman", Font.BOLD, 15));
		GridBagConstraints gbc_userName_label = new GridBagConstraints();
		gbc_userName_label.anchor = GridBagConstraints.NORTHEAST;
		gbc_userName_label.insets = new Insets(0, 0, 5, 5);
		gbc_userName_label.gridx = 0;
		gbc_userName_label.gridy = 0;
		loginTerminal_panel.add(userName_label, gbc_userName_label);
		
		textField = new JTextField();
		textField.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		textField.setColumns(10);
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 0;
		loginTerminal_panel.add(textField, gbc_textField);
		
		JLabel label_1 = new JLabel("Password");
		label_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.anchor = GridBagConstraints.EAST;
		gbc_label_1.insets = new Insets(0, 0, 5, 5);
		gbc_label_1.gridx = 0;
		gbc_label_1.gridy = 1;
		loginTerminal_panel.add(label_1, gbc_label_1);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		GridBagConstraints gbc_passwordField = new GridBagConstraints();
		gbc_passwordField.fill = GridBagConstraints.HORIZONTAL;
		gbc_passwordField.insets = new Insets(0, 0, 5, 0);
		gbc_passwordField.gridx = 1;
		gbc_passwordField.gridy = 1;
		loginTerminal_panel.add(passwordField, gbc_passwordField);
		
		JButton button = new JButton("Login");
		button.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		GridBagConstraints gbc_button = new GridBagConstraints();
		gbc_button.gridx = 1;
		gbc_button.gridy = 2;
		loginTerminal_panel.add(button, gbc_button);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setVisible(true);
		frame. setResizable(false);
		frame.getContentPane().add(loginTerminal_panel);
		button.addActionListener(new loginActions(textField,passwordField));
	}

}
