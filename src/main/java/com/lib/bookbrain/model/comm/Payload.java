package com.lib.bookbrain.model.comm;

import com.lib.bookbrain.constant.Default;
import com.lib.bookbrain.model.BaseEntity;
import com.lib.bookbrain.utils.MyArrays;
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
   if (objPayload instanceof Payload<? extends BaseEntity>) {
      return (Payload<BaseEntity>) objPayload; //
   }
   return new Payload<>();
}

/**
 * 对理想的 args 进行解析
 * <br/>得到一个 payload
 * <br/>里面包含了args 里面所有需要用到的信息
 *
 * @param args 参数数组 理想 args = [payload, token, id]
 * @return 集合了 args 所有信息的 payload
 */
public static Payload<BaseEntity> parseArgsTo(Object[] args) {
   /* ===================== args[0] ===================== */
   Payload<BaseEntity> _payload =
         Payload.getOrNew(args[Default.PAYLOAD_INDEX_IN_ARGS]);// 解析参数 => payload
   
   /* ===================== args[1] ===================== */
   {                                                        // token 在拦截器处解析，故此处不处理
      // args[Default.tokenIndexInArgs] => token
   }
   
   /* ===================== args[2] ===================== */
   {
      Integer _id =
            (Integer) MyArrays.getOrDefault(args, Default.ID_INDEX_IN_ARGS);
      _payload.setId(_id);                                  // payload 记录 id
   }
   
   return _payload;
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

