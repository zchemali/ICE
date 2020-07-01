package windowSetup;

import javax.swing.JFrame;
import java.awt.Insets;
import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import eventsHandler.loginActions;
import imageHandle.ImageLoader;

import javax.swing.JPasswordField;
import javax.swing.JButton;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;
import java.awt.Canvas;
import java.awt.SystemColor;
import javax.swing.JLayeredPane;
import java.awt.Panel;
import java.awt.BorderLayout;
import java.awt.Label;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import java.awt.TextField;

/**
 * This class creates the login terminal -if username/password correct then open @mainWindow
 * @author zchem
 * @since 26/6/2020
 * @version 1.0
 *
 */
public class loginTerminal {

	private JFrame frame;
	private ImageLoader loader;
	private JPasswordField passwordField;
	/**
	 * Launch the application/ was used to set window
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					loginTerminal window = new loginTerminal();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Constructor to creat the GUI
	 */
	public loginTerminal() {
		loader=new ImageLoader();
		initialize();
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 500, 232);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame. setResizable(false);
		frame.setLocationRelativeTo(null);
		
		JLayeredPane layeredPane = new JLayeredPane();
		frame.getContentPane().add(layeredPane, BorderLayout.CENTER);
		layeredPane.setLayout(null);
		
		Canvas backgroundCanvas = new Canvas() {
			public void paint (Graphics g) {
				g.drawImage(loader.getImage("/loginBackground.png"), 0, 0, 500, 300, null);
			}
		};
		backgroundCanvas.setBounds(0, 0, 494, 197);
		layeredPane.add(backgroundCanvas);
		
		Canvas userNameIcon = new Canvas();
		userNameIcon.setBackground(Color.RED);
		layeredPane.setLayer(userNameIcon, 1);
		userNameIcon.setBounds(148, 48, 33, 24);
		layeredPane.add(userNameIcon);
		
		TextField textField = new TextField();
		layeredPane.setLayer(textField, 1);
		textField.setBounds(187, 48, 94, 24);
		layeredPane.add(textField);
		
		Canvas passwordIcon = new Canvas();
		layeredPane.setLayer(passwordIcon, 1);
		passwordIcon.setBackground(Color.RED);
		passwordIcon.setBounds(148, 87, 33, 24);
		layeredPane.add(passwordIcon);
		
		passwordField = new JPasswordField();
		layeredPane.setLayer(passwordField, 1);
		passwordField.setBounds(187, 87, 94, 22);
		layeredPane.add(passwordField);
		
		JButton btnNewButton = new JButton("Login");
		layeredPane.setLayer(btnNewButton, 1);
		btnNewButton.setBounds(184, 122, 97, 25);
		layeredPane.add(btnNewButton);
		
	}
}
