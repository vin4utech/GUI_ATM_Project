package com.main_atm_machine;

import java.awt.*;
import javax.swing.*;
import java.util.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.LineBorder;

import com.Connection.DB_Connection;

public class Pin_Change_Window implements ActionListener {

	JFrame frame;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pin_Change_Window window = new Pin_Change_Window("");
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Pin_Change_Window(String get_card_from_main) {
		initialize(get_card_from_main);
	}

	JPasswordField txt_new_pin, txt_conf_new_pin;
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
		frame.setTitle("AUTOMATED TELLER MACHINE - ATM Deposit Window");

		ImageIcon atm_background_img = new ImageIcon(ClassLoader.getSystemResource("./images/Artboard.png"));
		Image i2 = atm_background_img.getImage().getScaledInstance(830, 775, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel back_image = new JLabel(i3);
		back_image.setBounds(-15, -35, 830, 775);
		frame.getContentPane().add(back_image);

		JLabel text = new JLabel("CHANGE YOUR PIN");
		text.setForeground(new Color(255, 255, 255));
		text.setFont(new Font("Nunito", Font.BOLD, 18));
		text.setBounds(200, 160, 320, 30);
		back_image.add(text);

		JLabel ent_pin = new JLabel("Enter New Pin        :");
		ent_pin.setForeground(new Color(255, 255, 255));
		ent_pin.setFont(new Font("Nunito", Font.BOLD, 14));
		ent_pin.setBounds(120, 210, 200, 30);
		back_image.add(ent_pin);

		JLabel msg_pin = new JLabel("(4-Digit pin)");
		msg_pin.setForeground(new Color(255, 255, 255));
		msg_pin.setFont(new Font("Nunito", Font.PLAIN, 12));
		msg_pin.setBounds(120, 225, 200, 30);
		back_image.add(msg_pin);

		JLabel reent_pin = new JLabel("Re-Enter New Pin   :");
		reent_pin.setForeground(new Color(255, 255, 255));
		reent_pin.setFont(new Font("Nunito", Font.BOLD, 14));
		reent_pin.setBounds(120, 255, 200, 30);
		back_image.add(reent_pin);

		txt_new_pin = new JPasswordField();
		txt_new_pin.setForeground(new Color(0, 0, 0));
		txt_new_pin.setBackground(new Color(255, 255, 255));
		txt_new_pin.setBorder(new LineBorder(new Color(0, 0, 0), 0, true));
		txt_new_pin.setFont(new Font("Nunito", Font.BOLD, 15));
		txt_new_pin.setBounds(265, 213, 170, 25);
		back_image.add(txt_new_pin);

		txt_conf_new_pin = new JPasswordField();
		txt_conf_new_pin.setForeground(new Color(0, 0, 0));
		txt_conf_new_pin.setBackground(new Color(255, 255, 255));
		txt_conf_new_pin.setBorder(new LineBorder(new Color(0, 0, 0), 0, true));
		txt_conf_new_pin.setFont(new Font("Nunito", Font.BOLD, 15));
		txt_conf_new_pin.setBounds(265, 258, 170, 25);
		back_image.add(txt_conf_new_pin);

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
		String npin = txt_new_pin.getText();
		String rpin = txt_conf_new_pin.getText();

		if(this.card_no == "") {
			JOptionPane.showMessageDialog(null,
					"Error : Card Number did not Find.\nPlease Exit and Login Once again to Change Your PIN.");
		}else {
			if (!npin.equals(rpin)) {
				JOptionPane.showMessageDialog(null, "Entered Pin Does Not Match.");
			} else if (npin.equals("")) {
				JOptionPane.showMessageDialog(null, "Please Enter new PIN.");
			} else if (rpin.equals("")) {
				JOptionPane.showMessageDialog(null, "Please Re-Enter new PIN.");
			} else {
				try {
					com.Connection.DB_Connection conn = new DB_Connection();

					String updateQueryOne = "UPDATE atm_db.atm_login SET pin_number = '" + rpin + "' WHERE card_number = '"
							+ this.card_no + "'";

					String updateQueryTwo = "UPDATE atm_db.signup_page_three SET atm_pin_no = '" + rpin
							+ "' WHERE atm_card_no = '" + this.card_no + "'";

					conn.st.executeUpdate(updateQueryOne);
					conn.st.executeUpdate(updateQueryTwo);
					
					JOptionPane.showMessageDialog(null, "PIN has been Changed Successfully.");

					frame.setVisible(false);
					new Main_Transaction_Window(this.card_no).frame.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		
		
	}

	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == confirm) {

			SendDataToDB();

		} else if (ae.getSource() == back) {
			frame.setVisible(false);
			new Main_Transaction_Window(this.card_no).frame.setVisible(true);
		}
	}
}
