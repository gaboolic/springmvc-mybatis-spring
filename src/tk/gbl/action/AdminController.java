package tk.gbl.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import tk.gbl.bean.Admin;
import tk.gbl.bean.Project;
import tk.gbl.service.ProjectService;
import tk.gbl.service.UserService;

import javax.servlet.http.HttpSession;
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
        System.out.println("project"+projects.size());
        return "admin/projectManager";
    }

    //项目管理 统计
    @RequestMapping("/moneyManager")
    public String projectManagerReduce(HttpSession session, Model model) {
        Admin admin = (Admin) session.getAttribute("user");
        List<Project> projects = null;
        if (admin.getStatus() == 0) {
            projects = projectService.getAllProject();
        } else {
            projects = projectService.getAllProjectOfUnit(admin.getUnit());
        }
        model.addAttribute("projects",projects);
        return "admin/moneyManager";
    }

    @RequestMapping("updateProjectCollegeState")
    public String updateProjectCollegeState(Project project) {
        projectService.updateProjectCollegeState(project);
        return null;
    }

    @RequestMapping("updateProjectSchoolState")
    public String updateProjectSchoolState(Project project) {
        projectService.updateProjectSchoolState(project);
        return null;
    }

}
