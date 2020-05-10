USE sampledb;

DROP TABLE IF EXISTS t_user;

-- 创建用户表
CREATE TABLE t_user (
    user_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_name VARCHAR(30) NULL,
    credits BIGINT NULL,
    password VARCHAR(32) NULL,
    last_visit datetime NULL,
    last_ip VARCHAR(32) NULL
) ENGINE=InnoDB;