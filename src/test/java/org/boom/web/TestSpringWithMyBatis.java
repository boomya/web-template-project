package org.boom.web;

import com.alibaba.fastjson.JSON;
import org.apache.log4j.Logger;
import org.boom.web.domain.User;
import org.boom.web.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by jiangshan on 14/8/20.
 */
@RunWith(SpringJUnit4ClassRunner.class)		//表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration(locations = {"classpath*:spring-*.xml"})
public class TestSpringWithMyBatis {

    private static Logger      logger      = Logger.getLogger(TestSpringWithMyBatis.class);
    //	private ApplicationContext ac = null;
//    @Resource
    private        UserService userService = BoomServiceLocators.getUserService();
//    public void setUserService(UserService userService){
//        this.userService = userService;
//    }

//	@Before
//	public void before() {
//		ac = new ClassPathXmlApplicationContext("applicationContext.xml");
//		userService = (IUserService) ac.getBean("userService");
//	}

    @Test
    public void test1() {
        User user = userService.getUserById(1);
        // System.out.println(user.getUserName());
        // logger.info("值："+user.getUserName());
        logger.info(JSON.toJSONString(user));
    }
}
