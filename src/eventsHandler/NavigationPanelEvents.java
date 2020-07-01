package eventsHandler;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;
/**
 * This class handles all of the events that occur on the {@link #NavigationPannel}
 * 
 * @author zchem
 *
 */
public class NavigationPanelEvents implements MouseListener {
	private JPanel cardPanel,home, inventoryCheck, inventoryEdit, settings, logout;
	CardLayout c;
	/**
	 * 
	 * @param c card layout which is passed from {@link #mainWindow}
	 * @param cardPanel the parent JPanel that contains all of the other JPanels and passed from {@link #mainWindow}
	 * @param home this is one of the navigation panels and passed from {@link #NavigationPannel}
	 * @param inventoryCheck this is one of the navigation panels and passed from {@link #NavigationPannel}
	 * @param inventoryEdit this is one of the navigation panels and passed from {@link #NavigationPannel}
	 * @param settings this is one of the navigation panels and passed from {@link #NavigationPannel}
	 * @param logout this is one of the navigation panels and passed from {@link #NavigationPannel}
	 */
 public NavigationPanelEvents(CardLayout c,JPanel cardPanel,JPanel home, JPanel inventoryCheck, JPanel  inventoryEdit, JPanel settings,JPanel  logout) {
	 this.cardPanel=cardPanel;
	 this.home=home;
	 this.inventoryCheck=inventoryCheck;
	 this.inventoryEdit=inventoryEdit;
	 this.settings=settings;
	 this.logout=logout;
	 this.c=c;
}
	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource()==home)
			c.show(cardPanel, "Inventory");
	}

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
		if(e.getSource()==home)
			home.setBackground(Color.WHITE);
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
