package com.lib.bookbrain.context;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class MyApplicationContext implements ApplicationContextAware {
private static ApplicationContext context;

public static ApplicationContext getApplicationContext() {
   return MyApplicationContext.context;
}

@Override
public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
   MyApplicationContext.context = applicationContext;
}
}
