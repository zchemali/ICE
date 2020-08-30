package windowSetup;

import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.Sizes;

import imageHandle.ImageLoader;
import panels.Inventory;
import panels.home;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;
import com.jgoodies.forms.layout.FormSpecs;
import java.awt.GridLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JEditorPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;
import javax.swing.event.CaretListener;
import javax.swing.event.CaretEvent;

public class kkk {

	private JFrame frame;
	private ImageLoader loader;
	private JTextField txtBarcode;
	private JTable table;
	private JTextField amountField;
	private JTextField nameField;
	private JTextField phoneField;
	private JTextField adressField;
	private JTextField cityField;
	private JTextField provinceField;
	private JTextField emailField;
	private JTextField lastNameField;
	private JTextField txtArcode;
	private JTable viewTable;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					kkk window = new kkk();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public kkk(){
		initialize();
		loader =new ImageLoader();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 856, 599);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel headerPanel = new JPanel();
		headerPanel.setBackground(new Color(32,43,65));
		
		frame.getContentPane().add(headerPanel, BorderLayout.NORTH);
		GridBagLayout gbl_headerPanel = new GridBagLayout();
		gbl_headerPanel.columnWidths = new int[]{20, 268};
		gbl_headerPanel.rowHeights = new int[] {58};
		gbl_headerPanel.columnWeights = new double[]{0.0, 4.9E-324};
		gbl_headerPanel.rowWeights = new double[]{0.0};
		headerPanel.setLayout(gbl_headerPanel);
		
		Canvas canvas = new Canvas();
		canvas.setBackground(Color.YELLOW);
		GridBagConstraints gbc_canvas = new GridBagConstraints();
		gbc_canvas.fill = GridBagConstraints.BOTH;
		gbc_canvas.insets = new Insets(0, 0, 0, 5);
		gbc_canvas.gridx = 0;
		gbc_canvas.gridy = 0;
		headerPanel.add(canvas, gbc_canvas);
		
		JLabel titleLabel = new JLabel("ICE");
		titleLabel.setForeground(Color.WHITE);
		titleLabel.setFont(new Font("Microsoft Himalaya", Font.BOLD, 26));
		GridBagConstraints gbc_titleLabel = new GridBagConstraints();
		gbc_titleLabel.fill = GridBagConstraints.BOTH;
		gbc_titleLabel.gridx = 1;
		gbc_titleLabel.gridy = 0;
		headerPanel.add(titleLabel, gbc_titleLabel);
		
		JSplitPane splitPane = new JSplitPane();
		frame.getContentPane().add(splitPane, BorderLayout.CENTER);
		
		JPanel tabPanel = new JPanel();
		tabPanel.setBorder(new CompoundBorder());
		tabPanel.setBackground(Color.WHITE);
		splitPane.setLeftComponent(tabPanel);
		tabPanel.setLayout(new FormLayout(new ColumnSpec[] {
				new ColumnSpec(ColumnSpec.FILL, Sizes.bounded(Sizes.PREFERRED, Sizes.constant("120dlu", true), Sizes.constant("120dlu", true)), 0),},
			new RowSpec[] {
				new RowSpec(RowSpec.CENTER, Sizes.bounded(Sizes.DEFAULT, Sizes.constant("30dlu", false), Sizes.constant("30dlu", false)), 0),
				new RowSpec(RowSpec.CENTER, Sizes.bounded(Sizes.DEFAULT, Sizes.constant("30dlu", false), Sizes.constant("30dlu", false)), 0),
				new RowSpec(RowSpec.CENTER, Sizes.bounded(Sizes.DEFAULT, Sizes.constant("30dlu", false), Sizes.constant("30dlu", false)), 0),
				new RowSpec(RowSpec.CENTER, Sizes.bounded(Sizes.DEFAULT, Sizes.constant("30dlu", false), Sizes.constant("30dlu", false)), 0),
				new RowSpec(RowSpec.CENTER, Sizes.bounded(Sizes.PREFERRED, Sizes.constant("162dlu", false), Sizes.constant("162dlu", false)), 5),}));
		
