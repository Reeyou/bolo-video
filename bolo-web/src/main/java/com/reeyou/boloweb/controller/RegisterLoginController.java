package com.reeyou.boloweb.controller;

import com.reeyou.bolocommon.utils.MD5Utils;
import com.reeyou.bolocommon.utils.ServerResponse;
import com.reeyou.boloweb.common.Constant;
import com.reeyou.boloweb.domain.pojo.Userinfo;
import com.reeyou.boloweb.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @author Reeyou
 * @data 2019/6/26 16:45
 */
@RestController
@Api(value = "用户登陆注册", tags = {"web登陆注册"})
public class RegisterLoginController {

	@Autowired
	private UserService userService;

	@PostMapping("/register")
	@ApiOperation(value = "用户注册")
	public ServerResponse register(Userinfo user) throws Exception {
		if(StringUtils.isBlank(user.getUsername()) || StringUtils.isBlank(user.getPassword())) {
			return ServerResponse.serverErrorMsg("用户名或密码不能为空");
		}
		return userService.register(user);
	}

	@PostMapping("/login")
	@ApiOperation(value = "用户登录")
	public ServerResponse login(String username, String password, HttpSession session) throws Exception {
		if(StringUtils.isBlank(username) || StringUtils.isBlank(password)) {
			return ServerResponse.serverErrorMsg("用户名或密码不能为空");
		}
		ServerResponse response = userService.login(username, password);
		if(response.isSuccuss()) {
			session.setAttribute(Constant.CURRENT_USER, response.getData());
			System.out.println("session:" + session.getAttribute(Constant.CURRENT_USER));
		}
		return response;
	}

}
