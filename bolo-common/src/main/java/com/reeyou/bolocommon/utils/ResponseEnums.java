package com.reeyou.bolocommon.utils;

/**
 * @author Reeyou
 * @data 2019/6/28 15:38
 */
public enum ResponseEnums {

	SUCCUSS(200, "SUCCUSS"),
	ERROR(500, "ERROR"),
	UNLOGIN(403, "UNLOGIN"),
	ERROR_AUGUMENTS(400, "ERROR_ARGUMENTS");

	private final int code;
	private final String desc;

	ResponseEnums(int code, String desc) {
		this.code = code;
		this.desc = desc;
	}

	public int getCode() {
		return  code;
	}

	public String getDesc() {
		return desc;
	}
}
