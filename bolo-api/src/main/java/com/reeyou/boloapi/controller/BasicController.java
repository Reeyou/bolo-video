package com.reeyou.boloapi.controller;

import com.reeyou.bolocommon.utils.RedisService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Reeyou
 * @data 2019/6/28 18:16
 */
public class BasicController {
	@Autowired
	public RedisService redis;

	public static final String USER_REDIS_SESSION = "user-redis-session";

	// 文件保存的命名空间
	public static final String FILE_SPACE = "C:/imooc_videos_dev";

	// ffmpeg所在目录
	public static final String FFMPEG_EXE = "C:\\ffmpeg\\bin\\ffmpeg.exe";

	// 每页分页的记录数
	public static final Integer PAGE_SIZE = 5;
}
