package com.main_atm_machine;

import java.awt.*;
import javax.swing.*;
import java.sql.*;

import com.Connection.DB_Connection;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Login_Window implements ActionListener {

	public JFrame frame;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login_Window window = new Login_Window("");
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Login_Window(String get_card_no) {
		initialize(get_card_no);
	}

	JButton login, clear, signup, exit;
	JTextField txt_card_no;
	JPasswordField txt_pin_no;
	String card_no;

	private void initialize(String new_card_no) {
		this.card_no = new_card_no;
		frame = new JFrame();
		frame.setResizable(false);

		frame.getContentPane().setLayout(null);
		Toolkit toolkit = frame.getToolkit();
		Dimension size = toolkit.getScreenSize();
		frame.setSize(500, 410);
		frame.setLocation(size.width / 2 - frame.getWidth() / 2, size.height / 2 - frame.getHeight() / 2);
		frame.setTitle("AUTOMATED TELLER MACHINE - Login Window");

		ImageIcon login_icon = new ImageIcon(ClassLoader.getSystemResource("./images/atm_money.png"));
		Image i2 = login_icon.getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel label_icon = new JLabel(i3);
		label_icon.setBounds(45, 24, 70, 70);
		frame.getContentPane().add(label_icon);

		JLabel heading = new JLabel("Welcome to ATM");
		heading.setFont(new Font("Nunito", Font.BOLD, 35));
		heading.setBounds(145, 22, 300, 80);
		frame.getContentPane().add(heading);

		JLabel card_no = new JLabel("Card Number ");
		card_no.setFont(new Font("Nunito", Font.BOLD, 18));
		card_no.setBounds(55, 122, 120, 40);
		frame.getContentPane().add(card_no);

		JLabel colon1 = new JLabel(":");
		colon1.setFont(new Font("Nunito", Font.BOLD, 18));
		colon1.setBounds(185, 122, 10, 40);
		frame.getContentPane().add(colon1);

		txt_card_no = new JTextField();
		txt_card_no.setFont(new Font("Nunito", Font.PLAIN, 15));
		txt_card_no.setText(new_card_no);
		txt_card_no.setBounds(215, 127, 200, 30);
		frame.getContentPane().add(txt_card_no);

		JLabel pin_no = new JLabel("ATM Pin No ");
		pin_no.setFont(new Font("Nunito", Font.BOLD, 18));
		pin_no.setBounds(55, 182, 120, 40);
		frame.getContentPane().add(pin_no);

		JLabel colon2 = new JLabel(":");
		colon2.setFont(new Font("Nunito", Font.BOLD, 18));
		colon2.setBounds(185, 182, 10, 40);
		frame.getContentPane().add(colon2);

		txt_pin_no = new JPasswordField();
		txt_pin_no.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					SendDataToDB();
				}
			}
		});
		txt_pin_no.setFont(new Font("Nunito", Font.PLAIN, 15));
		txt_pin_no.setBounds(215, 182, 200, 30);
		frame.getContentPane().add(txt_pin_no);

		/******** JBUTTONS CODE **************/

		Cursor cur = new Cursor(Cursor.HAND_CURSOR);

		login = new JButton("SIGN IN");

		login.addActionListener(this);

		login.setFont(new Font("Nunito", Font.BOLD, 15));
		login.setBackground(Color.black);
		login.setForeground(Color.white);
		login.setBounds(130, 252, 100, 30);
		login.setCursor(cur);
		frame.getContentPane().add(login);

		clear = new JButton("CLEAR");

		clear.addActionListener(this);

		clear.setFont(new Font("Nunito", Font.BOLD, 15));
		clear.setBackground(Color.black);
		clear.setForeground(Color.white);
		clear.setBounds(250, 252, 100, 30);
		clear.setCursor(cur);
		frame.getContentPane().add(clear);

		signup = new JButton("SIGN UP");
		signup.addActionListener(this);
		signup.setFont(new Font("Nunito", Font.BOLD, 15));
		signup.setBackground(Color.black);
		signup.setForeground(Color.white);
		signup.setBounds(130, 299, 220, 30);
		signup.setCursor(cur);
		frame.getContentPane().add(signup);

		exit = new JButton("EXIT");
		exit.addActionListener(this);
		exit.setFont(new Font("Nunito", Font.BOLD, 15));
		exit.setBackground(Color.GRAY);
		exit.setForeground(Color.RED);
		exit.setBounds(130, 340, 220, 30);
		exit.setCursor(cur);
		frame.getContentPane().add(exit);

		frame.setUndecorated(true);
	}

	public void SendDataToDB() {
		try {
			com.Connection.DB_Connection conn = new DB_Connection();
			String card_no = txt_card_no.getText();
			String pin_no = txt_pin_no.getText();

			String SelectQuery = "SELECT * FROM atm_db.atm_login WHERE card_number = '" + card_no
					+ "' and pin_number = '" + pin_no + "'";

			ResultSet rs = conn.st.executeQuery(SelectQuery);

			if (rs.next()) {
				frame.setVisible(false);
				new Main_Transaction_Window(card_no).frame.setVisible(true);

			} else {
				JOptionPane.showMessageDialog(null, "Incorrect Card Number or PIN.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == login) {

			SendDataToDB();

		} else if (ae.getSource() == signup) {
			frame.setVisible(false);
			new SignUp_Window_One().frame.setVisible(true);

		} else if (ae.getSource() == clear) {
			txt_card_no.setText(null);
			txt_pin_no.setText(null);
			txt_card_no.requestFocus();
		} else if (ae.getSource() == exit) {
			System.exit(0);
		}

	}

}
