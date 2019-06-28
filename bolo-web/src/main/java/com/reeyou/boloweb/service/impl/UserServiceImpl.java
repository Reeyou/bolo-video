package com.reeyou.boloweb.service.impl;

import com.reeyou.bolocommon.utils.MD5Utils;
import com.reeyou.bolocommon.utils.ServerResponse;
import com.reeyou.bolocommon.utils.TokenCache;
import com.reeyou.boloweb.domain.dao.UserinfoMapper;
import com.reeyou.boloweb.domain.pojo.Userinfo;
import com.reeyou.boloweb.service.UserService;
//import com.reeyou.boloweb.domain.vo.UserVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.UUID;

/**
 * @author Reeyou
 * @data 2019/6/26 16:55
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserinfoMapper userinfoMapper;

	@Autowired
	private UserService userService;

	@Override
	public boolean checkUserName(String userName) {
		Userinfo user  = new Userinfo();
		user.setUsername(userName);

		int result = userinfoMapper.checkUsername(userName);
		return result == 0 ? false : true;
	}

	@Override
	public ServerResponse register(Userinfo user) throws Exception {
		boolean userIsExist = userService.checkUserName(user.getUsername());

		if(!userIsExist) {
			user.setNickname(user.getUsername());
			user.setPassword(MD5Utils.getMD5Str(user.getPassword()));
			user.setFaceCount(0);
			user.setLikeCount(0);
			user.setFollowCount(0);
			int result = userinfoMapper.insert(user);
			if(result > 0) {
				return ServerResponse.serverSuccussMsg("注册成功");
			} else {
				return ServerResponse.serverErrorMsg("注册失败");
			}
		}
		user.setPassword("");
		return ServerResponse.serverErrorMsg("用户名已存在");
	}

//	public UserVO setUserRedisSessionToken(Users userModel) {
//		String uniqueToken = UUID.randomUUID().toString();
//		redis.set(USER_REDIS_SESSION + ":" + userModel.getId(), uniqueToken, 1000 * 60 * 30);
//
//		UsersVO userVO = new UsersVO();
//		BeanUtils.copyProperties(userModel, userVO);
//		userVO.setUserToken(uniqueToken);
//		return userVO;
//	}

	@Override
	public ServerResponse login(String username, String password) throws Exception {
		int resultCount = userinfoMapper.checkUsername(username);
		if(resultCount == 0) {
			return ServerResponse.serverErrorMsg("用户名不存在！");
		}

		Userinfo user = userinfoMapper.matchUser(username, MD5Utils.getMD5Str(password));
		if(user == null) {
			return ServerResponse.serverSuccussMsg("密码错误");
		}
		user.setPassword("");
		String userToken = UUID.randomUUID().toString();
		TokenCache.setToken(TokenCache.TOKEN+username,userToken);
		return ServerResponse.serverSuccuss("登录成功",user);
	}
}
