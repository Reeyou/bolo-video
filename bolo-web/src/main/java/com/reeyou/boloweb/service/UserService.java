package com.reeyou.boloweb.service;

import com.reeyou.boloweb.domain.pojo.Userinfo;

/**
 * @author Reeyou
 * @data 2019/6/26 16:55
 */
public interface UserService {

	public boolean checkUserName(String userName);

	public void savUser(Userinfo user);
}
