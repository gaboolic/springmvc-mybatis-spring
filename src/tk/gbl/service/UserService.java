package tk.gbl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tk.gbl.bean.Admin;
import tk.gbl.bean.Teacher;
import tk.gbl.mapper.AdminMapper;
import tk.gbl.mapper.TeacherMapper;
import tk.gbl.mapper.UnitMapper;





@Service("userService")
public class UserService {
	@Autowired
	AdminMapper adminMapper;
	
	@Autowired
	TeacherMapper teacherMapper;
	
	@Autowired
	UnitMapper unitMapper;

	public void addAdmin(Admin admin){
		adminMapper.save(admin);
	}
	
	public Admin getAdmin(int id){
		return adminMapper.get(id);
	}
	
	public void updateAdmin(Admin admin){
		adminMapper.update(admin);
	}
	
	public void deleteAdmin(int id){
		adminMapper.delete(id);
	}
 
	public void addTeacher(Teacher teacher) {
		teacherMapper.save(teacher);
	}

	public void updateTeacher(Teacher teacher) {
		teacherMapper.update(teacher);
	}

	public Teacher getTeacher(int id) {
		return teacherMapper.get(id);
	}

	public void deleteTeacher(int id) {
		teacherMapper.delete(id);
	}

	public boolean isConformTeacher(String username, String password) {
		return teacherMapper.getByUsername(username).getPassword().equals(password);
	}
	
	public boolean isExistTeacher(String username){
		return teacherMapper.getByUsername(username)!=null;
	}

	public boolean isConformAdmin(String username, String password) {
		return adminMapper.getByUsername(username).getPassword().equals(password);
	}
	
	public boolean isExistAdmin(String username){
		return adminMapper.getByUsername(username)!=null;
	}

	public Teacher getTeacher(String username) {
		return teacherMapper.getByUsername(username);
	}

	public Admin getAdmin(String username) {
		return adminMapper.getByUsername(username);
	}

	public List<Admin> getAllAdmin() {
		return adminMapper.getAll();
	}

    public List<Teacher> getAllTeacher() {
        return teacherMapper.getAll();
    }
}
