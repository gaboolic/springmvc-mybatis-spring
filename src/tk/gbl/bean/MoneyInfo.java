package tk.gbl.bean;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * create table money_info(
 * money_info_id int primary key auto_increment,
 * unit_id int comment '院系',
 * teacher_id int comment '教师',
 * project_id int comment '项目',
 * judge_time datetime comment '评定时间',
 * end_time datetime comment '结项时间',
 * money_limit int comment '经费额度',
 * give_time datetime comment '划拨时间',
 * money_from varchar(255) comment '经费来源',
 * reimburse_time datetime comment '报销时间',
 * reimburse_abstract varchar(255) comment '报销摘要',
 * reimburse_money int comment '报销金额',
 * remain_money int comment '结余金额',
 * description text comment '备注',
 *
 * FOREIGN KEY (unit_id) REFERENCES unit(unit_id),
 * FOREIGN KEY (teacher_id) REFERENCES teacher(teacher_id),
 * FOREIGN KEY (project_id) REFERENCES project(project_id)
 * );
 *
 * @author Don'T
 *         2014-1-23
 */
public class MoneyInfo {
    private int money_info_id;

    private Unit unit;

    private Teacher teacher;

    private Project project;

    private Date judge_time;

    private Date end_time;

    private int money_limit;

    private Date give_time;

    private String money_from;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date reimburse_time;

    private String reimburse_abstract;

    private int remain_money;

    private String description;

    public int getMoney_info_id() {
        return money_info_id;
    }

    public void setMoney_info_id(int money_info_id) {
        this.money_info_id = money_info_id;
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

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Date getJudge_time() {
        return judge_time;
    }

    public void setJudge_time(Date judge_time) {
        this.judge_time = judge_time;
    }

    public Date getEnd_time() {
        return end_time;
    }

    public void setEnd_time(Date end_time) {
        this.end_time = end_time;
    }

    public int getMoney_limit() {
        return money_limit;
    }

    public void setMoney_limit(int money_limit) {
        this.money_limit = money_limit;
    }

    public Date getGive_time() {
        return give_time;
    }

    public void setGive_time(Date give_time) {
        this.give_time = give_time;
    }

    public String getMoney_from() {
        return money_from;
    }

    public void setMoney_from(String money_from) {
        this.money_from = money_from;
    }

    public Date getReimburse_time() {
        return reimburse_time;
    }

    public void setReimburse_time(Date reimburse_time) {
        this.reimburse_time = reimburse_time;
    }

    public String getReimburse_abstract() {
        return reimburse_abstract;
    }

    public void setReimburse_abstract(String reimburse_abstract) {
        this.reimburse_abstract = reimburse_abstract;
    }

    public int getRemain_money() {
        return remain_money;
    }

    public void setRemain_money(int remain_money) {
        this.remain_money = remain_money;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
