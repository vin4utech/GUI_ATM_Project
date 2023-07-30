package com.main_atm_machine;

import java.awt.*;
import javax.swing.*;
import java.util.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.border.LineBorder;

import com.Connection.DB_Connection;

public class Balance_Enquiry_Window implements ActionListener {

	JFrame frame;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Balance_Enquiry_Window window = new Balance_Enquiry_Window("");
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Balance_Enquiry_Window(String get_card_from_main) {
		initialize(get_card_from_main);
	}

	JButton back;
	String card_no;
	JLabel balance;

	private void initialize(String set_card_for_balance) {
		this.card_no = set_card_for_balance;
		frame = new JFrame();
		frame.setResizable(false);

		frame.getContentPane().setLayout(null);

		Toolkit toolkit = frame.getToolkit();
		Dimension size = toolkit.getScreenSize();
		frame.setSize(790, 730);
		frame.setLocation(size.width / 2 - frame.getWidth() / 2, (int) (size.height / 2 - frame.getHeight() / 1.94));
		frame.setTitle("AUTOMATED TELLER MACHINE - ATM Deposit Window");

		ImageIcon atm_background_img = new ImageIcon(ClassLoader.getSystemResource("./images/Artboard.png"));
		Image i2 = atm_background_img.getImage().getScaledInstance(830, 775, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel back_image = new JLabel(i3);
		back_image.setBounds(-15, -35, 830, 775);
		frame.getContentPane().add(back_image);

		JLabel text = new JLabel("YOUR ACCOUNT BALANCE IS");
		text.setForeground(new Color(255, 255, 255));
		text.setFont(new Font("Nunito", Font.BOLD, 18));
		text.setBounds(160, 160, 320, 30);
		back_image.add(text);

		JLabel Rs = new JLabel("Rs. ");
		Rs.setForeground(new Color(255, 255, 255));
		Rs.setFont(new Font("Nunito", Font.BOLD, 18));
		Rs.setBounds(220, 210, 50, 30);
		back_image.add(Rs);

		int bal = 0;
		if (this.card_no == "") {
			JOptionPane.showMessageDialog(null,
					"Error : Card Number did not Find.\nPlease Exit and Login Once again to Change Your PIN.");
		} else {

			try {
				com.Connection.DB_Connection conn = new DB_Connection();

				ResultSet rs = conn.st
						.executeQuery("SELECT * FROM atm_db.main_transaction WHERE card_no = '" + this.card_no + "'");

				while (rs.next()) {
					if (rs.getString("transaction_type").equals("DEPOSIT")) {
						bal += Integer.parseInt(rs.getString("amount"));

					} else {
						bal -= Integer.parseInt(rs.getString("amount"));

					}
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		balance = new JLabel(""+bal);

		balance.setForeground(new Color(255, 255, 255));
		balance.setFont(new Font("Nunito", Font.BOLD, 18));
		balance.setBounds(270, 213, 170, 25);
		back_image.add(balance);

		Cursor cur = new Cursor(Cursor.HAND_CURSOR);
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

	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == back) {
			frame.setVisible(false);
			new Main_Transaction_Window(this.card_no).frame.setVisible(true);
		}
	}
}
