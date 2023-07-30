package com.main_atm_machine;

import java.awt.*;
import javax.swing.*;

import com.Connection.DB_Connection;

import java.util.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SignUp_Window_Three implements ActionListener {

	JFrame frame;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignUp_Window_Three window = new SignUp_Window_Three("");
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	String form_no;
	JRadioButton saving_ac, fixed_deposit_ac, current_ac, recuring_deposit_ac, salary_ac, nri_ac;
	ButtonGroup accountTypeGroup;
	JCheckBox atm_card_service, internet_bank_service, mobile_bank_service, email_sms_alert, estatement_service,
			cheque_book, check_tc;
	JButton submit, exit;

	public SignUp_Window_Three(String get_form_no_from_two) {
		initialize(get_form_no_from_two);
	}

	private void initialize(String form_no_page_three) {
		this.form_no = form_no_page_three;

		frame = new JFrame();
		frame.setResizable(false);

		frame.getContentPane().setLayout(null);

		Toolkit toolkit = frame.getToolkit();
		Dimension size = toolkit.getScreenSize();
		frame.setSize(700, 684);
		frame.setLocation(size.width / 2 - frame.getWidth() / 2, size.height / 2 - frame.getHeight() / 2);
		frame.setTitle("AUTOMATED TELLER MACHINE - Account Details Window -Page 03");

		ImageIcon register_icon = new ImageIcon(ClassLoader.getSystemResource("./images/atm_account_details.png"));
		Image i2 = register_icon.getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel label_icon = new JLabel(i3);
		label_icon.setBounds(175, 46, 60, 60);
		frame.getContentPane().add(label_icon);

		JLabel pg_no = new JLabel("Page No. 03");
		pg_no.setFont(new Font("Nunito", Font.PLAIN, 16));
		pg_no.setBounds(10, 15, 90, 20);
		frame.getContentPane().add(pg_no);

		JLabel reg_form_no = new JLabel("APPLICATION FORM NO - " + this.form_no);
		reg_form_no.setFont(new Font("Nunito", Font.BOLD, 16));
		reg_form_no.setBounds(389, 15, 260, 20);
		frame.getContentPane().add(reg_form_no);

		JLabel personal_detail = new JLabel("\u2022 Account Details \u2022");
		personal_detail.setFont(new Font("Nunito", Font.BOLD, 26));
		personal_detail.setBounds(250, 59, 245, 30);
		frame.getContentPane().add(personal_detail);

		/*********** FORM 2nd DATA **********************/

		JLabel account_type = new JLabel("• ACCOUNT TYPE");
		account_type.setFont(new Font("Nunito", Font.BOLD, 18));
		account_type.setBounds(30, 120, 175, 30);
		frame.getContentPane().add(account_type);

		JLabel colon1 = new JLabel(":");
		colon1.setFont(new Font("Nunito", Font.BOLD, 18));
		colon1.setBounds(220, 120, 10, 30);
		frame.getContentPane().add(colon1);

		JLabel card_no = new JLabel("• ATM Card No");
		card_no.setFont(new Font("Nunito", Font.BOLD, 18));
		card_no.setBounds(30, 260, 140, 30);
		frame.getContentPane().add(card_no);

		JLabel card_info = new JLabel("(Your 16-digit Card Number.)");
		card_info.setFont(new Font("Nunito", Font.PLAIN, 12));
		card_info.setBounds(43, 282, 162, 30);
		frame.getContentPane().add(card_info);

		JLabel colon2 = new JLabel(":");
		colon2.setFont(new Font("Nunito", Font.BOLD, 18));
		colon2.setBounds(220, 260, 10, 30);
		frame.getContentPane().add(colon2);

		JLabel pin_no = new JLabel("• ATM PIN");
		pin_no.setFont(new Font("Nunito", Font.BOLD, 18));
		pin_no.setBounds(30, 330, 115, 30);
		frame.getContentPane().add(pin_no);

		JLabel card_pin_info = new JLabel("(4-digit password.)");
		card_pin_info.setFont(new Font("Nunito", Font.PLAIN, 12));
		card_pin_info.setBounds(43, 352, 115, 30);
		frame.getContentPane().add(card_pin_info);

		JLabel colon3 = new JLabel(":");
		colon3.setFont(new Font("Nunito", Font.BOLD, 18));
		colon3.setBounds(220, 330, 10, 30);
		frame.getContentPane().add(colon3);

		JLabel service_required = new JLabel("• Bank Service Required");
		service_required.setFont(new Font("Nunito", Font.BOLD, 18));
		service_required.setBounds(30, 400, 213, 30);
		frame.getContentPane().add(service_required);

		JLabel colon4 = new JLabel(":");
		colon4.setFont(new Font("Nunito", Font.BOLD, 18));
		colon4.setBounds(246, 400, 10, 30);
		frame.getContentPane().add(colon4);

		JLabel card_dummy_no = new JLabel("XXXX - XXXX - XXXX - 1234");
		card_dummy_no.setFont(new Font("Nunito", Font.BOLD, 18));
		card_dummy_no.setBounds(265, 260, 260, 30);
		frame.getContentPane().add(card_dummy_no);

		JLabel card_dummy_info = new JLabel("It would appear on ATM Card / Cheque Book & Statement.");
		card_dummy_info.setFont(new Font("Nunito", Font.PLAIN, 12));
		card_dummy_info.setBounds(265, 282, 315, 30);
		frame.getContentPane().add(card_dummy_info);

		JLabel pin_dummy_no = new JLabel("XXXX ");
		pin_dummy_no.setFont(new Font("Nunito", Font.BOLD, 18));
		pin_dummy_no.setBounds(265, 330, 80, 30);
		frame.getContentPane().add(pin_dummy_no);

		/*********** FORM DATA 2nd TEXT FIELD **********************/

		Cursor cur = new Cursor(Cursor.HAND_CURSOR);

		saving_ac = new JRadioButton("Saving Account");
		saving_ac.setSelected(true);
		saving_ac.setFont(new Font("Nunito", Font.BOLD, 14));
		saving_ac.setBounds(63, 157, 150, 30);
		saving_ac.setCursor(cur);
		frame.getContentPane().add(saving_ac);

		current_ac = new JRadioButton("Current Account");
		current_ac.setFont(new Font("Nunito", Font.PLAIN, 14));
		current_ac.setBounds(63, 202, 150, 30);
		current_ac.setCursor(cur);
		frame.getContentPane().add(current_ac);

		salary_ac = new JRadioButton("Salary Account");
		salary_ac.setFont(new Font("Nunito", Font.PLAIN, 14));
		salary_ac.setBounds(243, 157, 140, 30);
		salary_ac.setCursor(cur);
		frame.getContentPane().add(salary_ac);

		nri_ac = new JRadioButton("NRI Account");
		nri_ac.setFont(new Font("Nunito", Font.PLAIN, 14));
		nri_ac.setBounds(243, 202, 140, 30);
		nri_ac.setCursor(cur);
		frame.getContentPane().add(nri_ac);

		fixed_deposit_ac = new JRadioButton("Fixed Deposit Account");
		fixed_deposit_ac.setFont(new Font("Nunito", Font.PLAIN, 14));
		fixed_deposit_ac.setBounds(413, 157, 210, 30);
		fixed_deposit_ac.setCursor(cur);
		frame.getContentPane().add(fixed_deposit_ac);

		recuring_deposit_ac = new JRadioButton("Recuring Deposit Account");
		recuring_deposit_ac.setFont(new Font("Nunito", Font.PLAIN, 14));
		recuring_deposit_ac.setBounds(413, 202, 210, 30);
		recuring_deposit_ac.setCursor(cur);
		frame.getContentPane().add(recuring_deposit_ac);

		accountTypeGroup = new ButtonGroup();
		accountTypeGroup.add(saving_ac);
		accountTypeGroup.add(fixed_deposit_ac);
		accountTypeGroup.add(salary_ac);
		accountTypeGroup.add(nri_ac);
		accountTypeGroup.add(current_ac);
		accountTypeGroup.add(recuring_deposit_ac);

		atm_card_service = new JCheckBox("ATM Card");
		atm_card_service.addActionListener(this);
		atm_card_service.setSelected(true);
		atm_card_service.setFont(new Font("Nunito", Font.BOLD, 14));
		atm_card_service.setBounds(63, 437, 115, 30);
		atm_card_service.setCursor(cur);
		frame.getContentPane().add(atm_card_service);

		cheque_book = new JCheckBox("Cheque Book");
		cheque_book.addActionListener(this);
		cheque_book.setFont(new Font("Nunito", Font.PLAIN, 14));
		cheque_book.setBounds(63, 482, 115, 30);
		cheque_book.setCursor(cur);
		frame.getContentPane().add(cheque_book);

		mobile_bank_service = new JCheckBox("Mobile Banking");
		mobile_bank_service.addActionListener(this);
		mobile_bank_service.setFont(new Font("Nunito", Font.PLAIN, 14));
		mobile_bank_service.setBounds(239, 437, 140, 30);
		mobile_bank_service.setCursor(cur);
		frame.getContentPane().add(mobile_bank_service);

		internet_bank_service = new JCheckBox("Internet Banking");
		internet_bank_service.addActionListener(this);
		internet_bank_service.setFont(new Font("Nunito", Font.PLAIN, 14));
		internet_bank_service.setBounds(239, 482, 140, 30);
		internet_bank_service.setCursor(cur);
		frame.getContentPane().add(internet_bank_service);

		email_sms_alert = new JCheckBox("E-mail / SMS Alerts");
		email_sms_alert.addActionListener(this);
		email_sms_alert.setFont(new Font("Nunito", Font.PLAIN, 14));
		email_sms_alert.setBounds(423, 437, 170, 30);
		email_sms_alert.setCursor(cur);
		frame.getContentPane().add(email_sms_alert);

		estatement_service = new JCheckBox("E-Statements");
		estatement_service.addActionListener(this);
		estatement_service.setFont(new Font("Nunito", Font.PLAIN, 14));
		estatement_service.setBounds(423, 482, 170, 30);
		estatement_service.setCursor(cur);
		frame.getContentPane().add(estatement_service);

		saving_ac.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				saving_ac.setFont(new Font("Nunito", Font.BOLD, 14));
				current_ac.setFont(new Font("Nunito", Font.PLAIN, 14));

				fixed_deposit_ac.setFont(new Font("Nunito", Font.PLAIN, 14));
				recuring_deposit_ac.setFont(new Font("Nunito", Font.PLAIN, 14));

				salary_ac.setFont(new Font("Nunito", Font.PLAIN, 14));
				nri_ac.setFont(new Font("Nunito", Font.PLAIN, 14));
			}
		});

		current_ac.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				saving_ac.setFont(new Font("Nunito", Font.PLAIN, 14));
				current_ac.setFont(new Font("Nunito", Font.BOLD, 14));

				fixed_deposit_ac.setFont(new Font("Nunito", Font.PLAIN, 14));
				recuring_deposit_ac.setFont(new Font("Nunito", Font.PLAIN, 14));

				salary_ac.setFont(new Font("Nunito", Font.PLAIN, 14));
				nri_ac.setFont(new Font("Nunito", Font.PLAIN, 14));
			}
		});

		fixed_deposit_ac.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				saving_ac.setFont(new Font("Nunito", Font.PLAIN, 14));
				current_ac.setFont(new Font("Nunito", Font.PLAIN, 14));

				fixed_deposit_ac.setFont(new Font("Nunito", Font.BOLD, 14));
				recuring_deposit_ac.setFont(new Font("Nunito", Font.PLAIN, 14));

				salary_ac.setFont(new Font("Nunito", Font.PLAIN, 14));
				nri_ac.setFont(new Font("Nunito", Font.PLAIN, 14));
			}
		});

		recuring_deposit_ac.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				saving_ac.setFont(new Font("Nunito", Font.PLAIN, 14));
				current_ac.setFont(new Font("Nunito", Font.PLAIN, 14));

				fixed_deposit_ac.setFont(new Font("Nunito", Font.PLAIN, 14));
				recuring_deposit_ac.setFont(new Font("Nunito", Font.BOLD, 14));

				salary_ac.setFont(new Font("Nunito", Font.PLAIN, 14));
				nri_ac.setFont(new Font("Nunito", Font.PLAIN, 14));
			}
		});

		salary_ac.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				saving_ac.setFont(new Font("Nunito", Font.PLAIN, 14));
				current_ac.setFont(new Font("Nunito", Font.PLAIN, 14));

				fixed_deposit_ac.setFont(new Font("Nunito", Font.PLAIN, 14));
				recuring_deposit_ac.setFont(new Font("Nunito", Font.PLAIN, 14));

				salary_ac.setFont(new Font("Nunito", Font.BOLD, 14));
				nri_ac.setFont(new Font("Nunito", Font.PLAIN, 14));
			}
		});

		nri_ac.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				saving_ac.setFont(new Font("Nunito", Font.PLAIN, 14));
				current_ac.setFont(new Font("Nunito", Font.PLAIN, 14));

				fixed_deposit_ac.setFont(new Font("Nunito", Font.PLAIN, 14));
				recuring_deposit_ac.setFont(new Font("Nunito", Font.PLAIN, 14));

				salary_ac.setFont(new Font("Nunito", Font.PLAIN, 14));
				nri_ac.setFont(new Font("Nunito", Font.BOLD, 14));
			}
		});

		/*********** FORM DATA BUTTONS **********************/

		submit = new JButton("SUBMIT");
		submit.setFont(new Font("Nunito", Font.BOLD, 15));
		submit.setBackground(Color.black);
		submit.setForeground(Color.white);
		submit.setBounds(200, 580, 100, 30);
		submit.setCursor(cur);
		submit.addActionListener(this);
		frame.getContentPane().add(submit);

		exit = new JButton("EXIT");
		exit.setFont(new Font("Nunito", Font.BOLD, 15));
		exit.setBackground(Color.black);
		exit.setForeground(Color.white);
		exit.setBounds(350, 580, 100, 30);
		exit.setCursor(cur);
		exit.addActionListener(this);
		frame.getContentPane().add(exit);

		check_tc = new JCheckBox(
				" • I hereby declares that the above entered details are correct to the best of my knowledge.");
		check_tc.setFont(new Font("Nunito", Font.PLAIN, 13));
		check_tc.setBounds(30, 533, 632, 23);
		check_tc.addActionListener(this);
		frame.getContentPane().add(check_tc);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void actionPerformed(ActionEvent ae) {
		if (atm_card_service.isSelected() == true) {
			atm_card_service.setFont(new Font("Nunito", Font.BOLD, 14));

		} else {

			atm_card_service.setFont(new Font("Nunito", Font.PLAIN, 14));
		}
		if (mobile_bank_service.isSelected() == true) {
			mobile_bank_service.setFont(new Font("Nunito", Font.BOLD, 14));

		} else {
			mobile_bank_service.setFont(new Font("Nunito", Font.PLAIN, 14));
		}
		if (internet_bank_service.isSelected() == true) {
			internet_bank_service.setFont(new Font("Nunito", Font.BOLD, 14));

		} else {
			internet_bank_service.setFont(new Font("Nunito", Font.PLAIN, 14));
		}
		if (cheque_book.isSelected() == true) {
			cheque_book.setFont(new Font("Nunito", Font.BOLD, 14));

		} else {
			cheque_book.setFont(new Font("Nunito", Font.PLAIN, 14));
		}
		if (email_sms_alert.isSelected() == true) {
			email_sms_alert.setFont(new Font("Nunito", Font.BOLD, 14));

		} else {
			email_sms_alert.setFont(new Font("Nunito", Font.PLAIN, 14));
		}
		if (estatement_service.isSelected() == true) {
			estatement_service.setFont(new Font("Nunito", Font.BOLD, 14));

		} else {
			estatement_service.setFont(new Font("Nunito", Font.PLAIN, 14));
		}

		if (check_tc.isSelected() == true) {
			check_tc.setFont(new Font("Nunito", Font.BOLD, 13));

		} else {
			check_tc.setFont(new Font("Nunito", Font.PLAIN, 13));
		}

		if (ae.getSource() == submit) {
			if (check_tc.isSelected() == true) {

				String form_no = this.form_no;

				saving_ac.setActionCommand("Saving Account");
				current_ac.setActionCommand("Current Account");
				fixed_deposit_ac.setActionCommand("Fixed Deposit Account");
				recuring_deposit_ac.setActionCommand("Recuring Deposit Account");
				salary_ac.setActionCommand("Salary Account");
				nri_ac.setActionCommand("NRI Account");

				String account_type = accountTypeGroup.getSelection().getActionCommand();

				Random random_no = new Random();
				Long card_number = Math.abs((random_no.nextLong() % 90000000L)) + 5040291000000000L;
				Long pin_number = Math.abs((random_no.nextLong() % 9000L)) + 1000L;

				String bank_services = "";

				if (atm_card_service.isSelected()) {
					bank_services = bank_services + "ATM Card,";
				}
				if (internet_bank_service.isSelected()) {
					bank_services = bank_services + " Internet Banking,";
				}
				if (mobile_bank_service.isSelected()) {
					bank_services = bank_services + " Mobile Banking,";
				}
				if (email_sms_alert.isSelected()) {
					bank_services = bank_services + " EMAIL & SMS Alert,";
				}
				if (estatement_service.isSelected()) {
					bank_services = bank_services + " E Statement,";
				}
				if (cheque_book.isSelected()) {
					bank_services = bank_services + " Cheque Book";
				}

				try {
					com.Connection.DB_Connection conn = new DB_Connection();
					String InsertQuery = "INSERT INTO atm_db.signup_page_three VALUES('" + form_no + "', '"
							+ account_type + "','" + card_number + "','" + pin_number + "','" + bank_services + "')";
					conn.st.executeUpdate(InsertQuery);

					String InsertQuery_login = "INSERT INTO atm_db.atm_login VALUES('" + form_no + "','" + card_number
							+ "','" + pin_number + "')";
					conn.st.executeUpdate(InsertQuery_login);

					Date date = new Date();
					String InsertQuery_fund = "INSERT INTO atm_db.main_transaction VALUES('" + card_number + "','"
							+ date + "','nill','0')";
					conn.st.executeUpdate(InsertQuery_fund);

					JOptionPane.showMessageDialog(null,
							"Your account has been Created Successfully...) \nNow you Can Login using 16-Digit Account Number and 4-Digit PIN.");

					JOptionPane.showMessageDialog(null,
							"New ATM-Card No   :   " + card_number + "\nNew PIN No   :   " + pin_number);

					frame.setVisible(false);

					String card_no = "" + card_number;

					new Login_Window(card_no).frame.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}

			} else {
				JOptionPane.showMessageDialog(null, "Please check the Acknowledgment.");
			}

		} else if (ae.getSource() == exit) {
			int confirmation = JOptionPane.showConfirmDialog(null,
					"If you are Exit this process your data will lost. \nDo you want to Cancel this Process ?",
					"- CONFIRMATION -", JOptionPane.YES_NO_OPTION);
			if (confirmation == 0) {

				frame.setVisible(false);
				new Login_Window("").frame.setVisible(true);

			}
		}

	}
}
