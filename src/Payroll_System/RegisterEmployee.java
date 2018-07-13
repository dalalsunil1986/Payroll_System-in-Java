package Payroll_System;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import ConnectionProvider.MyConnection;

import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class RegisterEmployee {

	public JFrame frame;

	Connection conn;
    Statement stmt;
    ResultSet rs;
  
    DefaultTableModel model = new DefaultTableModel();
    JTable tabGrid = new JTable(model);
    JScrollPane scrlPane = new JScrollPane(tabGrid);
    
    
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    private JTextField textField_4;
    private JTextField textField_5;
    private JTextField textField_6;
    private JTextField textField_7;
    private JTextField textField_8;
    private JTextField textField_9;
    private JTextField textField_10;
    private JTextField textField_11;

	/**
	 * Launch the application.
	 */
/*	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterEmployee window = new RegisterEmployee();
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
	public RegisterEmployee() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		
		frame.setBounds(0, 0, 1000, 650);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
	
		

		frame.getContentPane().setForeground(new Color(51, 0, 102));
		frame.getContentPane().setFont(new Font("Roboto", Font.BOLD, 18));
		frame.getContentPane().setBackground(new Color(102, 102, 153));
		frame.getContentPane().setLayout(null);

		JLabel lblPayrollManagementSystem = new JLabel("Employee Registration");
		lblPayrollManagementSystem.setForeground(new Color(204, 255, 204));
		lblPayrollManagementSystem.setFont(new Font("Roboto", Font.PLAIN, 26));
		lblPayrollManagementSystem.setBounds(322, 21, 381, 57);
		Font f = new Font("Roboto" ,Font.BOLD ,18);
		frame.getContentPane().add(lblPayrollManagementSystem);
		
		JLabel lblNewLabel = new JLabel("Employee ID");
		lblNewLabel.setForeground(new Color(204, 255, 204));
		lblNewLabel.setFont(new Font("Roboto", Font.PLAIN, 18));
		lblNewLabel.setBounds(84, 115, 125, 24);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblEmployeeName = new JLabel("Employee Name");
		lblEmployeeName.setForeground(new Color(204, 255, 204));
		lblEmployeeName.setFont(new Font("Dialog", Font.PLAIN, 18));
		lblEmployeeName.setBounds(84, 150, 139, 24);
		frame.getContentPane().add(lblEmployeeName);     
		
		JLabel lblDob = new JLabel("D.O.B");
		lblDob.setForeground(new Color(204, 255, 204));
		lblDob.setFont(new Font("Dialog", Font.PLAIN, 18));
		lblDob.setBounds(84, 185, 139, 24);
		frame.getContentPane().add(lblDob);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setForeground(new Color(204, 255, 204));
		lblGender.setFont(new Font("Dialog", Font.PLAIN, 18));
		lblGender.setBounds(84, 220, 139, 24);
		frame.getContentPane().add(lblGender);
		
		JRadioButton rdbtnM = new JRadioButton("Male");
		rdbtnM.setBounds(272, 224, 80, 23);
		frame.getContentPane().add(rdbtnM);
		
		textField = new JTextField();
		textField.setBounds(271, 115, 198, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(271, 155, 198, 20);
		frame.getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(271, 190, 198, 20);
		frame.getContentPane().add(textField_2);
		
		JRadioButton radioButton = new JRadioButton("Female");
		radioButton.setBounds(272, 261, 80, 23);
		frame.getContentPane().add(radioButton);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setForeground(new Color(204, 255, 204));
		lblEmail.setFont(new Font("Dialog", Font.PLAIN, 18));
		lblEmail.setBounds(84, 307, 125, 24);
		frame.getContentPane().add(lblEmail);
		
		JLabel lblContact = new JLabel("Contact");
		lblContact.setForeground(new Color(204, 255, 204));
		lblContact.setFont(new Font("Dialog", Font.PLAIN, 18));
		lblContact.setBounds(84, 342, 139, 24);
		frame.getContentPane().add(lblContact);
		
		JLabel lblAddressLine = new JLabel("Address Line 1");
		lblAddressLine.setForeground(new Color(204, 255, 204));
		lblAddressLine.setFont(new Font("Dialog", Font.PLAIN, 18));
		lblAddressLine.setBounds(84, 382, 139, 24);
		frame.getContentPane().add(lblAddressLine);
		
		JLabel lblAddressLine_1 = new JLabel("Address Line 2");
		lblAddressLine_1.setForeground(new Color(204, 255, 204));
		lblAddressLine_1.setFont(new Font("Dialog", Font.PLAIN, 18));
		lblAddressLine_1.setBounds(84, 417, 139, 24);
		frame.getContentPane().add(lblAddressLine_1);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(271, 312, 198, 20);
		frame.getContentPane().add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(271, 347, 198, 20);
		frame.getContentPane().add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(271, 387, 277, 20);
		frame.getContentPane().add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(271, 422, 277, 20);
		frame.getContentPane().add(textField_6);
		
		JLabel lblPinCode = new JLabel("Pin Code");
		lblPinCode.setForeground(new Color(204, 255, 204));
		lblPinCode.setFont(new Font("Dialog", Font.PLAIN, 18));
		lblPinCode.setBounds(543, 115, 125, 24);
		frame.getContentPane().add(lblPinCode);
		
		/*scrlPane.setViewportView(tabGrid);
		frame.getContentPane().add(scrlPane);
		 scrlPane.setBounds(10, 320, 940, 220);
		*/
		JLabel lblDepartme = new JLabel("Department");
		lblDepartme.setForeground(new Color(204, 255, 204));
		lblDepartme.setFont(new Font("Dialog", Font.PLAIN, 18));
		lblDepartme.setBounds(543, 150, 125, 24);
		frame.getContentPane().add(lblDepartme);
		
		JLabel lblDesignation = new JLabel("Designation");
		lblDesignation.setForeground(new Color(204, 255, 204));
		lblDesignation.setFont(new Font("Dialog", Font.PLAIN, 18));
		lblDesignation.setBounds(543, 185, 125, 24);
		frame.getContentPane().add(lblDesignation);
		
		JLabel lblDateHired = new JLabel("Date Hired");
		lblDateHired.setForeground(new Color(204, 255, 204));
		lblDateHired.setFont(new Font("Dialog", Font.PLAIN, 18));
		lblDateHired.setBounds(543, 220, 125, 24);
		frame.getContentPane().add(lblDateHired);
		
		JLabel lblBasicSalary = new JLabel("Basic Salary");
		lblBasicSalary.setForeground(new Color(204, 255, 204));
		lblBasicSalary.setFont(new Font("Dialog", Font.PLAIN, 18));
		lblBasicSalary.setBounds(543, 255, 125, 24);
		frame.getContentPane().add(lblBasicSalary);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(692, 115, 198, 20);
		frame.getContentPane().add(textField_7);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(692, 150, 198, 20);
		frame.getContentPane().add(textField_8);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(692, 190, 198, 20);
		frame.getContentPane().add(textField_9);
		
		textField_10 = new JTextField();
		textField_10.setColumns(10);
		textField_10.setBounds(692, 225, 198, 20);
		frame.getContentPane().add(textField_10);
		
		textField_11 = new JTextField();
		textField_11.setColumns(10);
		textField_11.setBounds(692, 262, 198, 20);
		frame.getContentPane().add(textField_11);
		ButtonGroup buttonGroup=new ButtonGroup();
		buttonGroup.add(rdbtnM);
		buttonGroup.add(radioButton);
		
		
		//inserting icon image into add employee button
		JButton btnNewButton = new JButton("Add Employee",new ImageIcon("images//employee.png"));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.setBounds(481, 524, 187, 23);
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				 try
			        {
					 String empid=textField.getText();
					 String empname=textField_1.getText();
					 String dob=textField_2.getText();
					 String gender="";
					 if(rdbtnM.isSelected())
					 {
						  gender="male";
					 }
					 else if(radioButton.isSelected())
					 {
						  gender="female";
					 }
					 
					 String email=textField_3.getText();
					 String contact=textField_4.getText();
					 String add1=textField_5.getText();
					 String add2=textField_6.getText();
					 String pincode=textField_7.getText();
					 String department=textField_8.getText();
					 String designation=textField_9.getText();
					 String datehired=textField_10.getText();
					 String salary=textField_11.getText();
					 
					 if(empid.equals("")||empname.equals("")||dob.equals("")||gender.equals("")||email.equals("")||
							 contact.equals("")||add1.equals("")||add2.equals("")||pincode.equals("")||
							 department.equals("")||designation.equals("")||datehired.equals("")||salary.equals(""))
					 {
						 JOptionPane.showMessageDialog(null, "Fill all data");
					 }
					 else
					 {
						 
						 //database connectivity
						 
						 Connection con=new MyConnection().getConnection();
						 
						 //inserting values into employee table
						 
					       PreparedStatement stmt=con.prepareStatement("insert into employee(empid,empname,dob,gender,email,contact,add1,add2,pincode,department,designation,datehired,salary) values(?,?,?,?,?,?,?,?,?,?,?,?,?)");
					        stmt.setString(1, empid);
					        stmt.setString(2, empname);
					        stmt.setString(3,dob);
					        stmt.setString(4,gender);
					        stmt.setString(5,email);
					        stmt.setString(6,contact);
					        stmt.setString(7,add1);
					        stmt.setString(8,add2);
					        stmt.setString(9,pincode);
					        stmt.setString(10,department);
					        stmt.setString(11,designation);
					        stmt.setString(12,datehired);
					        stmt.setString(13,salary);
					        
					            int i =stmt.executeUpdate();
					            if(i>0)
					            {
				                    JOptionPane.showMessageDialog(null, "All data added!");

					            }
					            else
					            {
					            	 JOptionPane.showMessageDialog(null, "Data Not added!");
					         
					            }
					            con.close();
						 
						
					 }
			        }
			        catch(Exception e1 )
			        {
			        	
			            System.out.println(e1);
			            JOptionPane.showMessageDialog(null, "Error!");
				        
			        }
				
			}
		});
		frame.getContentPane().add(btnNewButton);
		
		
		
	}
	
}
