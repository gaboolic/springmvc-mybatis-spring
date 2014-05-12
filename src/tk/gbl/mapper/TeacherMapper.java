package tk.gbl.mapper;

import tk.gbl.bean.Teacher;

public interface TeacherMapper extends BaseMapper<Teacher>{
	public void ttt();

	public boolean isConform(String username, String password);

	public Teacher getByUsername(String username);
}
