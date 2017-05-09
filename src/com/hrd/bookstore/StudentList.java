package com.hrd.bookstore;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hrd.bookstore.models.dao.StudentDao;
import com.hrd.bookstore.models.dto.StudentDto;

public class StudentList extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html");
		StudentDao dao=new StudentDao();
		List<StudentDto> list=dao.getStudents();
		/*for(int i=0;i<10;i++){
			int no = i++ ;
			list.add(new StudentDto("N00"+no,"Mey mey" ,"female"));
		}*/
		PrintWriter pw=resp.getWriter();
		String s="<a href='insert-student'>create Student</a>"+
				"<table border=1 cellpadding='5px' >"
				+"<thead><tr>"
				+"<th>Role No</th><th>Name</th><th>Gender</th></tr></thead>"
				+"<tbody>";
				
				if(!list.isEmpty()){
					for(StudentDto dto: list){
						s=s+"<tr>";
						s=s+"<td>"+dto.getRoleNo()+"</td>";
						s=s+"<td>"+dto.getName()+"</td>";
						s=s+"<td>"+dto.getGender()+"</td>";
						s=s+"</tr>";
					}
				}

				s=s+"</tbody></table>";
			
				pw.println(s);
	}
}
