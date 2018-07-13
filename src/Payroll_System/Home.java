package Payroll_System;

import java.awt.EventQueue;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import java.awt.Font;
import java.awt.Color;

import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;



public class Home extends JFrame {

	
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
/*	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home window = new Home();
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the application.
	 */
	public Home() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				new Login().frame.setVisible(true);
			}
		});
		
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	
	private void initialize() {
		
		this.setBounds(100, 100, 990, 700);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		

	
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 204, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblPayrollManagementSystem = new JLabel("");
		lblPayrollManagementSystem.setVerticalAlignment(SwingConstants.TOP);
		lblPayrollManagementSystem.setIcon(new ImageIcon("images/personal_insight.jpg"));
		lblPayrollManagementSystem.setBounds(0, 0, 983, 324);
		contentPane.add(lblPayrollManagementSystem);
		
		JLabel lblPayrollManagementSystem1 = new JLabel("Payroll Management System");
		lblPayrollManagementSystem1.setForeground(new Color(0, 0, 0));
		lblPayrollManagementSystem1.setBackground(new Color(102, 102, 255));
		lblPayrollManagementSystem1.setFont(new Font("Raleway", Font.BOLD, 18));
		lblPayrollManagementSystem1.setBounds(362, 345, 254, 35);
		contentPane.add(lblPayrollManagementSystem1);
		
		JButton btnNewButton = new JButton("Add Employee",new ImageIcon("images//empl.png"));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new RegisterEmployee().frame.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setBounds(92, 402, 219, 54);
		contentPane.add(btnNewButton);
		
		JButton btnSearchEmployee = new JButton("Search Employee",new ImageIcon("images//empl.png"));
		btnSearchEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			  new SearchEmployee().frame.setVisible(true);
			}
		});
		btnSearchEmployee.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnSearchEmployee.setBounds(623, 402, 219, 54);
		contentPane.add(btnSearchEmployee);
		
		JButton btnPaySlip = new JButton("Pay Slip",new ImageIcon("images//Payment.png"));
		btnPaySlip.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new PaySlip().frame.setVisible(true);
			}
		});
		btnPaySlip.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnPaySlip.setBounds(92, 491, 219, 54);
		contentPane.add(btnPaySlip);
		
		JButton btnViewEmployee = new JButton("View Employee", null);
		btnViewEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ViewEmployee().frame.setVisible(true);
			}
		});
		btnViewEmployee.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnViewEmployee.setBounds(623, 491, 219, 54);
		contentPane.add(btnViewEmployee);

		
		
		
	}
}
