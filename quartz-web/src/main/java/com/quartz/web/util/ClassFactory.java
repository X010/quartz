package com.quartz.web.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Copyright (c) 2012, Sohu.com All Rights Reserved.
 * <p/>
 * User: jeffreywu  MailTo:jeffreywu@sohu-inc.com
 * Date: 14-3-11
 * Time: PM6:25
 */
public class ClassFactory {
    private static ApplicationContext ctx;

    static {
        ctx = new ClassPathXmlApplicationContext(new String[]{"classpath:quartz-web.xml"});
    }

    public static void init() {
    }

    public static Object getBean(String name) {
        return ctx.getBean(name);
    }

    public static <T> T getBean(Class<T> clazz) {
        return ctx.getBean(clazz);
    }
}
