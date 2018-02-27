package cn.edu.computer.classcheckin.entity.po;

import java.util.Date;

public class CheckinStudents {
    private String studentid;

    private Integer classid;

    private String studentname;

    private Integer grade;

    private String mobilephone;

    private String operator;

    private Date datachangecreatetime;

    private Date datachangelasttime;

    public String getStudentid() {
        return studentid;
    }

    public void setStudentid(String studentid) {
        this.studentid = studentid == null ? null : studentid.trim();
    }

    public Integer getClassid() {
        return classid;
    }

    public void setClassid(Integer classid) {
        this.classid = classid;
    }

    public String getStudentname() {
        return studentname;
    }

    public void setStudentname(String studentname) {
        this.studentname = studentname == null ? null : studentname.trim();
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public String getMobilephone() {
        return mobilephone;
    }

    public void setMobilephone(String mobilephone) {
        this.mobilephone = mobilephone == null ? null : mobilephone.trim();
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