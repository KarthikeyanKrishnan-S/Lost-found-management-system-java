package mainApp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Found_items {
	// server details
	String url = "jdbc:mysql://localhost/lost_found";
	String name = "root";
	String pass = "Karthikeyan0204";

	Connection con;

	public Found_items() throws SQLException {
		// Connection Establishment
		con = DriverManager.getConnection(url, name, pass);
	}
	// Item Found person
	// Login
	public boolean founder_login(String uname, String pass) throws SQLException {
		String q8 = "Select *from login where username=? and password=?";
		PreparedStatement pst = con.prepareStatement(q8);
		pst.setString(1, uname);
		pst.setString(2, pass);
		ResultSet rs = pst.executeQuery();
		return rs.next(); // if matched true else false
	}
	// Found item Information
	public int found_details(String ptype, String pname, String description, String loc, String fdate, long contact)
			throws SQLException {
		String q1 = "insert into found_items(product_type,product_name,description,found_location,found_date,contact,status) values(?,?,?,?,?,?,?)";
		PreparedStatement pst = con.prepareStatement(q1);
		pst.setString(1, ptype);
		pst.setString(2, pname);
		pst.setString(3, description);
		pst.setString(4, loc);
		pst.setString(5, fdate);
		pst.setLong(6, contact);
		pst.setString(7, "in-Hand");
		int r = pst.executeUpdate();
		
		return r;
		
	}
	//Update Data
	public void update_data()throws SQLException {
		System.out.println();
	}
	// Update item status
	public int update_status(int id) throws SQLException {
		String q3 = "update found_items set status='Hand-over' where id=?";
		PreparedStatement pst = con.prepareStatement(q3);
		pst.setInt(1, id);
		int r = pst.executeUpdate();
		return r;
	}
}
