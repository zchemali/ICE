package racking;

import java.util.ArrayList;
/**
 * This class is used to look for columns and hanldes all of the abstract classes
 * @author zchem
 *
 */
public class Handler {
	ArrayList<Racking> rackingList=new ArrayList<Racking>();
	ArrayList<Product> productList=new ArrayList<Product>();
	
	public void add (Racking racking) {
		rackingList.add(racking);
	}
	public void addProduct (Product product) {
		productList.add(product);
	}


}
