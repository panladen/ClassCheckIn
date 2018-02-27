package cn.edu.computer.classcheckin.entity.po;

import java.util.Date;

public class CheckinLog {
    private Long logid;

    private Integer scheduleid;

    private Integer planorder;

    private String studentid;

    private Date checkdate;

    private String operator;

    private Date datachangecreatetime;

    private Date datachangelasttime;

    public Long getLogid() {
        return logid;
    }

    public void setLogid(Long logid) {
        this.logid = logid;
    }

    public Integer getScheduleid() {
        return scheduleid;
    }

    public void setScheduleid(Integer scheduleid) {
        this.scheduleid = scheduleid;
    }

    public Integer getPlanorder() {
        return planorder;
    }

    public void setPlanorder(Integer planorder) {
        this.planorder = planorder;
    }

    public String getStudentid() {
        return studentid;
    }

    public void setStudentid(String studentid) {
        this.studentid = studentid == null ? null : studentid.trim();
    }

    public Date getCheckdate() {
        return checkdate;
    }

    public void setCheckdate(Date checkdate) {
        this.checkdate = checkdate;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator == null ? null : operator.trim();
    }

    public Date getDatachangecreatetime() {
        return datachangecreatetime;
    }

    public void setDatachangecreatetime(Date datachangecreatetime) {
        this.datachangecreatetime = datachangecreatetime;
    }

    public Date getDatachangelasttime() {
        return datachangelasttime;
    }

    public void setDatachangelasttime(Date datachangelasttime) {
        this.datachangelasttime = datachangelasttime;
    }
}