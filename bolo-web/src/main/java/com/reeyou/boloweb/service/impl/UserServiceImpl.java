package com.reeyou.boloweb.service.impl;

import com.reeyou.bolocommon.utils.MD5Utils;
import com.reeyou.boloweb.utils.RedisService;
import com.reeyou.bolocommon.utils.ServerResponse;
import com.reeyou.boloweb.domain.dao.UserinfoMapper;
import com.reeyou.boloweb.domain.pojo.Userinfo;
import com.reeyou.boloweb.domain.vo.UserVo;
import com.reeyou.boloweb.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

	@Autowired
	private RedisService redisService;

	public static final String USER_REDIS_SESSION = "user-redis-session";

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
				return ServerResponse.serverSuccuss("注册成功");
			} else {
				return ServerResponse.serverErrorMsg("注册失败");
			}
		}
		user.setPassword("");


		return ServerResponse.serverErrorMsg("用户名已存在");
	}


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

		UserVo userVo = setRedisSeesion(user);

		return ServerResponse.serverSuccuss("登录成功",userVo);
	}

	public UserVo setRedisSeesion(Userinfo user) {
		String userToken = UUID.randomUUID().toString();
		redisService.set(USER_REDIS_SESSION + ":" + user.getId(), userToken, 1000 * 60 * 30);

		UserVo userVo = new UserVo();
		BeanUtils.copyProperties(user, userVo);
		userVo.setUserToken(userToken);
		return userVo;
	}

	@Override
	public ServerResponse getUserInfo(String id) throws Exception {
		Userinfo user = userinfoMapper.selectByPrimaryKey(id);
		if(user == null) {
			return ServerResponse.serverErrorMsg("找不到当前用户！");
		}
		user.setPassword("");
		return ServerResponse.serverSuccuss(user);
	}

}
