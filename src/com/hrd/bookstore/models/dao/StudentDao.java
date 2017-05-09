package com.hrd.bookstore.models.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.crypto.CipherInputStream;

import com.hrd.bookstore.connection.PGConnection;
import com.hrd.bookstore.models.dto.StudentDto;

public class StudentDao {
	
	public List<StudentDto> getStudents(){
		
		List<StudentDto> list =new ArrayList<>();
		Connection conn=null;
		try {
			conn =PGConnection.getConnection();
			ResultSet rs=conn.createStatement().executeQuery("SELECT * FROM tbstudent order by stu_id asc;");
			while(rs.next()){
				list.add(new StudentDto(
						rs.getString("stu_roleno"),
						rs.getString("stu_name"),
						rs.getString("stu_gender")
						));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return list;
	}
	
public boolean createStudent(StudentDto student){
		Connection conn=null;
		int rowEffected=0;
		String sql= "INSERT INTO tbstudent (stu_roleno,stu_name,stu_gender) VALUES(?,?,?)";
		try {
			conn =PGConnection.getConnection();
			
			PreparedStatement pstm=conn.prepareStatement(sql);
			pstm.setString(1, student.getRoleNo());
			pstm.setString(2, student.getName());
			pstm.setString(3, student.getGender());
			rowEffected=pstm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		if(rowEffected>0) return true;
		else return false;
	}

}
