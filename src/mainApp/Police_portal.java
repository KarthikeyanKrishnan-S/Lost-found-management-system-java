package mainApp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Police_portal {
	// server details
	String url = "jdbc:mysql://localhost/lost_found";
	String name = "root";
	String pass = "Karthikeyan0204";

	Connection con;

	public Police_portal() throws SQLException {

		// Connection Establishment
		con = DriverManager.getConnection(url, name, pass);
	}
	// Police (Common Authority)
	
	//Sign-up
	public void police_signup(String uname,String pass) throws SQLException {
		try {
		String q1 = "insert into police(username,password) values(?,?) ";
		PreparedStatement pst = con.prepareStatement(q1);
		pst.setString(1, uname);
		pst.setString(2, pass);
		pst.executeUpdate();
		System.out.println("SignUp Successfully");
		System.out.println("Login to continue");
		}catch(Exception e) {
			System.out.println("Error : "+e);
		}
		
		
		}
	
	// Login
	public boolean police_login(String uname, String pass) throws SQLException {
		String q2 = "Select *from police where username=? and password=?";
		PreparedStatement pst = con.prepareStatement(q2);
		pst.setString(1, uname);
		pst.setString(2, pass);
		ResultSet rs = pst.executeQuery();
		return rs.next(); // if match true else false
	}
	// show all data
	public void show() throws SQLException {
		String q3 = "Select *from found_items";
		Statement smt = con.createStatement();
		ResultSet rs = smt.executeQuery(q3);
		while (rs.next()) {
			System.out.println("Id 			: " + rs.getInt(1));
			System.out.println("Type			: " + rs.getString(2));
			System.out.println("Name			: " + rs.getString(3));
			System.out.println("Description		: " + rs.getString(4));
			System.out.println("Loaction 	 	: " + rs.getString(5));
			System.out.println("Date  		 	: " + rs.getString(6));
			System.out.println("Contact 	 		: " + rs.getLong(7));
			System.out.println("Status  		 	: " + rs.getString(8));
			System.out.println();
		}
	}
	// delete Query
	public void delete_data(int id) throws SQLException {
		String q4 = "delete from found_items where id=?";
		PreparedStatement pst = con.prepareStatement(q4);
		pst.setInt(1, id);
		pst.executeUpdate();
	}
}
