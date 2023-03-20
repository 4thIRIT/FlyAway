package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Flight;



public class FlightDatabase {

	
	public List<Flight> getflightinformation(String destination, String flightdate) throws SQLException
	{
		


		String sql = "select * from `Flights` where `destination`=? and ` FlightDate `=?";
	

		Connection conn = DBconnection.dbConn();
		
		PreparedStatement stat = conn.prepareStatement(sql);
		
		stat.setString(1, destination);
		stat.setString(2, flightdate);
		
		ResultSet rs = stat.executeQuery(sql);
		
		
		List<Flight> flights = new ArrayList<Flight>();
		while(rs.next()) {
			
			Flight f1 = new Flight();
			f1.setFlightid(rs.getString(1));
			f1.setFlightdate(rs.getString(2));
			f1.setAirline(rs.getString(3));
			f1.setDestination(rs.getString(4));
			f1.setPrice(rs.getString(5));
			flights.add(f1);
		}
		
		return flights;
	}

}
