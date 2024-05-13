package controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import model.Schedule;

public class ScheduleDAO {
	private SessionFactory sessionFactory;

	public ScheduleDAO() {
		sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	}

	public void saveSchedule(Schedule schedule) {
		try (Session session = sessionFactory.openSession()) {
			Transaction tx = session.beginTransaction();
			session.persist(schedule);
			tx.commit();
		}
	}

	public Schedule getSchedule(int id) {
		try (Session session = sessionFactory.openSession()) {
			return session.get(Schedule.class, id);
		}
	}

	public void updateSchedule(Schedule schedule) {
		try (Session session = sessionFactory.openSession()) {
			Transaction tx = session.beginTransaction();
			session.update(schedule);
			tx.commit();
		}
	}

	public void deleteSchedule(int id) {
		try (Session session = sessionFactory.openSession()) {
			Transaction tx = session.beginTransaction();
			Schedule schedule = session.get(Schedule.class, id);
			if (schedule != null) {
				session.delete(schedule);
			}
			tx.commit();
		}
	}

}
