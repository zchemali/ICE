package database;

import java.sql.Date;

import javax.swing.table.DefaultTableModel;

import org.bson.Document;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class PurchaseWriter {
	public PurchaseWriter(MongoDatabase db, Long barcodePurchase, String tireNamePurchase, Integer amountPurchase, Double priceUnitPurchase, Double totalPurchase,
			Double taxPurchase, Double afterTaxPurchase, String namePurchase, String lastNamePurchase, String phonePurchase, String emailPurchase, 
			String adressPurchase, String cityPurchase, String provincePurchase, String paymentPurchase, Integer dayPurchase, Integer monthPurchase, Integer yearPurchase) {
		MongoCollection<org.bson.Document> collection = db.getCollection("Purchase");
		Document doc =new Document("ID",lastNamePurchase+barcodePurchase);
		doc.append("Barcode", barcodePurchase);
		doc.append("Tire Name", tireNamePurchase);
		doc.append("Amount purchased", amountPurchase);
		doc.append("Price per Tire", priceUnitPurchase);
		doc.append("Total before Tax", totalPurchase);
		doc.append("Tax", taxPurchase);
		doc.append("After Tax", afterTaxPurchase);
		doc.append("Year", yearPurchase);
		doc.append("Month",monthPurchase);
		doc.append("Day", dayPurchase);
		doc.append("Customer info", new Document("Name",namePurchase+" "+lastNamePurchase).append("Phone", phonePurchase).append("Email", emailPurchase)
				.append("Adress", adressPurchase).append("City", cityPurchase).append("Prov", provincePurchase).append("Payment", paymentPurchase));
		
		
		collection.insertOne(doc);
		
	}
	}
