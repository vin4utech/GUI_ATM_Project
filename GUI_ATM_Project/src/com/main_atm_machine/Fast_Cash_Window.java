package com.main_atm_machine;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Date;

import javax.swing.*;

import com.Connection.DB_Connection;

public class Fast_Cash_Window implements ActionListener {

	JFrame frame;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Fast_Cash_Window window = new Fast_Cash_Window("");
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Fast_Cash_Window(String get_card_number_from_login) {
		initialize(get_card_number_from_login);
	}

	JButton hundred, one_thousand, five_thousand, five_hundred, two_thousand, ten_thousand, back;
	String card_number;

	private void initialize(String card_no_for_transaction) {
		this.card_number = card_no_for_transaction;
		frame = new JFrame();
		frame.setResizable(false);

		frame.getContentPane().setLayout(null);

		Toolkit toolkit = frame.getToolkit();
		Dimension size = toolkit.getScreenSize();
		frame.setSize(790, 730);
		frame.setLocation(size.width / 2 - frame.getWidth() / 2, (int) (size.height / 2 - frame.getHeight() / 1.94));
		frame.setTitle("AUTOMATED TELLER MACHINE - ATM Fast Cash Window");

		ImageIcon atm_background_img = new ImageIcon(ClassLoader.getSystemResource("./images/Artboard.png"));
		Image i2 = atm_background_img.getImage().getScaledInstance(830, 775, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel back_image = new JLabel(i3);
		back_image.setBounds(-15, -35, 830, 775);
		frame.getContentPane().add(back_image);

		JLabel text = new JLabel("SELECT WITHDRAW AMOUNT");
		text.setForeground(new Color(255, 255, 255));
		text.setFont(new Font("Nunito", Font.BOLD, 18));
		text.setBounds(160, 170, 300, 30);
		back_image.add(text);

		Cursor cur = new Cursor(Cursor.HAND_CURSOR);

		hundred = new JButton("Rs. 100");
		hundred.setHorizontalAlignment(SwingConstants.CENTER);
		hundred.setFont(new Font("Nunito", Font.BOLD, 15));
		hundred.setBounds(103, 275, 160, 30);
		hundred.setCursor(cur);
		hundred.addActionListener(this);
		back_image.add(hundred);

		one_thousand = new JButton("Rs. 1000");
		one_thousand.setHorizontalAlignment(SwingConstants.CENTER);
		one_thousand.setFont(new Font("Nunito", Font.BOLD, 15));
		one_thousand.setBounds(103, 315, 160, 30);
		one_thousand.setCursor(cur);
		one_thousand.addActionListener(this);
		back_image.add(one_thousand);

		five_thousand = new JButton("Rs. 5000");
		five_thousand.setHorizontalAlignment(SwingConstants.CENTER);
		five_thousand.setFont(new Font("Nunito", Font.BOLD, 15));
		five_thousand.setBounds(103, 355, 160, 30);
		five_thousand.setCursor(cur);
		five_thousand.addActionListener(this);
		back_image.add(five_thousand);

		five_hundred = new JButton("Rs. 500");
		five_hundred.setHorizontalAlignment(SwingConstants.CENTER);
		five_hundred.setFont(new Font("Nunito", Font.BOLD, 15));
		five_hundred.setBounds(328, 275, 160, 30);
		five_hundred.setCursor(cur);
		five_hundred.addActionListener(this);
		back_image.add(five_hundred);

		two_thousand = new JButton("Rs. 2000");
		two_thousand.setHorizontalAlignment(SwingConstants.CENTER);
		two_thousand.setFont(new Font("Nunito", Font.BOLD, 15));
		two_thousand.setBounds(328, 315, 160, 30);
		two_thousand.setCursor(cur);
		two_thousand.addActionListener(this);
		back_image.add(two_thousand);

		ten_thousand = new JButton("Rs. 10000");
		ten_thousand.setHorizontalAlignment(SwingConstants.CENTER);
		ten_thousand.setFont(new Font("Nunito", Font.BOLD, 15));
		ten_thousand.setBounds(328, 355, 160, 30);
		ten_thousand.setCursor(cur);
		ten_thousand.addActionListener(this);
		back_image.add(ten_thousand);

		back = new JButton("Back");
		back.setHorizontalAlignment(SwingConstants.CENTER);
		back.setFont(new Font("Nunito", Font.BOLD, 15));
		back.setBounds(328, 395, 160, 30);
		back.setCursor(cur);
		back.addActionListener(this);
		back_image.add(back);

		frame.setUndecorated(true);
	}

	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == back) {
			frame.setVisible(false);
			new Main_Transaction_Window(this.card_number).frame.setVisible(true);

		} else {
			if (this.card_number == "") {
				JOptionPane.showMessageDialog(null,
						"Error : Card Number did not Find.\nPlease Exit and Login Once again to Withdraw Amount.");
			} else {
				String amount = ((JButton) ae.getSource()).getText().substring(4);
			
				try {
					com.Connection.DB_Connection conn = new DB_Connection();
					ResultSet rs = conn.st
							.executeQuery("SELECT * FROM atm_db.main_transaction WHERE card_no = " + this.card_number);
					int balance = 0;
					while (rs.next()) {
						if (rs.getString("transaction_type").equals("DEPOSIT") || rs.getString("transaction_type").equals("nill")) {
							balance += Integer.parseInt(rs.getString("amount"));
						} else {
							balance -= Integer.parseInt(rs.getString("amount"));
						}
					}

					if (ae.getSource() != back && balance < Integer.parseInt(amount)) {
						JOptionPane.showMessageDialog(null, "INSUFFICIENT BALANCE....!");
					} else {
						Date date = new Date();
						String Query = "INSERT INTO atm_db.main_transaction VALUES('" + this.card_number + "', '" + date
								+ "', 'WITHDRAW','" + amount + "')";
						conn.st.executeUpdate(Query);

						JOptionPane.showMessageDialog(null, "Rs. " + amount + " Debited Successfully.");
						frame.setVisible(false);
						new Main_Transaction_Window(this.card_number).frame.setVisible(true);

					}

				} catch (Exception e) {
					System.out.println("Here is Issue :");
					e.printStackTrace();
				}
			}

		}
	}
}
