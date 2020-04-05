package org.example.alvin.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.util.Assert;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

    private UserService userService;

    @Before
    public void init() {
        userService = Mockito.mock(UserService.class);
    }

    @Test
    public void hasMatchUserTest() {
        Mockito.when(userService.hasMatchUser("admin", "123456")).thenReturn(true);

        boolean hasMatchUser1 = userService.hasMatchUser("admin", "123456");
        boolean hasMatchUser2 = userService.hasMatchUser("admin", "123");

        Assert.isTrue(hasMatchUser1);
        Assert.isTrue(!hasMatchUser2);
    }
}