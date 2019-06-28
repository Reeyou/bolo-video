package com.reeyou.boloweb.common;

import com.google.common.collect.Sets;

import java.util.Set;

/**
 * @author Reeyou
 * @data 2019/6/28 16:55
 */
public class Constant {

	public static final String CURRENT_USER = "currentUser";

	public static final String USERNAME = "username";
	public static final String PASSWORD = "password";
	public static final String EMAIL = "email";

	public interface  Role {
		int ROLE_CUSTOMER = 0; // 用户
		int ROLE_ADMIN = 1; // 管理员
	}

	public interface ProductListOrderBy{
		Set<String> PRICE_ASC_DESC = Sets.newHashSet("price_desc","price_asc");
	}

}
