package com.example.base;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

/**
 * @author: Jackson
 * @date: 2019/11/13
 * @description:
 */
@Component
public class SpringBeanUtil implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    private static synchronized void modify(ApplicationContext applicationContext) {
        SpringBeanUtil.applicationContext = applicationContext;
    }

    @Override
    public void setApplicationContext(@Nullable ApplicationContext applicationContext) {
        SpringBeanUtil.modify(applicationContext);
    }

    public static ApplicationContext getApplicationContext() {
        if (applicationContext == null) {
            throw new IllegalStateException("applicationContext property is  not yet init");
        }
        return applicationContext;
    }

    public static <T> T getBean(String beanName, Class<T> clazz) {
        try {
            return getApplicationContext().getBean(beanName, clazz);
        } catch (BeansException e) {
            throw new IllegalStateException("BeansException.cause by:" + e.getMessage());
        }
    }

    public static <T> T getBean(Class<T> clazz) {
        try {
            return getApplicationContext().getBean(clazz);
        } catch (BeansException e) {
            throw new IllegalStateException("BeansException.cause by:" + e.getMessage());
        }
    }

    /**
     * 判断beanName是否存在
     *
     * @param beanName
     * @return
     */
    public static boolean containsBean(String beanName) {
        return getApplicationContext().containsBean(beanName);
    }

    public static void cleanHolder() {
        applicationContext = null;
    }
}
