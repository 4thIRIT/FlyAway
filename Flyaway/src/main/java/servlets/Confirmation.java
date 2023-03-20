package servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.PassengerDB;

/**
 * Servlet implementation class Confirmation
 */
@WebServlet("/Confirmation")
public class Confirmation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Confirmation() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Pragma", "0");
		
		String email = request.getParameter("email");
		String name = request.getParameter("name");
		String flightid = request.getParameter("flightid");
		String price = request.getParameter("price");
		String flightdate = request.getParameter("flightdate");
		String airline = request.getParameter("airline");	
		
		String destination = request.getParameter("destination");
		
		System.out.println(destination);
		System.out.println(flightid);
		System.out.println(price);
		System.out.println(flightdate);
		System.out.println(airline);
		System.out.println(name);
		
		PassengerDB db = new PassengerDB();
		
		try {
			
			Boolean f1 = db.insertpassenger(flightid, name, email,flightdate,airline,destination );
			
			if (f1) 
				{
				request.setAttribute("flightid", flightid);
				request.setAttribute("price", price);
				request.setAttribute("destination", destination);
				request.setAttribute("flightdate", flightdate);
				request.setAttribute("airline", airline);
				request.setAttribute("name", name);
				RequestDispatcher dispatcher = request.getRequestDispatcher("confirmation.jsp");
				dispatcher.forward(request, response);
				}
			
			else 
				{
				response.sendRedirect("payment.jsp?error=Flight already booked in passenger name.");
				}
			}
		
		catch (SQLException e) {
			
			// TODO Auto-generated catch block
			System.out.println("error "+e.getMessage());
			response.sendRedirect("payment.jsp?error=Something went wrong");
		}
		
		
		
	}

}
