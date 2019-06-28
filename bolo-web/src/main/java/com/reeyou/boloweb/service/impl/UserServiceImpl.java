package com.reeyou.boloweb.service.impl;

import com.reeyou.boloweb.domain.dao.UserinfoMapper;
import com.reeyou.boloweb.domain.pojo.Userinfo;
import com.reeyou.boloweb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Reeyou
 * @data 2019/6/26 16:55
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserinfoMapper userinfoMapper;

	@Override
	public boolean checkUserName(String userName) {
		Userinfo user  = new Userinfo();
		user.setUsername(userName);

		int result = userinfoMapper.checkUsername(userName);
		return result == 0 ? false : true;
	}

	@Override
	public void savUser(Userinfo user) {}

}
