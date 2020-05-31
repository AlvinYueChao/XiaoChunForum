package org.example.alvin.service;


import org.example.alvin.dao.LoginLogDao;
import org.example.alvin.dao.UserDao;
import org.example.alvin.domain.LoginLog;
import org.example.alvin.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.OffsetDateTime;

@Service
public class UserService {
    private final UserDao userDao;
    private final LoginLogDao loginLogDao;

    @Autowired
    public UserService(UserDao userDao, LoginLogDao loginLogDao, RedisTemplate<Object, Object> redisTemplate) {
        this.userDao = userDao;
        this.loginLogDao = loginLogDao;
    }

    public boolean hasMatchUser(String userName, String password) {
        return userDao.getMatchCount(userName, password) > 0;
    }

    public User findUserByUserName(String userName) {
        return userDao.findUserByUserName(userName);
    }

    @Transactional
    public void loginSuccess(User user) {

    }
}
