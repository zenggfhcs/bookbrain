package com.lib.bookbrain.constant;

import com.lib.bookbrain.model.pojo.BaseResponseInfo;
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
	TOKEN_FAILED(401, "TOKEN_FAILED: 请检查您的登录状态，或者重新登录"),

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
	DATA_NOT_EXIST("进行操作数据不存在"),

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

	LOGIN_EXPIRED(401, "登录过期，请重新登录"),

	TOKEN_RESET(199, "网络波动~~ 请稍后再试..."),

	FILE_UPLOAD_FAILED(601, "文件上传失败，请稍后再试"),
	THE_EMAIL_NOT_EXIST(404, "没有与该邮箱对应的用户"),
	BORROW_NUM_UPPER_LIMIT(501, "借阅数已达上限，请先归还一部分图书"),
	HAS_EXPIRED_BORROW(501, "存在逾期借阅，请先归还再借阅"),
	IS_BORROWED(501, "已经借阅了该图书，不可重复借阅同一本图书"),
	THE_BOOK_HAS_BEEN_BORROWED(501, "该图书已被借阅，请刷新页面"),
	ESCHEAT_FAILED(505, "归还失败"),
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
