package entity;

public class Passenger {
	
	private String flightid;
	private String name;
	private String email;
	private String flightdate;
	private String airline;
	private String destination;
	
	
	public Passenger(String flightid, String name, String email, String flightdate, String airline,
			String destination) {
		super();
		this.flightid = flightid;
		this.name = name;
		this.email = email;
		this.flightdate = flightdate;
		this.airline = airline;
		this.destination = destination;
	}
	
	
	public Passenger() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	
	public String getFlightid() {
		return flightid;
	}
	public void setFlightid(String flightid) {
		this.flightid = flightid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
	@Override
	public String toString() {
		return "Passenger [flightid=" + flightid + ", name=" + name + ", email=" + email + ", flightdate=" + flightdate
				+ ", airline=" + airline + ", destination=" + destination + "]";
	}



}
