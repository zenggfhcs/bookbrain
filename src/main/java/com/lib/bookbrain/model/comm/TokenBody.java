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
public class TokenBody {
/**
 * 用户 id
 */
private Integer id;
/**
 * 用户名
 */
private String name;
/**
 * 到期时间
 */
private Long exp;
}
