package com.main_atm_machine;

import java.awt.*;
import javax.swing.*;
import java.util.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import com.Connection.DB_Connection;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.DefaultTableCellRenderer;

public class Mini_Statement_Window implements ActionListener {

	JFrame frame;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Mini_Statement_Window window = new Mini_Statement_Window("");
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Mini_Statement_Window(String get_card_from_main) {
		initialize(get_card_from_main);
	}

	String card_no;
	private JTable table;

	private void initialize(String set_card_for_statement) {
		this.card_no = set_card_for_statement;
		frame = new JFrame();
		frame.setResizable(false);

		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("State Bank Of India");
		lblNewLabel.setFont(new Font("Nunito", Font.BOLD, 22));
		lblNewLabel.setBounds(145, 11, 211, 35);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Nunito", Font.BOLD, 16));
		lblName.setBounds(10, 64, 56, 23);
		frame.getContentPane().add(lblName);

		JLabel lblName_1 = new JLabel("A/C Number");
		lblName_1.setFont(new Font("Nunito", Font.BOLD, 16));
		lblName_1.setBounds(10, 98, 98, 23);
		frame.getContentPane().add(lblName_1);

		JLabel lblName_2 = new JLabel(":");
		lblName_2.setFont(new Font("Nunito", Font.BOLD, 16));
		lblName_2.setBounds(137, 64, 15, 23);
		frame.getContentPane().add(lblName_2);

		JLabel lblName_1_1 = new JLabel(":");
		lblName_1_1.setFont(new Font("Nunito", Font.BOLD, 16));
		lblName_1_1.setBounds(137, 98, 15, 23);
		frame.getContentPane().add(lblName_1_1);

		Toolkit toolkit = frame.getToolkit();
		Dimension size = toolkit.getScreenSize();
		frame.setSize(540, 600);
		frame.setLocation(size.width / 2 - frame.getWidth() / 2, (int) (size.height / 2 - frame.getHeight() / 1.94));
		frame.setTitle("AUTOMATED TELLER MACHINE - ATM Mini-Statement Window");

		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(30, 140, 200, 22);
		frame.getContentPane().add(comboBox);

		JLabel lbl_curr_bal = new JLabel("Current Bal. :");
		lbl_curr_bal.setFont(new Font("Nunito", Font.BOLD, 16));
		lbl_curr_bal.setBounds(253, 138, 103, 23);
		frame.getContentPane().add(lbl_curr_bal);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 181, 504, 269);
		frame.getContentPane().add(scrollPane);

		table = new JTable();
		table.setFont(new Font("Nunito", Font.PLAIN, 13));
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		table.setRowSelectionAllowed(false);
		DefaultTableModel tbl_model = (DefaultTableModel) table.getModel();

		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);

		DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
		rightRenderer.setHorizontalAlignment(JLabel.RIGHT);

		tbl_model.setColumnIdentifiers(new String[] { "Sr No", "Date", "Credit", "Debit", "Balance" });

		table.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);

		for (int i = 2; i <= 4; i++) {
			table.getColumnModel().getColumn(i).setCellRenderer(rightRenderer);
		}

		scrollPane.setViewportView(table);

		int bal = 0, count = 0;
		String form_num = "", name = "", ac_no = "", date = "", cr = "", dr = "";
		if (this.card_no == "") {
			JOptionPane.showMessageDialog(null,
					"Error : Card Number did not Find.\nPlease Exit and Login Once again to Change Your PIN.");
		} else {

			try {
				com.Connection.DB_Connection conn = new DB_Connection();

				ResultSet rs1 = conn.st.executeQuery("SELECT * FROM atm_db.main_transaction WHERE card_no = '"
						+ this.card_no + "' AND transaction_type != 'nill' ");

				while (rs1.next()) {
					count = count + 1;

					if (rs1.getString("transaction_type").equals("DEPOSIT")) {
						bal += Integer.parseInt(rs1.getString("amount"));
						cr = "" + Integer.parseInt(rs1.getString("amount")) + ".0";
						dr = "  -  ";

					} else {
						bal -= Integer.parseInt(rs1.getString("amount"));
						dr = "" + Integer.parseInt(rs1.getString("amount")) + ".0";
						cr = "  -  ";
					}

					date = rs1.getString("date");
					String[] rows = { "" + count, date, cr, dr, "" + bal + ".0" };
					tbl_model.addRow(rows);

					ac_no = rs1.getString("card_no").substring(0, 4) + "XXXXXXXX"
							+ rs1.getString("card_no").substring(12);

				}

				ResultSet rs2 = conn.st.executeQuery(
						"SELECT * FROM atm_db.signup_page_three WHERE atm_card_no = '" + this.card_no + "'");

				while (rs2.next()) {
					form_num = rs2.getString("form_no");
				}

				ResultSet rs3 = conn.st
						.executeQuery("SELECT * FROM atm_db.signup_page_one WHERE form_no = '" + form_num + "'");

				while (rs3.next()) {
					name = rs3.getString("name");
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		JLabel nm = new JLabel("" + name);
		nm.setFont(new Font("Nunito", Font.BOLD, 16));
		nm.setBounds(162, 64, 217, 23);
		frame.getContentPane().add(nm);

		JLabel ac = new JLabel("" + ac_no);
		ac.setFont(new Font("Nunito", Font.BOLD, 16));
		ac.setBounds(162, 98, 217, 23);
		frame.getContentPane().add(ac);

		JLabel curr_bal = new JLabel("" + bal);
		curr_bal.setFont(new Font("Nunito", Font.BOLD, 16));
		curr_bal.setBounds(366, 138, 149, 23);
		frame.getContentPane().add(curr_bal);

		Cursor cur = new Cursor(Cursor.HAND_CURSOR);
	}

	public void actionPerformed(ActionEvent ae) {
//		if (ae.getSource() == back) {
//			frame.setVisible(false);
//			new Main_Transaction_Window(this.card_no).frame.setVisible(true);
//		}
	}
}
