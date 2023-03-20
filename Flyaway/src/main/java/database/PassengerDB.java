package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Passenger;

public class PassengerDB {
	
	
	public Boolean insertpassenger (String flightid, String name, String email, String flightdate, String airline, String destination) throws SQLException {
		
		
		String sql = "insert into `Passengers` values(?,?,?,?,?,?) ";

		Connection conn = DBconnection.dbConn();
		
		PreparedStatement stat = conn.prepareStatement(sql);

		
		stat.setString(1, flightid);
		stat.setString(2, name);
		stat.setString(3, email);
		stat.setString(4, flightdate);
		stat.setString(5, airline);
		stat.setString(6, destination);
		
		
		try {
			
			stat.execute();
		}
		
		catch(Exception e) {
			
			System.out.println("error "+e.getMessage());
			return false;
		}
		
		return true;

		}
	
	
	public List<Passenger> getAll() throws SQLException
	{
		List<Passenger> passengers = new ArrayList<Passenger>();

		String sql = "SELECT * FROM `Passengers` ORDER BY FlightDate ASC";

		Connection conn = DBconnection.dbConn();
		
		PreparedStatement stat = conn.prepareStatement(sql);

		ResultSet rs = stat.executeQuery(sql);
		
		while(rs.next()) {
			Passenger p1 = new Passenger();
			p1.setFlightid(rs.getString(1));
			p1.setName(rs.getString(2));
			p1.setEmail(rs.getString(3));
			p1.setFlightdate(rs.getString(4));
			p1.setAirline(rs.getString(5));
			p1.setDestination(rs.getString(6));
			passengers.add(p1);
		}
		return passengers;
	}
	
	
	

}
