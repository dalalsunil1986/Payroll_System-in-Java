/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConnectionProvider;

import java.sql.*;


public class MyConnection 
{
    public Connection con=null;
   public  Connection getConnection(  )
    {
           try{
        Class.forName("com.mysql.jdbc.Driver");

        con=DriverManager.getConnection("jdbc:mysql://localhost:3306/payroll","root","");
        //here test is the database name, root is the username and root is the password
       
        }
           catch(Exception e){ System.out.println(e);}
           return con;

    }
   
}