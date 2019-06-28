package com.reeyou.boloweb.domain.pojo;

public class UserFans {
    private String id;

    private String userId;

    private String fanId;

    public UserFans(String id, String userId, String fanId) {
        this.id = id;
        this.userId = userId;
        this.fanId = fanId;
    }

    public UserFans() {
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getFanId() {
        return fanId;
    }

    public void setFanId(String fanId) {
        this.fanId = fanId == null ? null : fanId.trim();
    }
}