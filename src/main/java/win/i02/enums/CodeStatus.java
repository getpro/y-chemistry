package win.i02.enums;

/**
 * Created by Qi on 2017/6/10.
 */
public enum CodeStatus {
    Success(0,""),
    ErrorParams(1,"缺少参数"),
    EmptyResult(2,"无记录"),
    ExistResult(3,"记录已存在"),
    Error(999,"未知错误")
    ;

    private int code;
    private String msg;

    private CodeStatus(int code,String msg){
        this.code = code;
        this.msg = msg;
    }

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
