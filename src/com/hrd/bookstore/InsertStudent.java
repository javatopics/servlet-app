package com.hrd.bookstore;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hrd.bookstore.models.dao.StudentDao;
import com.hrd.bookstore.models.dto.StudentDto;

/**
 * Servlet implementation class InsertStudent
 */
@WebServlet("/insert-student")
public class InsertStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertStudent() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 response.setContentType("text/html");  
		response.sendRedirect("student-form.jsp");
		
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		 response.setContentType("text/html");  
		PrintWriter pw=response.getWriter();
		String name=request.getParameter("name");
		String gender=request.getParameter("gender");
		String roleNo=request.getParameter("roleNo");
		StudentDto dto=new StudentDto();
		dto.setRoleNo(roleNo);
		dto.setName(name);
		dto.setGender(gender);
		
		StudentDao dao=new StudentDao();
		dao.createStudent(dto);
		
		
		/*String s="<table border=1 cellpadding='5px' >"
			+"<thead><tr>"
			+"<th>name</th><th>gender</th><th>Age</th></tr></thead>"
			+"<tbody><tr>";
		
			s=s+"<td>"+roleNo+"</td>";
			s=s+"<td>"+name+"</td>";
			s=s+"<td>"+gender+"</td>";
		
			
			s=s+"</tr>"
			+"</tbody></table>";
		
			pw.println(s);*/
		

	}

}







