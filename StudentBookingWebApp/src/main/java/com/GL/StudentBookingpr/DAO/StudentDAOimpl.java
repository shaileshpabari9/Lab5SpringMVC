package com.GL.StudentBookingpr.DAO;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.GL.StudentBookingpr.Model.Student;

@Repository
public class StudentDAOimpl implements DAO {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	@Transactional
	public void save(Student student) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(student);

	}

	@Override
	@Transactional
	public void Delete(int id) {
		Session session = sessionFactory.getCurrentSession();
		Student student = session.get(Student.class, id);
		session.delete(student);

	}

	@Override
	@Transactional
	public Student findbyid(int id) {
		Session session = sessionFactory.getCurrentSession();
		Student student = session.get(Student.class, id);
		return student;
	}

	@Override
	@Transactional
	public List<Student> findAll() {
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("deprecation")
		Criteria criteria = session.createCriteria(Student.class);
		return criteria.list();
	}

}
