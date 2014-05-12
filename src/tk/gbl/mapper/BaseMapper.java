package tk.gbl.mapper;

import java.util.List;



public interface BaseMapper<T> {
	void save(T T);
	void delete(int id);
	void update(T T);
	T get(int id);
	List<T> getAll();
}
