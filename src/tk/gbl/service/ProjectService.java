package tk.gbl.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.gbl.bean.Project;
import tk.gbl.bean.Teacher;
import tk.gbl.bean.Unit;
import tk.gbl.mapper.AdminMapper;
import tk.gbl.mapper.ProjectMapper;
import tk.gbl.mapper.TeacherMapper;
import tk.gbl.mapper.UnitMapper;

import java.util.List;

@Service("projectService")
public class ProjectService {
	@Autowired
	AdminMapper adminMapper;
	
	@Autowired
	TeacherMapper teacherMapper;
	
	@Autowired
	UnitMapper unitMapper;
	
	@Autowired
	ProjectMapper projectMapper;

	public void addProject(Project project) {
		projectMapper.save(project);
	}

	public Project getProject(int project_id) {
		return projectMapper.get(project_id);
	}

	public void updateProject(Project p) {
		projectMapper.update(p);
	}

	public void deleteProject(int id) {
		projectMapper.delete(id);
	}

	public void updateProjectState(Project project) {
		Project p = projectMapper.get(project.getProject_id());
		p.setState(project.getState());
		projectMapper.update(p);
	}

	public void updateProjectCollegeState(Project project) {
		Project p = projectMapper.get(project.getProject_id());
		p.setCollege_check_state(project.isCollege_check_state());
		projectMapper.update(p);
	}

	public void updateProjectSchoolState(Project project) {
		Project p = projectMapper.get(project.getProject_id());
		p.setSchool_check_state(project.isSchool_check_state());
		projectMapper.update(p);
	}

    public List<Project> getAllProject() {
        return projectMapper.getAll();
    }

    public List<Project> getAllProjectOfUnit(Unit unit) {
        return projectMapper.getAllOfUnit(unit);
    }

    public List<Project> getAllOfTeacher(Teacher teacher) {
        return projectMapper.getAllOfTeacher(teacher);
    }
}
