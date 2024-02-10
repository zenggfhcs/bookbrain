package com.lib.bookbrain.context;

import lombok.NonNull;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * 用于获取应用上下文，供 {@link com.lib.bookbrain.utils.JBean} 使用
 *
 * @author yunxia
 */
@Component
public class MyApplicationContext implements ApplicationContextAware {
private static ApplicationContext context;

public static ApplicationContext getApplicationContext() {
   return MyApplicationContext.context;
}

@Override
public void setApplicationContext(@NonNull ApplicationContext applicationContext) throws BeansException {
   MyApplicationContext.context = applicationContext;
}

}
