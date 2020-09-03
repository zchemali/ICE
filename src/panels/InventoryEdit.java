package panels;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import com.mongodb.client.MongoDatabase;

import database.InventoryFindOne;
import database.InventoryLoader;
import imageHandle.ImageLoader;

public class InventoryEdit extends JPanel{
public InventoryEdit(JPanel cardPanel, CardLayout c,MongoDatabase db) {
	ImageLoader loader = new ImageLoader();
	setBackground(new Color(82,94,104));
	setLayout(new BorderLayout(0, 0));
	
	JPanel searchPanel = new JPanel();
	searchPanel.setPreferredSize(new Dimension(2000, 100));
	add(searchPanel, BorderLayout.NORTH);
	searchPanel.setLayout(null);
	

	JButton addNew = new JButton("New");
	addNew.setFont(new Font("Tahoma", Font.PLAIN, 18));
	addNew.setBounds(35, 27, 100, 30);
	searchPanel.add(addNew);
	
	JTextField txtBarcode = new JTextField();
	txtBarcode.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			if ( e.getSource()==txtBarcode) {
				txtBarcode.setText("");
			}
		}
	});
	txtBarcode.setFont(new Font("Tahoma", Font.PLAIN, 18));
	txtBarcode.setText("Barcode");
	txtBarcode.setBounds(296, 27, 100, 30);
	searchPanel.add(txtBarcode);
	txtBarcode.setColumns(10);
	
	JButton searchBtn = new JButton("Search");
	searchBtn.setFont(new Font("Tahoma", Font.PLAIN, 18));
	searchBtn.setBounds(184, 27, 100, 30);
	searchPanel.add(searchBtn);
	

	
	JButton clrBtn = new JButton("Refresh");
	clrBtn.setFont(new Font("Tahoma", Font.PLAIN, 18));
	clrBtn.setBounds(491, 27, 100, 30);
	searchPanel.add(clrBtn);
	
	JScrollPane scrollPane_1 = new JScrollPane();
	add(scrollPane_1, BorderLayout.CENTER);
	DefaultTableModel tableModel = new DefaultTableModel();
	JTable table = new JTable(tableModel);
	table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	tableModel.addColumn("Barcode");
	tableModel.addColumn("Name");
	tableModel.addColumn("Amount Available");
	tableModel.addColumn("Price per Tire");
	new InventoryLoader(tableModel, db);
//	tableModel.insertRow(0, new Object[] {122,"Summ",22,2.3});
//	new InventoryLoader(tableModel2, db);
	table.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
        public void valueChanged(ListSelectionEvent event) {
            // do some actions here, for example
            // print first column value from selected row
//        	Integer barcode= (Integer) table.getValueAt(table.getSelectedRow(), 0);
//        	Integer amount=(Integer) table.getValueAt(table.getSelectedRow(), 1);
//        	Integer price= (Integer) table.getValueAt(table.getSelectedRow(), 2);
//        	cardPanel.add(new Purchase(barcode,amount,price), "Purchase");
        	Long barcode= (Long) table.getValueAt(table.getSelectedRow(), 0);
        	String tireName=(String) table.getValueAt(table.getSelectedRow(), 1);
        	Integer amount=(Integer) table.getValueAt(table.getSelectedRow(), 2);
        	Double price= (Double) table.getValueAt(table.getSelectedRow(), 3);
        	cardPanel.add(new Edit(barcode,price, tireName, c, cardPanel, db),"Edit");
        	c.show(cardPanel, "Edit");
        	
   
        	
//            System.out.println(barcode+"  "+amount+"  "+price);
        	
        }
    });
	
	scrollPane_1.setViewportView(table);
}
	
}
