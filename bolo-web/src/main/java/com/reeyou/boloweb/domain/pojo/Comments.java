package com.reeyou.boloweb.domain.pojo;

import java.util.Date;

public class Comments {
    private String id;

    private String videoId;

    private String fromUserId;

    private Date createTime;

    private String comment;

    public Comments(String id, String videoId, String fromUserId, Date createTime, String comment) {
        this.id = id;
        this.videoId = videoId;
        this.fromUserId = fromUserId;
        this.createTime = createTime;
        this.comment = comment;
    }

    public Comments() {
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getVideoId() {
        return videoId;
    }

    public void setVideoId(String videoId) {
        this.videoId = videoId == null ? null : videoId.trim();
    }

    public String getFromUserId() {
        return fromUserId;
    }

    public void setFromUserId(String fromUserId) {
        this.fromUserId = fromUserId == null ? null : fromUserId.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment == null ? null : comment.trim();
    }
}