		JPanel homeNavPanel = new JPanel();
		homeNavPanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				homeNavPanel.setBackground(new Color(255,66,0));
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				homeNavPanel.setBackground(new Color(78,119,165)); 
			}
		});
		homeNavPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.WHITE, null, null, null));
		FlowLayout flowLayout = (FlowLayout) homeNavPanel.getLayout();
		flowLayout.setVgap(13);
		homeNavPanel.setBackground(new Color(78,119,165));
		tabPanel.add(homeNavPanel, "1, 1, fill, fill");
		
		Canvas homeIconCanvas = new Canvas();
		homeIconCanvas.setBackground(Color.RED);
		homeIconCanvas.setSize(20, 20);
		homeNavPanel.add(homeIconCanvas);
		
		JLabel homeLabel = new JLabel("Home");
	
		homeLabel.setForeground(SystemColor.menu);
		homeLabel.setFont(new Font("Arial Black", Font.PLAIN, 16));
		homeNavPanel.add(homeLabel);
		
		JPanel inventoryCheckNavPanel = new JPanel();
		inventoryCheckNavPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.WHITE, null, null, null));
		inventoryCheckNavPanel.setBackground(new Color(78,119,165));
		tabPanel.add(inventoryCheckNavPanel, "1, 2, fill, fill");
		inventoryCheckNavPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 13));
		
		Canvas inventoryIconCanvas = new Canvas();
		inventoryIconCanvas.setBackground(Color.RED);
		inventoryIconCanvas.setForeground(Color.RED);
		inventoryIconCanvas.setSize(20, 20);
		inventoryCheckNavPanel.add(inventoryIconCanvas);
		
		JLabel inventoryLabel = new JLabel("Inventory");
		
		inventoryLabel.setForeground(SystemColor.menu);
		inventoryLabel.setFont(new Font("Arial Black", Font.PLAIN, 16));
		inventoryCheckNavPanel.add(inventoryLabel);
		
		JPanel inventoryEditPanel = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) inventoryEditPanel.getLayout();
		flowLayout_1.setVgap(13);
		inventoryEditPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		inventoryEditPanel.setBackground(new Color(78,119,165));
		tabPanel.add(inventoryEditPanel, "1, 3, fill, fill");
		
		Canvas editIconCanvas = new Canvas();
		editIconCanvas.setSize(20, 20);
		inventoryEditPanel.add(editIconCanvas);
		
		JLabel EditLabel = new JLabel("Edit Inventory");
	
		EditLabel.setForeground(SystemColor.menu);
		EditLabel.setFont(new Font("Arial Black", Font.PLAIN, 16));
		inventoryEditPanel.add(EditLabel);
		
		JPanel settingsNavPanel = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) settingsNavPanel.getLayout();
		flowLayout_2.setVgap(13);
		settingsNavPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		settingsNavPanel.setBackground(new Color(78,119,165));
		tabPanel.add(settingsNavPanel, "1, 4, fill, fill");
		
		Canvas settingsIconCanvas = new Canvas();
		settingsIconCanvas.setSize(20,20);
		settingsNavPanel.add(settingsIconCanvas);
		
		JLabel settingsLAbel = new JLabel("Settings");
		settingsLAbel.setForeground(SystemColor.menu);
		settingsLAbel.setFont(new Font("Arial Black", Font.PLAIN, 16));
		settingsNavPanel.add(settingsLAbel);
		
		JPanel logoutPanel = new JPanel();
		logoutPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.WHITE, null, null, null));
		logoutPanel.setBackground(new Color(78,119,165));
		tabPanel.add(logoutPanel, "1, 5, fill, fill");
		logoutPanel.setLayout(new BoxLayout(logoutPanel, BoxLayout.Y_AXIS));
		
		Canvas canvaogoutIconCanvas = new Canvas();
		canvaogoutIconCanvas.setEnabled(false);
		canvaogoutIconCanvas.setSize(20, 20);
		logoutPanel.add(canvaogoutIconCanvas);
		
		JPanel cardPanel = new JPanel();
		cardPanel.setMinimumSize(new Dimension(2000, 660));
		splitPane.setRightComponent(cardPanel);
		CardLayout c =new CardLayout(0,0);
		cardPanel.setLayout(c);
		
		
		
