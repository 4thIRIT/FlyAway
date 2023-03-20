package servlets;

import java.io.IOException;
import java.sql.SQLException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.MemberDB;
import entity.Member;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
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
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		
		
		if(email == null || email.isEmpty())
		{
		
			response.sendRedirect("register.jsp?error=Email cannot be null");
			return;
		}
		
		if(password == null || password.isEmpty())
		{
			response.sendRedirect("register.jsp?error=Password cannot empty");
			return;
		}
		
		if(name == null || name.isEmpty())
		{
			response.sendRedirect("register.jsp?error=Phone cannot be null");
			return;
		}
		
		MemberDB db = new MemberDB();
		Member m1 = new Member();
		m1.setEmail(email);
		m1.setName(name);
		m1.setPassword(password);
		
		try {
			if(db.insertmember(email, name, password))
			{
				
				response.sendRedirect("login.jsp");
			}
			else {
				response.sendRedirect("register.jsp?error=Registration unsuccessful");
			
			}
		} catch (SQLException e) {
			// keep me on registration page
			response.sendRedirect("register.jsp?error=Something went wrong");
			
		}
	}
}


