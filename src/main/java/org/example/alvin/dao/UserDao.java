package org.example.alvin.dao;

import lombok.extern.slf4j.Slf4j;
import org.example.alvin.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Slf4j
@Repository
public class UserDao {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /**
     * 根据用户名和密码获取匹配的用户数。
     *
     * @param userName 用户名
     * @param password 密码
     * @return 匹配的用户数。1 表示用户名/密码正确，0 表示用户名或密码错误
     */
    public int getMatchCount(String userName, String password) {
        String query = " SELECT COUNT(*) FROM t_user WHERE user_name = ? AND password = ? ";
        Integer matchCount = null;
        try {
            matchCount = jdbcTemplate.queryForObject(query, new Object[]{userName, password}, Integer.class);
        } catch (DataAccessException e) {
            log.error("该用户不存在，请检查用户名和密码是否输入正确", e);
        }
        return matchCount == null ? 0 : matchCount;
    }

    /**
     * 根据用户名获取 User 对象
     *
     * @param userName 用户名
     * @return 对应的 User 对象
     */
    public User findUserByUserName(final String userName) {
        String query = " SELECT * FROM t_user WHERE user_name = ? ";
        final User user = new User();
        try {
            jdbcTemplate.query(query, new Object[]{userName}, new RowCallbackHandler() {
                public void processRow(ResultSet resultSet) throws SQLException {
                    user.setUserName(userName);
                    user.setUserId(resultSet.getInt("user_id"));
                    user.setCredits(resultSet.getInt("credits"));
                }
            });
        } catch (DataAccessException e) {
            log.error("无法找到 {} 对应的用户，请检查用户名是否输入正确", userName, e);
        }
        return user;
    }
}
