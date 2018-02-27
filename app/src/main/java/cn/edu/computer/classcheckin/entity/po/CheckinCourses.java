package cn.edu.computer.classcheckin.entity.po;

import java.util.Date;

public class CheckinCourses {
    private Integer coursesid;

    private String coursename;

    private String coursedesc;

    private Integer coursecredit;

    private String teacherid;

    private Boolean isrequired;

    private String operator;

    private Date datachangecreatetime;

    private Date datachangelasttime;

    public Integer getCoursesid() {
        return coursesid;
    }

    public void setCoursesid(Integer coursesid) {
        this.coursesid = coursesid;
    }

    public String getCoursename() {
        return coursename;
    }

    public void setCoursename(String coursename) {
        this.coursename = coursename == null ? null : coursename.trim();
    }

    public String getCoursedesc() {
        return coursedesc;
    }

    public void setCoursedesc(String coursedesc) {
        this.coursedesc = coursedesc == null ? null : coursedesc.trim();
    }

    public Integer getCoursecredit() {
        return coursecredit;
    }

    public void setCoursecredit(Integer coursecredit) {
        this.coursecredit = coursecredit;
    }

    public String getTeacherid() {
        return teacherid;
    }

    public void setTeacherid(String teacherid) {
        this.teacherid = teacherid == null ? null : teacherid.trim();
    }

    public Boolean getIsrequired() {
        return isrequired;
    }

    public void setIsrequired(Boolean isrequired) {
        this.isrequired = isrequired;
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