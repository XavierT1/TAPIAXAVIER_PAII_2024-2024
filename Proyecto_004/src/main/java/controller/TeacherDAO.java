package controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import model.Teacher;

public class TeacherDAO {
	private SessionFactory sessionFactory;

	public TeacherDAO() {
		sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	}

	public void saveTeacher(Teacher teacher) {
		try (Session session = sessionFactory.openSession()) {
			Transaction tx = session.beginTransaction();
			session.persist(teacher);
			tx.commit();
		}
	}

	public Teacher getTeacher(int id) {
		try (Session session = sessionFactory.openSession()) {
			return session.get(Teacher.class, id);
		}
	}

	public void updateTeacher(Teacher teacher) {
		try (Session session = sessionFactory.openSession()) {
			Transaction tx = session.beginTransaction();
			session.update(teacher);
			tx.commit();
		}
	}

	public void deleteTeacher(int id) {
		try (Session session = sessionFactory.openSession()) {
			Transaction tx = session.beginTransaction();
			Teacher teacher = session.get(Teacher.class, id);
			if (teacher != null) {
				session.delete(teacher);
			}
			tx.commit();
		}
	}
}