//		JLayeredPane home = new JLayeredPane();
		
		cardPanel.add(new home(), "Home");
//		Canvas canvas_1 = new Canvas() {
//			public void paint (Graphics g) {
//				g.drawImage(loader.getImage("/cardPanel.jpg"), 0, 0,1800,1000, null);
//			}
//		};
//		canvas_1.setSize(1800, 1000);
//		home.add(canvas_1);
		
		JPanel inventoryCardPanel = new JPanel();
		inventoryCardPanel.setBackground(new Color(82,94,104));
		cardPanel.add(inventoryCardPanel, "Inventory");
		inventoryCardPanel.setLayout(new BorderLayout(0, 0));
		
		JPanel purchasePanel = new JPanel();
		purchasePanel.setBackground(new Color(82,94,104));
		cardPanel.add(purchasePanel, "Purchase");
		
		Canvas canvas_1 = new Canvas() {
			public void paint (Graphics g) {
				g.drawImage(loader.getImage("/left-arrow.png"), 0, 0, 22, 22, null);
		}};
		canvas_1.setLocation(7, 7);
		canvas_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getSource()==canvas_1)
					c.show(cardPanel, "Inventory");
			}
		});
		purchasePanel.setLayout(null);
		canvas_1.setSize(56,25);
		purchasePanel.add(canvas_1);
		
		JLabel barcodeLabel = new JLabel("Barcode");
		barcodeLabel.setOpaque(true);
		barcodeLabel.setBackground(SystemColor.inactiveCaption);
		barcodeLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		barcodeLabel.setBounds(7, 57, 81, 25);
		purchasePanel.add(barcodeLabel);
		
		JLabel barcodeText = new JLabel("Barcode");
		barcodeText.setEnabled(false);
		barcodeText.setOpaque(true);
		barcodeText.setFont(new Font("Tahoma", Font.PLAIN, 18));
		barcodeText.setBackground(SystemColor.inactiveCaption);
		barcodeText.setBounds(100, 57, 81, 25);
		purchasePanel.add(barcodeText);
		
		JLabel amountLabel = new JLabel("Amount");
		amountLabel.setOpaque(true);
		amountLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		amountLabel.setBackground(SystemColor.inactiveCaption);
		amountLabel.setBounds(7, 97, 81, 25);
		purchasePanel.add(amountLabel);
		
		amountField = new JTextField();
	

	
		amountField.setBounds(100, 99, 81, 25);
		purchasePanel.add(amountField);
		amountField.setColumns(10);
		
		JLabel totalLabel = new JLabel("Total");
		totalLabel.setOpaque(true);
		totalLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		totalLabel.setBackground(SystemColor.inactiveCaption);
		totalLabel.setBounds(7, 139, 81, 25);
		purchasePanel.add(totalLabel);
	
		JLabel totalText = new JLabel("Total");
		totalText.setOpaque(true);
		totalText.setFont(new Font("Tahoma", Font.PLAIN, 18));
		totalText.setEnabled(false);
		totalText.setBackground(SystemColor.inactiveCaption);
		totalText.setBounds(100, 139, 81, 25);
		purchasePanel.add(totalText);
	
		JLabel taxLabel = new JLabel("Tax");
		taxLabel.setOpaque(true);
		taxLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		taxLabel.setBackground(SystemColor.inactiveCaption);
		taxLabel.setBounds(7, 177, 81, 25);
		purchasePanel.add(taxLabel);
	
		JLabel taxText = new JLabel("Tax");
		taxText.setOpaque(true);
		taxText.setFont(new Font("Tahoma", Font.PLAIN, 18));
		taxText.setEnabled(false);
		taxText.setBackground(SystemColor.inactiveCaption);
		taxText.setBounds(100, 177, 81, 25);
		purchasePanel.add(taxText);
		
		JLabel afterTaxLabel = new JLabel("After Tax");
		afterTaxLabel.setOpaque(true);
		afterTaxLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		afterTaxLabel.setBackground(SystemColor.inactiveCaption);
		afterTaxLabel.setBounds(7, 216, 81, 25);
		purchasePanel.add(afterTaxLabel);
		
		JLabel afterTaxText = new JLabel("After Tax");
		afterTaxText.setOpaque(true);
		afterTaxText.setFont(new Font("Tahoma", Font.PLAIN, 18));
		afterTaxText.setEnabled(false);
		afterTaxText.setBackground(SystemColor.inactiveCaption);
		afterTaxText.setBounds(100, 216, 81, 25);
		purchasePanel.add(afterTaxText);
		amountField.addCaretListener(new CaretListener() {
			public void caretUpdate(CaretEvent e) {
				if( e.getSource()==amountField) {
					totalText.setText(Integer.parseInt(amountField.getText())*2.3+"");
					taxText.setText(Double.parseDouble(totalText.getText())*5/100+"");
					afterTaxText.setText(Double.parseDouble(totalText.getText())+Double.parseDouble(taxText.getText())+"");
				}}
		});
		JLabel firstNameLabel = new JLabel("First Name");
		firstNameLabel.setOpaque(true);
		firstNameLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		firstNameLabel.setBackground(SystemColor.inactiveCaption);
		firstNameLabel.setBounds(7, 254, 91, 25);
		purchasePanel.add(firstNameLabel);
		
		nameField = new JTextField();
		nameField.setColumns(10);
		nameField.setBounds(100, 254, 81, 25);
		purchasePanel.add(nameField);
		
		JLabel phoneLabel = new JLabel("Phone");
		phoneLabel.setOpaque(true);
		phoneLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		phoneLabel.setBackground(SystemColor.inactiveCaption);
		phoneLabel.setBounds(7, 293, 81, 25);
		purchasePanel.add(phoneLabel);
		
		phoneField = new JTextField();
		phoneField.setColumns(10);
		phoneField.setBounds(100, 293, 81, 25);
		purchasePanel.add(phoneField);
		
		JLabel adressLabel = new JLabel("Adress");
		adressLabel.setOpaque(true);
		adressLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		adressLabel.setBackground(SystemColor.inactiveCaption);
		adressLabel.setBounds(7, 331, 81, 25);
		purchasePanel.add(adressLabel);
		
		adressField = new JTextField();
		adressField.setColumns(10);
		adressField.setBounds(100, 331, 81, 25);
		purchasePanel.add(adressField);
		
		JLabel cityLabel = new JLabel("City");
		cityLabel.setOpaque(true);
		cityLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		cityLabel.setBackground(SystemColor.inactiveCaption);
		cityLabel.setBounds(202, 331, 81, 25);
		purchasePanel.add(cityLabel);
		
		cityField = new JTextField();
		cityField.setColumns(10);
		cityField.setBounds(295, 331, 81, 25);
		purchasePanel.add(cityField);
		
		JLabel provinceLabel = new JLabel("Province");
		provinceLabel.setOpaque(true);
		provinceLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		provinceLabel.setBackground(SystemColor.inactiveCaption);
		provinceLabel.setBounds(393, 331, 81, 25);
		purchasePanel.add(provinceLabel);
		
		provinceField = new JTextField();
		provinceField.setColumns(10);
		provinceField.setBounds(486, 331, 81, 25);
		purchasePanel.add(provinceField);
		
		JLabel emailLabel = new JLabel("Email");
		emailLabel.setOpaque(true);
		emailLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		emailLabel.setBackground(SystemColor.inactiveCaption);
		emailLabel.setBounds(202, 293, 81, 25);
		purchasePanel.add(emailLabel);
		
		emailField = new JTextField();
		emailField.setColumns(10);
		emailField.setBounds(295, 293, 81, 25);
		purchasePanel.add(emailField);
		
		JLabel paymentLabel = new JLabel("Payment");
		paymentLabel.setOpaque(true);
		paymentLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		paymentLabel.setBackground(SystemColor.inactiveCaption);
		paymentLabel.setBounds(7, 371, 81, 25);
		purchasePanel.add(paymentLabel);
		
		JComboBox paymentCombo = new JComboBox();
		paymentCombo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		paymentCombo.setModel(new DefaultComboBoxModel(new String[] {"Cash", "Credit", "e-Transfer"}));
		paymentCombo.setBounds(100, 374, 81, 22);
		purchasePanel.add(paymentCombo);
		
		JButton purchaseButton = new JButton("Purchase");
		
		purchaseButton.setForeground(SystemColor.controlText);
