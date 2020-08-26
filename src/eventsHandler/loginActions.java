package eventsHandler;

import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoDatabase;

import windowSetup.loginTerminal;
import windowSetup.mainWindow;

/**
 * This class handles the evenets from @loginTerminal
 * @author zchem
 *
 */
public class loginActions implements ActionListener{
	private TextField tf;
	private JPasswordField pf;
	private MongoDatabase db;
	private MongoClient mongoClient;
//	private loginTerminal lt;
	private JFrame frame;
//	String[] validNames=new String [2];//used to store correct user name 
//	String[] validPassword=new String[2];//used to store correct passwords
public loginActions(TextField textField, JPasswordField pf,JFrame frame)
{	
//	MongoClient mongoClient = new MongoClient();
//	DB database = mongoClient.getDB("myMongoDb");
//	boolean auth = database.

	this.tf=textField;
	this.pf=pf;
//	this.lt=lt;
	this.frame=frame;
	//temp in future i want the user to be able to set up the password via email
//	 validNames[0]="Zchemali";
//	 validNames[1]="ZiadChemali";
//	 validPassword[0]="1234567";
//	 validPassword[1]="1234567";

}
/**
 * Overrides the method in the interface-checks if the userName/Paswword combo are valid-
 * if combo is correct then create the @mainWindow
 */
	@Override
	public void actionPerformed(ActionEvent e) {
		String user=tf.getText();
		String pwd=pf.getText();
//		String URL=	"mongodb://"+user+":"+pwd+"@ice-shard-00-00.aetvl.mongodb.net:27017,ice-shard-00-01.aetvl.mongodb.net:27017,ice-shard-00-02.aetvl.mongodb.net:27017/ICE?ssl=true&replicaSet=atlas-v1nylr-shard-0&authSource=admin&retryWrites=true&w=majority";
		String URL="mongodb+srv://"+user+":"+pwd+"@ice.aetvl.mongodb.net/ICE?retryWrites=true&w=majority";
//		String URL="mongodb+srv://"+user+":"+pwd+"@ice.aetvl.mongodb.net/ICE?retryWrites=true&w=majority";
		MongoClientURI uri = new MongoClientURI(URL);
		mongoClient=new MongoClient(uri);
		db=mongoClient.getDatabase(uri.getDatabase());
		
		try {
			System.out.println(mongoClient.getDatabaseNames());
			System.out.println(db.getName());}
		catch (Exception e1) {
							
				{JOptionPane.showMessageDialog(frame, "Incorrect combo");
				tf.setText("");
				pf.setName("");
				
				}
			
				
		
	}

}}
