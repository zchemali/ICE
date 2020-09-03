package database;

import javax.swing.table.DefaultTableModel;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.sun.xml.internal.txw2.Document;

public class InventoryLoader {
	public InventoryLoader(DefaultTableModel tableModel,MongoDatabase db) {
		MongoCollection<org.bson.Document> collection = db.getCollection("Inventory");
		MongoCursor<org.bson.Document> cursor = collection.find().iterator();
		try {
		    while (cursor.hasNext()) {
		    	org.bson.Document doc =cursor.next();
		    	tableModel.insertRow(0, new Object [] {doc.get("Barcode"),doc.get("Tire Name"),doc.get("Amount Available"),doc.get("Price per Item")});
//		        System.out.println(doc.get("Barcode")+" "+doc.get("Tire Name"));
//		    cursor.next();
		    }
		} finally {
		    cursor.close();
		}
		
	}

}
