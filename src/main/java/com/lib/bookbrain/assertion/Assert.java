package com.lib.bookbrain.assertion;

import com.lib.bookbrain.constant.Error;
import com.lib.bookbrain.fnuction.Predicate;

/**
 * bool 检查类
 *
 * @author yunxia
 */
public class Assert {
/**
 * 对 predicate 进行断言，当断言失败时，抛出一个运行时异常
 * 这个异常的具体类型由 ee 的具体值决定
 *
 * @param predicate 断言 lambda
 * @param ee        异常枚举值
 */
public static void isCorrect(Predicate predicate, Error ee) {
   if (predicate.test()) {
      return;
   }
   throw ee.generateError();
}

}
