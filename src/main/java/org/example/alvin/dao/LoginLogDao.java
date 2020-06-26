package org.example.alvin.dao;

import lombok.extern.slf4j.Slf4j;
import org.example.alvin.domain.LoginLog;
import org.example.alvin.repository.LoginLogRepository;
import org.springframework.stereotype.Repository;

@Slf4j
@Repository
public class LoginLogDao extends BaseDao<LoginLog> {

    private LoginLogRepository loginLogRepository;

    public void setLoginLogRepository(LoginLogRepository loginLogRepository) {
        this.loginLogRepository = loginLogRepository;
    }

    public void save(LoginLog loginLog) {
        this.loginLogRepository.save(loginLog);
    }
}
