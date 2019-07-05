package com.reeyou.boloweb.service.impl;

import com.reeyou.bolocommon.utils.ServerResponse;
import com.reeyou.boloweb.service.UploadService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * @author Reeyou
 * @data 2019/7/5 9:51
 */
@Service
public class UploadServiceImpl implements UploadService {

	@Value("${web.upload-path}")
	private String path;

	@Value("${spring.base.gateway}")
	private String gateway;

	@Override
	public ServerResponse upload(MultipartFile file) {
		try {
			String data = "";
			String temp = "img" + File.separator + "upload";

			String filename = file.getOriginalFilename();
			String extensionName = StringUtils.substringAfter(filename, ".");

			String newFileName = String.valueOf(System.currentTimeMillis() + "." + extensionName);

			String dataDirectory = temp.concat(File.separator);

			String filePath = path.concat(dataDirectory);

			File dest = new File(filePath, newFileName);
			if(!dest.getParentFile().exists()) {
				dest.getParentFile().mkdir();
			}
			file.transferTo(dest);
			data = dataDirectory.replaceAll("\\\\", "/") + newFileName;

			String responseData = gateway + data;


			return ServerResponse.serverSuccuss("图片上传成功",responseData);
		} catch (IOException e) {
			return ServerResponse.serverErrorMsg(("图片上传失败"));
		}

	}
}
