package servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.FlightDB;
import entity.Flight;

/**
 * Servlet implementation class Purchase
 */
@WebServlet("/Purchase")
public class Purchase extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Purchase() {
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
		
		String flightid = request.getParameter("flightid");
		
		FlightDB db = new FlightDB();
		
		
		
		try {
			
			Flight f1 = db.flightByflightid(flightid);
			
			String price = f1.getPrice();
			String destination = f1.getDestination();
			String flightdate = f1.getFlightdate();
			String airline = f1.getAirline();
	
			
			
			
			request.setAttribute("flightid", flightid);
			request.setAttribute("price", price);
			request.setAttribute("destination", destination);
			request.setAttribute("flightdate", flightdate);
			request.setAttribute("airline", airline);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("payment.jsp");
			dispatcher.forward(request, response);
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
