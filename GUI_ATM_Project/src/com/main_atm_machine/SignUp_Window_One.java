package com.main_atm_machine;

import com.Connection.*;

import java.awt.*;
import javax.swing.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;
import java.text.*;

public class SignUp_Window_One implements ActionListener {

	JFrame frame;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignUp_Window_One window = new SignUp_Window_One();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/************* GLOBAL VARIABLES DECLARATION *********************/
	long form_no_page_one;
	JTextField txt_name, txt_father_name, txt_email, txt_address, txt_city, txt_state, txt_pincode;
	JDateChooser dateChooser;
	JRadioButton male, female, other;
	JComboBox txt_marital_status;
	JButton next, clear;
	JCheckBox check_tc;

	public SignUp_Window_One() {
		initialize();
	}

	private void initialize() {

		Random ran = new Random();
		form_no_page_one = Math.abs((ran.nextLong() % 9000L)) + 1000L;

		frame = new JFrame();
		frame.setResizable(false);

		frame.getContentPane().setLayout(null);

		Toolkit toolkit = frame.getToolkit();
		Dimension size = toolkit.getScreenSize();
		frame.setSize(840, 470);
		frame.setLocation(size.width / 2 - frame.getWidth() / 2, size.height / 2 - frame.getHeight() / 2);
		frame.setTitle("AUTOMATED TELLER MACHINE - Registration Window -Page 01");

		ImageIcon register_icon = new ImageIcon(ClassLoader.getSystemResource("./images/atm_registeration.png"));
		Image i2 = register_icon.getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel label_icon = new JLabel(i3);
		label_icon.setBounds(221, 46, 60, 60);
		frame.getContentPane().add(label_icon);

		JLabel pg_no = new JLabel("Page No. 01");
		pg_no.setFont(new Font("Nunito", Font.PLAIN, 16));
		pg_no.setBounds(10, 15, 90, 20);
		frame.getContentPane().add(pg_no);

		JLabel reg_form_no = new JLabel("APPLICATION FORM NO - " + form_no_page_one);
		reg_form_no.setFont(new Font("Nunito", Font.BOLD, 17));
		reg_form_no.setBounds(540, 15, 260, 20);
		frame.getContentPane().add(reg_form_no);

		JLabel personal_detail = new JLabel("\u2022 Personal Details \u2022");
		personal_detail.setFont(new Font("Nunito", Font.BOLD, 26));
		personal_detail.setBounds(308, 58, 258, 30);
		frame.getContentPane().add(personal_detail);

		/*********** FORM 1st DATA **********************/

		JLabel name = new JLabel("Full Name ");
		name.setFont(new Font("Nunito", Font.BOLD, 16));
		name.setBounds(20, 126, 120, 30);
		frame.getContentPane().add(name);

		JLabel colon1 = new JLabel(":");
		colon1.setFont(new Font("Nunito", Font.BOLD, 16));
		colon1.setBounds(150, 126, 10, 30);
		frame.getContentPane().add(colon1);

		JLabel father_name = new JLabel("Father's Name ");
		father_name.setFont(new Font("Nunito", Font.BOLD, 16));
		father_name.setBounds(20, 171, 135, 30);
		frame.getContentPane().add(father_name);

		JLabel colon2 = new JLabel(":");
		colon2.setFont(new Font("Nunito", Font.BOLD, 16));
		colon2.setBounds(150, 171, 10, 30);
		frame.getContentPane().add(colon2);

		JLabel dob = new JLabel("Date of Birth ");
		dob.setFont(new Font("Nunito", Font.BOLD, 16));
		dob.setBounds(20, 216, 135, 30);
		frame.getContentPane().add(dob);

		JLabel colon3 = new JLabel(":");
		colon3.setFont(new Font("Nunito", Font.BOLD, 16));
		colon3.setBounds(150, 216, 10, 30);
		frame.getContentPane().add(colon3);

		JLabel gender = new JLabel("Gender ");
		gender.setFont(new Font("Nunito", Font.BOLD, 16));
		gender.setBounds(20, 261, 135, 30);
		frame.getContentPane().add(gender);

		JLabel colon4 = new JLabel(":");
		colon4.setFont(new Font("Nunito", Font.BOLD, 16));
		colon4.setBounds(150, 261, 10, 30);
		frame.getContentPane().add(colon4);

		JLabel email = new JLabel("E-Mail Address ");
		email.setFont(new Font("Nunito", Font.BOLD, 16));
		email.setBounds(20, 306, 140, 30);
		frame.getContentPane().add(email);

		JLabel colon5 = new JLabel(":");
		colon5.setFont(new Font("Nunito", Font.BOLD, 16));
		colon5.setBounds(150, 306, 10, 30);
		frame.getContentPane().add(colon5);

		JLabel marital_status = new JLabel("Marital Status ");
		marital_status.setFont(new Font("Nunito", Font.BOLD, 16));
		marital_status.setBounds(423, 126, 140, 30);
		frame.getContentPane().add(marital_status);

		JLabel colon6 = new JLabel(":");
		colon6.setFont(new Font("Nunito", Font.BOLD, 16));
		colon6.setBounds(543, 126, 10, 30);
		frame.getContentPane().add(colon6);

		JLabel address = new JLabel("Address ");
		address.setFont(new Font("Nunito", Font.BOLD, 16));
		address.setBounds(423, 171, 140, 30);
		frame.getContentPane().add(address);

		JLabel colon7 = new JLabel(":");
		colon7.setFont(new Font("Nunito", Font.BOLD, 16));
		colon7.setBounds(543, 171, 10, 30);
		frame.getContentPane().add(colon7);

		JLabel city = new JLabel("City ");
		city.setFont(new Font("Nunito", Font.BOLD, 16));
		city.setBounds(423, 216, 140, 30);
		frame.getContentPane().add(city);

		JLabel colon8 = new JLabel(":");
		colon8.setFont(new Font("Nunito", Font.BOLD, 16));
		colon8.setBounds(543, 216, 10, 30);
		frame.getContentPane().add(colon8);

		JLabel state = new JLabel("State ");
		state.setFont(new Font("Nunito", Font.BOLD, 16));
		state.setBounds(423, 261, 140, 30);
		frame.getContentPane().add(state);

		JLabel colon9 = new JLabel(":");
		colon9.setFont(new Font("Nunito", Font.BOLD, 16));
		colon9.setBounds(543, 261, 10, 30);
		frame.getContentPane().add(colon9);

		JLabel pincode = new JLabel("Pin Code ");
		pincode.setFont(new Font("Nunito", Font.BOLD, 16));
		pincode.setBounds(423, 306, 82, 30);
		frame.getContentPane().add(pincode);

		JLabel colon10 = new JLabel(":");
		colon10.setFont(new Font("Nunito", Font.BOLD, 16));
		colon10.setBounds(543, 306, 10, 30);
		frame.getContentPane().add(colon10);

		/*********** FORM DATA 2nd TEXT FIELD **********************/

		Cursor cur = new Cursor(Cursor.HAND_CURSOR);

		txt_name = new JTextField();
		txt_name.setFont(new Font("Nunito", Font.PLAIN, 15));
		txt_name.setBounds(170, 127, 225, 30);
		frame.getContentPane().add(txt_name);

		txt_father_name = new JTextField();
		txt_father_name.setFont(new Font("Nunito", Font.PLAIN, 15));
		txt_father_name.setBounds(170, 172, 225, 30);
		frame.getContentPane().add(txt_father_name);

		dateChooser = new JDateChooser();
		dateChooser.getCalendarButton().setFont(new Font("Tahoma", Font.PLAIN, 13));
		dateChooser.setBounds(170, 217, 225, 30);
		dateChooser.getCalendarButton().setCursor(cur);
		frame.getContentPane().add(dateChooser);

		male = new JRadioButton("Male");
		male.setSelected(true);
		male.setFont(new Font("Nunito", Font.BOLD, 15));
		male.setBounds(170, 262, 60, 30);
		male.setCursor(cur);
		frame.getContentPane().add(male);

		female = new JRadioButton("Female");
		female.setFont(new Font("Nunito", Font.BOLD, 15));
		female.setBounds(241, 262, 75, 30);
		female.setCursor(cur);
		frame.getContentPane().add(female);

		other = new JRadioButton("Other");
		other.setFont(new Font("Nunito", Font.BOLD, 15));
		other.setBounds(327, 262, 67, 30);
		other.setCursor(cur);
		frame.getContentPane().add(other);

		ButtonGroup genderGroup = new ButtonGroup();
		genderGroup.add(male);
		genderGroup.add(female);
		genderGroup.add(other);

		txt_email = new JTextField();
		txt_email.setFont(new Font("Nunito", Font.PLAIN, 15));
		txt_email.setBounds(170, 307, 225, 30);
		frame.getContentPane().add(txt_email);

		txt_marital_status = new JComboBox();
		txt_marital_status
				.setModel(new DefaultComboBoxModel(new String[] { "Married", "Unmarried", "Student", "Other" }));
		txt_marital_status.setFont(new Font("Nunito", Font.PLAIN, 15));
		txt_marital_status.setBounds(563, 127, 225, 30);
		frame.getContentPane().add(txt_marital_status);

		txt_address = new JTextField();
		txt_address.setFont(new Font("Nunito", Font.PLAIN, 15));
		txt_address.setBounds(563, 172, 225, 30);
		frame.getContentPane().add(txt_address);

		txt_city = new JTextField();
		txt_city.setFont(new Font("Nunito", Font.PLAIN, 15));
		txt_city.setBounds(563, 217, 225, 30);
		frame.getContentPane().add(txt_city);

		txt_state = new JTextField();
		txt_state.setFont(new Font("Nunito", Font.PLAIN, 15));
		txt_state.setBounds(563, 262, 225, 30);
		frame.getContentPane().add(txt_state);

		txt_pincode = new JTextField();
		txt_pincode.setFont(new Font("Nunito", Font.PLAIN, 15));
		txt_pincode.setBounds(563, 307, 225, 30);
		frame.getContentPane().add(txt_pincode);

		/*********** FORM DATA BUTTONS **********************/

		next = new JButton("NEXT");
		next.setFont(new Font("Nunito", Font.BOLD, 15));
		next.setBackground(Color.black);
		next.setForeground(Color.white);
		next.setBounds(688, 368, 100, 30);
		next.setCursor(cur);
		next.addActionListener(this);

		frame.getContentPane().add(next);

		clear = new JButton("CLEAR");
		clear.setFont(new Font("Nunito", Font.BOLD, 15));
		clear.setBackground(Color.black);
		clear.setForeground(Color.white);
		clear.setBounds(563, 368, 100, 30);
		clear.setCursor(cur);
		clear.addActionListener(this);
		frame.getContentPane().add(clear);

		check_tc = new JCheckBox(" • I agree to the Terms and Conditions and Privacy Policy.");
		check_tc.setSelected(true);
		check_tc.setFont(new Font("Nunito", Font.BOLD, 14));
		check_tc.setBounds(28, 373, 420, 23);
		frame.getContentPane().add(check_tc);

		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);

	}
	
	

	/******************
	 * This Part will Continue @ last when complition of Register form
 ************/

	public void actionPerformed(ActionEvent ae) {

		if (ae.getSource() == next) {
			String form_no = "" + form_no_page_one;

			String name = txt_name.getText();
			String marital_status = txt_marital_status.getSelectedItem().toString();

			String father_name = txt_father_name.getText();
			String address = txt_address.getText();

//			SimpleDateFormat sdf = new SimpleDateFormat("dd-MMMM-yy");
//			String dob = sdf.format(dateChooser.getDate());
			/************************ OR ****************************/
			String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
			String city = txt_city.getText();

			String gender = null;
			if (male.isSelected()) {
				gender = "Male";
			} else if (female.isSelected()) {
				gender = "Female";
			} else if (other.isSelected()) {
				gender = "Other";
			}
			String state = txt_state.getText();

			String email = txt_email.getText();
			String pincode = txt_pincode.getText();

			try {
				if (check_tc.isSelected()) {
					if (name.equals("")) {
						JOptionPane.showMessageDialog(null, "Please fill all the Information.");
					} else {
						int confirmation = JOptionPane.showConfirmDialog(null, "Do You Want To Processed Next ?",
								"- CONFIRMATION -", JOptionPane.YES_NO_OPTION);

						if (confirmation == 0) {
							com.Connection.DB_Connection conn = new DB_Connection();
							String insertQuery = "INSERT INTO atm_db.signup_page_one VALUES('" + form_no + "', '" + name
									+ "', '" + father_name + "', '" + dob + "', '" + gender + "', '" + email + "', '"
									+ marital_status + "', '" + address + "', '" + city + "', '" + state + "', '"
									+ pincode + "')";
							conn.st.executeUpdate(insertQuery);

							frame.setVisible(false);
							new SignUp_Window_Two(form_no).frame.setVisible(true);
						} else {
							txt_name.requestFocus();
						}
					}

				} else {
					JOptionPane.showMessageDialog(null, "Please accept the Term & Condition.");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (ae.getSource() == clear) {

			txt_name.setText("");
			txt_father_name.setText("");
			((JTextField) dateChooser.getDateEditor().getUiComponent()).setText("");
			txt_name.requestFocus();
			male.setSelected(true);
			txt_email.setText("");
			txt_marital_status.setSelectedIndex(0);
			txt_address.setText("");
			txt_city.setText("");
			txt_state.setText("");
			txt_pincode.setText("");

		}
	}
}