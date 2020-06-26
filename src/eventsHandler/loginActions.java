package eventsHandler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class loginActions implements ActionListener{
	private JTextField tf;
	private JPasswordField pf;
public loginActions(JTextField tf, JPasswordField pf)
{
	this.tf=tf;
	this.pf=pf;
}
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("hi");
	}

}
