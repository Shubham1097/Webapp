package org.btm.jdbcApp;
import java.sql.*;
import java.util.Scanner;
public class LoginValidation
{
	public static void main(String[] args) 
	{
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String qry="Select username from btm.user where name=? and pswd=?";
		Scanner sc=new Scanner(System.in);
		System.out.println("enter name??");
		String name=sc.next();
		System.out.println("enter password??");
		String pswd=sc.next();
		sc.close();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=tiger");
			pstmt=con.prepareStatement(qry);
			//set the value for placeholder before execution//
			pstmt.setString(1, name);
			pstmt.setString(2, pswd);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				String uname=rs.getString(1);
				System.out.println("Welcome "+uname);
			}
			else
			{
				System.err.println("Invalid name/password");
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		finally {
			if(rs!=null)
			{
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(pstmt!=null)
			{
				try {
					pstmt.close();
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
