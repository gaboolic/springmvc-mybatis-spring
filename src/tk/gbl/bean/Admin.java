package tk.gbl.bean;

/**
 * status:
 * 0 root
 * 1 校级
 * 2 院级
 *
 * Date: 2014-2-13
 * Time: 下午3:19:20
 *
 */
public class Admin {
	int admin_id;
	String username;
	String password;
	String realname;
	int status;
	Unit unit;
	public int getAdmin_id() {
		return admin_id;
	}
	public void setAdmin_id(int admin_id) {
		this.admin_id = admin_id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRealname() {
		return realname;
	}
	public void setRealname(String realname) {
		this.realname = realname;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Unit getUnit() {
		return unit;
	}
	public void setUnit(Unit unit) {
		this.unit = unit;
	}
}
