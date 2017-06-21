package win.i02.bean;

import win.i02.enums.CodeStatus;

/**
 * 返回结果
 * Created by Qi on 2017/6/10.
 */
public class BaseResultBean {
    protected int code;
    protected String msg;
    protected Object result;

    public BaseResultBean(int code, String msg, Object result) {
        this.code = code;
        this.msg = msg;
        this.result = result;
    }

    public BaseResultBean(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public BaseResultBean(CodeStatus codeStatus){
        this.code=codeStatus.getCode();
        this.msg=codeStatus.getMsg();
    }

    public BaseResultBean(Object result) {
        this.result = result;
        this.code=200;
    }

    public BaseResultBean(int code) {
        this.code = code;
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

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }
}
