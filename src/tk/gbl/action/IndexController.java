package tk.gbl.action;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import tk.gbl.bean.Admin;
import tk.gbl.bean.Teacher;
import tk.gbl.service.UserService;

@Controller
public class IndexController {

    @Autowired
    UserService userService;

    @RequestMapping("/")
    public String root() {
        return "index";
    }

    @RequestMapping("/index")
    public String index() {
        System.out.println("********index");
        return "index";
    }

    @RequestMapping("/login")
    public String login(HttpSession session, String username, String password, int type) {

        System.out.println(username+password+type);
        switch (type) {
            case -1:
                if (userService.isConformTeacher(username, password)) {
                    System.out.println("conformTeacher");
                    Teacher teacher = userService.getTeacher(username);
                    System.out.println(teacher.getStatus());
                    if (teacher.getStatus() != -1) {
                        return "index";
                    }
                    session.setAttribute("user", teacher);
                    return "redirect:teacher/";
                }
            case 0:
                if (userService.isConformAdmin(username, password)) {
                    Admin admin = userService.getAdmin(username);
                    if (admin.getStatus() != 0) {
                        return "index";
                    }
                    session.setAttribute("user", admin);
                    return "redirect:sa/";
                }
            case 1:
            case 2:
                if (userService.isConformAdmin(username, password)) {
                    Admin admin = userService.getAdmin(username);
                    if (admin.getStatus() != 1 && admin.getStatus() != 2) {
                        return "index";
                    }
                    session.setAttribute("user", admin);
                    return "redirect:admin/";
                }
        }
        return "index";
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("user");
        return "index";
    }
}
