package com.reeyou.boloweb.domain.dao;

import com.reeyou.boloweb.domain.pojo.UserLikeVideos;

public interface UserLikeVideosMapper {
    int deleteByPrimaryKey(String id);

    int insert(UserLikeVideos record);

    int insertSelective(UserLikeVideos record);

    UserLikeVideos selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(UserLikeVideos record);

    int updateByPrimaryKey(UserLikeVideos record);
}