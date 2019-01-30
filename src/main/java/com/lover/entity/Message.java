package com.lover.entity;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Date;

/**
 * @Class Message
 * @TODO 留言板实体对象
 */
public class Message {

    private String mid;         // 留言ID
    private Manager manager;    // 留言人
    private Manager replyManager;   // 回复人
    private Date ctime;         // 创建时间
    private String content;     // 内容
    private String intro;
    private String reply;       // 回复内容

    public Message() {
    }

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }

    public Manager getReplyManager() {
        return replyManager;
    }

    public void setReplyManager(Manager replyManager) {
        this.replyManager = replyManager;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public Date getCtime() {
        return ctime;
    }

    public void setCtime(Date ctime) {
        this.ctime = ctime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getReply() {
        return reply;
    }

    public void setReply(String reply) {
        this.reply = reply;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public void format(){
        try {
            this.intro = URLDecoder.decode(this.intro, "UTF-8");
            this.content = URLDecoder.decode(this.content, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    public void init(){
        this.ctime = new Date();
        this.mid = String.valueOf(System.currentTimeMillis()/1000);

    }

    @Override
    public String toString() {
        return "Message{" +
                "mid='" + mid + '\'' +
                ", manager=" + manager +
                ", ctime=" + ctime +
                ", content='" + content + '\'' +
                ", intro='" + intro + '\'' +
                '}';
    }
}
