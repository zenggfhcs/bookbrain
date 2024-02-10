package com.lib.bookbrain.model.dto;

import com.lib.bookbrain.model.entity.BaseEntity;
import com.lib.bookbrain.utils.Jwt;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

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
 * 请求者
 */
protected transient TokenBody tokenBody;
/**
 * 过滤
 */
protected Filter filter;


/**
 * 将 arg 强制转换成 Payload 对象，如果 arg 是 null 或者不是一个 Payload 实例，就创建一个新的 Payload
 *
 * @param arg 用来转换成 Payload 对象的原始对象
 * @return arg 对应的 Payload 对象
 */
@SuppressWarnings("unchecked")
public static Payload<BaseEntity> getOrNew(Object arg) {
   if (arg instanceof Payload<? extends BaseEntity>) {
      return (Payload<BaseEntity>) arg; //
   }
   return new Payload<>();
}

/**
 * 理想 args = [payload, token, id]
 *
 * @param args 1
 * @return 2
 */
public static Payload<BaseEntity> parseArgsTo(Object[] args) {
   Payload<BaseEntity> _payload = Payload.getOrNew(args[0]);   // 解析参数 => parameter
   {
      String token = args.length > 1                           // 获取 token
            ? args[1].toString()
            : "";
      TokenBody tokenBody = Jwt.decoder(token);                // 解析token，token => tokenBody
      _payload.setTokenBody(tokenBody);                        // payload 记录 tokenBody
   }
   {
      Integer _id = args.length > 2                            //
            ? Integer.parseInt(args[2].toString())             // payload 记录 id
            : 0;
      _payload.setId(_id);
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

/**
 * 清理载荷信息，只保留实体
 */
public void clear() {
   setId(null);
   setTokenBody(null);
   setFilter(null);
}

@Data
@NoArgsConstructor
@AllArgsConstructor
public static class Filter {
   protected static LocalDateTime lower_TIME_DEFAULT_VALUE = LocalDateTime.of(2023, 1, 1, 0, 0);
   protected static LocalDateTime upper_TIME_DEFAULT_VALUE = LocalDateTime.of(2038, 1, 1, 0, 0);
   /**
    * 创建时间下限
    */
   protected LocalDateTime lowerCreateTime = lower_TIME_DEFAULT_VALUE;
   /**
    * 创建时间上限
    */
   protected LocalDateTime upperCreateTime = upper_TIME_DEFAULT_VALUE;
   /**
    * 最后更新时间下限
    */
   protected LocalDateTime lowerUpdateTime = lower_TIME_DEFAULT_VALUE;
   /**
    * 最后更新时间上限
    */
   protected LocalDateTime upperUpdateTime = upper_TIME_DEFAULT_VALUE;
   /**
    * 分页查询-起始行
    */
   protected Integer pageStart = 0;
   /**
    * 分页查询-页长
    */
   protected Integer pageSize = 10;
   /**
    * 年龄下限
    */
   private Integer lowerAge = 0;
   /**
    * 年龄上限
    */
   private Integer upperAge = 238;
   /**
    * 最后登录时间下限
    */
   private LocalDateTime lowerLastLoginTime = lower_TIME_DEFAULT_VALUE;
   /**
    * 最后登录时间上限
    */
   private LocalDateTime upperLastLoginTime = upper_TIME_DEFAULT_VALUE;
   
   /**
    * 执行时间下限
    */
   private Long lowerElapsedTime = 0L;
   /**
    * 执行时间上限
    */
   private Long upperElapsedTime = 10000L;
}
}

