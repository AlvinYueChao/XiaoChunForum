package org.example.alvin.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/smart-context.xml")
public class UserServiceTest {
    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Test
    public void hasMatchUserTest() {
        boolean hasMatchUser1 = userService.hasMatchUser("admin", "123456");
        boolean hasMatchUser2 = userService.hasMatchUser("admin", "123");

        Assert.isTrue(hasMatchUser1);
        Assert.isTrue(!hasMatchUser2);
    }
}
