package eventsHandler;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.mongodb.client.MongoDatabase;

import navigationPannel.NavigationPannel;
import panels.Inventory;
/**
 * This class handles all of the events that occur on the {@link #NavigationPannel}
 * 
 * @author zchem
 *
 */
public class NavigationPanelEvents implements MouseListener {
	private JPanel cardPanel,home, inventoryCheck, inventoryEdit, settings, logout;
	CardLayout c;
	MongoDatabase db;
	/**
	 * 
	 * @param c card layout which is passed from {@link #mainWindow}
	 * @param cardPanel the parent JPanel that contains all of the other JPanels and passed from {@link #mainWindow}
	 * @param home this is one of the navigation panels and passed from {@link #NavigationPannel}
	 * @param inventoryCheck this is one of the navigation panels and passed from {@link #NavigationPannel}
	 * @param inventoryEdit this is one of the navigation panels and passed from {@link #NavigationPannel}
	 * @param settings this is one of the navigation panels and passed from {@link #NavigationPannel}
	 * @param logout this is one of the navigation panels and passed from {@link #NavigationPannel}
	 * @param db 
	 * @param navigationPannel 
	 */
 public NavigationPanelEvents(CardLayout c,JPanel cardPanel,JPanel home, JPanel inventoryCheck, JPanel  inventoryEdit, JPanel settings,JPanel  logout, MongoDatabase db) {
	 this.cardPanel=cardPanel;
	 this.home=home;
	 this.inventoryCheck=inventoryCheck;
	 this.inventoryEdit=inventoryEdit;
	 this.settings=settings;
	 this.logout=logout;
	 this.c=c;
	 this.db=db;
}
	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource()==home)
			c.show(cardPanel, "Home");
		else if(e.getSource()==inventoryCheck)
			{
			cardPanel.add(new Inventory(cardPanel, c, db),"Inventory");
			c.show(cardPanel,"Inventory");
			}
		else if(e.getSource()==inventoryEdit)
			c.show(cardPanel, "Edit");
		else if(e.getSource()==settings)
			c.show(cardPanel, "Settings");
		else if (e.getSource()==logout) {
			 int temp = JOptionPane.showConfirmDialog(cardPanel, "Are you sure you want to logout", "Alert", JOptionPane.YES_NO_OPTION);
		if (temp==JOptionPane.YES_OPTION)
			System.exit(0);
			
	}}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		if(e.getSource()==home )
			home.setBackground(new Color(255,66,0));
		else if(e.getSource()==inventoryCheck)
			inventoryCheck.setBackground(new Color(255,66,0));
		else if(e.getSource()==inventoryEdit)
			inventoryEdit.setBackground(new Color(255,66,0));
		else if(e.getSource()==settings)
			settings.setBackground(new Color(255,66,0));
		else if (e.getSource()==logout) 
			logout.setBackground(new Color(255,66,0));
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		if(e.getSource()==home )
			home.setBackground(new Color(78,119,165));
		else if(e.getSource()==inventoryCheck)
			inventoryCheck.setBackground(new Color(78,119,165));
		else if(e.getSource()==inventoryEdit)
			inventoryEdit.setBackground(new Color(78,119,165));
		else if(e.getSource()==settings)
			settings.setBackground(new Color(78,119,165));
		else if (e.getSource()==logout) 
			logout.setBackground(new Color(78,119,165));
	}

}
