package tk.gbl.action;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import tk.gbl.bean.Admin;
import tk.gbl.bean.Teacher;
import tk.gbl.bean.Unit;
import tk.gbl.service.UnitService;
import tk.gbl.service.UserService;

/**
4.4 超级管理员模块
1、系统设定
　　　   超级管理员账号采用固化用户名的形式，可以更改密码，整个系统只有一个超级管理员“admin”，负责整个系统的信息设定。
2、教师信息维护
　　　   可以实现有的教师账号信息进行删除操作，需要注意的是删除教师账号的同时就会删除对就该教师的项目的所有信息，且不能找回。
　　　  可以添加新的教师账号信息，提供的信息有：用户名、密码、所属单位、真实姓名四项。
3、院系管理员信息维护
　　　  可以对现有的院系管理员账号信息进行删除操作，需要注意的是删除院系管理员账号不会删除对应该院系的所有教师的项目的信息。
　　　 可以添加新的院系管理员账号信息，提供的信息有：用户名、密码、所属单位、真实姓名四项。
4、校级管理员信息维护
　　　   可以对现有的校级管理员账号信息进行删除操作，需要注意的是删除院系管理员账号不会删除任何项目的信息。
　　　  可以添加新的校级管理员账号信息，提供的信息有：用户名、密码、所属单位、真实姓名四项。
5、单位信息维护
　　　   由于教师的所属单位信息（即教师是属于哪个院系的）很重要，超级管理员机可以对单位信息进行增删改的操作，删除一个单位会同时删除属于这个单位的所有管理账号信息（教师、院系管理员、校级管理员）。
6、数据库维护
　　　  整个系统的数据库的备份、还原操作。
 */
 

@Controller
@RequestMapping(value="/sa")
public class SuperAdminController {

	@Autowired
	UserService userService;
	@Autowired
	UnitService unitService;
	
	@RequestMapping("/")
	public String index(){
		return "sa/sa_index";
	}
	//修改sa密码
	@RequestMapping(value="/saManager",method = RequestMethod.GET)
	public String saManager(Model model){
        Admin admin = userService.getAdmin("admin");
        model.addAttribute("admin",admin);
		return "sa/saManager";
	}
    //修改sa密码
    @RequestMapping(value="/updateSA",method = RequestMethod.POST)
    public String updateSA(Admin admin){
        String password = admin.getPassword();
        if(password != null){
            Admin a = userService.getAdmin("admin");
            a.setPassword(admin.getPassword());
            userService.updateAdmin(a);
        }
        return "sa/saManager";
    }
	
	//院校级管理员管理首页
	@RequestMapping("/adminManager")
	public String adminManager(Model model){
        List<Admin> admins = userService.getAllAdmin();
        model.addAttribute("admins",admins);
		return "sa/adminManager";
	}
    //增加院校管理员
    @RequestMapping(value="/addAdmin",method = RequestMethod.GET)
    public String addAdmin(){
        return "/sa/addAdmin";
    }
	//增加院校管理员
    @RequestMapping(value="/addAdmin",method = RequestMethod.POST)
	public String addAdmin(HttpSession session,Admin admin){
		Admin user = (Admin) session.getAttribute("user");
		System.out.println(user.getUsername());
		System.out.println(user.getStatus());
		if(user == null || user.getStatus() != 0) {
			return "/error";
		}
		if(admin.getUsername() == null) {
			return "/sa/addAdmin";
		}
		userService.addAdmin(admin);
        return "redirect:/sa/adminManager";
	}
	//修改院校管理员
	@RequestMapping(value="/updateAdmin",method = RequestMethod.GET)
	public String updateAdmin(int id,Model model){
        Admin admin = userService.getAdmin(id);
        model.addAttribute("admin",admin);
		return "/sa/updateAdmin";
	}
    //修改院校管理员
    @RequestMapping(value="/updateAdmin",method = RequestMethod.POST)
    public String updateAdmin(Admin admin){

        userService.updateAdmin(admin);
        return "redirect:/sa/adminManager";
    }
	//查询院校管理员
	@RequestMapping("/getAdmin")
	public String getAdmin(int id){
		Admin admin = userService.getAdmin(id);
		System.out.println(admin.getUsername());
		System.out.println(admin.getUnit().getName());
		return null;
	}
	//查询出所有院校管理员
	@RequestMapping("/getAllAdmin")
	public String getAllAdmin(){
		List<Admin> admins = userService.getAllAdmin();
		System.out.println(admins.size());
		return null;
	}
	//删除
	@RequestMapping("/deleteAdmin")
	public String deleteAdmin(int id){
		userService.deleteAdmin(id);
        return "redirect:/sa/adminManager";
	}

	//教师管理首页
	@RequestMapping("/teacherManager")
	public String teacherManager(Model model){
        List<Teacher> teachers = userService.getAllTeacher();
        model.addAttribute("teachers",teachers);
		return "sa/teacherManager";
	}
	@RequestMapping("/addTeacher")
	public String addTeacher(Teacher teacher){
		if(teacher.getUsername() == null) {
			return "/admin/addTeacher_input";
		}
		System.out.println(teacher.getUsername());
		
		userService.addTeacher(teacher);
		
		return "sa/teacherManager";
	}
	
	@RequestMapping("/updateTeacher")
	public String updateTeacher(Teacher teacher){
		if(teacher.getUsername() == null) {
			return "/admin/addTeacher_input";
		}
		System.out.println(teacher.getTeacher_id());
		System.out.println(teacher.getUsername());
		System.out.println(teacher.getPassword());
		userService.updateTeacher(teacher);
		
		return "sa/teacherManager";
	
	}
	@RequestMapping("/getTeacher")
	public String getTeacher(int id){
		Teacher teacher = userService.getTeacher(id);
		System.out.println(teacher.getUsername());
		System.out.println(teacher.getUnit().getName());
		return "sa/teacherManager";
	
	}
	
	@RequestMapping("/deleteTeacher")
	public String deleteTeacher(int id){
		userService.deleteTeacher(id);
		return "sa/teacherManager";
	
	}
	
	
	//单位管理首页
	@RequestMapping("/unitManager")
	public String unitManager(Model model){
        List<Unit> units = unitService.getAllUnit();
        model.addAttribute("units",units);
		return "sa/unitManager";
	}
	@RequestMapping("/addUnit")
	public String addUnit(Unit unit){
		unitService.addUnit(unit);
		return "sa/unitManager";
	}
	@RequestMapping("/deleteUnit")
	public String deleteUnit(int id){
		unitService.deleteUnit(id);
		return "sa/unitManager";
	}
	@RequestMapping("/updateUnit")
	public String updateUnit(Unit unit){
		unitService.updateUnit(unit);
		return "sa/unitManager";
	}
}