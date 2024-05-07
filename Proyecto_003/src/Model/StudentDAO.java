package Model;

public interface StudentDAO {
	public void create(Student student);

	public Student read(int id);

	public void delete(Student student);

	public void update(Student student);
}
