package database;

import javax.swing.table.DefaultTableModel;

import org.bson.conversions.Bson;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.sun.xml.internal.txw2.Document;

public class InventoryFindOne {
	
	public InventoryFindOne (DefaultTableModel tableModel,MongoDatabase db,int barcode) {
		MongoCollection<org.bson.Document> collection = db.getCollection("Inventory");
//		MongoCursor<org.bson.Document> cursor = collection.find().iterator();
		Bson bsonFilter = Filters.eq("Barcode", barcode);
		org.bson.Document doc = collection.find(bsonFilter).first();
	
		tableModel.insertRow(0, new Object [] {doc.get("Barcode"),doc.get("Tire Name"),doc.get("Amount Available"),doc.get("Price per Item")});
	
	}
}
