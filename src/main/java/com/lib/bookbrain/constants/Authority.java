package com.lib.bookbrain.constants;

import lombok.Data;

/**
 * 用户权限枚举
 *
 * @author yunxia
 */
@Data
public class Authority {
private Integer id;
/* ============================ user ============================ */
private Boolean insertUserPrivilege;                           // 创建
private Boolean selectUserPrivilege;                           // 删除
private Boolean deleteUserPrivilege;                           // 获取
private Boolean updateUserPrivilege;                           // 更新
/* ============================ user ============================ */
/* -------- book -------- */
private Boolean insertBookPrivilege;                         // 创建
private Boolean deleteBookPrivilege;                         // 删除
private Boolean selectBookPrivilege;                            // 获取
private Boolean updateBookPrivilege;                         // 更新
/* -------- book -------- */

/* -------- book info -------- */
private Boolean insertBookInfoPrivilege;                    // 创建
private Boolean deleteBookInfoPrivilege;                    // 删除
private Boolean selectBookInfoPrivilege;                       // 获取
private Boolean updateBookInfoPrivilege;                    // 更新
/* -------- book info -------- */

/* -------- publisher -------- */
private Boolean insertPublisherPrivilege;                    // 创建
private Boolean deletePublisherPrivilege;                    // 删除
private Boolean selectPublisherPrivilege;                       // 获取
private Boolean updatePublisherPrivilege;                    // 更新
/* -------- publisher -------- */

/* -------- debit -------- */
private Boolean insertDebitPrivilege;                        // 创建
private Boolean deleteDebitPrivilege;                        // 删除
private Boolean selectDebitPrivilege;                           // 获取
private Boolean updateDebitPrivilege;                        // 更新
/* -------- debit -------- */
/* ============================ log ============================ */
private Boolean deleteLogPrivilege;
private Boolean selectLogPrivilege;
/* ============================ log ============================ */
}
