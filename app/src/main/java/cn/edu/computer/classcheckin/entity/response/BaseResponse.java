package cn.edu.computer.classcheckin.entity.response;


/**
 * @auther panfei
 * @date 2018/2/22
 */
public class BaseResponse {

    private int code;
    private String msg;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
