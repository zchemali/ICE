package navigationPannel;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JPanel;

import imageHandle.ImageLoader;

public class NavigationPannel extends JPanel {
	private ImageLoader loader;
private JPanel home,inventoryCheck,inventoryEdit,settings,logout;
	public NavigationPannel(int width,int height) {
		loader=new ImageLoader();
		this.setLayout(new GridBagLayout());
		this.setSize((new Dimension(width,height)));
		
		

	home = new JPanel();
	GridBagConstraints gbc_homeNavigationPanel = new GridBagConstraints();
	gbc_homeNavigationPanel.fill = GridBagConstraints.BOTH;
	gbc_homeNavigationPanel.insets = new Insets(0, 0, 5, 0);
	gbc_homeNavigationPanel.gridx = 0;
	gbc_homeNavigationPanel.gridy = 0;
	gbc_homeNavigationPanel.weighty = 0.01;
	this.add(home, gbc_homeNavigationPanel);
	
	home.setLayout(new FlowLayout());
	JLabel homeLabel = new JLabel("Home");
	
	Canvas canvas = new Canvas(){
	
public void paint(Graphics g) {
		
		g.drawImage(loader.getImage("/home_icon.png"),0,0,22,22,null);
	}};
	canvas.setSize(20, 20);

	
	home.add(canvas);
	home.add(homeLabel);
	
	
	
	inventoryCheck= new JPanel();
	GridBagConstraints gbc_inventoryCheckNavigationPanel = new GridBagConstraints();
	gbc_inventoryCheckNavigationPanel.fill = GridBagConstraints.BOTH;
	gbc_inventoryCheckNavigationPanel.insets = new Insets(0, 0, 5, 0);
	gbc_inventoryCheckNavigationPanel.gridx = 0;
	gbc_inventoryCheckNavigationPanel.gridy = 1;
	gbc_inventoryCheckNavigationPanel.weighty= 0.01;
	this.add(inventoryCheck, gbc_inventoryCheckNavigationPanel);
	inventoryCheck.setLayout(new FlowLayout());
	JLabel inventoryCheckLabel = new JLabel("Inventory");
	
	Canvas canvas2 = new Canvas(){
	
public void paint(Graphics g) {
		
		
		g.drawImage(loader.getImage("/inventory.png"),0,0,22,22,null);
	}};
	canvas2.setSize(20, 20);

	
	inventoryCheck.add(canvas2);
	inventoryCheck.add(inventoryCheckLabel);
	
	inventoryEdit = new JPanel();
	GridBagConstraints gbc_editInventoryNavigationPanel = new GridBagConstraints();
	gbc_editInventoryNavigationPanel.fill = GridBagConstraints.BOTH;
	gbc_editInventoryNavigationPanel.insets = new Insets(0, 0, 5, 0);
	gbc_editInventoryNavigationPanel.gridx = 0;
	gbc_editInventoryNavigationPanel.gridy = 2;
	gbc_editInventoryNavigationPanel.weighty = 0.01;
	this.add(inventoryEdit, gbc_editInventoryNavigationPanel);
	inventoryEdit.setLayout(new FlowLayout());
	JLabel inventoryEditLabel =new JLabel("Edit Inventory");
	
	Canvas canvas3=new Canvas() {
		public void paint (Graphics g) {
			g.drawImage(loader.getImage("/editInventory.png"), 0, 0, 22, 22,null);
		}
	};
	canvas3.setSize(20,20);
	inventoryEdit.add(canvas3);
	inventoryEdit.add(inventoryEditLabel);
	
	
	settings= new JPanel();
	GridBagConstraints gbc_settingsNavigationPanel = new GridBagConstraints();
	gbc_settingsNavigationPanel.fill = GridBagConstraints.BOTH;
	gbc_settingsNavigationPanel.gridx = 0;
	gbc_settingsNavigationPanel.gridy = 3;
	gbc_settingsNavigationPanel.weighty =0.1;
	this.add(settings, gbc_settingsNavigationPanel);
	settings.setLayout(new FlowLayout());
	JLabel settingsLabel=new JLabel("Settings");
	Canvas canvas4=new Canvas() {
		public void paint (Graphics g) {
			g.drawImage(loader.getImage("/settings.png"),0,0,22,22,null);
		}};
		canvas4.setSize(20,20);
		settings.add(canvas4);
		settings.add(settingsLabel);
		
		logout=new JPanel();
		GridBagConstraints gbc_logout = new GridBagConstraints();
		gbc_logout.fill = GridBagConstraints.BOTH;
		gbc_logout.gridx = 0;
		gbc_logout.gridy = 4;
		gbc_logout.weighty =0.01;
		this.add(logout,gbc_logout);
		
		Canvas canvas5 =new Canvas() {
			public void paint(Graphics g) {
				g.drawImage(loader.getImage("/logout.png"), 0,0,24,24,null);
			}
		};
		canvas5.setSize(25,25);
		logout.add(canvas5);
		
	
}}
