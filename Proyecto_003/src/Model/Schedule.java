package Model;

import java.sql.Time;

public class Schedule {
	private int idSubject;
	private int idStudent;
	private int idTeacher;
	private Time timeStart;
	private Time timeEnd;
	private String day;

	public Schedule(int idSubject, int idStudent, int idTeacher, Time timeStart, Time timeEnd, String day) {
		super();
		this.idSubject = idSubject;
		this.idStudent = idStudent;
		this.idTeacher = idTeacher;
		this.timeStart = timeStart;
		this.timeEnd = timeEnd;
		this.day = day;
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
