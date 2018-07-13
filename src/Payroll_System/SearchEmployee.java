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
import net.proteanit.sql.DbUtils;

import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
public class SearchEmployee {

	public JFrame frame;
	
	Connection conn;
    private JTextField textField_1;
    private JTextField textField;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchEmployee window = new SearchEmployee();
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
	public SearchEmployee() {
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		
		frame.setBounds(0, 0, 982, 511);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		frame.getContentPane().setForeground(new Color(51, 0, 102));
		frame.getContentPane().setFont(new Font("Roboto", Font.BOLD, 18));
		frame.getContentPane().setBackground(new Color(102, 102, 153));
		frame.getContentPane().setLayout(null);
		JTable jTable1 = new JTable();
		JScrollPane jScrollPane1 = new JScrollPane();
		JLabel lblPayrollManagementSystem = new JLabel("Search Employee ");
		lblPayrollManagementSystem.setForeground(new Color(204, 255, 204));
		lblPayrollManagementSystem.setFont(new Font("Roboto", Font.PLAIN, 26));
		lblPayrollManagementSystem.setBounds(181, 11, 381, 57);
		Font f = new Font("Roboto" ,Font.BOLD ,18);
		frame.getContentPane().add(lblPayrollManagementSystem);

		
		JLabel lblNewLabel = new JLabel("Employee ID");
		lblNewLabel.setForeground(new Color(204, 255, 204));
		lblNewLabel.setFont(new Font("Roboto", Font.PLAIN, 18));
		lblNewLabel.setBounds(78, 89, 125, 24);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setForeground(new Color(204, 255, 204));
		lblEmail.setFont(new Font("Dialog", Font.PLAIN, 18));
		lblEmail.setBounds(78, 135, 125, 24);
		frame.getContentPane().add(lblEmail);
		
		JButton btnNewButton = new JButton("Search",new ImageIcon("images//search.png"));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				
				Connection con=new MyConnection().getConnection();
                java.sql.PreparedStatement stmt;
                try {
                	//sql query to search employee with employee id       	
                	
                    stmt = con.prepareStatement("select * from employee where empid=? OR email=?");
                    stmt.setString(1, textField.getText());
                    stmt.setString(2, textField_1.getText());
                    ResultSet rs= stmt.executeQuery();
                    jTable1.setModel(DbUtils.resultSetToTableModel(rs));
                    jTable1.repaint();
                } catch (SQLException ex) {
                    Logger.getLogger(SearchEmployee.class.getName()).log(Level.SEVERE, null, ex);
                   JOptionPane.showMessageDialog(null, "Enter Correct data");
                }
			
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton.setBounds(250, 192, 160, 23);
		frame.getContentPane().add(btnNewButton);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(250, 140, 198, 20);
		frame.getContentPane().add(textField_1);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(250, 94, 198, 20);
		frame.getContentPane().add(textField);
		
		//setting model that will show the output of the result search
		
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
	        Connection con=new MyConnection().getConnection();
            java.sql.PreparedStatement stmt;
            try {
                stmt = con.prepareStatement("select * from employee");
             
                ResultSet rs= stmt.executeQuery();
                jTable1.setModel(DbUtils.resultSetToTableModel(rs));
                jTable1.repaint();
            } catch (SQLException ex) {
                Logger.getLogger(SearchEmployee.class.getName()).log(Level.SEVERE, null, ex);
               
            }
	        frame.getContentPane().add(jScrollPane1);
	        jScrollPane1.setBounds(24, 252, 932, 220);
	        
	        JButton btnAllEmployee = new JButton("ALL EMployee");
	        btnAllEmployee.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		Connection con=new MyConnection().getConnection();
	                java.sql.PreparedStatement stmt;
	                try {
	                    stmt = con.prepareStatement("select * from employee");
	                 
	                    ResultSet rs= stmt.executeQuery();
	                    jTable1.setModel(DbUtils.resultSetToTableModel(rs));
	                    jTable1.repaint();
	                } catch (SQLException ex) {
	                    Logger.getLogger(SearchEmployee.class.getName()).log(Level.SEVERE, null, ex);
	                   
	                }
	        	}
	        });
	        btnAllEmployee.setFont(new Font("Tahoma", Font.BOLD, 12));
	        btnAllEmployee.setBounds(421, 192, 141, 23);
	        frame.getContentPane().add(btnAllEmployee);
	}
}
