package com.lib.bookbrain.model;

import com.lib.bookbrain.model.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 参数载体
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Payload<T extends BaseEntity> {
/**
 * id
 */
protected Integer id;
/**
 * 参数实体
 */
protected T entity;
/**
 * 请求者
 */
protected transient TokenBody tokenBody;


/**
 * 将 arg 强制转换成 Payload 对象，如果 arg 是 null 或者不是一个 Payload 实例，就创建一个新的 Payload
 *
 * @param arg 用来转换成 Payload 对象的原始对象
 * @return arg 对应的 Payload 对象
 */
//@SuppressWarnings("unchecked") // 去除警告
public static Payload<BaseEntity> getOrNew(Object arg) {
   if (arg instanceof Payload<? extends BaseEntity>) {
      return (Payload<BaseEntity>) arg;
   }
   return new Payload<>();
}

}
