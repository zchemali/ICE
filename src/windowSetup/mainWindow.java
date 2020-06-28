package windowSetup;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JSplitPane;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Canvas;
import net.miginfocom.swing.MigLayout;
import java.awt.Color;
/**
 * This class creates the main window terminal where the user can navigate to different panels
 * panel1=home
 * panel2=InventoryCheck/selling(include column for date)
 * panel3=Inventory edit (possibly with password) ----include barcode/num of items/item name/location on the racking
 * panel4=Summary of sales
 * panel 5=settings (create a new password-edit the racking type/number of rackings
 * IMPORTANT NEED TO CREATE MULTIPLE CLASSES FOR THE WINDOW ELEMENTS INSTEAD OF HAVING ALL OF THESE ELEMNTS IN ONE METHOD
 * @author zchem
 *
 */
public class mainWindow  {

	private JFrame frame;
	private static final int WIDTH=400,HEIGHT=400;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mainWindow window = new mainWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public mainWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setSize(WIDTH,HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);
		//splits the container into two parts the navigation panel on the left and the display panles on the right WITH CARD LAYOUT
		JSplitPane splitPane = new JSplitPane();
		splitPane.setBounds(0, 30, WIDTH, HEIGHT);
		//need to make border of two sides fixed
		frame.getContentPane().add(splitPane);
		
		JPanel home_panel = new JPanel();
		splitPane.setRightComponent(home_panel);
		home_panel.setLayout(new CardLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		home_panel.add(scrollPane, "name_1073931092874200");
		
		JPanel panel = new JPanel();
		home_panel.add(panel, "name_1074184709261599");
		
		JPanel panel_1 = new JPanel();
		home_panel.add(panel_1, "name_1074188909790600");
		
		JPanel panel_2 = new JPanel();
		home_panel.add(panel_2, "name_1074192120796599");
		
		JPanel navigationPanel = new JPanel();
		splitPane.setLeftComponent(navigationPanel);
		GridBagLayout gbl_navigationPanel = new GridBagLayout();
		gbl_navigationPanel.columnWidths = new int[]{71, 0};
		gbl_navigationPanel.rowHeights = new int[]{39, 103, 80, 79, 0};
		gbl_navigationPanel.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_navigationPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		navigationPanel.setLayout(gbl_navigationPanel);
		
		JPanel homeNavigationPanel = new JPanel();
		GridBagConstraints gbc_homeNavigationPanel = new GridBagConstraints();
		gbc_homeNavigationPanel.fill = GridBagConstraints.BOTH;
		gbc_homeNavigationPanel.insets = new Insets(0, 0, 5, 0);
		gbc_homeNavigationPanel.gridx = 0;
		gbc_homeNavigationPanel.gridy = 0;
		navigationPanel.add(homeNavigationPanel, gbc_homeNavigationPanel);
		
		Canvas canvas = new Canvas(){
		
	public void paint(Graphics g) {
			
			System.out.println("hI");
			g.setColor(Color.GREEN);
			g.fillRect(0, 0, 5, 5);
		}};
		canvas.setSize(10, 10);
	
		
		homeNavigationPanel.add(canvas);
		
		
		JLabel lblNewLabel = new JLabel("New label");
		homeNavigationPanel.add(lblNewLabel);
		
		JPanel inventoryCheckNavigationPanel = new JPanel();
		GridBagConstraints gbc_inventoryCheckNavigationPanel = new GridBagConstraints();
		gbc_inventoryCheckNavigationPanel.fill = GridBagConstraints.BOTH;
		gbc_inventoryCheckNavigationPanel.insets = new Insets(0, 0, 5, 0);
		gbc_inventoryCheckNavigationPanel.gridx = 0;
		gbc_inventoryCheckNavigationPanel.gridy = 1;
		navigationPanel.add(inventoryCheckNavigationPanel, gbc_inventoryCheckNavigationPanel);
		inventoryCheckNavigationPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JPanel editInventoryNavigationPanel = new JPanel();
		GridBagConstraints gbc_editInventoryNavigationPanel = new GridBagConstraints();
		gbc_editInventoryNavigationPanel.fill = GridBagConstraints.BOTH;
		gbc_editInventoryNavigationPanel.insets = new Insets(0, 0, 5, 0);
		gbc_editInventoryNavigationPanel.gridx = 0;
		gbc_editInventoryNavigationPanel.gridy = 2;
		navigationPanel.add(editInventoryNavigationPanel, gbc_editInventoryNavigationPanel);
		
		JPanel settingsNavigationPanel = new JPanel();
		GridBagConstraints gbc_settingsNavigationPanel = new GridBagConstraints();
		gbc_settingsNavigationPanel.fill = GridBagConstraints.BOTH;
		gbc_settingsNavigationPanel.gridx = 0;
		gbc_settingsNavigationPanel.gridy = 3;
		navigationPanel.add(settingsNavigationPanel, gbc_settingsNavigationPanel);
		
		JPanel header_panel = new JPanel();
		header_panel.setBounds(0, 0, 370, 28);
		frame.getContentPane().add(header_panel);
	}
	

}
