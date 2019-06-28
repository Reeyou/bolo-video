package com.reeyou.bolocommon.utils;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;
/**
 * @author Reeyou
 * @data 2019/6/28 11:11
 */

public interface MyMapper<T> extends Mapper<T>, MySqlMapper<T> {
	//TODO
	//FIXME 特别注意，该接口不能被扫描到，否则会出错
}