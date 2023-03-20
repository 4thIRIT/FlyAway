package servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.PassengerDB;
import entity.Passenger;

/**
 * Servlet implementation class Upcoming
 */
@WebServlet("/Upcoming")
public class Upcoming extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Upcoming() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Pragma", "0");
		
		PassengerDB db = new PassengerDB();
		
		try {
					List<Passenger> passengers = new ArrayList<Passenger>();
					passengers = db.getAll();
					
					if (passengers.size()!=0) 
						{
						
						System.out.println("Your Upcoming Flights");				
						request.setAttribute("passengers", passengers);		
						RequestDispatcher dispatcher = request.getRequestDispatcher("upcoming.jsp");
						dispatcher.forward(request, response);
						
						}
					
					else 
						{
						response.sendRedirect("noupcoming.jsp");
						System.out.println("No Flights Upcoming");
						}
					}
				
				catch (SQLException e) {
					
					// TODO Auto-generated catch block
					System.out.println("error "+e.getMessage());
					response.sendRedirect("payment.jsp?error=Something went wrong");
				}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
