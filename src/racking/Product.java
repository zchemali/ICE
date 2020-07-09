package racking;

import java.util.ArrayList;

public abstract class Product {
	protected String barcode;//barcode
	protected String name;//of product
	protected int amount;//amunt of product
	String column;
	int row,depth;
	
	
	
	public Product(String barcode,String name,int amount,String column,int row,int depth) {
		this.barcode=barcode;
		this.name=name;
		this.amount=amount;
		this.column=column;
		this.row=row;
		this.depth=depth;
	}



	public String getBarcode() {
		return barcode;
	}



	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public int getAmount() {
		return amount;
	}



	public void setAmount(int amount) {
		this.amount = amount;
	}



	public String getColumn() {
		return column;
	}



	public void setColumn(String column) {
		this.column = column;
	}



	public int getRow() {
		return row;
	}



	public void setRow(int row) {
		this.row = row;
	}



	public int getDepth() {
		return depth;
	}



	public void setDepth(int depth) {
		this.depth = depth;
	}

	
}
