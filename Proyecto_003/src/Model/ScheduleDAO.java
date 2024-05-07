package Model;

public interface ScheduleDAO {
	public Schedule read(int id);

	public void create(Schedule schedule);

	public void delete(Schedule schedule);

	public void update(Schedule schedule);
}
