package com.lib.bookbrain.model.comm;

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
public class TokenInfo {// todo 修改 token info
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
}
