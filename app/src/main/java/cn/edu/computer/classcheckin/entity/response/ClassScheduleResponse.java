package cn.edu.computer.classcheckin.entity.response;


import java.util.Date;
import java.util.List;

import cn.edu.computer.classcheckin.entity.dto.CourseScheduleDTO;

/**
 * @auther panfei
 * @date 2018/2/22
 */
public class ClassScheduleResponse extends BaseResponse{

    private List<CourseScheduleDTO> courses;

    private Date queryDate;

    public List<CourseScheduleDTO> getCourses() {
        return courses;
    }

    public void setCourses(List<CourseScheduleDTO> courses) {
        this.courses = courses;
    }

    public Date getQueryDate() {
        return queryDate;
    }

    public void setQueryDate(Date queryDate) {
        this.queryDate = queryDate;
    }
}
