package windowSetup;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JSplitPane;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.UIManager;
import java.awt.Canvas;
import java.awt.Insets;
import java.awt.GridLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.Sizes;

import imageHandle.ImageLoader;

import com.jgoodies.forms.layout.FormSpecs;
import java.awt.SystemColor;
import java.awt.Label;
import javax.swing.border.CompoundBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.BevelBorder;
import java.awt.CardLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLayeredPane;
import javax.swing.JMenuBar;

public class WindowNav {

	private JFrame frame;
	private ImageLoader loader;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WindowNav window = new WindowNav();
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
	public WindowNav() {
		initialize();
		loader =new ImageLoader();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 656, 356);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
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
		
		JSplitPane splitPane = new JSplitPane();
		frame.getContentPane().add(splitPane, BorderLayout.CENTER);
		
		JPanel tabPanel = new JPanel();
		tabPanel.setBorder(new CompoundBorder());
		tabPanel.setBackground(Color.WHITE);
		splitPane.setLeftComponent(tabPanel);
		tabPanel.setLayout(new FormLayout(new ColumnSpec[] {
				new ColumnSpec(ColumnSpec.FILL, Sizes.bounded(Sizes.PREFERRED, Sizes.constant("120dlu", true), Sizes.constant("120dlu", true)), 0),},
			new RowSpec[] {
				new RowSpec(RowSpec.CENTER, Sizes.bounded(Sizes.DEFAULT, Sizes.constant("30dlu", false), Sizes.constant("30dlu", false)), 0),
				new RowSpec(RowSpec.CENTER, Sizes.bounded(Sizes.DEFAULT, Sizes.constant("30dlu", false), Sizes.constant("30dlu", false)), 0),
				new RowSpec(RowSpec.CENTER, Sizes.bounded(Sizes.DEFAULT, Sizes.constant("30dlu", false), Sizes.constant("30dlu", false)), 0),
				new RowSpec(RowSpec.CENTER, Sizes.bounded(Sizes.DEFAULT, Sizes.constant("30dlu", false), Sizes.constant("30dlu", false)), 0),
				new RowSpec(RowSpec.CENTER, Sizes.bounded(Sizes.PREFERRED, Sizes.constant("162dlu", false), Sizes.constant("162dlu", false)), 5),}));
		
