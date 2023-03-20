package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import database.FlightDB;


import entity.Flight;

/**
 * Servlet implementation class Dashboard
 */
@WebServlet("/Dashboard")
public class Dashboard extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Dashboard() {
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
		
		String destination = request.getParameter("destination");
		String flightdate = request.getParameter("flightdate");
		System.out.println(destination);
		System.out.println(flightdate);
		
		FlightDB db = new FlightDB();
		List<Flight> flights = new ArrayList<Flight>();
		
		try {
			
			flights = db.getflight(flightdate, destination);
			System.out.println(flights);
			System.out.println("flights2");
			
			if(flights.size()==0)
			{
				response.sendRedirect("noresults.jsp");
				System.out.println("No Flights Available");
			}
			else
			{
				System.out.println("Flights Available");				
				request.setAttribute("flights", flights);		
				RequestDispatcher dispatcher = request.getRequestDispatcher("results.jsp");
				dispatcher.forward(request, response);
		
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			response.sendRedirect("dashboard.jsp?error=Something went wrong");

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
