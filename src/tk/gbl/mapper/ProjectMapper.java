package tk.gbl.mapper;

import tk.gbl.bean.Project;
import tk.gbl.bean.Teacher;
import tk.gbl.bean.Unit;

import java.util.List;

public interface ProjectMapper extends BaseMapper<Project>{

    List<Project> getAllOfUnit(Unit unit);

    List<Project> getAllOfTeacher(Teacher teacher);
}
