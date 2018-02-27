package cn.edu.computer.classcheckin.entity.po;

import java.util.Date;

public class CheckinClass {
    private Integer classid;

    private String classname;

    private Integer studentcount;

    private String classteacherid;

    private String classmonitorid;

    private String operator;

    private Date datachangecreatetime;

    private Date datachangelasttime;

    public Integer getClassid() {
        return classid;
    }

    public void setClassid(Integer classid) {
        this.classid = classid;
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname == null ? null : classname.trim();
    }

    public Integer getStudentcount() {
        return studentcount;
    }

    public void setStudentcount(Integer studentcount) {
        this.studentcount = studentcount;
    }

    public String getClassteacherid() {
        return classteacherid;
    }

    public void setClassteacherid(String classteacherid) {
        this.classteacherid = classteacherid == null ? null : classteacherid.trim();
    }

    public String getClassmonitorid() {
        return classmonitorid;
    }

    public void setClassmonitorid(String classmonitorid) {
        this.classmonitorid = classmonitorid == null ? null : classmonitorid.trim();
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