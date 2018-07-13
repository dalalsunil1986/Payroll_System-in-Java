package Payroll_System;

import java.awt.Color;


import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.*;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import ConnectionProvider.MyConnection;

import java.awt.event.ActionListener;




class InvalidException extends Exception {
}

public class Login implements ActionListener {

	 JFrame frame;
	 JPanel contentPane;
	 JTextField unametf;
	 JPasswordField passwordField;
	 JButton b;
	
    int cnt = 0, cnt1 = 0;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frame.setVisible(true);
					window.frame.setTitle("Login");
					
					window.frame.setResizable(false);
					window.frame.setLocationRelativeTo(null);
					window.frame.setBounds(100, 100, 626, 340);
					  WindowAdapter exitListener = new WindowAdapter() {

				            @Override
				            
				            //validation frames 
				            
				            public void windowClosing(WindowEvent e) {
				                int confirm = JOptionPane.showOptionDialog(window.frame,
				                        "Are You Sure to Close this Application?",
				                        "Exit Confirmation", JOptionPane.YES_NO_CANCEL_OPTION,
				                        JOptionPane.QUESTION_MESSAGE, null, null, null);
				                if(confirm == JOptionPane.YES_OPTION){
				                	window.frame.setDefaultCloseOperation(window.frame.DISPOSE_ON_CLOSE);//yes

				                } else if (confirm == JOptionPane.CANCEL_OPTION) {
				                	window.frame.setDefaultCloseOperation(window.frame.DO_NOTHING_ON_CLOSE);//cancel
				                } else {
				                	window.frame.setDefaultCloseOperation(window.frame.DO_NOTHING_ON_CLOSE);//no
				                }
				            }
				        };
				        window.frame. addWindowListener(exitListener);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	
	//main class login
	
	public Login()  {
		initialize();
	}

	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(200, 200, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.getContentPane().setForeground(new Color(51, 0, 102));
		frame.getContentPane().setFont(new Font("Roboto", Font.BOLD, 18));
		frame.getContentPane().setBackground(new Color(102, 102, 153));
		frame.getContentPane().setLayout(null);

		JLabel lblPayrollManagementSystem = new JLabel("Payroll Management System");
		lblPayrollManagementSystem.setForeground(new Color(204, 255, 204));
		lblPayrollManagementSystem.setFont(new Font("Roboto", Font.PLAIN, 26));
		lblPayrollManagementSystem.setBounds(153, 30, 381, 57);
		Font f = new Font("Roboto" ,Font.BOLD ,18);
		frame.getContentPane().add(lblPayrollManagementSystem);
		

		JLabel lblUsername = new JLabel("Username");
		lblUsername.setForeground(new Color(204, 255, 204));
		lblUsername.setFont(new Font("Roboto", Font.PLAIN, 14));
		lblUsername.setBounds(171, 129, 90, 19);
		frame.getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(new Color(204, 255, 204));
		lblPassword.setFont(new Font("Roboto", Font.PLAIN, 14));
		lblPassword.setBounds(171, 183, 90, 19);
		frame.getContentPane().add(lblPassword);
		
		unametf = new JTextField();
		unametf.setBounds(314, 128, 141, 20);
		frame.getContentPane().add(unametf);
		unametf.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(314, 182, 141, 20);
		frame.getContentPane().add(passwordField);
		
		 b = new JButton("Login");
		b.addActionListener(this);
		b.setFont(new Font("Tahoma", Font.PLAIN, 13));
		b.setBounds(264, 241, 89, 23);
		frame.getContentPane().add(b);
		frame.setBounds(100, 100, 626, 369);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
		
		
		public void actionPerformed(ActionEvent ae) {
			if (ae.getSource() ==b ) {
				
					String s = unametf.getText();
					String s1 = new String(passwordField.getPassword());
					 try
				        {
				        Connection con=new MyConnection().getConnection();
				        
				        //connecting with database : admin=admin
				        
				       PreparedStatement stmt=con.prepareStatement("select * from admin where adminid=? AND password=?");
				        stmt.setString(1, s);
				        stmt.setString(2, s1);
				            ResultSet rs=stmt.executeQuery();
				            if(s.equals("")||s1.equals(""))
				            {
			                    JOptionPane.showMessageDialog(null, "Username or Password is Blank!!");

				            }
				            else
				            {
				            	if(rs.next())
				            	{
				               
				            		new Home().setVisible(true);
				                    	frame.setVisible(false);
				                   
				               
				                    	System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
				            	}
				            	else
				            	{
				            		unametf.setText("");
				            		passwordField.setText("");
				                    JOptionPane.showMessageDialog(null, "Username or Password is Incorrect!!");
				                
				            	}
				            }
				            con.close();
				        }
				        catch(Exception e )
				        {
				        	unametf.setText("");
							passwordField.setText("");
				            System.out.println(e);
				            JOptionPane.showMessageDialog(null, "Error in Login!!");
					        
				        }
					 
					
								
			}
		
		}
	}

