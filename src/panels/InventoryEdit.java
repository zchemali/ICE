package panels;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import com.mongodb.client.MongoDatabase;

import database.InventoryFindOne;
import database.InventoryLoader;

public class InventoryEdit extends JPanel{

	public InventoryEdit(JPanel cardPanel, CardLayout c,MongoDatabase db) {
			setBackground(new Color(82,94,104));
			setLayout(new BorderLayout(0, 0));
			JPanel searchTab = new JPanel();
			searchTab.setBackground(Color.WHITE);
			searchTab.setPreferredSize(new Dimension(2000, 100));
			add(searchTab,"North");
			searchTab.setLayout(null);
			
			JTextField txtBarcode = new JTextField();
			txtBarcode.setText("Barcode");
			txtBarcode.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					if(e.getSource()==txtBarcode) {
						txtBarcode.setText("");
					}
			}});
			txtBarcode.setFont(new Font("Tahoma", Font.PLAIN, 18));
			txtBarcode.setBounds(257, 35, 116, 30);
			txtBarcode.setBackground(Color.LIGHT_GRAY);
			searchTab.add(txtBarcode);
			txtBarcode.setColumns(10);
			
			JButton btnNewButton = new JButton("Search");
			btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
			btnNewButton.setBounds(139, 35, 97, 30);
			searchTab.add(btnNewButton);
			
			JButton clearBtn = new JButton("Clear");
			clearBtn.setFont(new Font("Tahoma", Font.PLAIN, 18));
			clearBtn.setBounds(513, 35, 97, 30);
			searchTab.add(clearBtn);
			
			JScrollPane scrollPane = new JScrollPane();
			add(scrollPane, BorderLayout.CENTER);
			DefaultTableModel tableModel = new DefaultTableModel();
			JTable table = new JTable(tableModel);
		
			tableModel.addColumn("Barcode");
			tableModel.addColumn("Name");
			tableModel.addColumn("Amount Available");
			tableModel.addColumn("Price per Tire");
			new InventoryLoader(tableModel, db);
			//pass the tableModel to constructo of inventory loader
		btnNewButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					if (e.getSource()==btnNewButton)
						tableModel.setRowCount(0);
					new InventoryFindOne(tableModel,db,Integer.parseInt(txtBarcode.getText()));
				}
			});
		clearBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource()==clearBtn) {
					tableModel.setRowCount(0);
					new InventoryLoader(tableModel, db);
				}
			}
		});
//			tableModel.insertRow(0, new Object[] {10020,"Winter",23,2});
//			tableModel.insertRow(0, new Object[] {100222230,"Summer",23,2});
			table.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
		        public void valueChanged(ListSelectionEvent event) {
		            // do some actions here, for example
		            // print first column value from selected row
//		        	Integer barcode= (Integer) table.getValueAt(table.getSelectedRow(), 0);
//		        	Integer amount=(Integer) table.getValueAt(table.getSelectedRow(), 1);
//		        	Integer price= (Integer) table.getValueAt(table.getSelectedRow(), 2);
//		        	cardPanel.add(new Purchase(barcode,amount,price), "Purchase");
		        	c.show(cardPanel, "Purchase");
		        	
		   
		        	
//		            System.out.println(barcode+"  "+amount+"  "+price);
		        	
		        }
		    });
			scrollPane.setViewportView(table);
		}

	}
	}
}
