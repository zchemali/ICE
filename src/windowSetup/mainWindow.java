package windowSetup;

import java.awt.EventQueue;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JSplitPane;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import navigationPannel.NavigationPannel;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Canvas;
import net.miginfocom.swing.MigLayout;
import java.awt.Color;
import java.awt.Dimension;
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
	private static final int WIDTH=400,HEIGHT=400,HEADERHEIGHT=40;;
	
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
		frame.setSize(448,594);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
	
		JPanel headerPanel = new JPanel();
		headerPanel.setBackground(new Color(32,43,65));
		
		frame.getContentPane().add(headerPanel, BorderLayout.NORTH);
		GridBagLayout gbl_headerPanel = new GridBagLayout();
		gbl_headerPanel.columnWidths = new int[]{20, 268};
		gbl_headerPanel.rowHeights = new int[] {58};
		gbl_headerPanel.columnWeights = new double[]{0.0, 4.9E-324};
		gbl_headerPanel.rowWeights = new double[]{0.0};
		headerPanel.setLayout(gbl_headerPanel);
		
		Canvas canvas = new Canvas();
		canvas.setBackground(Color.YELLOW);
		GridBagConstraints gbc_canvas = new GridBagConstraints();
		gbc_canvas.fill = GridBagConstraints.BOTH;
		gbc_canvas.insets = new Insets(0, 0, 0, 5);
		gbc_canvas.gridx = 0;
		gbc_canvas.gridy = 0;
		headerPanel.add(canvas, gbc_canvas);
		
		JLabel titleLabel = new JLabel("ICE");
		titleLabel.setForeground(Color.WHITE);
		titleLabel.setFont(new Font("Microsoft Himalaya", Font.BOLD, 26));
		GridBagConstraints gbc_titleLabel = new GridBagConstraints();
		gbc_titleLabel.fill = GridBagConstraints.BOTH;
		gbc_titleLabel.gridx = 1;
		gbc_titleLabel.gridy = 0;
		headerPanel.add(titleLabel, gbc_titleLabel);
		//frame.getContentPane().setLayout(null);
		//splits the container into two parts the navigation panel on the left and the display panles on the right WITH CARD LAYOUT
		JSplitPane splitPane = new JSplitPane();
		splitPane.setOneTouchExpandable(false);
		//splitPane.setDividerLocation(0.3);
		
		//need to make border of two sides fixed
		frame.getContentPane().add(splitPane, BorderLayout.CENTER);
		
		JPanel cardPane = new JPanel();
		cardPane.setMinimumSize(new Dimension(2000,HEIGHT-HEADERHEIGHT));
		splitPane.setRightComponent(cardPane);
		CardLayout c= new CardLayout(0,0);
	
		cardPane.setLayout(c);
		
		JPanel homePanel = new JPanel();
		
		cardPane.add(homePanel,"Home");
		
		JPanel inventoryCheckPanel = new JPanel();
		JLabel l=new JLabel("THIS IS INVENTORY bro");
		inventoryCheckPanel.add(l);
		cardPane.add(inventoryCheckPanel,"Inventory");
		
		JPanel inventoryEditPanel = new JPanel();
		cardPane.add(inventoryEditPanel,"Edit");
		
		JPanel settingsPanel = new JPanel();
		
		cardPane.add(settingsPanel,"Settings");
		
		//NavigationPannel np=new NavigationPannel(WIDTH/4,HEIGHT-28,)
		splitPane.setLeftComponent(new NavigationPannel(WIDTH/4,HEIGHT-28,cardPane,c));
	
	}
	

}
