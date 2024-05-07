package Model;

public interface SubjectDAO {
	public Subject read(int id);

	public void delete(Subject subject);

	public void update(Subject subject);

	public void create(Subject subject);
}
