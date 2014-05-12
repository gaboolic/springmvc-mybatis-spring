package tk.gbl.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import tk.gbl.service.MoneyService;

/**
 * 4.5 教学经费管理
 * 数据库字段包括：院系、教师、项目名称、项目级别、评定时间、结项时间、经费额度、划拨时间、经费来源、报销时期、报销摘要、报销金额、结余金额、备注
 */

@Controller
@RequestMapping(value="/money")
public class MoneyController {
	MoneyService moneyService;
	
	@RequestMapping("/")
	public String index(){
		return "money/money_index";
	}
	
	@RequestMapping("moneyManager")
	public String moneyManager(){
		return "money/moneyManager";
	}
}
