package com.lib.bookbrain.model.comm;

import com.lib.bookbrain.model.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 参数载体
 *
 * @author yunxia
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
 * 将 objPayload 强制转换成 Payload 对象
 * <br/> 如果 objPayload 是 null 或者不是一个 Payload 实例，就创建一个新的 Payload
 *
 * @param objPayload Payload 对象的原始对象
 * @return objPayload 对应的 Payload 对象
 */
@SuppressWarnings("unchecked")
public static Payload<BaseEntity> getOrNew(Object objPayload) {
   if (objPayload.getClass() == Payload.class) {
      return (Payload<BaseEntity>) objPayload;
   }
   return new Payload<>();
}

/**
 * 通过实体生成载体
 *
 * @param e   实体对象
 * @param <E> BaseEntity
 * @return 封装了实体的载体对象
 */
public static <E extends BaseEntity> Payload<E> generateByEntity(E e) {
   Payload<E> _payload = new Payload<>();
   _payload.setEntity(e);
   return _payload;
}

}
