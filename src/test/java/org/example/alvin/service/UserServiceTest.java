package org.example.alvin.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.util.Assert;

@ContextConfiguration(locations = "../applicationContext.xml")
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void hasMatchUserTest() {
        boolean hasMatchUser1 = userService.hasMatchUser("admin", "123456");
        boolean hasMatchUser2 = userService.hasMatchUser("admin", "123");

        Assert.isTrue(hasMatchUser1);
        Assert.isTrue(!hasMatchUser2);
    }

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
