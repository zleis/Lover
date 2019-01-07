package com.lover.entity;

public enum Feedback {
    FEEDBACK_SUCCESS(10000, "请求成功"),
    FEEDBACK_USER_NO_EXIT(10001, "用户不存在"),
    FEEDBACK_PASS_ERROR(10002, "密码错误")
//    FEEDBACK
    ,
    ;

    private int feedback;
    private String comment;

    Feedback(int feedback, String comment) {
        this.feedback = feedback;
        this.comment = comment;
    }

    public int getFeedback() {
        return feedback;
    }

    public void setFeedback(int feedback) {
        this.feedback = feedback;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
