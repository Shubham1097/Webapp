package org.btm.jdbcApp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertMultiple
{
	public static void main(String[] args) 
	{
		Connection con=null;
		Statement stmt=null;
		String qry1="insert into btm.student1 values(1,'Pradeep',35.55)";
		String qry2="insert into btm.student1 values(2,'Mandeep',36.55)";
		String qry3="insert into btm.student1 values(3,'Sandeep',37.55)";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Class Loaded and Registered");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=tiger");
			System.out.println("Connection established with db server");
			stmt=con.createStatement();
			System.out.println("Plateform Created");
			stmt.executeUpdate(qry1);
			stmt.executeUpdate(qry2);
			stmt.executeUpdate(qry3);
			System.out.println("inserted");

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		finally {
			if(stmt!=null)
			{
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(con!=null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			System.out.println("close all the costly resources");
		}

	}

}

