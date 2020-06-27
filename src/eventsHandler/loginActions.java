package eventsHandler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import windowSetup.loginTerminal;
import windowSetup.mainWindow;

/**
 * This class handles the evenets from @loginTerminal
 * @author zchem
 *
 */
public class loginActions implements ActionListener{
	private JTextField tf;
	private JPasswordField pf;
	private loginTerminal lt;
	private JFrame frame;
	String[] validNames=new String [2];
	String[] validPassword=new String[2];
public loginActions(loginTerminal lt,JTextField tf, JPasswordField pf,JFrame frame)
{
	this.tf=tf;
	this.pf=pf;
	this.lt=lt;
	this.frame=frame;
	 validNames[0]="Zchemali";
	 validNames[1]="ZiadChemali";
	 validPassword[0]="1234567";
	 validPassword[1]="1234567";

}
	@Override
	public void actionPerformed(ActionEvent e) {
		boolean check=false;
		for (int i=0;i<validNames.length;i++)
		{	if(validNames[i].equals(tf.getText()) && validPassword[i].contentEquals(pf.getText()))
			check=true;}
			if(check)
			{
				frame.dispose();
				new mainWindow();
			}
			else
				{JOptionPane.showMessageDialog(frame, "Incorrect combo");
				System.out.println(validNames[0].equals(tf.getText()));
				tf.setText("");
				pf.setName("");
				}
			
				
		
	}

}
