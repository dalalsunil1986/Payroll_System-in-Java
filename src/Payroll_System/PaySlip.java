package Payroll_System;

import java.awt.Color;

import java.awt.EventQueue;
import java.awt.Font;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.mysql.jdbc.PreparedStatement;

import ConnectionProvider.MyConnection;

import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class PaySlip {

	public JFrame frame;
	private JTextField unametf;
	private JPasswordField passwordField;
	Connection conn;
    Statement stmt;
    ResultSet rs;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    private JTextField textField_4;
    private JTextField textField_5;
    private JTextField textField_6;
	
	/**
	 * Launch the application.
	 */
/*	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PaySlip window = new PaySlip();
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
	public PaySlip() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
	
		frame.setBounds(0, 0, 650, 600);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		frame.getContentPane().setForeground(new Color(51, 0, 102));
		frame.getContentPane().setFont(new Font("Roboto", Font.BOLD, 18));
		frame.getContentPane().setBackground(new Color(102, 102, 153));
		frame.getContentPane().setLayout(null);

		JLabel lblPayrollManagementSystem = new JLabel("Employee PaySlip ");
		lblPayrollManagementSystem.setForeground(new Color(204, 255, 204));
		lblPayrollManagementSystem.setFont(new Font("Roboto", Font.PLAIN, 26));
		lblPayrollManagementSystem.setBounds(181, 11, 381, 57);
		Font f = new Font("Roboto" ,Font.BOLD ,18);
		frame.getContentPane().add(lblPayrollManagementSystem);
		
		JLabel label = new JLabel("Employee ID");
		label.setForeground(new Color(204, 255, 204));
		label.setFont(new Font("Dialog", Font.PLAIN, 18));
		label.setBounds(52, 84, 125, 24);
		frame.getContentPane().add(label);
		
		JLabel lblName = new JLabel("DOB");
		lblName.setForeground(new Color(204, 255, 204));
		lblName.setFont(new Font("Dialog", Font.PLAIN, 18));
		lblName.setBounds(52, 125, 125, 24);
		frame.getContentPane().add(lblName);
		
		JLabel lblDepartment = new JLabel("Department");
		lblDepartment.setForeground(new Color(204, 255, 204));
		lblDepartment.setFont(new Font("Dialog", Font.PLAIN, 18));
		lblDepartment.setBounds(52, 165, 125, 24);
		frame.getContentPane().add(lblDepartment);
		
		JLabel lblPayDate = new JLabel("Pay Date");
		lblPayDate.setForeground(new Color(204, 255, 204));
		lblPayDate.setFont(new Font("Dialog", Font.PLAIN, 18));
		lblPayDate.setBounds(52, 206, 125, 24);
		frame.getContentPane().add(lblPayDate);
		
		JLabel lblBasic = new JLabel("Basic");
		lblBasic.setForeground(new Color(204, 255, 204));
		lblBasic.setFont(new Font("Dialog", Font.PLAIN, 18));
		lblBasic.setBounds(52, 246, 125, 24);
		frame.getContentPane().add(lblBasic);
		
		JLabel lblProvidentFund = new JLabel("Provident Fund");
		lblProvidentFund.setForeground(new Color(204, 255, 204));
		lblProvidentFund.setFont(new Font("Dialog", Font.PLAIN, 18));
		lblProvidentFund.setBounds(52, 287, 125, 24);
		frame.getContentPane().add(lblProvidentFund);
		
		JLabel lblConveyance = new JLabel("Conveyance");
		lblConveyance.setForeground(new Color(204, 255, 204));
		lblConveyance.setFont(new Font("Dialog", Font.PLAIN, 18));
		lblConveyance.setBounds(52, 330, 125, 24);
		frame.getContentPane().add(lblConveyance);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(205, 89, 198, 20);
		frame.getContentPane().add(textField);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBounds(205, 130, 198, 20);
		frame.getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBounds(205, 170, 198, 20);
		frame.getContentPane().add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(205, 211, 198, 20);
		frame.getContentPane().add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(205, 251, 198, 20);
		frame.getContentPane().add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(205, 292, 198, 20);
		frame.getContentPane().add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(205, 335, 198, 20);
		frame.getContentPane().add(textField_6);
		
		JButton btnNewButton = new JButton("Pay Slip");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String empid=textField.getText();
				String empname=textField_1.getText();
				String Department=textField_2.getText();
				String paydate=textField_3.getText();
				String basic=textField_4.getText();
				String providedfund=textField_5.getText();
				String Conveyance=textField_6.getText();
				
				if(empid.equals("")||empname.equals("")||Department.equals("")||paydate.equals("")||basic.equals("")||providedfund.equals("")||Conveyance.equals(""))
				{
					JOptionPane.showMessageDialog(null, "fill all the data");
				}
				else
				{try
				{
					
					//inserting values into database pay 
					
					 Connection con=new MyConnection().getConnection();
				       java.sql.PreparedStatement stmt=con.prepareStatement("insert into pay(empid,empname,department,paydate,basic,providedfund,conveyance) values(?,?,?,?,?,?,?)");
				        stmt.setString(1, empid);
				        stmt.setString(2, empname);
				        stmt.setString(3,Department);
				        stmt.setString(4,paydate);
				        stmt.setString(5,basic);
				        stmt.setString(6,providedfund);
				        stmt.setString(7,Conveyance);
				        
				        
				        
				            int i =stmt.executeUpdate();
				            if(i>0)
				            {
			                    JOptionPane.showMessageDialog(null, "All data added!"); //dialog box 

				            }
				            else
				            {
				            	 JOptionPane.showMessageDialog(null, "Data Not added!"); //dialog box
				         
				            }
				            con.close();
					 
					
				 }
		        
		        catch(Exception e1 )
		        {
		        	
		            System.out.println(e1);
		            JOptionPane.showMessageDialog(null, "Error!");
			        
		        }
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setBounds(243, 471, 104, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnFind = new JButton("Find");
		btnFind.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			       String empno=textField.getText();
			        if(empno.equals(""))
			        {
			            JOptionPane.showMessageDialog(null, "Enter Employee id");
			        }
			        else
			        {
			        Connection con=new MyConnection().getConnection();
			            java.sql.PreparedStatement stmt;
			            try {
			                stmt = con.prepareStatement("select * from employee where empid=? "); //retriving information from database employee according to the employee id
			                stmt.setString(1, empno);
			                ResultSet rs= stmt.executeQuery();
			                if(rs.next())
			                {
			                	textField_1.setText(rs.getString(3));
			                textField_2.setText(rs.getString(11));
			                }
			                else
			                {
			                    JOptionPane.showMessageDialog(null, "No data found");
			                }
			               
			            } catch (SQLException ex) {
			                Logger.getLogger(PaySlip.class.getName()).log(Level.SEVERE, null, ex);
			               
			            }
			}
			}});
		btnFind.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnFind.setBounds(431, 88, 89, 23);
		frame.getContentPane().add(btnFind);

		
	}
}
