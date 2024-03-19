package com.lib.bookbrain.constant;

import com.lib.bookbrain.pojo.BaseResponseInfo;
import lombok.Getter;

@Getter
public enum ResponseInfo {

	/**
	 *
	 */
	SUCCESS(200, ""),

	/**
	 * 登录失败提示信息：用户名或者密码错误
	 */
	ID_OR_PASSWORD_FAILED("Username or password error"),

	/**
	 * token 创建或者解析时异常
	 */
	TOKEN_FAILED("TOKEN_FAILED: token 创建（解析）时错误，请检查您的登录状态，或者重新登录"),

	/**
	 *
	 */
	CREATE_ERROR("Creation failed"),

	/**
	 *
	 */
	CREATE_DATA_ERROR("The data required to create a new one is empty"),

	/**
	 *
	 */
	DATA_NOT_EXIST("The data does not exist"),

	/**
	 *
	 */
	UPDATE_DATA_ERROR("The data required for update is empty"),

	/**
	 *
	 */
	UPDATE_OLD_DATE_ERROR("The data to be updated is empty"),

	/**
	 *
	 */
	UPDATE_ERROR("Update failed"),

	/**
	 *
	 */
	DELETE_DATA_ERROR("The data to be deleted is empty"),

	/**
	 *
	 */
	DELETE_ERROR("Delete error"),

	/**
	 *
	 */
	MISS_PERMISSION("You don't have enough permission to do this"),

	/**
	 *
	 */
	SQL_EXEC_FAILED("Sql execution failed"),

	/**
	 *
	 */
	ERROR("service error"),

	/**
	 *
	 */
	FILE_NOT_EXIST("文件不存在"),

	/**
	 * 邮箱重复注册时返回
	 */
	THIS_EMAIL_IS_EXIST("该邮箱已经注册"),

	REGISTER_FIELD("REGISTER_FIELD"),


	DATA_STRUCTURE_FAILED("DATA_STRUCTURE_FAILED"),

	SEND_EMAIL_ERROR("EMAIL_SEND_FAILED: 如果该邮箱使用正常，请联系管理员(1635276938@qq.com)"),

	PUBLISHER_NAME_REPEAT("NAME_REPEAT: 已经存在名称相同的出版社了"),

	TEMPLATE_READ_FAILED("读取模板时发生了错误，请联系管理员(1635276938@qq.com)"),
	;

private final BaseResponseInfo info;

ResponseInfo(BaseResponseInfo info) {
	this.info = info;
}

ResponseInfo(Integer code, String msg) {
	this(BaseResponseInfo.builder()
			.message(msg)
			.code(code)
			.build());
}

ResponseInfo(String msg) {
	this(-1, msg);
}
}
