package com.main_atm_machine;

import java.awt.*;
import javax.swing.*;
import java.util.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.LineBorder;

import com.Connection.DB_Connection;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Deposit_Window implements ActionListener {

	JFrame frame;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Deposit_Window window = new Deposit_Window("");
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Deposit_Window(String get_card_from_main) {
		initialize(get_card_from_main);
	}

	JTextField txt_amount;
	JButton deposit, back;
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
		frame.setTitle("AUTOMATED TELLER MACHINE - ATM Deposit Window");

		ImageIcon atm_background_img = new ImageIcon(ClassLoader.getSystemResource("./images/Artboard.png"));
		Image i2 = atm_background_img.getImage().getScaledInstance(830, 775, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel back_image = new JLabel(i3);
		back_image.setBounds(-15, -35, 830, 775);
		frame.getContentPane().add(back_image);

		JLabel text = new JLabel("Enter Amount You Want To Deposit");
		text.setForeground(new Color(255, 255, 255));
		text.setFont(new Font("Nunito", Font.BOLD, 17));
		text.setBounds(150, 180, 320, 30);
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
		deposit = new JButton("Deposit");
		deposit.setHorizontalAlignment(SwingConstants.RIGHT);
		deposit.setFont(new Font("Nunito", Font.BOLD, 15));
		deposit.setBounds(328, 355, 160, 30);
		deposit.setCursor(cur);
		deposit.addActionListener(this);
		back_image.add(deposit);
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
		String deposit_amount = txt_amount.getText();
		int deposit_amt = Integer.parseInt(deposit_amount);
		Date date = new Date();
		if (this.card_no == "") {
			JOptionPane.showMessageDialog(null,
					"Error : Card Number did not Find.\nPlease Exit and Login Once again to Deposit Amount.");
		} else {
			if (deposit_amount.equals("") || deposit_amt <= 0) {
				JOptionPane.showMessageDialog(null, "Please Enter Correct Amount you want to Deposit.");
			} else {
				try {
					com.Connection.DB_Connection conn = new DB_Connection();
					String insertQuery = "INSERT INTO atm_db.main_transaction VALUES('" + this.card_no + "', '" + date
							+ "', 'DEPOSIT', '" + deposit_amount + "')";

					conn.st.executeUpdate(insertQuery);

					JOptionPane.showMessageDialog(null, "Rs. " + deposit_amount + " Deposited Successfully.");

					frame.setVisible(false);
					new Main_Transaction_Window(this.card_no).frame.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

	}

	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == deposit) {

			SendDataToDB();

		} else if (ae.getSource() == back) {
			frame.setVisible(false);
			new Main_Transaction_Window(this.card_no).frame.setVisible(true);
		}
	}

}
