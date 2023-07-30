package com.main_atm_machine;

import java.awt.*;
import javax.swing.*;
import java.util.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.border.LineBorder;

import com.Connection.DB_Connection;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class Fund_Transfer_Window implements ActionListener {

	JFrame frame;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Fund_Transfer_Window window = new Fund_Transfer_Window("");
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Fund_Transfer_Window(String get_card_from_main) {
		initialize(get_card_from_main);
	}

	JTextField ac_no, amount;
	JPasswordField pin;
	JButton confirm, back;
	String card_no;

	private void initialize(String set_card_for_deposit) {
		this.card_no = set_card_for_deposit;
		frame = new JFrame();
		frame.setResizable(false);

		frame.getContentPane().setLayout(null);

		Toolkit toolkit = frame.getToolkit();
		Dimension size = toolkit.getScreenSize();
		frame.setSize(790, 730);
		frame.setLocation(size.width / 2 - frame.getWidth() / 2, (int) (size.height / 2 - frame.getHeight() / 1.94));
		frame.setTitle("AUTOMATED TELLER MACHINE - ATM Fund Transfer Window");

		ImageIcon atm_background_img = new ImageIcon(ClassLoader.getSystemResource("./images/Artboard.png"));
		Image i2 = atm_background_img.getImage().getScaledInstance(830, 775, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel back_image = new JLabel(i3);
		back_image.setBounds(-15, -35, 830, 775);
		frame.getContentPane().add(back_image);

		JLabel text = new JLabel("ACCOUNT TRANSFER FUND");
		text.setForeground(new Color(255, 255, 255));
		text.setFont(new Font("Nunito", Font.BOLD, 18));
		text.setBounds(180, 145, 320, 30);
		back_image.add(text);

		JLabel ac_number = new JLabel("Account Number   :");
		ac_number.setForeground(new Color(255, 255, 255));
		ac_number.setFont(new Font("Nunito", Font.BOLD, 14));
		ac_number.setBounds(120, 190, 145, 30);
		back_image.add(ac_number);

		JLabel digit = new JLabel("(16-Digit AC No.)");
		digit.setForeground(new Color(255, 255, 255));
		digit.setFont(new Font("Nunito", Font.PLAIN, 12));
		digit.setBounds(120, 205, 145, 30);
		back_image.add(digit);

		JLabel amount_rs = new JLabel("Amount in Rs.       :");
		amount_rs.setForeground(new Color(255, 255, 255));
		amount_rs.setFont(new Font("Nunito", Font.BOLD, 14));
		amount_rs.setBounds(120, 235, 145, 30);
		back_image.add(amount_rs);

		JLabel lbl_pin = new JLabel("Enter Your PIN      :");
		lbl_pin.setForeground(new Color(255, 255, 255));
		lbl_pin.setFont(new Font("Nunito", Font.BOLD, 14));
		lbl_pin.setBounds(120, 283, 145, 30);
		back_image.add(lbl_pin);

		ac_no = new JTextField();
		ac_no.setForeground(new Color(0, 0, 0));
		ac_no.setBackground(new Color(255, 255, 255));
		ac_no.setBorder(new LineBorder(new Color(0, 0, 0), 0, true));
		ac_no.setFont(new Font("Nunito", Font.BOLD, 15));
		ac_no.setBounds(265, 193, 170, 25);
		back_image.add(ac_no);

		amount = new JTextField();
		amount.setForeground(new Color(0, 0, 0));
		amount.setBackground(new Color(255, 255, 255));
		amount.setBorder(new LineBorder(new Color(0, 0, 0), 0, true));
		amount.setFont(new Font("Nunito", Font.BOLD, 15));
		amount.setBounds(265, 238, 170, 25);
		back_image.add(amount);

		pin = new JPasswordField();
		pin.setForeground(new Color(0, 0, 0));
		pin.setBackground(new Color(255, 255, 255));
		pin.setBorder(new LineBorder(new Color(0, 0, 0), 0, true));
		pin.setFont(new Font("Nunito", Font.BOLD, 15));
		pin.setBounds(265, 283, 170, 25);
		back_image.add(pin);

		Cursor cur = new Cursor(Cursor.HAND_CURSOR);
//
		confirm = new JButton("CONFIRM");
		confirm.setHorizontalAlignment(SwingConstants.RIGHT);
		confirm.setFont(new Font("Nunito", Font.BOLD, 15));
		confirm.setBounds(328, 355, 160, 30);
		confirm.setCursor(cur);
		confirm.addActionListener(this);
		back_image.add(confirm);
//
		back = new JButton("Back");
		back.setHorizontalAlignment(SwingConstants.RIGHT);
		back.setFont(new Font("Nunito", Font.BOLD, 15));
		back.setBounds(328, 395, 160, 30);
		back.setCursor(cur);
		back.addActionListener(this);
		back_image.add(back);

		frame.setUndecorated(true);
	}

	public void SendDataToDB() {

		String amt = amount.getText();
		int get_amt = Integer.parseInt(amt);
		String pin_no = pin.getText(), form_num = "", name = "";

		if (this.card_no == "") {
			JOptionPane.showMessageDialog(null,
					"Error : Card Number did not Find.\nPlease Exit and Login Once again to Change Your PIN.");
		} else {
			try {
				com.Connection.DB_Connection conn = new DB_Connection();

				ResultSet rs1 = conn.st.executeQuery(
						"SELECT * FROM atm_db.signup_page_three WHERE atm_card_no = '" + ac_no.getText() + "'");

				while (rs1.next()) {
					form_num = rs1.getString("form_no");
				}

				ResultSet rs2 = conn.st
						.executeQuery("SELECT * FROM atm_db.signup_page_one WHERE form_no = '" + form_num + "'");

				while (rs2.next()) {
					name = rs2.getString("name");
				}

				if (!form_num.equals("")) {
					JOptionPane.showMessageDialog(null, "Account Number :   " + ac_no.getText()
							+ ".\nAccount Holder Name :   " + name + ".\nAccount Found.");

					if (get_amt <= 0) {
						JOptionPane.showMessageDialog(null, "Please Enter Correct Amount you want to Transfer.");
					} else {

						String SelectQuery = "SELECT * FROM atm_db.atm_login WHERE card_number = '" + this.card_no
								+ "' and pin_number = '" + pin_no + "'";

						ResultSet rs = conn.st.executeQuery(SelectQuery);

						if (rs.next()) {
							Date date = new Date();
							String insertDepQuery = "INSERT INTO atm_db.main_transaction VALUES('" + ac_no.getText()
									+ "', '" + date + "', 'DEPOSIT', '" + amount.getText() + "')";

							conn.st.executeUpdate(insertDepQuery);

							String insertWithQuery = "INSERT INTO atm_db.main_transaction VALUES('" + this.card_no
									+ "', '" + date + "', 'WITHDRAW', '" + amount.getText() + "')";

							conn.st.executeUpdate(insertWithQuery);

							JOptionPane.showMessageDialog(null,
									"Rs. " + amount.getText() + " Transfered Successfully.");

							frame.setVisible(false);
							new Main_Transaction_Window(this.card_no).frame.setVisible(true);

						} else {
							JOptionPane.showMessageDialog(null, "Incorrect Card PIN.");
						}
					}

				} else {
					JOptionPane.showMessageDialog(null,
							"Account Number " + ac_no.getText() + " not Found.\nPlease Enter correct account number.");
				}

			} catch (Exception exc) {
				exc.printStackTrace();
			}
		}
	}

	public void actionPerformed(ActionEvent ae) {
		String withdraw_amount = amount.getText();
		int balance = 0;

		if (ae.getSource() == confirm) {
			try {
				com.Connection.DB_Connection conn = new DB_Connection();

				ResultSet rs3 = conn.st
						.executeQuery("SELECT * FROM atm_db.main_transaction WHERE card_no = " + this.card_no);

				while (rs3.next()) {
					if (rs3.getString("transaction_type").equals("DEPOSIT")
							|| rs3.getString("transaction_type").equals("nill")) {
						balance += Integer.parseInt(rs3.getString("amount"));
					} else {
						balance -= Integer.parseInt(rs3.getString("amount"));
					}
				}

				if (ae.getSource() != back && balance < Integer.parseInt(withdraw_amount)) {
					JOptionPane.showMessageDialog(null, "INSUFFICIENT BALANCE....!");
				} else {
					SendDataToDB();
				}
			} catch (Exception ex) {
				System.out.println("Error 2) ---- Here is Issue :");
				ex.printStackTrace();
			}

		} else if (ae.getSource() == back) {
			frame.setVisible(false);
			new Main_Transaction_Window(this.card_no).frame.setVisible(true);
		}
	}
}
