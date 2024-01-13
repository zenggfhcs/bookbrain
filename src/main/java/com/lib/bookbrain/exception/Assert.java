package com.lib.bookbrain.exception;

import org.apache.logging.log4j.util.Supplier;

/**
 * bool 检查类
 *
 * @author yunxia
 */
public class Assert {
public static void isCorrect(Supplier<Boolean> supplier, RuntimeException e) {
   if (supplier.get()) {
      return;
   }
   throw e;
}


}
