package panels;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class Purchase extends JPanel {

	public Purchase(Integer barcode,Integer amount, Integer price) {
		setBackground(new Color(82,94,104));
		setLayout(null);
		
		JLabel barcodePurchase = new JLabel("Barcode:");
		barcodePurchase.setLabelFor(this);
		barcodePurchase.setFont(new Font("Tahoma", Font.PLAIN, 18));
		barcodePurchase.setOpaque(true);
		barcodePurchase.setBackground(SystemColor.controlLtHighlight);
		barcodePurchase.setBounds(45, 56, 79, 26);
		add(barcodePurchase);
		JLabel lblNewLabel = new JLabel(barcode+"");
		lblNewLabel.setBounds(136, 56, 125, 26);
		add(lblNewLabel);
	}
}
