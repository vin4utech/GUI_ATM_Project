package com.main_atm_machine;

import com.Connection.*;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class SignUp_Window_Two implements ActionListener {

	JFrame frame;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignUp_Window_Two window = new SignUp_Window_Two("");
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	JTextField txt_mob_no, txt_pan_no, txt_adhar_no;
	JRadioButton senior_yes, senior_no, existing_ac_yes, existing_ac_no;
	JComboBox txt_religion, txt_category, txt_occupation, txt_income, txt_qualification;
	JButton next, clear;
	JCheckBox check_tc;
	String form_no;

	public SignUp_Window_Two(String get_form_no_from_one) {
		initialize(get_form_no_from_one);
	}

	private void initialize(String form_no_page_two) {
		this.form_no = form_no_page_two;

		frame = new JFrame();
		frame.setResizable(false);

		frame.getContentPane().setLayout(null);

		Toolkit toolkit = frame.getToolkit();
		Dimension size = toolkit.getScreenSize();
		frame.setSize(840, 470);
		frame.setLocation(size.width / 2 - frame.getWidth() / 2, size.height / 2 - frame.getHeight() / 2);
		frame.setTitle("AUTOMATED TELLER MACHINE - Additional Information Window -Page 02");

		ImageIcon register_icon = new ImageIcon(ClassLoader.getSystemResource("./images/atm_personal_details.png"));
		Image i2 = register_icon.getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel label_icon = new JLabel(i3);
		label_icon.setBounds(199, 45, 60, 60);
		frame.getContentPane().add(label_icon);

		JLabel pg_no = new JLabel("Page No. 02");
		pg_no.setFont(new Font("Nunito", Font.PLAIN, 16));
		pg_no.setBounds(10, 15, 90, 20);
		frame.getContentPane().add(pg_no);

		JLabel reg_form_no = new JLabel("APPLICATION FORM NO - " + this.form_no);
		reg_form_no.setFont(new Font("Nunito", Font.BOLD, 17));
		reg_form_no.setBounds(540, 15, 260, 20);
		frame.getContentPane().add(reg_form_no);

		JLabel personal_detail = new JLabel("\u2022 Additional Details \u2022");
		personal_detail.setFont(new Font("Nunito", Font.BOLD, 26));
		personal_detail.setBounds(286, 58, 275, 30);
		frame.getContentPane().add(personal_detail);

		/*********** FORM 2nd DATA **********************/

		JLabel religion = new JLabel("Religion ");
		religion.setFont(new Font("Nunito", Font.BOLD, 16));
		religion.setBounds(20, 126, 108, 30);
		frame.getContentPane().add(religion);

		JLabel colon1 = new JLabel(":");
		colon1.setFont(new Font("Nunito", Font.BOLD, 16));
		colon1.setBounds(145, 126, 10, 30);
		frame.getContentPane().add(colon1);

		JLabel category = new JLabel("Category ");
		category.setFont(new Font("Nunito", Font.BOLD, 16));
		category.setBounds(20, 171, 108, 30);
		frame.getContentPane().add(category);

		JLabel colon2 = new JLabel(":");
		colon2.setFont(new Font("Nunito", Font.BOLD, 16));
		colon2.setBounds(145, 171, 10, 30);
		frame.getContentPane().add(colon2);

		JLabel occupation = new JLabel("Occupation ");
		occupation.setFont(new Font("Nunito", Font.BOLD, 16));
		occupation.setBounds(20, 216, 108, 30);
		frame.getContentPane().add(occupation);

		JLabel colon3 = new JLabel(":");
		colon3.setFont(new Font("Nunito", Font.BOLD, 16));
		colon3.setBounds(145, 216, 10, 30);
		frame.getContentPane().add(colon3);

		JLabel income = new JLabel("Income ");
		income.setFont(new Font("Nunito", Font.BOLD, 16));
		income.setBounds(20, 261, 108, 30);
		frame.getContentPane().add(income);

		JLabel colon4 = new JLabel(":");
		colon4.setFont(new Font("Nunito", Font.BOLD, 16));
		colon4.setBounds(145, 261, 10, 30);
		frame.getContentPane().add(colon4);

		JLabel pan_no = new JLabel("PAN Number ");
		pan_no.setFont(new Font("Nunito", Font.BOLD, 16));
		pan_no.setBounds(20, 306, 108, 30);
		frame.getContentPane().add(pan_no);

		JLabel colon5 = new JLabel(":");
		colon5.setFont(new Font("Nunito", Font.BOLD, 16));
		colon5.setBounds(145, 306, 10, 30);
		frame.getContentPane().add(colon5);

		JLabel Edu_details = new JLabel("Qualification ");
		Edu_details.setFont(new Font("Nunito", Font.BOLD, 16));
		Edu_details.setBounds(413, 126, 116, 30);
		frame.getContentPane().add(Edu_details);

		JLabel colon6 = new JLabel(":");
		colon6.setFont(new Font("Nunito", Font.BOLD, 16));
		colon6.setBounds(548, 126, 10, 30);
		frame.getContentPane().add(colon6);

		JLabel mob_no = new JLabel("Mobile No");
		mob_no.setFont(new Font("Nunito", Font.BOLD, 16));
		mob_no.setBounds(413, 171, 116, 30);
		frame.getContentPane().add(mob_no);

		JLabel colon7 = new JLabel(":");
		colon7.setFont(new Font("Nunito", Font.BOLD, 16));
		colon7.setBounds(548, 171, 10, 30);
		frame.getContentPane().add(colon7);

		JLabel senior_citizen = new JLabel("Senior Citizen");
		senior_citizen.setFont(new Font("Nunito", Font.BOLD, 16));
		senior_citizen.setBounds(413, 216, 140, 30);
		frame.getContentPane().add(senior_citizen);

		JLabel senior_citizen_max_60 = new JLabel("(Age above 60)");
		senior_citizen_max_60.setFont(new Font("Nunito", Font.PLAIN, 13));
		senior_citizen_max_60.setBounds(413, 234, 140, 30);
		frame.getContentPane().add(senior_citizen_max_60);

		JLabel colon8 = new JLabel(":");
		colon8.setFont(new Font("Nunito", Font.BOLD, 16));
		colon8.setBounds(548, 216, 10, 30);
		frame.getContentPane().add(colon8);

		JLabel existing_ac = new JLabel("Existing Account");
		existing_ac.setFont(new Font("Nunito", Font.BOLD, 16));
		existing_ac.setBounds(413, 261, 140, 30);
		frame.getContentPane().add(existing_ac);

		JLabel colon9 = new JLabel(":");
		colon9.setFont(new Font("Nunito", Font.BOLD, 16));
		colon9.setBounds(548, 261, 10, 30);
		frame.getContentPane().add(colon9);

		JLabel adhar_no = new JLabel("Aadhar Number");
		adhar_no.setFont(new Font("Nunito", Font.BOLD, 16));
		adhar_no.setBounds(413, 306, 138, 30);
		frame.getContentPane().add(adhar_no);

		JLabel colon10 = new JLabel(":");
		colon10.setFont(new Font("Nunito", Font.BOLD, 16));
		colon10.setBounds(548, 306, 10, 30);
		frame.getContentPane().add(colon10);

		/*********** FORM DATA 2nd TEXT FIELD **********************/

		Cursor cur = new Cursor(Cursor.HAND_CURSOR);

		String valReligion[] = { "-- Select Religion --", "Hindu", "Muslim", "Sikh", "Buddh", "Christian", "Other" };
		txt_religion = new JComboBox(valReligion);
		txt_religion.setFont(new Font("Nunito", Font.PLAIN, 15));
		txt_religion.setBounds(170, 127, 225, 30);
		frame.getContentPane().add(txt_religion);

		String valCategory[] = { "-- Select Category --", "General", "OBC", "SC", "ST-NT", "Other" };
		txt_category = new JComboBox(valCategory);
		txt_category.setFont(new Font("Nunito", Font.PLAIN, 15));
		txt_category.setBounds(170, 172, 225, 30);
		frame.getContentPane().add(txt_category);

		String valOccupation[] = { "-- Select Occupation -- ", "Salaried", "Self_Employee", "Own-Business",
				"Government-Employee", "Student", "Retired", "Other" };
		txt_occupation = new JComboBox(valOccupation);
		txt_occupation.setFont(new Font("Nunito", Font.PLAIN, 15));
		txt_occupation.setBounds(170, 217, 225, 30);
		frame.getContentPane().add(txt_occupation);

		String valSalary[] = { "-- Select Income --", "0 - 50,000", "1,00,000 - 2,50,000", "2,60,000 - 3,50,000",
				"3,60,000 - 5,00,000", "Upto 10,00,000" };
		txt_income = new JComboBox(valSalary);
		txt_income.setFont(new Font("Nunito", Font.PLAIN, 15));
		txt_income.setBounds(170, 262, 225, 30);
		frame.getContentPane().add(txt_income);

		txt_pan_no = new JTextField();
		txt_pan_no.setFont(new Font("Nunito", Font.PLAIN, 15));
		txt_pan_no.setBounds(170, 307, 225, 30);
		frame.getContentPane().add(txt_pan_no);

		String valQualification[] = { "-- Select Qualification --", "Not Applicable", "Higher-School", "Non-Graduate",
				"Bachelors-Graduate", "Post-Graduate", "Doctor", "Other" };
		txt_qualification = new JComboBox(valQualification);
		txt_qualification.setFont(new Font("Nunito", Font.PLAIN, 15));
		txt_qualification.setBounds(563, 127, 225, 30);
		frame.getContentPane().add(txt_qualification);

		txt_mob_no = new JTextField();
		txt_mob_no.setFont(new Font("Nunito", Font.PLAIN, 15));
		txt_mob_no.setBounds(563, 172, 225, 30);
		frame.getContentPane().add(txt_mob_no);

		/**
		 * -------------- RADIO BUTTONS for Senior Citizen -------------------------
		 ***/

		senior_yes = new JRadioButton("YES");
		senior_yes.setFont(new Font("Nunito", Font.BOLD, 15));
		senior_yes.setBounds(565, 217, 60, 30);
		senior_yes.setCursor(cur);
		frame.getContentPane().add(senior_yes);

		senior_no = new JRadioButton("NO");
		senior_no.setSelected(true);
		senior_no.setFont(new Font("Nunito", Font.BOLD, 15));
		senior_no.setBounds(655, 217, 60, 30);
		senior_no.setCursor(cur);
		frame.getContentPane().add(senior_no);

		ButtonGroup seniorGroup = new ButtonGroup();
		seniorGroup.add(senior_yes);
		seniorGroup.add(senior_no);

		/**
		 * -------------- RADIO BUTTONS for Existing Account -------------------------
		 ***/

		existing_ac_yes = new JRadioButton("YES");
		existing_ac_yes.setFont(new Font("Nunito", Font.BOLD, 15));
		existing_ac_yes.setBounds(565, 262, 60, 30);
		existing_ac_yes.setCursor(cur);
		frame.getContentPane().add(existing_ac_yes);

		existing_ac_no = new JRadioButton("NO");
		existing_ac_no.setSelected(true);
		existing_ac_no.setFont(new Font("Nunito", Font.BOLD, 15));
		existing_ac_no.setBounds(655, 262, 60, 30);
		existing_ac_no.setCursor(cur);
		frame.getContentPane().add(existing_ac_no);

		ButtonGroup existing_acGroup = new ButtonGroup();
		existing_acGroup.add(existing_ac_yes);
		existing_acGroup.add(existing_ac_no);

		txt_adhar_no = new JTextField();
		txt_adhar_no.setFont(new Font("Nunito", Font.PLAIN, 15));
		txt_adhar_no.setBounds(563, 307, 225, 30);
		frame.getContentPane().add(txt_adhar_no);

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

		check_tc = new JCheckBox(" • I agree to the Given Information is Correct and True.");
		check_tc.setSelected(true);
		check_tc.setFont(new Font("Nunito", Font.BOLD, 14));
		check_tc.setBounds(28, 373, 420, 23);
		frame.getContentPane().add(check_tc);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == next) {

			String form_no = this.form_no;

			String religion = txt_religion.getSelectedItem().toString();
			String qualification = txt_qualification.getSelectedItem().toString();

			String category = txt_category.getSelectedItem().toString();
			String mobile_no = txt_mob_no.getText();

			String occupation = txt_occupation.getSelectedItem().toString();
			String seniorcitizen = null;
			if (senior_yes.isSelected()) {
				seniorcitizen = "YES";
			} else if (senior_no.isSelected()) {
				seniorcitizen = "NO";
			}

			String income = txt_income.getSelectedItem().toString();
			String existing_ac = null;
			if (existing_ac_yes.isSelected()) {
				existing_ac = "YES";
			} else if (existing_ac_no.isSelected()) {
				existing_ac = "NO";
			}

			String pancardno = txt_pan_no.getText();
			String adharcardno = txt_adhar_no.getText();

			try {
				if (check_tc.isSelected()) {
					if (txt_religion.getSelectedIndex() == 0 || txt_qualification.getSelectedIndex() == 0
							|| txt_category.getSelectedIndex() == 0 || txt_occupation.getSelectedIndex() == 0
							|| txt_income.getSelectedIndex() == 0 || mobile_no.equals("") || pancardno.equals("")
							|| adharcardno.equals("")) {
						JOptionPane.showMessageDialog(null, "Please fill all the Information.");
					} else {
						int confirmation = JOptionPane.showConfirmDialog(null, "Do You Want To Processed Next ?",
								"- CONFIRMATION -", JOptionPane.YES_NO_OPTION);

						if (confirmation == 0) {
							com.Connection.DB_Connection conn = new DB_Connection();
							String InsertQuery = "INSERT INTO atm_db.signup_page_two VALUES('" + form_no + "', '"
									+ religion + "', '" + category + "', '" + occupation + "', '" + income + "', '"
									+ qualification + "', '" + mobile_no + "', '" + seniorcitizen + "', '" + existing_ac
									+ "', '" + pancardno + "', '" + adharcardno + "')";
							conn.st.executeUpdate(InsertQuery);

							frame.setVisible(false);
							new SignUp_Window_Three(form_no).frame.setVisible(true);
						}
					}
				} else {
					JOptionPane.showMessageDialog(null, "Please check the given Information is Correct & True.");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		} else if (ae.getSource() == clear) {

			txt_religion.setSelectedIndex(0);
			txt_qualification.setSelectedIndex(0);

			txt_category.setSelectedIndex(0);
			txt_mob_no.setText("");

			txt_occupation.setSelectedIndex(0);
			senior_no.setSelected(true);

			txt_income.setSelectedIndex(0);
			existing_ac_no.setSelected(true);

			txt_pan_no.setText("");
			txt_adhar_no.setText("");

		}
	}

}
