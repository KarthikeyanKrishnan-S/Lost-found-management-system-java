package mainApp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Lost_items {
	// server details
	String url = "jdbc:mysql://localhost/lost_found";
	String name = "root";
	String pass = "Karthikeyan0204";

	Connection con;

	public Lost_items() throws SQLException {

		// Connection Establishment
		con = DriverManager.getConnection(url, name, pass);

	}

	//Lost item
	// To get info about lost item
	public void lost_details(String ptype) throws SQLException {
		String q2 = "select *from found_items where product_type=?";
		PreparedStatement pst = con.prepareStatement(q2);
		pst.setString(1, ptype);
		ResultSet rs = pst.executeQuery();
		if(rs.next()) {
		while (rs.next()) {
			System.out.println("Type			: " + rs.getString(2));
			System.out.println("Name			: " + rs.getString(3));
			System.out.println("Description		: " + rs.getString(4));
			System.out.println("Loaction 	 	: " + rs.getString(5));
			System.out.println("Date  		 	: " + rs.getString(6));
			System.out.println("Contact 	 		: " + rs.getLong(7));
			System.out.println("Status  		 	: " + rs.getString(8));
			System.out.println();
		}
		}else {
			System.out.println("There is no product type in "+ptype+"\n");
		}
	}

}
