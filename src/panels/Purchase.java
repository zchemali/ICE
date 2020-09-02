package panels;

import java.awt.Canvas;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.table.DefaultTableModel;

import com.mongodb.client.MongoDatabase;

import database.PurchaseWriter;
import database.updateInventory;
import imageHandle.ImageLoader;

public class Purchase extends JPanel {

	public Purchase(Long barcode,Integer prevAmount, Double price,String tireName,CardLayout c,JPanel cardPanel,MongoDatabase db,DefaultTableModel tableModel) {
		ImageLoader loader =new ImageLoader();
		setBackground(new Color(82,94,104));
		setLayout(null);
		
		
		Canvas canvas_1 = new Canvas() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public void paint (Graphics g) {
				g.drawImage(loader.getImage("/left-arrow.png"), 0, 0, 22, 22, null);
		}};
		canvas_1.setSize(22, 22);
		canvas_1.setLocation(7, 7);
		canvas_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getSource()==canvas_1)
					c.show(cardPanel, "Inventory");
			}
		});
		canvas_1.setSize(56,25);
		add(canvas_1);
		
		JLabel barcodeLabel = new JLabel("Barcode");
		barcodeLabel.setOpaque(true);
		barcodeLabel.setBackground(SystemColor.inactiveCaption);
		barcodeLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		barcodeLabel.setBounds(7, 57, 81, 25);
		add(barcodeLabel);
		
		JLabel barcodeText = new JLabel(barcode+"");
		barcodeText.setEnabled(false);
		barcodeText.setOpaque(true);
		barcodeText.setFont(new Font("Tahoma", Font.PLAIN, 18));
		barcodeText.setBackground(SystemColor.inactiveCaption);
		barcodeText.setBounds(100, 57, 81, 25);
		add(barcodeText);
		
		JLabel amountLabel = new JLabel("Amount");
		amountLabel.setOpaque(true);
		amountLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		amountLabel.setBackground(SystemColor.inactiveCaption);
		amountLabel.setBounds(7, 97, 81, 25);
		add(amountLabel);
		
		JTextField amountField = new JTextField();
	

	
		amountField.setBounds(100, 99, 81, 25);
		add(amountField);
		amountField.setColumns(10);
		
		JLabel totalLabel = new JLabel("Total");
		totalLabel.setOpaque(true);
		totalLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		totalLabel.setBackground(SystemColor.inactiveCaption);
		totalLabel.setBounds(7, 139, 81, 25);
		add(totalLabel);
	
		JLabel totalText = new JLabel("Total");
		totalText.setOpaque(true);
		totalText.setFont(new Font("Tahoma", Font.PLAIN, 18));
		totalText.setEnabled(false);
		totalText.setBackground(SystemColor.inactiveCaption);
		totalText.setBounds(100, 139, 81, 25);
		add(totalText);
	
		JLabel taxLabel = new JLabel("Tax");
		taxLabel.setOpaque(true);
		taxLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		taxLabel.setBackground(SystemColor.inactiveCaption);
		taxLabel.setBounds(7, 177, 81, 25);
		add(taxLabel);
	
		JLabel taxText = new JLabel("Tax");
		taxText.setOpaque(true);
		taxText.setFont(new Font("Tahoma", Font.PLAIN, 18));
		taxText.setEnabled(false);
		taxText.setBackground(SystemColor.inactiveCaption);
		taxText.setBounds(100, 177, 81, 25);
		add(taxText);
		
		JLabel afterTaxLabel = new JLabel("After Tax");
		afterTaxLabel.setOpaque(true);
		afterTaxLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		afterTaxLabel.setBackground(SystemColor.inactiveCaption);
		afterTaxLabel.setBounds(7, 216, 81, 25);
		add(afterTaxLabel);
		
		JLabel afterTaxText = new JLabel("After Tax");
		afterTaxText.setOpaque(true);
		afterTaxText.setFont(new Font("Tahoma", Font.PLAIN, 18));
		afterTaxText.setEnabled(false);
		afterTaxText.setBackground(SystemColor.inactiveCaption);
		afterTaxText.setBounds(100, 216, 81, 25);
		add(afterTaxText);
		amountField.addCaretListener(new CaretListener() {
			public void caretUpdate(CaretEvent e) {
				if( e.getSource()==amountField) {
					if(Integer.parseInt(amountField.getText())<=prevAmount) {
					totalText.setText(Integer.parseInt(amountField.getText())*price+"");
					taxText.setText(Double.parseDouble(totalText.getText())*5/100+"");
					afterTaxText.setText(Double.parseDouble(totalText.getText())+Double.parseDouble(taxText.getText())+"");
				}else {
					JOptionPane.showMessageDialog(cardPanel, "Must be smaller than or equal to "+prevAmount);
					
				}
				}}});
		JLabel firstNameLabel = new JLabel("First Name");
		firstNameLabel.setOpaque(true);
		firstNameLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		firstNameLabel.setBackground(SystemColor.inactiveCaption);
		firstNameLabel.setBounds(7, 254, 91, 25);
		add(firstNameLabel);
		
		JTextField nameField = new JTextField();
		nameField.setColumns(10);
		nameField.setBounds(100, 254, 81, 25);
		add(nameField);
		
		JLabel phoneLabel = new JLabel("Phone");
		phoneLabel.setOpaque(true);
		phoneLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		phoneLabel.setBackground(SystemColor.inactiveCaption);
		phoneLabel.setBounds(7, 293, 81, 25);
		add(phoneLabel);
		
		JTextField phoneField = new JTextField();
		phoneField.setColumns(10);
		phoneField.setBounds(100, 293, 81, 25);
		add(phoneField);
		
		JLabel adressLabel = new JLabel("Adress");
		adressLabel.setOpaque(true);
		adressLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		adressLabel.setBackground(SystemColor.inactiveCaption);
		adressLabel.setBounds(7, 331, 81, 25);
		add(adressLabel);
		
		JTextField adressField = new JTextField();
		adressField.setColumns(10);
		adressField.setBounds(100, 331, 81, 25);
		add(adressField);
		
		JLabel cityLabel = new JLabel("City");
		cityLabel.setOpaque(true);
		cityLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		cityLabel.setBackground(SystemColor.inactiveCaption);
		cityLabel.setBounds(202, 331, 81, 25);
		add(cityLabel);
		
		JTextField cityField = new JTextField();
		cityField.setColumns(10);
		cityField.setBounds(295, 331, 81, 25);
		add(cityField);
		
		JLabel provinceLabel = new JLabel("Province");
		provinceLabel.setOpaque(true);
		provinceLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		provinceLabel.setBackground(SystemColor.inactiveCaption);
		provinceLabel.setBounds(393, 331, 81, 25);
		add(provinceLabel);
		
		JTextField provinceField = new JTextField();
		provinceField.setColumns(10);
		provinceField.setBounds(486, 331, 81, 25);
		add(provinceField);
		
		JLabel emailLabel = new JLabel("Email");
		emailLabel.setOpaque(true);
		emailLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		emailLabel.setBackground(SystemColor.inactiveCaption);
		emailLabel.setBounds(202, 293, 81, 25);
		add(emailLabel);
		
		JTextField emailField = new JTextField();
		emailField.setColumns(10);
		emailField.setBounds(295, 293, 81, 25);
		add(emailField);
		
		JLabel paymentLabel = new JLabel("Payment");
		paymentLabel.setOpaque(true);
		paymentLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		paymentLabel.setBackground(SystemColor.inactiveCaption);
		paymentLabel.setBounds(7, 371, 81, 25);
		add(paymentLabel);
		
		JComboBox paymentCombo = new JComboBox();
		paymentCombo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		paymentCombo.setModel(new DefaultComboBoxModel(new String[] {"Cash", "Credit", "e-Transfer"}));
		paymentCombo.setBounds(100, 374, 81, 22);
		add(paymentCombo);
		
		JButton purchaseButton = new JButton("Purchase");
		
		purchaseButton.setForeground(SystemColor.controlText);
