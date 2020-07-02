package navigationPannel;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.SystemColor;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.Sizes;

import eventsHandler.NavigationPanelEvents;
import imageHandle.ImageLoader;

/**
 * This class sets the navigation panel to the container
 * 
 * @author zchem
 *
 */
public class NavigationPannel extends JPanel {
	private ImageLoader loader;
	private JPanel cardPanel,home, inventoryCheck, inventoryEdit, settings, logout;
	private NavigationPanelEvents event;
	CardLayout c1;
	/**
	 * 
	 * @param width still not sure if needed
	 * @param height still not sure if needed
	 * @param cardPane this is the parent panel of right side of splitPane it is passed to the event class {@link #NavigationPanelEvents}
	 * @param c1 this is the card layout of the parent panel and it is passed to the event class {@link #NavigationPanelEvents}
	 */
	public NavigationPannel(int width, int height, JPanel cardPane, CardLayout c1) {
		loader = new ImageLoader();
		this.setLayout(new GridBagLayout());
		this.setSize((new Dimension(width, height)));
		this.setMaximumSize((new Dimension(width, height)));
		this.cardPanel=cardPane;
		this.c1=c1;
		this.setLayout(new FormLayout(new ColumnSpec[] {
				new ColumnSpec(ColumnSpec.FILL, Sizes.bounded(Sizes.PREFERRED, Sizes.constant("120dlu", true), Sizes.constant("120dlu", true)), 0),},
			new RowSpec[] {
				new RowSpec(RowSpec.CENTER, Sizes.bounded(Sizes.DEFAULT, Sizes.constant("30dlu", false), Sizes.constant("30dlu", false)), 0),
				new RowSpec(RowSpec.CENTER, Sizes.bounded(Sizes.DEFAULT, Sizes.constant("30dlu", false), Sizes.constant("30dlu", false)), 0),
				new RowSpec(RowSpec.CENTER, Sizes.bounded(Sizes.DEFAULT, Sizes.constant("30dlu", false), Sizes.constant("30dlu", false)), 0),
				new RowSpec(RowSpec.CENTER, Sizes.bounded(Sizes.DEFAULT, Sizes.constant("30dlu", false), Sizes.constant("30dlu", false)), 0),
				new RowSpec(RowSpec.CENTER, Sizes.bounded(Sizes.PREFERRED, Sizes.constant("162dlu", false), Sizes.constant("162dlu", false)), 5),}));
		
		home = new JPanel();
		home.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.WHITE, null, null, null));
		FlowLayout flowLayout = (FlowLayout) home.getLayout();
		flowLayout.setVgap(13);
		home.setBackground(new Color(78,119,165));
		this.add(home, "1, 1, fill, fill");
		
		Canvas homeIconCanvas = new Canvas() {
			public void paint(Graphics g) {
				g.drawImage(loader.getImage("/home_icon.png"), 0, 0, 22, 22,null);
			}};
		homeIconCanvas.setSize(20, 20);
		home.add(homeIconCanvas);
		
		JLabel homeLabel = new JLabel("Home");
		homeLabel.setForeground(SystemColor.menu);
		homeLabel.setFont(new Font("Arial Black", Font.PLAIN, 16));
		home.add(homeLabel);
		
		inventoryCheck = new JPanel();
		inventoryCheck.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.WHITE, null, null, null));
		inventoryCheck.setBackground(new Color(78,119,165));
		this.add(inventoryCheck, "1, 2, fill, fill");
		inventoryCheck.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 13));
		
		Canvas inventoryIconCanvas = new Canvas() {
			public void paint(Graphics g)
			{
				g.drawImage(loader.getImage("/inventory.png"), 0, 0, 22, 22, null);
		}};
		inventoryIconCanvas.setSize(20, 20);
		inventoryCheck.add(inventoryIconCanvas);
		
		JLabel inventoryLabel = new JLabel("Inventory");
		inventoryLabel.setForeground(SystemColor.menu);
		inventoryLabel.setFont(new Font("Arial Black", Font.PLAIN, 16));
		inventoryCheck.add(inventoryLabel);
		
		inventoryEdit = new JPanel();
		inventoryEdit.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 13));
		inventoryEdit.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		inventoryEdit.setBackground(new Color(78,119,165));
		this.add(inventoryEdit, "1, 3, fill, fill");
		
		Canvas editIconCanvas = new Canvas() {
			public void paint (Graphics g) {
				g.drawImage(loader.getImage("/editInventory.png"), 0, 0, 22, 22, null);
		}};
		editIconCanvas.setSize(20, 20);
		inventoryEdit.add(editIconCanvas);
		
		JLabel EditLabel = new JLabel("Edit Inventory");
		EditLabel.setForeground(SystemColor.menu);
		EditLabel.setFont(new Font("Arial Black", Font.PLAIN, 16));
		inventoryEdit.add(EditLabel);
		
		settings = new JPanel();
		settings.setLayout(new FlowLayout(FlowLayout.CENTER,5,13));
		settings.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		settings.setBackground(new Color(78,119,165));
		this.add(settings, "1, 4, fill, fill");
		
		Canvas settingsIconCanvas = new Canvas() {
			public void paint (Graphics g) {
				g.drawImage(loader.getImage("/settings.png"), 0, 0, 22, 22, null);
		}};
		settingsIconCanvas.setSize(20,20);
		settings.add(settingsIconCanvas);
		
		JLabel settingsLAbel = new JLabel("Settings");
		settingsLAbel.setForeground(SystemColor.menu);
		settingsLAbel.setFont(new Font("Arial Black", Font.PLAIN, 16));
		settings.add(settingsLAbel);
		
		logout = new JPanel();
		logout.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.WHITE, null, null, null));
		logout.setBackground(new Color(78,119,165));
		logout.setLayout(new GridBagLayout());
		GridBagConstraints c=new GridBagConstraints();
		c.anchor=GridBagConstraints.SOUTH;
		
		this.add(logout, "1, 5, fill, fill");
		
		Canvas canvaogoutIconCanvas = new Canvas() {
			public void paint (Graphics g) {
				g.drawImage(loader.getImage("/logout.png"), 0, 0, 30, 30, null);
		}};
		canvaogoutIconCanvas.setSize(30, 30);
		logout.add(canvaogoutIconCanvas);
		event=new NavigationPanelEvents(c1, cardPanel, home, inventoryCheck, inventoryEdit, settings, logout);
		home.addMouseListener(event);
		inventoryCheck.addMouseListener(event);
		inventoryEdit.addMouseListener(event);
		settings.addMouseListener(event);
		logout.addMouseListener(event);
		/*
		 * not needed
		JLabel logoutLabel = new JLabel("Logout");
		logoutLabel.setForeground(SystemColor.menu);
		logoutLabel.setFont(new Font("Arial Black", Font.PLAIN, 16));
		logoutPanel.add(logoutLabel);
		
		JPanel cardPanel = new JPanel();
		splitPane.setRightComponent(cardPanel);
		cardPanel.setLayout(new CardLayout(0, 0));
		
		JPanel homeCardPanel = new JPanel();
		cardPanel.add(homeCardPanel, "Home");
		
		JPanel inventoryCardPanel = new JPanel();
		cardPanel.add(inventoryCardPanel, "Inventory");
		
		JPanel inventoryEditCardPanel = new JPanel();
		cardPanel.add(inventoryEditCardPanel, "Edit");
		
		JPanel settingsCardPanel = new JPanel();
		cardPanel.add(settingsCardPanel, "Settings");
		
	}
		*/

	}
}
