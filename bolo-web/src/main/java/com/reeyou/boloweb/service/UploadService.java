package com.reeyou.boloweb.service;

import com.reeyou.bolocommon.utils.ServerResponse;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author Reeyou
 * @data 2019/7/5 9:50
 */
public interface UploadService  {

	public ServerResponse upload(MultipartFile file);

}
