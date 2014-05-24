package tk.gbl.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import tk.gbl.bean.Admin;
import tk.gbl.bean.MoneyInfo;
import tk.gbl.bean.Project;
import tk.gbl.service.MoneyService;
import tk.gbl.service.ProjectService;
import tk.gbl.service.UserService;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

/**
 * 4.2 院系管理员模块
 * 1、立项审核
 * 本模块使用人员是院系管理员，账号信息是由超级管理员分配的，主要实现的是针对本院系的教师提交的项目的审核，只有通过院系管理员审核通过的项目才会在校管理员管理模块出现。
 * 　　　状态信息有：通过、未通过，如果审核未通过，院系管理员需要填写相应的原因。
 * 2、项目统计
 * 　　　院系管理员可以对本院系的教师的项目信息进行查询汇总功能，实现经费统计、状态统计、项目数量统计等功能。
 *
 * 4.3 校级管理员模块
 * 1、立项审核
 * 本模块使用人员是校级管理员，账号信息是由超级管理员分配的，对于通过院系管理员审核的项目信息才能进入这个模块。
 * 状态信息有：通过、未通过，如果审核未通过，院系管理员需要填写相应的原因。
 * 2、项目统计
 * 院系管理员可以对本院系的教师的项目信息进行查询汇总功能，实现经费统计、状态统计、项目数量统计等功能。
 */

@Controller
@RequestMapping(value = "/admin")
public class AdminController {

    @Autowired
    UserService userService;
    @Autowired
    ProjectService projectService;
    @Autowired
    MoneyService moneyService;

    @RequestMapping("/")
    public String index() {
        return "admin/index";
    }

    //项目管理 审核
    @RequestMapping("/projectManager")
    public String projectManager(HttpSession session, Model model) {
        Admin admin = (Admin) session.getAttribute("user");
        List<Project> projects = null;
        if (admin.getStatus() == 0 || admin.getStatus() == 1) {
            projects = projectService.getAllProject();
        } else {
            projects = projectService.getAllProjectOfUnit(admin.getUnit());
        }
        model.addAttribute("projects",projects);
        return "admin/projectManager";
    }

    //项目管理 统计
    @RequestMapping("/projectCount")
    public String projectManagerReduce(HttpSession session, Model model) {
        Admin admin = (Admin) session.getAttribute("user");
        List<Project> projects = null;
        if (admin.getStatus() == 0 || admin.getStatus() == 1) {
            projects = projectService.getAllProject();
        } else {
            projects = projectService.getAllProjectOfUnit(admin.getUnit());
        }
        model.addAttribute("projects",projects);
        return "admin/projectCount";
    }

    //经费管理
    @RequestMapping("/moneyManager")
    public String projectMoneyManager(HttpSession session, Model model) {
        List<MoneyInfo> moneyInfos = moneyService.getAllMoneyInfo();
        model.addAttribute("moneyInfos",moneyInfos);
        return "admin/moneyManager";
    }


    @RequestMapping(value = "collegeConfirmProject" ,method = RequestMethod.GET)
    public String collegeConfirmProject(Model model,int id){
        Project project = projectService.getProject(id);
        model.addAttribute("project",project);
        return "admin/confirmProject";
    }
    @RequestMapping(value = "collegeConfirmProject" ,method = RequestMethod.POST)
    public String collegeConfirmProject(int id){
        Project project = projectService.getProject(id);
        project.setCollege_check_state(true);
        projectService.updateProject(project);
        return "redirect:/admin/projectManager";
    }
    @RequestMapping(value="collegeRefuseProject",method = RequestMethod.GET)
    public String collegeRefuseProject(Model model,int id){
        Project project = projectService.getProject(id);
        model.addAttribute("project",project);
        return "admin/refuseProject";
    }
    @RequestMapping(value="collegeRefuseProject",method = RequestMethod.POST)
    public String collegeRefuseProject(int id,String message){
        Project project = projectService.getProject(id);
        project.setReason(message);
        project.setCollege_check_state(false);
        projectService.updateProject(project);
        return "admin/refuseProject";
    }

    @RequestMapping("updateProjectSchoolState")
    public String updateProjectSchoolState(Project project) {
        projectService.updateProjectSchoolState(project);
        return null;
    }





    @RequestMapping(value = "confirmProject" ,method = RequestMethod.GET)
    public String schoolConfirmProject(Model model,int id){
        Project project = projectService.getProject(id);
        model.addAttribute("project",project);
        return "admin/confirmProject";
    }
    @RequestMapping(value = "confirmProject" ,method = RequestMethod.POST)
    public String schoolConfirmProject(HttpSession session,int id,Integer money){
        Admin admin = (Admin) session.getAttribute("user");
        Project project = projectService.getProject(id);
        if(admin.getStatus() == 1) {
            project.setSchool_check_state(true);
            MoneyInfo moneyInfo = new MoneyInfo();
            moneyInfo.setProject(project);
            moneyInfo.setMoney_limit(money);
            moneyInfo.setGive_time(new Date());
            moneyInfo.setEnd_time(new Date());
            moneyInfo.setJudge_time(new Date());
            moneyInfo.setTeacher(project.getTeacher());
            moneyInfo.setUnit(project.getUnit());
            moneyService.saveMoneyInfo(moneyInfo);
        } else {
            project.setCollege_check_state(true);
        }
        projectService.updateProject(project);
        return "redirect:/admin/projectManager";
    }
    @RequestMapping(value="refuseProject",method = RequestMethod.GET)
    public String schoolRefuseProject(Model model,int id){
        Project project = projectService.getProject(id);
        model.addAttribute("project",project);
        return "admin/refuseProject";
    }
    @RequestMapping(value="refuseProject",method = RequestMethod.POST)
    public String schoolRefuseProject(HttpSession session,int id,String message){
        Admin admin = (Admin) session.getAttribute("user");
        Project project = projectService.getProject(id);
        project.setReason(message);
        if(admin.getStatus() == 1){
            project.setSchool_check_state(false);
        } else {
            project.setCollege_check_state(false);
        }
        projectService.updateProject(project);
        return "redirect:/admin/projectManager";
    }


    @RequestMapping(value="/viewProject")
    public String viewProject(Model model,int id){
        Project project = projectService.getProject(id);
        model.addAttribute("project",project);
        return "admin/projectDetail";
    }
}
