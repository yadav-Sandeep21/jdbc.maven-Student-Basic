package com.ty.maven.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ty.maven.dto.Student;
import com.ty.maven.util.ConnectionObject;

public class StudentDao {
public int saveStudent(Student student) {
		
		String sql="INSERT INTO student VALUES(?,?,?,?)";
		Connection connection=ConnectionObject.getConnection();
		
		try {
			PreparedStatement preparestatement=connection.prepareStatement(sql);
			preparestatement.setInt(1,student.getSid());
			preparestatement.setString(2,student.getName());
			preparestatement.setString(3,student.getEmail());
			preparestatement.setString(4,student.getPhone());
			
			return preparestatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			{
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return 0;
	}

public Student getStudentById(int sid) {
	String sql="SELECT * FROM student WHERE sid=?";
	Connection connection=ConnectionObject.getConnection();
	try {
		PreparedStatement preparestatement=connection.prepareStatement(sql);
		preparestatement.setInt(1,sid);
		
		ResultSet resultset=preparestatement.executeQuery();
		if(resultset.next()) 
		{
			Student student=new Student();
			student.setSid(resultset.getInt(1));
			student.setName(resultset.getString(2));
			student.setEmail(resultset.getString(3));
			student.setPhone(resultset.getString(4));
			return student;
		}
		else
		{
			System.out.println("No such person found");
		}
		
	} catch (SQLException e) {
		e.printStackTrace();
	}finally {
		if(connection!=null)
		{
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	return null;
}
}
