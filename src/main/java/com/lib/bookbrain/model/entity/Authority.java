package com.lib.bookbrain.model.entity;

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
private Boolean insertUserPrivilege = null;                           // 创建
private Boolean selectUserPrivilege = null;                           // 删除
private Boolean deleteUserPrivilege = null;                           // 获取
private Boolean updateUserPrivilege = null;                           // 更新
/* ============================ user ============================ */

/* ============================ book ============================ */
private Boolean insertBookPrivilege = null;                           // 创建
private Boolean deleteBookPrivilege = null;                           // 删除
private Boolean selectBookPrivilege = null;                           // 获取
private Boolean updateBookPrivilege = null;                           // 更新
/* ============================ book ============================ */

/* ============================ book info ============================ */
private Boolean insertBookInfoPrivilege = null;                       // 创建
private Boolean deleteBookInfoPrivilege = null;                       // 删除
private Boolean selectBookInfoPrivilege = null;                       // 获取
private Boolean updateBookInfoPrivilege = null;                       // 更新
/* ============================ book info ============================ */

/* ============================ publisher ============================ */
private Boolean insertPublisherPrivilege = null;                      // 创建
private Boolean deletePublisherPrivilege = null;                      // 删除
private Boolean selectPublisherPrivilege = null;                      // 获取
private Boolean updatePublisherPrivilege = null;                      // 更新
/* ============================ publisher ============================ */

/* ============================ debit ============================ */
private Boolean insertDebitPrivilege = null;                          // 创建
private Boolean deleteDebitPrivilege = null;                          // 删除
private Boolean selectDebitPrivilege = null;                          // 获取
private Boolean updateDebitPrivilege = null;                          // 更新
/* ============================ debit ============================ */

/* ============================ log ============================ */
private Boolean deleteLogPrivilege = null;                            // 删除
private Boolean selectLogPrivilege = null;                            // 查找
/* ============================ log ============================ */
}
