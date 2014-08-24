package org.boom.web;

import org.boom.web.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by jiangshan on 14/8/22.
 */
public class BoomServiceLocators {

    private static ApplicationContext context;
    private static RuntimeException initException = null;

    static {
        try {
            context = new ClassPathXmlApplicationContext("classpath*:spring-config.xml");
        } catch (RuntimeException e) {
            initException = e;
        }
    }

    public static ApplicationContext getApplicationContext() {
        if (context == null) {
            throw initException;
        }
        return context;
    }

    public static UserService getUserService() {
        return (UserService) getApplicationContext().getBean("userService");
    }

}
