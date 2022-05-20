package com.ty.maven.controller;

import com.ty.maven.dao.StudentDao;
import com.ty.maven.dto.Student;

public class TestStudent {

	public static void main(String[] args) {
		// Save Student
		Student student = new Student();
		student.setSid(5);
		student.setName("Sandeep");
		student.setEmail("sandeep@gmail.com");
		student.setPhone("8976543223");

		StudentDao dao = new StudentDao();
		int res = dao.saveStudent(student);
		if (res > 0) {
			System.out.println("Student Added");
		} else {
			System.out.println("Not Added");
		}

		// Get Person By Id
		/*
		StudentDao dao = new StudentDao();

		Student v = dao.getStudentById(1);
		System.out.println(v);
		*/
	}

}
