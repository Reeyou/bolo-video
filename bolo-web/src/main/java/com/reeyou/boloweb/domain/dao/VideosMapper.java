package com.reeyou.boloweb.domain.dao;

import com.reeyou.boloweb.domain.pojo.Videos;

public interface VideosMapper {
    int deleteByPrimaryKey(String id);

    int insert(Videos record);

    int insertSelective(Videos record);

    Videos selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Videos record);

    int updateByPrimaryKey(Videos record);
}