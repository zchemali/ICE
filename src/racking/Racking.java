package racking;

import java.util.ArrayList;
/**
 * This abstract class creates the column/rows/depth Also it will store products and check for empty slots
 * @author zchem
 *
 */
public abstract class Racking {
	String column;
	int row,depth;
	protected ArrayList<String> barcode;//barcode
	protected ArrayList<String> name;//of product
	protected ArrayList<Integer> amount;//amunt of product
	protected ArrayList<ArrayList> rowList;
	protected ArrayList<Integer> depthList;
	
	
	public Racking(String column ,int row ,int depth) {
		this.depth=depth;
		this.column=column;
		this.row=row;
		//NOTE : Must create the depth prior to creating the rowList
		depthList=new ArrayList<Integer>();
		for (int i=0;i<depth;i++) {
			depthList.add(null);
		}
		rowList=new ArrayList<ArrayList>();
		for(int i=0;i<row;i++)
			{rowList.add(depthList);
			
			}
	
		
			
		
	}
	//------------Getters And setters-------------//

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

	public ArrayList<String> getBarcode() {
		return barcode;
	}

	public void setBarcode(ArrayList<String> barcode) {
		this.barcode = barcode;
	}

	public ArrayList<String> getName() {
		return name;
	}

	public void setName(ArrayList<String> name) {
		this.name = name;
	}

	public ArrayList<Integer> getAmount() {
		return amount;
	}

	public void setAmount(ArrayList<Integer> amount) {
		this.amount = amount;
	}



	public ArrayList<ArrayList> getRowList() {
		return rowList;
	}

	public void setRowList(ArrayList<ArrayList> rowList) {
		this.rowList = rowList;
	}

	public ArrayList<Integer> getDepthList() {
		return depthList;
	}

	public void setDepthList(int i) {
		this.depthList.set(i, 1);
	}

	/**
	 * This method check all the empty slots for a row
	 * @param row passed down by the user
	 * @return the empty slots in a row
	 */
	public String checkEmptySlots(int row) {
		ArrayList <Integer> temp=getRowList().get(row-1);
		StringBuffer sb=new StringBuffer();
		sb.append("the empty slots in z-diretion for this row are :");
		System.err.println(temp.size());
		
			
		
		for (int i=0;i<temp.size();i++)
		{
			if(temp.get(i)==null) {
				sb.append(" slot" + (i+1));
			}}
			return sb.toString();
		
	}
	public ArrayList<Integer> getFreeDepthSlots(){
		ArrayList<Integer> temp =new ArrayList<Integer>();
		for (int i=0;i<getDepthList().size();i++)
		{
			if(getDepthList().get(i)==null) {
				temp.add(getDepthList().get(i));
			}}
		return temp;
	}


}
