package racking;

import java.util.ArrayList;
import java.util.Scanner;


/**
 * This is the test class for creating column/rows which are going to be implemted in the GUI later after success of test
 * @author zchem
 *
 */
public class Test {
 
	private Handler handler;
	private ArrayList<Integer> depth;
	/*
	 * Constructor that will create columns based on user input
	 */
	public Test() {
		handler=new Handler();
		boolean answer=true;
		while (answer){
			System.out.println("Do you want to create a racking column ?");	
			Scanner scanner =new Scanner (System.in);
			
			if(scanner.nextLine().equalsIgnoreCase("yes")) {
				System.out.println("Column name");	
				String name=scanner.nextLine();
				System.out.println("Column rows");	
				int row=Integer.parseInt(scanner.nextLine());
				System.out.println("Row depth");	
				int depth=Integer.parseInt(scanner.nextLine());
				handler.add(new RackingColumn(name,row,depth) );
			}
			else
			{	answer=false;
			break;}
			
		}
		
		
		
	}
	/**
	 * This will let the user select a column
	 */
	public void selectColumn() {
		System.out.println("Which column do you want to enter?");
		Scanner scanner =new Scanner (System.in);
		String columnName=scanner.nextLine();
		Racking temp = null;
		for(int i=0;i<handler.rackingList.size();i++)
		{
			if(handler.rackingList.get(i).getColumn().equalsIgnoreCase(columnName)) {
				temp=handler.rackingList.get(i);
			}
		}
		addProduct(temp);
		
	}
	/**
	 * This method will add products to specific row and certain depth
	 * @param rackingColumn
	 */
	public void addProduct(Racking rackingColumn) {
		System.out.println("This column "+rackingColumn.getColumn());
		System.out.println("Which row you want to check ?");
		Scanner scanner =new Scanner (System.in);
		int row=scanner.nextInt();
		System.out.println(rackingColumn.checkEmptySlots((row)));
		depth=rackingColumn.getFreeDepthSlots();
		System.out.println("Barcode of product");
		String barcode=scanner.next();
		System.out.println("Product name");
		String productName=scanner.next();
		System.out.println("Product amount");
		int productAmount=scanner.nextInt();
		int depthSelected = 0;
		boolean check=true;
		while (check) {
			System.out.println("where in this row you want to put product");
			depthSelected=scanner.nextInt();
			if(depthSelected>depth.size()+1) {
				System.out.println("Error");
			}
			else {
				rackingColumn.setDepthList(depthSelected-1);
				check=false;
			}
			
		}
		//creates the product item
		handler.addProduct(new ProductItem(barcode, productName, productAmount, rackingColumn.getColumn(), row, depthSelected));
		
		
	
		
	}
	/**
	 * This method checks the barcode and prints location of element 
	 */
	public void check() {
		System.out.println("which barcode is it?");
		Scanner scanner =new Scanner(System.in);
		String barcode=scanner.next();
		for(int i=0;i<handler.productList.size();i++) {
			Product temp=handler.productList.get(i);
			if(barcode.equals(temp.getBarcode()))
			{
				System.out.println("Its in column"+temp.getColumn()+"Row "+temp.getRow()+"depth slot:"+temp.getDepth());
			}
		}
		
		
	}
	//Need a search method to search for item in ALL COLUMNS based on barcode
	public static void main(String[] args) {
		Test test =new Test();
		test.selectColumn();
		test.check();
		
		
	}

}
