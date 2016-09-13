package doan.bansachonline;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DulieuDB {
	private static Connection con;
	private DulieuDB(){
		try {
			con = DriverManager.getConnection("jdbc:sqlserver://DESKTOP-F4K5517:1433;databasename = BanSachOnline","sa","sapassword");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public synchronized static Connection getConnection(){
		if(con==null)
			new DulieuDB();
		return con;
	}
}
