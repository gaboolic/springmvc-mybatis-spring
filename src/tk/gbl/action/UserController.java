package tk.gbl.action;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import tk.gbl.service.UserService;

@Controller
@RequestMapping(value="/user")
public class UserController {

	@Autowired
	UserService userService;
	
//
//	@RequestMapping(method = RequestMethod.GET)
//	public String toRegister(Model model){
//		model.addAttribute(new User());
//		return "user_index";
//	}
//	
//	
//	@RequestMapping("/hello")
//	public String hello() {
//		System.out.println("user/hello");
//
//		return "hello";
//	}
//	
//	
//	@RequestMapping(value="{username}", method=RequestMethod.GET)
//	public String getView(@PathVariable String username, Model model) {
//		User user = new User();
//		user.setUsername("111");
//		user.setPassword("psw");
//		
//		user = userService.selectUser(username);
//		model.addAttribute(user);
//		return "user";
//	}
//	
//	@RequestMapping(value="add/{username}", method=RequestMethod.GET)
//	public String addUser(@PathVariable String username, Model model) {
//		User user = new User();
//		user.setUsername(username);
//		user.setPassword("psw");
//		
//		userService.insertUser(user);
//		model.addAttribute(user);
//		return "user";
//	}
}
