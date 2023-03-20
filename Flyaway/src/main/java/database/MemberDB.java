package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MemberDB {
	
	
	public Boolean insertmember (String email, String name, String password) throws SQLException {
			
			
			String sql = "insert into `Members` values(?,?,?) ";
	
			Connection conn = DBconnection.dbConn();
			
			PreparedStatement stat = conn.prepareStatement(sql);
	
			
			stat.setString(1, email);
			stat.setString(2, name);
			stat.setString(2, password);
			
			
			try {
				
				stat.execute();
			}
			
			catch(Exception e) {
				
				System.out.println("error "+e.getMessage());
				return false;
			}
			
			return true;
	
			}
	
	
	
	
	public Boolean validatemember(String email, String password) throws SQLException {

		
		Boolean isValid = false;
		String sql = "select * from `Members` where `email`=? and `password`=?";

		Connection conn = DBconnection.dbConn();
		
		PreparedStatement stat = conn.prepareStatement(sql);

		stat.setString(1, email);
		stat.setString(2, password);
		
		
		try {
			
			ResultSet rs = stat.executeQuery();	

			if(rs.next()) 
				{
				isValid = true;
		
				}

		}
		
		catch(Exception e) {
			
			System.out.println("error "+e.getMessage());
			
		}
		
		return isValid;
	}
	
		

	
	
	public Boolean updatememberpassword (String email, String password, String newpassword) throws SQLException {
		
			
		String sql = "update `Members` set `password`=? where `email`=? and `password`=?";

		Connection conn = DBconnection.dbConn();
		
		PreparedStatement stat = conn.prepareStatement(sql);

		stat.setString(1, newpassword);
		stat.setString(2, email);
		stat.setString(3, password);
		
		try {
			
			stat.execute();
		}
		
		catch(Exception e) {
			
			System.out.println("error "+e.getMessage());
			return false;
		}
		
		return true;

		}

}
