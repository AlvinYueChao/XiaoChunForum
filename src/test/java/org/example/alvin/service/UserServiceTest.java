package org.example.alvin.service;

import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.Assert;

public class UserServiceTest {
    private UserService userService;

    @Test
    public void componentScanTest() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService = (UserService) applicationContext.getBean("userService");

        boolean hasMatchUser1 = userService.hasMatchUser("admin", "123456");
        boolean hasMatchUser2 = userService.hasMatchUser("admin", "123");

        Assert.isTrue(hasMatchUser1);
        Assert.isTrue(!hasMatchUser2);
    }
}
