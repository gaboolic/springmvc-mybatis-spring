package tk.gbl.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import tk.gbl.bean.Project;
import tk.gbl.bean.Teacher;
import tk.gbl.bean.Unit;
import tk.gbl.service.ProjectService;
import tk.gbl.service.UnitService;
import tk.gbl.service.UserService;

import java.util.Date;
import java.util.List;

/**
 * 教师模块
 * 1、立项提交 本模块的使用人员是教师，系统预设教师编号为登录名（密码也是教师编号），
 * 每个教师都属于河北科技师范学院的某个院系。教师进行登录实现立项信息添加工作，
 * 需要上传立项申请书，完成立项工作，在此立项人员需要填写关于项目的相关信息如下：
 * 申报项目类别、项目名称、承担单位、主持人、持人手机、申报日期、申请经费、
 * 开始日期、结束日期八项，完成提供工作后项目的院系审核状态以及校审核状态均为“未审核”，
 * 项目进度状态为“立项提交”。
 * 2、项目状态更新
 * 这是指的经过校级管理员审核通过的项目
 * ，立项主持人可以更改项目进展状态，没经过院系管理员以及校管理员通过的项目无法进行更改，
 * 更改的状态有：立项成功、中期审核、结题等。
 * 3项目维护
 * 　　　这是教师对自己负责项目的管理，包括修改、删除，但是已经经过院系审核或校级审核的
 * 项目不能进行删除。
 */

@Controller
@RequestMapping(value = "/teacher")
public class TeacherController {

    @Autowired
    UserService userService;
    @Autowired
    ProjectService projectService;
    @Autowired
    UnitService unitService;

    @RequestMapping("/")
    public String index() {
        return "teacher/teacher_index";
    }

    @RequestMapping("/projectManager")
    public String projectList(Model model, HttpSession session) {
        Teacher user = (Teacher) session.getAttribute("user");
        List<Project> projects = projectService.getAllOfTeacher(user);
        model.addAttribute("projects", projects);
        return "teacher/projectManager";
    }

    //立项提交
    @RequestMapping(value = "/addProject", method = RequestMethod.GET)
    public String addProject(Model model) {
        List<Unit> units = unitService.getAllUnit();
        model.addAttribute("units",units);
        return "teacher/projectAdd";
    }

    @RequestMapping(value = "/addProject", method = RequestMethod.POST)
    public String addProject(Project project, HttpSession session) {
        Teacher teacher = (Teacher) session.getAttribute("user");
        project.setTeacher(teacher);
        Unit unit = teacher.getUnit();
        project.setUnit(unit);
        project.setApply_date(new Date());
        System.out.println(project.getStart_date());
        projectService.addProject(project);
        return "redirect:/teacher/projectManager";
    }

    //修改
    @RequestMapping(value = "/updateProject", method = RequestMethod.GET)
    public String updateProject(int id, Model model) {
        Project project = projectService.getProject(id);
        model.addAttribute("project", project);
        List<Unit> units = unitService.getAllUnit();
        model.addAttribute("units",units);
        return "teacher/projectUpdate";
    }

    @RequestMapping(value = "/updateProject", method = RequestMethod.POST)
    public String updateProject(HttpSession session, Project project) {
        Teacher teacher = (Teacher) session.getAttribute("user");
        project.setTeacher(teacher);
        projectService.updateProject(project);
        return "redirect:/teacher/projectManager";
    }

    @RequestMapping(value = "/viewProject")
    public String viewProject(Model model, int id) {
        Project project = projectService.getProject(id);
        model.addAttribute("project", project);
        return "teacher/projectDetail";
    }


    //项目状态更新
    @RequestMapping(value = "/updateProjectState", method = RequestMethod.GET)
    public String updateProjectState(Model model, int id) {
        Project project = projectService.getProject(id);
        model.addAttribute("project", project);
        return "teacher/projectUpdateState";
    }

    @RequestMapping(value = "/updateProjectState", method = RequestMethod.POST)
    public String updateProjectState(Project project) {
        projectService.updateProjectState(project);
        return "redirect:/teacher/projectManager";
    }

    //删除
    @RequestMapping("/deleteProject")
    public String deleteProject(int id) {
        projectService.deleteProject(id);
        return "redirect:/teacher/projectManager";
    }
}
