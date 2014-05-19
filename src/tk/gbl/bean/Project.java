package tk.gbl.bean;

import java.util.Date;

/**
 * create table project(
 * project_id int primary key auto_increment,
 * type int comment '申报项目类别',
 * name varchar(255) comment '项目名称',
 * unit_id int comment '单位',
 * teacher_id int comment '申报人',
 * //参加人员
 * phone int comment '申报人手机',
 * apply_date datetime comment '申报日期',
 * apply_money int comment '申请经费',
 * //经费使用
 * start_date datetime comment '开始日期',
 * end_date datetime comment '结束日期',
 * college_check_state int comment '院系审核状态',
 * school_check_state int comment '校审核状态',
 * state int comment '项目进度状态',
 *
 * FOREIGN KEY (unit_id) REFERENCES unit(unit_id),
 * FOREIGN KEY (teacher_id) REFERENCES teacher(teacher_id)
 * );
 *
 * @author Don'T
 *         2014-1-23
 */
public class Project {
    private int project_id;
    private int type;
    private String name;
    private Unit unit;
    private Teacher teacher;
    private int phone;
    private Date apply_date;
    private int apply_money;
    private Date start_date;
    private Date end_date;
    private boolean college_check_state;


    boolean school_check_state;
    int state;
    /**
     * 拒绝原因
     */
    String reason;

    public int getProject_id() {
        return project_id;
    }

    public void setProject_id(int project_id) {
        this.project_id = project_id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public Date getApply_date() {
        return apply_date;
    }

    public void setApply_date(Date apply_date) {
        this.apply_date = apply_date;
    }

    public int getApply_money() {
        return apply_money;
    }

    public void setApply_money(int apply_money) {
        this.apply_money = apply_money;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }

    public boolean isCollege_check_state() {
        return college_check_state;
    }

    public void setCollege_check_state(boolean college_check_state) {
        this.college_check_state = college_check_state;
    }

    public boolean isSchool_check_state() {
        return school_check_state;
    }

    public void setSchool_check_state(boolean school_check_state) {
        this.school_check_state = school_check_state;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
