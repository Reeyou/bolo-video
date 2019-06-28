package com.reeyou.boloweb.domain.dao;

import com.reeyou.bolocommon.utils.MyMapper;
import com.reeyou.boloweb.domain.pojo.Userinfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserinfoMapper {
    int deleteByPrimaryKey(String id);

    @Select("select count(1) from mmall_user where username = #{username}")
    int checkUsername(String username);

    int insert(Userinfo record);

    int insertSelective(Userinfo record);

    Userinfo selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Userinfo record);

    int updateByPrimaryKey(Userinfo record);
}