package com.main_atm_machine;

import java.awt.*;
import javax.swing.*;
import java.util.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;

import javax.swing.border.LineBorder;

import com.Connection.DB_Connection;

public class Withdraw_Window implements ActionListener {

	JFrame frame;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Withdraw_Window window = new Withdraw_Window("");
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Withdraw_Window(String get_card_from_main) {
		initialize(get_card_from_main);
	}

	JTextField txt_amount;
	JButton withdraw, back;
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
		frame.setTitle("AUTOMATED TELLER MACHINE - ATM Withdraw Window");

		ImageIcon atm_background_img = new ImageIcon(ClassLoader.getSystemResource("./images/Artboard.png"));
		Image i2 = atm_background_img.getImage().getScaledInstance(830, 775, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel back_image = new JLabel(i3);
		back_image.setBounds(-15, -35, 830, 775);
		frame.getContentPane().add(back_image);

		JLabel text = new JLabel("Enter the Amount You Want To Withdraw");
		text.setForeground(new Color(255, 255, 255));
		text.setFont(new Font("Nunito", Font.BOLD, 16));
		text.setBounds(145, 180, 330, 30);
		back_image.add(text);

		JLabel rs = new JLabel("Rs.");
		rs.setForeground(new Color(255, 255, 255));
		rs.setFont(new Font("Nunito", Font.PLAIN, 35));
		rs.setBounds(165, 245, 50, 30);
		back_image.add(rs);

		txt_amount = new JTextField();
		txt_amount.setForeground(new Color(0, 0, 0));
		txt_amount.setBackground(new Color(255, 255, 255));
		txt_amount.setBorder(new LineBorder(new Color(0, 0, 0), 0, true));
		txt_amount.setHorizontalAlignment(SwingConstants.CENTER);
		txt_amount.setFont(new Font("Nunito", Font.BOLD, 23));
		txt_amount.setBounds(220, 240, 200, 40);
		back_image.add(txt_amount);

		Cursor cur = new Cursor(Cursor.HAND_CURSOR);
//
		withdraw = new JButton("Cash Withdraw");
		withdraw.setHorizontalAlignment(SwingConstants.RIGHT);
		withdraw.setFont(new Font("Nunito", Font.BOLD, 15));
		withdraw.setBounds(328, 355, 160, 30);
		withdraw.setCursor(cur);
		withdraw.addActionListener(this);
		back_image.add(withdraw);
//
		back = new JButton("Back");
		back.setHorizontalAlignment(SwingConstants.RIGHT);
		back.setFont(new Font("Nunito", Font.BOLD, 15));
		back.setBounds(328, 395, 160, 30);
		back.setCursor(cur);
		back.addActionListener(this);
		back_image.add(back);

		txt_amount.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
					frame.setVisible(false);
					new Main_Transaction_Window(card_no).frame.setVisible(true);
				}

				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					SendDataToDB();
				}
			}
		});

		frame.setUndecorated(true);
	}

	

	public void SendDataToDB() {
		String withdraw_amount = txt_amount.getText();
		int withdraw_amt = Integer.parseInt(withdraw_amount);
		Date date = new Date();
		if (this.card_no == "") {
			JOptionPane.showMessageDialog(null,
					"Error : Card Number did not Find.\nPlease Exit and Login Once again to Withdraw Amount.");
		} else {
			if (withdraw_amount.equals("") || withdraw_amt <= 0) {
				JOptionPane.showMessageDialog(null, "Please Enter Correct Amount you want to Withdraw.");
			} else {
				try {
					com.Connection.DB_Connection conn = new DB_Connection();

					String insertQuery = "INSERT INTO atm_db.main_transaction VALUES('" + this.card_no + "', '" + date
							+ "', 'WITHDRAW', '" + withdraw_amount + "')";

					conn.st.executeUpdate(insertQuery);

					JOptionPane.showMessageDialog(null, "Rs. " + withdraw_amount + " Withdraw Successfully.");

					frame.setVisible(false);
					new Main_Transaction_Window(this.card_no).frame.setVisible(true);

				} catch (Exception e) {
					System.out.println("Error 1) ---- Here is Issue :");
					e.printStackTrace();
				}
			}
		}
	}

	public void actionPerformed(ActionEvent ae) {
		String withdraw_amount = txt_amount.getText();
		int balance = 0;
		if (ae.getSource() == withdraw) {
			try {
				com.Connection.DB_Connection conn = new DB_Connection();
				ResultSet rs = conn.st
						.executeQuery("SELECT * FROM atm_db.main_transaction WHERE card_no = " + this.card_no);
				
				while (rs.next()) {
					if (rs.getString("transaction_type").equals("DEPOSIT") || rs.getString("transaction_type").equals("nill")) {
						balance += Integer.parseInt(rs.getString("amount"));
					} else {
						balance -= Integer.parseInt(rs.getString("amount"));
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
