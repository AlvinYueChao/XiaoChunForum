USE sampledb;
GO

DROP TABLE IF EXISTS t_user;
GO

-- 创建用户表
CREATE TABLE t_user (
    user_id INT AUTO_INCREMENT PRIMARY KEY,
    user_name VARCHAR(30) NULL,
    credits INT NULL,
    password VARCHAR(32) NULL,
    last_visit datetime NULL,
    last_ip VARCHAR(32) NULL
) ENGINE=InnoDB;
GO