package Model;

public interface TeacherDAO {
	public void create(Teacher teacher);

	public Teacher read(int id);

	public void delete(Teacher teacher);

	public void update(Teacher teacher);
}
