package com.reeyou.boloweb.controller;

import com.reeyou.bolocommon.utils.ServerResponse;
import com.reeyou.boloweb.domain.pojo.Userinfo;
import com.reeyou.boloweb.service.UploadService;
import com.reeyou.boloweb.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author Reeyou
 * @data 2019/7/5 10:06
 */
@RestController
@Api(value = "用户信息", tags = {"web用户信息"})
@RequestMapping("/weapp")
public class UserController {

	@Autowired
	private UploadService uploadService;

	@Autowired
	private UserService userService;

	@PostMapping("/upload")
	@ResponseBody
	@ApiOperation(value = "上传头像")
	public ServerResponse upload(MultipartFile file) throws Exception {
		return uploadService.upload(file);
	}

	@PostMapping("/getUserInfo")
	@ResponseBody
	@ApiOperation(value = "获取用户信息")
	public ServerResponse getUserInfo(String id) throws Exception {
		return userService.getUserInfo(id);
	}
}
