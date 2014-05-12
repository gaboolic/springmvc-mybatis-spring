package tk.gbl.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tk.gbl.mapper.AdminMapper;
import tk.gbl.mapper.MoneyInfoMapper;
import tk.gbl.mapper.ProjectMapper;
import tk.gbl.mapper.TeacherMapper;
import tk.gbl.mapper.UnitMapper;

@Service("moneyService")
public class MoneyService {
	@Autowired
	AdminMapper adminMapper;
	
	@Autowired
	TeacherMapper teacherMapper;
	
	@Autowired
	UnitMapper unitMapper;
	
	@Autowired
	ProjectMapper projectMapper;
	
	@Autowired
	MoneyInfoMapper moneyInfoMapper;
}
