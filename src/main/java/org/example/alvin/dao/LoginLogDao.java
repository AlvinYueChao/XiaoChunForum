package org.example.alvin.dao;

import lombok.extern.slf4j.Slf4j;
import org.example.alvin.domain.LoginLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Slf4j
@Repository
public class LoginLogDao {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void insertLoginLog(LoginLog loginLog) {
        String query = " INSERT INTO t_login_log(user_id, ip, login_datetime) values (?,?,?) ";
        try {
            jdbcTemplate.update(query, loginLog.getUserId(), loginLog.getIp(), loginLog.getLoginDate());
        } catch (DataAccessException e) {
            log.error("更新登录日志信息出错，请重试或放弃本次修改", e);
        }
    }
}
