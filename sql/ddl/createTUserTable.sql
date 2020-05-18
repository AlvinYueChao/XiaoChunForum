USE sampledb;

DROP TABLE IF EXISTS t_user;

CREATE TABLE t_user (
    user_id INT AUTO_INCREMENT PRIMARY KEY,
    user_name VARCHAR(30) NOT NULL,
    password VARCHAR(30) NOT NULL DEFAULT '',
    user_type TINYINT NOT NULL DEFAULT 1 COMMENT '1:普通用户; 2: 管理员',
    locked TINYINT NOT NULL DEFAULT 0 COMMENT '0: 未锁定; 1: 锁定',
    credits INT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

ALTER TABLE t_user ADD INDEX t_user_user_name (user_name);