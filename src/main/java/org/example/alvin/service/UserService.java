package org.example.alvin.service;


import org.example.alvin.dao.LoginLogDao;
import org.example.alvin.dao.UserDao;
import org.example.alvin.domain.LoginLog;
import org.example.alvin.domain.User;
import org.example.alvin.domain.UserLockStatus;
import org.example.alvin.domain.UserType;
import org.example.alvin.exception.UserExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {
    private final UserDao userDao;
    private final LoginLogDao loginLogDao;

    @Autowired
    public UserService(UserDao userDao, LoginLogDao loginLogDao, RedisTemplate<Object, Object> redisTemplate) {
        this.userDao = userDao;
        this.loginLogDao = loginLogDao;
    }

    public void register(User user) throws UserExistException {
        User matchedUser = this.findUserByUserName(user.getUserName());
        if (matchedUser != null) {
            throw new UserExistException("该用户名已被占用");
        } else {
            user.setCredits(5);
            user.setUserType(UserType.COMMON_USER.getValue());
            this.userDao.save(user);
        }
    }

    public boolean hasMatchUser(String userName, String password) {
        return userDao.getMatchCount(userName, password) > 0;
    }

    public User findUserByUserName(String userName) {
        return userDao.findUserByUserName(userName);
    }

    public void lockUser(String userName) throws UserExistException {
        User user = this.findUserByUserName(userName);
        if (user == null) {
            throw new UserExistException("该用户名不存在，无法锁定");
        } else {
            user.setLocked(UserLockStatus.USER_LOCK.getLockStatus());
            userDao.save(user);
        }
    }

    public void unlockUser(String userName) throws UserExistException {
        User user = this.findUserByUserName(userName);
        if (user == null) {
            throw new UserExistException("该用户名不存在，无法解锁");
        } else {
            user.setLocked(UserLockStatus.USER_UNLOCK.getLockStatus());
            userDao.save(user);
        }
    }

    @Transactional
    public void loginSuccess(User user) {
        user.setCredits(user.getCredits() + 5);
        LoginLog loginLog = new LoginLog();
        loginLog.setUser(user);
        loginLog.setIp(user.getLastIp());
        loginLog.setLoginDate(user.getLastVisit());

        userDao.updateLoginInfo(user);
        loginLogDao.save(loginLog);
    }
}