//		purchaseButton.setBackground(SystemColor.activeCaption);
		purchaseButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		purchaseButton.setBounds(167, 454, 177, 25);
		purchasePanel.add(purchaseButton);
		
		lastNameField = new JTextField();
		lastNameField.setColumns(10);
		lastNameField.setBounds(295, 256, 81, 25);
		purchasePanel.add(lastNameField);
		
		JLabel lastNameLabel = new JLabel("Last Name");
		lastNameLabel.setOpaque(true);
		lastNameLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lastNameLabel.setBackground(SystemColor.inactiveCaption);
		lastNameLabel.setBounds(203, 254, 91, 25);
		purchasePanel.add(lastNameLabel);
		
		JLabel tireNameLabel = new JLabel("Tire Name");
		tireNameLabel.setOpaque(true);
		tireNameLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		tireNameLabel.setBackground(SystemColor.inactiveCaption);
		tireNameLabel.setBounds(193, 57, 81, 25);
		purchasePanel.add(tireNameLabel);
		
		JLabel tireNameText = new JLabel("Name");
		tireNameText.setOpaque(true);
		tireNameText.setFont(new Font("Tahoma", Font.PLAIN, 18));
		tireNameText.setEnabled(false);
		tireNameText.setBackground(SystemColor.inactiveCaption);
		tireNameText.setBounds(286, 57, 81, 25);
		purchasePanel.add(tireNameText);
		
		JLabel priceLabel = new JLabel("Price ea");
		priceLabel.setOpaque(true);
		priceLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		priceLabel.setBackground(SystemColor.inactiveCaption);
		priceLabel.setBounds(193, 97, 81, 25);
		purchasePanel.add(priceLabel);
		
		JLabel priceText = new JLabel("Price");
		priceText.setOpaque(true);
		priceText.setFont(new Font("Tahoma", Font.PLAIN, 18));
		priceText.setEnabled(false);
		priceText.setBackground(SystemColor.inactiveCaption);
		priceText.setBounds(286, 97, 81, 25);
		purchasePanel.add(priceText);
		
		JLabel dateLabel = new JLabel("Date dd/mm/yyyy");
		dateLabel.setOpaque(true);
		dateLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		dateLabel.setBackground(SystemColor.inactiveCaption);
		dateLabel.setBounds(7, 409, 142, 25);
		purchasePanel.add(dateLabel);
		
		JComboBox dayBox = new JComboBox();
		dayBox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		dayBox.setBounds(180, 412, 41, 22);
		purchasePanel.add(dayBox);
		
		JComboBox monthBox = new JComboBox();
		monthBox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
		monthBox.setBounds(233, 412, 41, 22);
		purchasePanel.add(monthBox);
		
		JComboBox yearBox = new JComboBox();
		yearBox.setModel(new DefaultComboBoxModel(new String[] {"2020", "2021", "2022", "2023", "2024", "2025"}));
		yearBox.setBounds(286, 412, 58, 22);
		purchasePanel.add(yearBox);
		purchaseButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource()==purchaseButton) {
					if(amountField.getText().isEmpty() || nameField.getText().isEmpty() || lastNameField.getText().isEmpty() || phoneField.getText().isEmpty()|| emailField.getText().isEmpty() || adressField.getText().isEmpty() || cityField.getText().isEmpty() || provinceField.getText().isEmpty()) {
						JOptionPane.showMessageDialog(purchasePanel, "One or more fields are empty");
					}
					else {
					String barcodePurchase=barcodeText.getText();
					String tireNamePurchase=tireNameText.getText();
					String amountPurchase=amountField.getText();
					String priceUnitPurchase=priceText.getText();
					String totalPurchase=totalText.getText();
					String taxPurchase=taxText.getText();
					String afterTaxPurchase=afterTaxText.getText();
					String namePurchase=nameField.getText();
					String lastNamePurchase=lastNameField.getText();
					String phonePurchase=phoneField.getText();
					String emailPurchase=emailField.getText();
					String adressPurchase=adressField.getText();
					String cityPurchase=cityField.getText();
					String provincePurchase=provinceField.getText();
					String paymentPurchase=paymentCombo.getSelectedItem().toString();
					String dayPurchase=dayBox.getSelectedItem().toString();
					//send all these to pdfwriter/database witer
					
				}}
			}
		});
		JPanel searchTab = new JPanel();
		searchTab.setBackground(Color.WHITE);
		searchTab.setPreferredSize(new Dimension(2000, 100));
		inventoryCardPanel.add(searchTab,"North");
		searchTab.setLayout(null);
		
		txtBarcode = new JTextField();
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
		inventoryCardPanel.add(scrollPane, BorderLayout.CENTER);
		DefaultTableModel tableModel = new DefaultTableModel();
		JTable table = new JTable(tableModel);
	
		tableModel.addColumn("Barcode");
		tableModel.addColumn("Amount Available");
		tableModel.addColumn("Price per Tire");
		tableModel.insertRow(0, new Object[] {10020,23,2});
		tableModel.insertRow(0, new Object[] {100222230,23,2});
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
	        public void valueChanged(ListSelectionEvent event) {
	            // do some actions here, for example
	            // print first column value from selected row
	        	Integer barcode= (Integer) table.getValueAt(table.getSelectedRow(), 0);
	        	Integer amount=(Integer) table.getValueAt(table.getSelectedRow(), 1);
	        	Integer price= (Integer) table.getValueAt(table.getSelectedRow(), 2);
	        	
	        	c.show(cardPanel, "Purchase");
	        	
	   
	        	
	            System.out.println(barcode+"  "+amount+"  "+price);
	        	
	        }
	    });
		scrollPane.setViewportView(table);
		
		
		
		
		JPanel inventoryEditCardPanel = new JPanel();
		inventoryEditCardPanel.setBackground(new Color(82,94,104));
		cardPanel.add(inventoryEditCardPanel, "Edit");
		inventoryEditCardPanel.setLayout(new BorderLayout(0, 0));
		
		JPanel searchPanel = new JPanel();
		searchPanel.setPreferredSize(new Dimension(2000, 100));
		inventoryEditCardPanel.add(searchPanel, BorderLayout.NORTH);
		searchPanel.setLayout(null);
		
		Canvas plusCanvas = new Canvas() {
			public void paint (Graphics g) {
				g.drawImage(loader.getImage("/google-plus.png"),0,0, 40,40, null);
			}
		};
		plusCanvas.setSize(40, 40);
		plusCanvas.setBounds(10, 10, 50, 42);
		searchPanel.add(plusCanvas);
		
		txtArcode = new JTextField();
		txtArcode.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtArcode.setText("Barcode");
		txtArcode.setBounds(192, 23, 116, 29);
		searchPanel.add(txtArcode);
		txtArcode.setColumns(10);
		
		JButton searchBtn = new JButton("Search");
		searchBtn.setFont(new Font("Tahoma", Font.PLAIN, 18));
		searchBtn.setBounds(83, 25, 97, 27);
		searchPanel.add(searchBtn);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		inventoryEditCardPanel.add(scrollPane_1, BorderLayout.CENTER);
		DefaultTableModel tableModel2 = new DefaultTableModel();
		viewTable = new JTable(tableModel2);
		tableModel2.addColumn("Barcode");
		tableModel2.addColumn("Name");
		tableModel2.addColumn("Amount Available");
		tableModel2.addColumn("Price per Tire");
		
		scrollPane_1.setViewportView(viewTable);
		
		JPanel settingsCardPanel = new JPanel();
		settingsCardPanel.setBackground(new Color(82,94,104));
		cardPanel.add(settingsCardPanel, "Settings");
		
		JLabel lblNewLabel_3 = new JLabel("settings");
		lblNewLabel_3.setForeground(SystemColor.inactiveCaptionBorder);
		settingsCardPanel.add(lblNewLabel_3);
		inventoryLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getSource()==inventoryLabel) {
					c.show(cardPanel, "Inventory");
				}
			}
		});
		EditLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getSource()==EditLabel) {
					c.show(cardPanel, "Edit");
				}
			}
		});
		
	}
}
