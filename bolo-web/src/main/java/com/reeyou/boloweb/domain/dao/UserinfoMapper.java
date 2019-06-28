package com.reeyou.boloweb.domain.dao;

import com.reeyou.boloweb.domain.pojo.Userinfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserinfoMapper {
    int deleteByPrimaryKey(String id);

    @Select("select count(1) from userinfo where username = #{username}")
    int checkUsername(String username);

    @Select("select * from userinfo where username = #{username} and password = #{password}")
    Userinfo matchUser(@Param("username") String username, @Param("password") String password);

    int insert(Userinfo record);

    int insertSelective(Userinfo record);

    Userinfo selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Userinfo record);

    int updateByPrimaryKey(Userinfo record);
}