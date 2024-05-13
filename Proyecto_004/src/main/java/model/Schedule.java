package model;

import java.sql.Time;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "schedule")
public class Schedule {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "idSubject")
	private int idSubject;

	@Column(name = "idStudent")
	private int idStudent;

	@Column(name = "idTeacher")
	private int idTeacher;

	@Column(name = "timeStart")
	private Time timeStart;

	@Column(name = "timeEnd")
	private Time timeEnd;

	@Column(name = "day")
	private String day;

	public Schedule() {

	}

	public Schedule(int id, int idSubject, int idStudent, int idTeacher, Time timeStart, Time timeEnd, String day) {
		super();
		this.id = id;
		this.idSubject = idSubject;
		this.idStudent = idStudent;
		this.idTeacher = idTeacher;
		this.timeStart = timeStart;
		this.timeEnd = timeEnd;
		this.day = day;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdSubject() {
		return idSubject;
	}

	public void setIdSubject(int idSubject) {
		this.idSubject = idSubject;
	}

	public int getIdStudent() {
		return idStudent;
	}

	public void setIdStudent(int idStudent) {
		this.idStudent = idStudent;
	}

	public int getIdTeacher() {
		return idTeacher;
	}

	public void setIdTeacher(int idTeacher) {
		this.idTeacher = idTeacher;
	}

	public Time getTimeStart() {
		return timeStart;
	}

	public void setTimeStart(Time timeStart) {
		this.timeStart = timeStart;
	}

	public Time getTimeEnd() {
		return timeEnd;
	}

	public void setTimeEnd(Time timeEnd) {
		this.timeEnd = timeEnd;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

}
