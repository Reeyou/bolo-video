package com.reeyou.boloweb.service;

import com.reeyou.bolocommon.utils.ServerResponse;
import com.reeyou.boloweb.domain.pojo.Userinfo;

import javax.servlet.http.HttpSession;

/**
 * @author Reeyou
 * @data 2019/6/26 16:55
 */
public interface UserService {

	public boolean checkUserName(String userName);

	ServerResponse<String> register(Userinfo user) throws Exception;

	public ServerResponse login(String username, String password) throws Exception;

	public ServerResponse getUserInfo(String id) throws Exception;
}
