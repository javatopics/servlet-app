package com.hrd.bookstore;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hrd.bookstore.connection.PGConnection;

/**
 * Servlet implementation class Home
 */
@WebServlet(description = "a servlet Home page", urlPatterns = { "/home" })
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 response.setContentType("text/html");  
		/*PrintWriter write= response.getWriter();
		write.println("<html>");
		write.println("<head><title>Home page |</title></head>");
		write.println("<body>");
		write.print("<h1>holle servlet Home page</h1>");
		write.print("<form action='"+request.getServletContext().getContextPath()+"/' role='form' method='POST'> "
				+"<input type='text' name='name'/>"
				+"<input type='text' name='gender'/>"
				+"<input type='text' name='age'/>"
				+"<input type='submit' name= 'btn-submit'>"
				+"</form>");
		write.println("</body>");
		write.println("</html>");*/
		
		 PGConnection.getConnection();
		request.getRequestDispatcher("student-form.jsp").forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		/*String name=request.getParameter("name");
		String gender=request.getParameter("gender");
		String age =request.getParameter("age");
		
		PrintWriter write= response.getWriter();
		write.append("Name :" +name);
		write.append("Gender :" +gender);
		write.append("Age :" +age);*/
	}

}
