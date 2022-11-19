package com.GL.StudentBookingpr.DAO;

import java.util.List;

import com.GL.StudentBookingpr.Model.Student;

public interface DAO {

	public void save(Student student);

	public void Delete(int id);

	public Student findbyid(int id);

	public List<Student> findAll();

	

}