		JPanel homeNavPanel = new JPanel();
		homeNavPanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				homeNavPanel.setBackground(new Color(255,66,0));
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				homeNavPanel.setBackground(new Color(78,119,165)); 
			}
		});
		homeNavPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.WHITE, null, null, null));
		FlowLayout flowLayout = (FlowLayout) homeNavPanel.getLayout();
		flowLayout.setVgap(13);
		homeNavPanel.setBackground(new Color(78,119,165));
		tabPanel.add(homeNavPanel, "1, 1, fill, fill");
		
		Canvas homeIconCanvas = new Canvas();
		homeIconCanvas.setBackground(Color.RED);
		homeIconCanvas.setSize(20, 20);
		homeNavPanel.add(homeIconCanvas);
		
		JLabel homeLabel = new JLabel("Home");
	
		homeLabel.setForeground(SystemColor.menu);
		homeLabel.setFont(new Font("Arial Black", Font.PLAIN, 16));
		homeNavPanel.add(homeLabel);
		
		JPanel inventoryCheckNavPanel = new JPanel();
		inventoryCheckNavPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.WHITE, null, null, null));
		inventoryCheckNavPanel.setBackground(new Color(78,119,165));
		tabPanel.add(inventoryCheckNavPanel, "1, 2, fill, fill");
		inventoryCheckNavPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 13));
		
		Canvas inventoryIconCanvas = new Canvas();
		inventoryIconCanvas.setBackground(Color.RED);
		inventoryIconCanvas.setForeground(Color.RED);
		inventoryIconCanvas.setSize(20, 20);
		inventoryCheckNavPanel.add(inventoryIconCanvas);
		
		JLabel inventoryLabel = new JLabel("Inventory");
		inventoryLabel.setForeground(SystemColor.menu);
		inventoryLabel.setFont(new Font("Arial Black", Font.PLAIN, 16));
		inventoryCheckNavPanel.add(inventoryLabel);
		
		JPanel inventoryEditPanel = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) inventoryEditPanel.getLayout();
		flowLayout_1.setVgap(13);
		inventoryEditPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		inventoryEditPanel.setBackground(new Color(78,119,165));
		tabPanel.add(inventoryEditPanel, "1, 3, fill, fill");
		
		Canvas editIconCanvas = new Canvas();
		editIconCanvas.setSize(20, 20);
		inventoryEditPanel.add(editIconCanvas);
		
		JLabel EditLabel = new JLabel("Edit Inventory");
		EditLabel.setForeground(SystemColor.menu);
		EditLabel.setFont(new Font("Arial Black", Font.PLAIN, 16));
		inventoryEditPanel.add(EditLabel);
		
		JPanel settingsNavPanel = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) settingsNavPanel.getLayout();
		flowLayout_2.setVgap(13);
		settingsNavPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		settingsNavPanel.setBackground(new Color(78,119,165));
		tabPanel.add(settingsNavPanel, "1, 4, fill, fill");
		
		Canvas settingsIconCanvas = new Canvas();
		settingsIconCanvas.setSize(20,20);
		settingsNavPanel.add(settingsIconCanvas);
		
		JLabel settingsLAbel = new JLabel("Settings");
		settingsLAbel.setForeground(SystemColor.menu);
		settingsLAbel.setFont(new Font("Arial Black", Font.PLAIN, 16));
		settingsNavPanel.add(settingsLAbel);
		
		JPanel logoutPanel = new JPanel();
		logoutPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.WHITE, null, null, null));
		logoutPanel.setBackground(new Color(78,119,165));
		tabPanel.add(logoutPanel, "1, 5, fill, fill");
		logoutPanel.setLayout(new BoxLayout(logoutPanel, BoxLayout.Y_AXIS));
		
		Canvas canvaogoutIconCanvas = new Canvas();
		canvaogoutIconCanvas.setEnabled(false);
		canvaogoutIconCanvas.setSize(20, 20);
		logoutPanel.add(canvaogoutIconCanvas);
		
		JLabel logoutLabel = new JLabel("Logout");
		logoutLabel.setForeground(SystemColor.menu);
		logoutLabel.setFont(new Font("Arial Black", Font.PLAIN, 16));
		logoutPanel.add(logoutLabel);
		
		JPanel cardPanel = new JPanel();
		cardPanel.setMinimumSize(new Dimension(2000, 660));
		splitPane.setRightComponent(cardPanel);
		
		cardPanel.setLayout(new CardLayout(0, 0));
		
		JPanel homeCardPanel = new JPanel();
		homeCardPanel.setBackground(new Color(82,94,104));
		
		
		
		JLayeredPane home = new JLayeredPane();
		home.add(homeCardPanel);
		cardPanel.add(home, "Home");
		Canvas canvas_1 = new Canvas() {
			public void paint (Graphics g) {
				g.drawImage(loader.getImage("/cardPanel.jpg"), 0, 0,1800,1000, null);
			}
		};
		home.setLayer(canvas_1, 1);
		canvas_1.setSize(1800, 1000);
		home.add(canvas_1);
		
		JPanel inventoryCardPanel = new JPanel();
		inventoryCardPanel.setBackground(new Color(82,94,104));
		cardPanel.add(inventoryCardPanel, "Inventory");
		
		JLabel lblNewLabel_1 = new JLabel("inventpry");
		lblNewLabel_1.setForeground(SystemColor.text);
		inventoryCardPanel.add(lblNewLabel_1);
		
		JPanel inventoryEditCardPanel = new JPanel();
		inventoryEditCardPanel.setBackground(new Color(82,94,104));
		cardPanel.add(inventoryEditCardPanel, "Edit");
		
		JLabel lblNewLabel_2 = new JLabel("edit");
		lblNewLabel_2.setForeground(SystemColor.info);
		inventoryEditCardPanel.add(lblNewLabel_2);
		
		JPanel settingsCardPanel = new JPanel();
		settingsCardPanel.setBackground(new Color(82,94,104));
		cardPanel.add(settingsCardPanel, "Settings");
		
		JLabel lblNewLabel_3 = new JLabel("settings");
		lblNewLabel_3.setForeground(SystemColor.inactiveCaptionBorder);
		settingsCardPanel.add(lblNewLabel_3);
		
	}
}
