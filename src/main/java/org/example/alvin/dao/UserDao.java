package org.example.alvin.dao;

import lombok.extern.slf4j.Slf4j;
import org.example.alvin.domain.User;
import org.example.alvin.repository.UserRepository;
import org.example.alvin.util.DateTimeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

@Slf4j
@Repository
public class UserDao extends BaseDao<User> {

    private UserRepository userRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * 根据用户名和密码获取匹配的用户数。
     *
     * @param userName 用户名
     * @param password 密码
     * @return 匹配的用户数。1 表示用户名/密码正确，0 表示用户名或密码错误
     */
    public int getMatchCount(String userName, String password) {
        Integer matchCount = this.userRepository.countByUserNameAndPassword(userName, password);
        return matchCount == null ? 0 : matchCount;
    }

    /**
     * 根据用户名获取 User 对象
     *
     * @param userName 用户名
     * @return 对应的 User 对象
     */
    public User findUserByUserName(final String userName) {
        return this.userRepository.findByUserName(userName);
    }

    public User findUserById(final int userId) {
        return this.userRepository.findByUserId(userId);
    }

    public void save(User user) {
        this.userRepository.save(user);
    }

    /**
     * 根据模糊用户名查找符合条件的所有用户
     * @param userName 用户名关键字
     * @param pageNo 页首元素下标
     * @param pageSize 页大小
     * @return 该页所有用户
     */
    public Page<User> findUserByUserName(final String userName, int pageNo, int pageSize) {
        String query = " SELECT * FROM t_user WHERE user_name like ? ";
        return pagedQuery(query, pageNo, pageSize, userName);
    }

    /**
     * 更新用户积分，最后登录 IP 以及最后登录时间
     *
     * @param user 要保存的 User 对象
     */
    public void updateLoginInfo(User user) {
        String query = " UPDATE t_user SET last_visit = ?, last_ip = ?, credits = ? WHERE user_id = ? ";
        try {
            getJdbcTemplate().update(query, DateTimeUtils.safeToDateTimeString(user.getLastVisit()), user.getLastIp(), user.getCredits(), user.getUserId());
        } catch (DataAccessException e) {
            log.error("更新用户信息出错，请重试或放弃本次修改", e);
        }
    }
}
