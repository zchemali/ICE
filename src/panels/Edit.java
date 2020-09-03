package panels;

import java.awt.Canvas;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.SystemColor;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.mongodb.client.MongoDatabase;

import imageHandle.ImageLoader;

public class Edit extends JPanel {
	public Edit(Long barcode,Double price,String tireName,CardLayout c,JPanel cardPanel,MongoDatabase db) {
		setBackground(new Color(82,94,104));
		setLayout(null);
	
		JLabel tireNameLabel = new JLabel("Tire Name");
		tireNameLabel.setOpaque(true);
		tireNameLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		tireNameLabel.setBackground(SystemColor.inactiveCaption);
		tireNameLabel.setBounds(36, 118, 96, 32);
		add(tireNameLabel);
		
		JTextField tireField = new JTextField();
		tireField.setColumns(10);
		tireField.setBounds(144, 122, 116, 29);
		add(tireField);
		
		JLabel barcLabel = new JLabel("Barcode");
		barcLabel.setOpaque(true);
		barcLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		barcLabel.setBackground(SystemColor.inactiveCaption);
		barcLabel.setBounds(36, 72, 96, 32);
		add(barcLabel);
		
		JTextField barcodeField = new JTextField();
		barcodeField.setColumns(10);
		barcodeField.setBounds(144, 76, 116, 29);
		add(barcodeField);
		
		JLabel amntLabel = new JLabel("Amount");
		amntLabel.setOpaque(true);
		amntLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		amntLabel.setBackground(SystemColor.inactiveCaption);
		amntLabel.setBounds(36, 163, 96, 32);
		add(amntLabel);
		
		JTextField amntField = new JTextField();
		amntField.setColumns(10);
		amntField.setBounds(144, 167, 116, 29);
		add(amntField);
		
		JLabel tirePriceLabel = new JLabel("Price/tire");
		tirePriceLabel.setOpaque(true);
		tirePriceLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		tirePriceLabel.setBackground(SystemColor.inactiveCaption);
		tirePriceLabel.setBounds(36, 213, 96, 32);
		add(tirePriceLabel);
		
		JTextField priceField = new JTextField();
		priceField.setColumns(10);
		priceField.setBounds(144, 217, 116, 29);
		add(priceField);
		
		JButton updateBtn = new JButton("Update");
		updateBtn.setBackground(SystemColor.activeCaption);
		updateBtn.setFont(new Font("Tahoma", Font.PLAIN, 18));
		updateBtn.setBounds(101, 300, 144, 46);
		add(updateBtn);
	}

}
