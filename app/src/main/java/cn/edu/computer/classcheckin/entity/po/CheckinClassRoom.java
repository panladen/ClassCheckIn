package cn.edu.computer.classcheckin.entity.po;

import java.util.Date;

public class CheckinClassRoom {
    private Integer roomid;

    private String roomno;

    private String campus;

    private Integer roomseatcount;

    private Boolean projector;

    private Integer width;

    private Integer length;

    private String operator;

    private Date datachangecreatetime;

    private Date datachangelasttime;

    public Integer getRoomid() {
        return roomid;
    }

    public void setRoomid(Integer roomid) {
        this.roomid = roomid;
    }

    public String getRoomno() {
        return roomno;
    }

    public void setRoomno(String roomno) {
        this.roomno = roomno == null ? null : roomno.trim();
    }

    public String getCampus() {
        return campus;
    }

    public void setCampus(String campus) {
        this.campus = campus == null ? null : campus.trim();
    }

    public Integer getRoomseatcount() {
        return roomseatcount;
    }

    public void setRoomseatcount(Integer roomseatcount) {
        this.roomseatcount = roomseatcount;
    }

    public Boolean getProjector() {
        return projector;
    }

    public void setProjector(Boolean projector) {
        this.projector = projector;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
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