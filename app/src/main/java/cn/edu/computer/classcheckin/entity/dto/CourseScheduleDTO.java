package cn.edu.computer.classcheckin.entity.dto;


import java.util.Date;

import cn.edu.computer.classcheckin.entity.po.CheckinCourses;

/**
 * @auther panfei
 * @date 2018/2/23
 */
public class CourseScheduleDTO extends CheckinCourses {

    private Boolean hasChecked;

    private Date date;

    public Boolean getHasChecked() {
        return hasChecked;
    }

    public void setHasChecked(Boolean hasChecked) {
        this.hasChecked = hasChecked;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
