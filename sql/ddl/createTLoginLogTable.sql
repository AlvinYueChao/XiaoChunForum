USE sampledb;

DROP TABLE IF EXISTS t_login_log;

-- 创建用户登录日志表
CREATE TABLE t_login_log (
    login_log_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_id BIGINT NOT NULL,
    ip VARCHAR(32) NULL,
    login_datetime datetime NULL
) ENGINE=InnoDB;