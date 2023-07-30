package com.main_atm_machine;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Main_Transaction_Window implements ActionListener, KeyListener {

	JFrame frame;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main_Transaction_Window window = new Main_Transaction_Window("");
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Main_Transaction_Window(String get_card_number_from_login) {
		initialize(get_card_number_from_login);
	}

	JButton deposit, fast_cash, pin_change, transfer, cash_withdraw, mini_statement, balance_enq, exit;
	String card_number;

	private void initialize(String card_no_for_transaction) {
		this.card_number = card_no_for_transaction;
		frame = new JFrame();
		frame.setResizable(false);

		frame.getContentPane().setLayout(null);

		Toolkit toolkit = frame.getToolkit();
		Dimension size = toolkit.getScreenSize();
		frame.setSize(790, 730);
		frame.setLocation(size.width / 2 - frame.getWidth() / 2, (int) (size.height / 2 - frame.getHeight() / 1.94));
		frame.setTitle("AUTOMATED TELLER MACHINE - ATM Transaction Window");

		ImageIcon atm_background_img = new ImageIcon(ClassLoader.getSystemResource("./images/Artboard.png"));
		Image i2 = atm_background_img.getImage().getScaledInstance(830, 775, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel back_image = new JLabel(i3);
		back_image.setBounds(-15, -35, 830, 775);
		frame.getContentPane().add(back_image);

		JLabel text = new JLabel("Please Select Your Transaction");
		text.setForeground(new Color(255, 255, 255));
		text.setFont(new Font("Nunito", Font.BOLD, 16));
		text.setBounds(180, 140, 230, 30);
		back_image.add(text);

		Cursor cur = new Cursor(Cursor.HAND_CURSOR);

		String d = "<html>&nbsp;&nbsp;<u>D</u>eposit</html>";
		deposit = new JButton(d);
		deposit.addKeyListener(this);
		deposit.setHorizontalAlignment(SwingConstants.LEFT);
		deposit.setFont(new Font("Nunito", Font.BOLD, 15));
		deposit.setBounds(103, 275, 160, 30);
		deposit.setCursor(cur);
		deposit.addActionListener(this);
		back_image.add(deposit);

		String f = "<html>&nbsp;&nbsp;<u>F</u>ast-Cash</html>";
		fast_cash = new JButton(f);
		fast_cash.setHorizontalAlignment(SwingConstants.LEFT);
		fast_cash.setFont(new Font("Nunito", Font.BOLD, 15));
		fast_cash.setBounds(103, 315, 160, 30);
		fast_cash.setCursor(cur);
		fast_cash.addActionListener(this);
		back_image.add(fast_cash);

		String p = "<html>&nbsp;&nbsp;<u>P</u>in-Change</html>";
		pin_change = new JButton(p);
		pin_change.setHorizontalAlignment(SwingConstants.LEFT);
		pin_change.setFont(new Font("Nunito", Font.BOLD, 15));
		pin_change.setBounds(103, 355, 160, 30);
		pin_change.setCursor(cur);
		pin_change.addActionListener(this);
		back_image.add(pin_change);

		String t = "<html>&nbsp;&nbsp;Fund <u>T</u>ransfer</html>";
		transfer = new JButton(t);
		transfer.setHorizontalAlignment(SwingConstants.LEFT);
		transfer.setFont(new Font("Nunito", Font.BOLD, 15));
		transfer.setBounds(103, 395, 160, 30);
		transfer.setCursor(cur);
		transfer.addActionListener(this);
		back_image.add(transfer);

		String w = "<html>Cash <u>W</u>ithdraw&nbsp;&nbsp;</html>";
		cash_withdraw = new JButton(w);
		cash_withdraw.setHorizontalAlignment(SwingConstants.RIGHT);
		cash_withdraw.setFont(new Font("Nunito", Font.BOLD, 15));
		cash_withdraw.setBounds(328, 275, 160, 30);
		cash_withdraw.setCursor(cur);
		cash_withdraw.addActionListener(this);
		back_image.add(cash_withdraw);

		String s = "<html>Mini-<u>S</u>tatement&nbsp;&nbsp;</html>";
		mini_statement = new JButton(s);
		mini_statement.setHorizontalAlignment(SwingConstants.RIGHT);
		mini_statement.setFont(new Font("Nunito", Font.BOLD, 15));
		mini_statement.setBounds(328, 315, 160, 30);
		mini_statement.setCursor(cur);
		mini_statement.addActionListener(this);
		back_image.add(mini_statement);

		String b = "<html><u>B</u>alance Enquiry&nbsp;&nbsp;</html>";
		balance_enq = new JButton(b);
		balance_enq.setHorizontalAlignment(SwingConstants.RIGHT);
		balance_enq.setFont(new Font("Nunito", Font.BOLD, 15));
		balance_enq.setBounds(328, 355, 160, 30);
		balance_enq.setCursor(cur);
		balance_enq.addActionListener(this);
		back_image.add(balance_enq);

		String e = "<html><u>E</u>xit&nbsp;&nbsp;</html>";
		exit = new JButton(e);
		exit.setHorizontalAlignment(SwingConstants.RIGHT);
		exit.setFont(new Font("Nunito", Font.BOLD, 15));
		exit.setBounds(328, 395, 160, 30);
		exit.setCursor(cur);
		exit.addActionListener(this);
		back_image.add(exit);

		frame.setUndecorated(true);
	}

	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == exit) {
			frame.setVisible(false);
			new Login_Window(this.card_number).frame.setVisible(true);
		} else if (ae.getSource() == deposit) {
			frame.setVisible(false);
			new Deposit_Window(this.card_number).frame.setVisible(true);
		} else if (ae.getSource() == cash_withdraw) {
			frame.setVisible(false);
			new Withdraw_Window(this.card_number).frame.setVisible(true);
		} else if (ae.getSource() == fast_cash) {
			frame.setVisible(false);
			new Fast_Cash_Window(this.card_number).frame.setVisible(true);
		} else if (ae.getSource() == pin_change) {
			frame.setVisible(false);
			new Pin_Change_Window(this.card_number).frame.setVisible(true);
		} else if (ae.getSource() == balance_enq) {
			frame.setVisible(false);
			new Balance_Enquiry_Window(this.card_number).frame.setVisible(true);
		} else if (ae.getSource() == mini_statement) {

			new Mini_Statement_Window(this.card_number).frame.setVisible(true);
		} else if (ae.getSource() == transfer) {
			frame.setVisible(false);
			new Fund_Transfer_Window(this.card_number).frame.setVisible(true);
		}

	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_D) {
			frame.setVisible(false);
			new Deposit_Window(this.card_number).frame.setVisible(true);
		}

		if (e.getKeyCode() == KeyEvent.VK_W) {
			frame.setVisible(false);
			new Withdraw_Window(this.card_number).frame.setVisible(true);
		}

		if (e.getKeyCode() == KeyEvent.VK_F) {
			frame.setVisible(false);
			new Fast_Cash_Window(this.card_number).frame.setVisible(true);
		}

		if (e.getKeyCode() == KeyEvent.VK_P) {
			frame.setVisible(false);
			new Pin_Change_Window(this.card_number).frame.setVisible(true);
		}

		if (e.getKeyCode() == KeyEvent.VK_B) {
			frame.setVisible(false);
			new Balance_Enquiry_Window(this.card_number).frame.setVisible(true);
		}

		if (e.getKeyCode() == KeyEvent.VK_S) {

			new Mini_Statement_Window(this.card_number).frame.setVisible(true);
		}
		
		if (e.getKeyCode() == KeyEvent.VK_T) {

			frame.setVisible(false);
			new Fund_Transfer_Window(this.card_number).frame.setVisible(true);
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
