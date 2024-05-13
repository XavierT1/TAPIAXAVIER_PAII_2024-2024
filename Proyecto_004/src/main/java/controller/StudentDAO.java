package controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import model.Student;

public class StudentDAO {
	private SessionFactory sessionFactory;

	public StudentDAO() {
		sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	}

	public void saveStudent(Student student) {
		try (Session session = sessionFactory.openSession()) {
			Transaction tx = session.beginTransaction();
			session.persist(student);
			tx.commit();
		}
	}

	public Student getStudent(int id) {
		try (Session session = sessionFactory.openSession()) {
			return session.get(Student.class, id);
		}
	}

	public void updateStudent(Student student) {
		try (Session session = sessionFactory.openSession()) {
			Transaction tx = session.beginTransaction();
			session.update(student);
			tx.commit();
		}
	}

	public void deleteStudent(int id) {
		try (Session session = sessionFactory.openSession()) {
			Transaction tx = session.beginTransaction();
			Student student = session.get(Student.class, id);
			if (student != null) {
				session.delete(student);
			}
			tx.commit();
		}
	}
}
