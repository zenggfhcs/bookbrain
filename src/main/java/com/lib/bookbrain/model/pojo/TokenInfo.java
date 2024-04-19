package com.lib.bookbrain.model.pojo;

import com.lib.bookbrain.model.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * token body
 *
 * @author yunxia
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TokenInfo {
/**
 * 签发人
 */
private String iss;
/**
 * 主题
 */
private String sub = "abc";
/**
 * 受众
 */
private Integer aud;
/**
 * 生效时间
 */
private Long nbf;
/**
 * 到期时间
 */
private Long exp;
/**
 * 编号
 */
private String jti;

/**
 * 邮箱
 */
private String eml;

/**
 * 版本号
 */
private Integer rev;

public static TokenInfo fromUser(User user) {
	TokenInfo _info = new TokenInfo();
	_info.setAud(user.getId());
	_info.setEml(user.getEmail());
	_info.setRev(user.getRevision());
	return _info;
}
}
