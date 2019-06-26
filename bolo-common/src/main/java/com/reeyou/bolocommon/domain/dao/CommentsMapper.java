package com.reeyou.bolocommon.domain.dao;

import com.reeyou.bolocommon.domain.pojo.Comments;

public interface CommentsMapper {
    int deleteByPrimaryKey(String id);

    int insert(Comments record);

    int insertSelective(Comments record);

    Comments selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Comments record);

    int updateByPrimaryKeyWithBLOBs(Comments record);

    int updateByPrimaryKey(Comments record);
}