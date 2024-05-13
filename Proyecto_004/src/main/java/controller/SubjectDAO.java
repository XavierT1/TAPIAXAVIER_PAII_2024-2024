package controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import model.Subject;

public class SubjectDAO {
	private SessionFactory sessionFactory;

	public SubjectDAO() {
		sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	}

	public void saveSubject(Subject subject) {
		try (Session session = sessionFactory.openSession()) {
			Transaction tx = session.beginTransaction();
			session.persist(subject);
			tx.commit();
		}
	}

	public Subject getSubject(int id) {
		try (Session session = sessionFactory.openSession()) {
			return session.get(Subject.class, id);
		}
	}

	public void updateSubject(Subject subject) {
		try (Session session = sessionFactory.openSession()) {
			Transaction tx = session.beginTransaction();
			session.update(subject);
			tx.commit();
		}
	}

	public void deleteSubject(int id) {
		try (Session session = sessionFactory.openSession()) {
			Transaction tx = session.beginTransaction();
			Subject subject = session.get(Subject.class, id);
			if (subject != null) {
				session.delete(subject);
			}
			tx.commit();
		}
	}
}
