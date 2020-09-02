package database;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

public class updateInventory {
	public updateInventory(MongoDatabase db,Long barcode,String tireName,Integer amount,Double price) {
		MongoCollection<org.bson.Document> collection = db.getCollection("Inventory");
		Bson bsonFilter = Filters.eq("Barcode", barcode);
//		org.bson.Document doc = collection.find(bsonFilter).first();
		Document updated=new Document();
		Bson updatedValue=new Document("Amount Available", amount);
		Bson oper=new Document("$set",updatedValue);
//		updated.append("Barcode", barcode).append("Tire Name", tireName).append("Amount Available", amount).append("Price per Item", price);
		collection.updateOne(bsonFilter,oper);
	}

}
