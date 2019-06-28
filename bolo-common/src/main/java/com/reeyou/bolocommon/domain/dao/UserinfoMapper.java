package com.reeyou.bolocommon.domain.dao;

import com.reeyou.bolocommon.domain.pojo.Userinfo;

public interface UserinfoMapper {
    int deleteByPrimaryKey(String id);

    int insert(Userinfo record);

    int insertSelective(Userinfo record);

    Userinfo selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Userinfo record);

    int updateByPrimaryKey(Userinfo record);
}