//		purchaseButton.setBackground(SystemColor.activeCaption);
		purchaseButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		purchaseButton.setBounds(167, 454, 177, 25);
		add(purchaseButton);
		
		JTextField lastNameField = new JTextField();
		lastNameField.setColumns(10);
		lastNameField.setBounds(295, 256, 81, 25);
		add(lastNameField);
		
		JLabel lastNameLabel = new JLabel("Last Name");
		lastNameLabel.setOpaque(true);
		lastNameLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lastNameLabel.setBackground(SystemColor.inactiveCaption);
		lastNameLabel.setBounds(203, 254, 91, 25);
		add(lastNameLabel);
		
		JLabel tireNameLabel = new JLabel("Tire Name");
		tireNameLabel.setOpaque(true);
		tireNameLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		tireNameLabel.setBackground(SystemColor.inactiveCaption);
		tireNameLabel.setBounds(193, 57, 81, 25);
		add(tireNameLabel);
		
		JLabel tireNameText = new JLabel(tireName);
		tireNameText.setOpaque(true);
		tireNameText.setFont(new Font("Tahoma", Font.PLAIN, 18));
		tireNameText.setEnabled(false);
		tireNameText.setBackground(SystemColor.inactiveCaption);
		tireNameText.setBounds(286, 57, 81, 25);
		add(tireNameText);
		
		JLabel priceLabel = new JLabel("Price ea");
		priceLabel.setOpaque(true);
		priceLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		priceLabel.setBackground(SystemColor.inactiveCaption);
		priceLabel.setBounds(193, 97, 81, 25);
		add(priceLabel);
		
		JLabel priceText = new JLabel(price+"");
		priceText.setOpaque(true);
		priceText.setFont(new Font("Tahoma", Font.PLAIN, 18));
		priceText.setEnabled(false);
		priceText.setBackground(SystemColor.inactiveCaption);
		priceText.setBounds(286, 97, 81, 25);
		add(priceText);
		
		JLabel dateLabel = new JLabel("Date dd/mm/yyyy");
		dateLabel.setOpaque(true);
		dateLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		dateLabel.setBackground(SystemColor.inactiveCaption);
		dateLabel.setBounds(7, 409, 142, 25);
		add(dateLabel);
		
		JComboBox dayBox = new JComboBox();
		dayBox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		dayBox.setBounds(180, 412, 41, 22);
		add(dayBox);
		
		JComboBox monthBox = new JComboBox();
		monthBox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
		monthBox.setBounds(233, 412, 41, 22);
		add(monthBox);
		
		JComboBox yearBox = new JComboBox();
		yearBox.setModel(new DefaultComboBoxModel(new String[] {"2020", "2021", "2022", "2023", "2024", "2025"}));
		yearBox.setBounds(286, 412, 58, 22);
		add(yearBox);
		purchaseButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource()==purchaseButton) {
					if(amountField.getText().isEmpty() || nameField.getText().isEmpty() || lastNameField.getText().isEmpty() || phoneField.getText().isEmpty()|| emailField.getText().isEmpty() || adressField.getText().isEmpty() || cityField.getText().isEmpty() || provinceField.getText().isEmpty()) {
						JOptionPane.showMessageDialog(cardPanel, "One or more fields are empty");
					}
					else {
					Long barcodePurchase=Long.parseLong(barcodeText.getText());
					String tireNamePurchase=tireNameText.getText();
					Integer amountPurchase=Integer.parseInt(amountField.getText());
					Double priceUnitPurchase=Double.parseDouble(priceText.getText());
					Double totalPurchase=Double.parseDouble(totalText.getText());
					Double taxPurchase=Double.parseDouble(taxText.getText());
					Double afterTaxPurchase=Double.parseDouble(afterTaxText.getText());
					String namePurchase=nameField.getText();
					String lastNamePurchase=lastNameField.getText();
					String phonePurchase=phoneField.getText();
					String emailPurchase=emailField.getText();
					String adressPurchase=adressField.getText();
					String cityPurchase=cityField.getText();
					String provincePurchase=provinceField.getText();
					String paymentPurchase=paymentCombo.getSelectedItem().toString();
					Integer dayPurchase=Integer.parseInt(dayBox.getSelectedItem().toString());
					Integer monthPurchase=Integer.parseInt(monthBox.getSelectedItem().toString());
					Integer yearPurchase=Integer.parseInt(yearBox.getSelectedItem().toString());
					new updateInventory(db, barcodePurchase, tireNamePurchase, prevAmount-amountPurchase, price);
					new PurchaseWriter(db,barcodePurchase,tireNamePurchase,amountPurchase,
							priceUnitPurchase,totalPurchase,taxPurchase,afterTaxPurchase
							,namePurchase,lastNamePurchase,phonePurchase,emailPurchase,
							adressPurchase,cityPurchase,provincePurchase,paymentPurchase,dayPurchase
							,monthPurchase,yearPurchase);
					c.show(cardPanel, "Home");
					//send all these to pdfwriter/database witer
					//update Inventory database
					
				}}
			}
		});
	}
}
