package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

import entity.Flight;

public class FlightDB {
	
	
	public Flight flightByflightid(String flightid) throws SQLException
	{
		String sql = "select * from Flights where flightid=?";

		
		Connection conn = DBconnection.dbConn();
		
		PreparedStatement stat = conn.prepareStatement(sql);

		stat.setString(1, flightid);

		Flight f1 = null;
		ResultSet rs = stat.executeQuery();
		while(rs.next()) {
			f1= new Flight();
			f1.setFlightid(rs.getString(1));
			f1.setFlightdate(rs.getString(2));
			f1.setAirline(rs.getString(3));
			f1.setDestination(rs.getString(4));
			f1.setPrice(rs.getString(5));
		}
		return f1;
	}
	
	
	public List<Flight> getflight(String flightdate, String destination) throws SQLException
	{
		List<Flight> flight = new ArrayList<Flight>();

		String sql = "select * from Flights where flightdate=? and `destination`=?";

	
		Connection conn = DBconnection.dbConn();
		
		PreparedStatement stat = conn.prepareStatement(sql);
		
		stat.setString(1, flightdate);
		stat.setString(2, destination);
		
		ResultSet rs = stat.executeQuery();
		while(rs.next()) {
			Flight f1 = new Flight();
			f1.setFlightid(rs.getString(1));
			f1.setFlightdate(rs.getString(2));
			f1.setAirline(rs.getString(3));
			f1.setDestination(rs.getString(4));
			f1.setPrice(rs.getString(5));
			flight.add(f1);
		}

		return flight;
	}

}
