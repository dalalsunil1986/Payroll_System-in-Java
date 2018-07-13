package Payroll_System;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import ConnectionProvider.MyConnection;
import net.proteanit.sql.DbUtils;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ViewEmployee {

	public JFrame frame;
	private JTextField textField;
	private JButton btnNewButton;
	private JButton btnViewPayslip;
	private JButton btnnew;

	/**
	 * Launch the application.
	 */
/*	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewEmployee window = new ViewEmployee();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the application.
	 */
	public ViewEmployee() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		
		frame.setBounds(0, 0, 981, 506);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	
		frame.getContentPane().setForeground(new Color(51, 0, 102));
		frame.getContentPane().setFont(new Font("Roboto", Font.BOLD, 18));
		frame.getContentPane().setBackground(new Color(102, 102, 153));
		frame.getContentPane().setLayout(null);

		JTable jTable1 = new JTable();
		JScrollPane jScrollPane1 = new JScrollPane();
		
		//adding frames
		JLabel lblPayrollManagementSystem = new JLabel("View Employee ");
		lblPayrollManagementSystem.setForeground(new Color(204, 255, 204));
		lblPayrollManagementSystem.setFont(new Font("Roboto", Font.PLAIN, 26));
		lblPayrollManagementSystem.setBounds(181, 11, 381, 57);
		Font f = new Font("Roboto" ,Font.BOLD ,18);
		frame.getContentPane().add(lblPayrollManagementSystem);
		
		JLabel label = new JLabel("Employee ID");
		label.setForeground(new Color(204, 255, 204));
		label.setFont(new Font("Dialog", Font.PLAIN, 18));
		label.setBounds(48, 115, 125, 24);
		frame.getContentPane().add(label);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(232, 115, 198, 20);
		frame.getContentPane().add(textField);
		
		btnNewButton = new JButton("View Details");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection con=new MyConnection().getConnection();
                java.sql.PreparedStatement stmt;
                try {
                	
                	//getting data from employee table with employee id (empid)
                    stmt = con.prepareStatement("select * from employee where empid=?");
                    stmt.setString(1, textField.getText());
                   
                    ResultSet rs= stmt.executeQuery();
                    jTable1.setModel(DbUtils.resultSetToTableModel(rs));
                    jTable1.repaint();
                } catch (SQLException ex) {
                    Logger.getLogger(SearchEmployee.class.getName()).log(Level.SEVERE, null, ex);
                   JOptionPane.showMessageDialog(null, "Enter Correct data");
                }
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setBounds(99, 209, 157, 23);
		frame.getContentPane().add(btnNewButton);
		
		jTable1.setModel(new javax.swing.table.DefaultTableModel(
	            new Object [][] {
	                {null, null, null, null, null, null},
	                {null, null, null, null, null, null},
	                {null, null, null, null, null, null},
	                {null, null, null, null, null, null}
	            },
	            new String [] {
	                "Employee Data"
	            }
	        ));
		 jScrollPane1.setViewportView(jTable1);
		 frame.getContentPane().add(jScrollPane1);
	        jScrollPane1.setBounds(24, 252, 932, 220);
	        
		btnViewPayslip = new JButton("View All Employee");
		btnViewPayslip.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection con=new MyConnection().getConnection();
                java.sql.PreparedStatement stmt;
                try {
                	
                	//displaying all employee details from the database employee
                    stmt = con.prepareStatement("select * from employee");
                   
                   
                    ResultSet rs= stmt.executeQuery();
                    jTable1.setModel(DbUtils.resultSetToTableModel(rs));
                    jTable1.repaint();
                } catch (SQLException ex) {
                    Logger.getLogger(SearchEmployee.class.getName()).log(Level.SEVERE, null, ex);
                   JOptionPane.showMessageDialog(null, "Enter Correct data");
                }
			}
		});
		btnViewPayslip.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnViewPayslip.setBounds(579, 209, 188, 23);
		frame.getContentPane().add(btnViewPayslip);
		
		
		jTable1.setModel(new javax.swing.table.DefaultTableModel(
	            new Object [][] {
	                {null, null, null, null, null, null, null}
	                
	            },
	            new String [] {
	                "Pay Slip"
	            }
	        ));
		
				
		
	}
}
