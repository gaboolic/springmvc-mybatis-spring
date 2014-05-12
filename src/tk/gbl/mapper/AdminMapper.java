package tk.gbl.mapper;

import java.util.List;

import tk.gbl.bean.Admin;


public interface AdminMapper extends BaseMapper<Admin>{

	boolean isConform(String username, String password);

	Admin getByUsername(String username);

	List<Admin> getAll();
	

}
