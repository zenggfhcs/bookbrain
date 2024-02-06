package com.lib.bookbrain.exception;

import com.lib.bookbrain.constants.EException;
import org.apache.logging.log4j.util.Supplier;

/**
 * bool 检查类
 *
 * @author yunxia
 */
public class Assert {
public static void isCorrect(Supplier<Boolean> supplier, EException ee) {
   if (supplier.get()) {
      return;
   }
   throw ee.generateExp();
}
}
