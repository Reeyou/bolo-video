package com.reeyou.bolocommon.domain.pojo;

public class Userinfo {
    private String id;

    private String username;

    private String password;

    private String avatarPath;

    private String nickname;

    private Integer faceCount;

    private Integer likeCount;

    private Integer followCount;

    public Userinfo(String id, String username, String password, String avatarPath, String nickname, Integer faceCount, Integer likeCount, Integer followCount) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.avatarPath = avatarPath;
        this.nickname = nickname;
        this.faceCount = faceCount;
        this.likeCount = likeCount;
        this.followCount = followCount;
    }

    public Userinfo() {
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getAvatarPath() {
        return avatarPath;
    }

    public void setAvatarPath(String avatarPath) {
        this.avatarPath = avatarPath == null ? null : avatarPath.trim();
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    public Integer getFaceCount() {
        return faceCount;
    }

    public void setFaceCount(Integer faceCount) {
        this.faceCount = faceCount;
    }

    public Integer getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(Integer likeCount) {
        this.likeCount = likeCount;
    }

    public Integer getFollowCount() {
        return followCount;
    }

    public void setFollowCount(Integer followCount) {
        this.followCount = followCount;
    }
}