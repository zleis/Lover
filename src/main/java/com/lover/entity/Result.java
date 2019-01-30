package com.lover.entity;

/**
 * @Class Result
 * @Author ZLei
 * @Date 2019/1/6
 * @TODO 返回消息
 */
public class Result {
    private int feedback;   // 返回code信息
    private Object obj;     // 返回的对象
    private String msg;     // 状态消息

    public Result() {
    }

    public Result(int feedback, Object obj, String msg) {
        this.feedback = feedback;
        this.obj = obj;
        this.msg = msg;
    }

    public int getFeedback() {
        return feedback;
    }

    public void setFeedback(int feedback) {
        this.feedback = feedback;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public static Result resultFactory(Feedback feedback){
        Result result = new Result();
        result.feedback = feedback.getFeedback();
        result.msg = feedback.getComment();
        return result;
    }

    @Override
    public String toString() {
        return "Result{" +
                "feedback=" + feedback +
                ", obj=" + obj +
                ", msg='" + msg + '\'' +
                '}';
    }
}
