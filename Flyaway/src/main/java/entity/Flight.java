package entity;

public class Flight {
	
	
	private String flightid;
	private String flightdate;
	private String airline;
	private String destination;
	private String price;
	
	
	public Flight() {
		
		// TODO Auto-generated constructor stub
	}
	public String getFlightid() {
		return flightid;
	}
	public void setFlightid(String flightid) {
		this.flightid = flightid;
	}
	public String getFlightdate() {
		return flightdate;
	}
	public void setFlightdate(String flightdate) {
		this.flightdate = flightdate;
	}
	public String getAirline() {
		return airline;
	}
	public void setAirline(String airline) {
		this.airline = airline;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	
	public Flight(String flightid, String flightdate, String airline, String destination, String price) {
		super();
		this.flightid = flightid;
		this.flightdate = flightdate;
		this.airline = airline;
		this.destination = destination;
		this.price = price;
	}
	@Override
	public String toString() {
		return "Flight [flightid=" + flightid + ", flightdate=" + flightdate + ", airline=" + airline + ", destination="
				+ destination + ", price=" + price + "]";
	}
	
	



}
