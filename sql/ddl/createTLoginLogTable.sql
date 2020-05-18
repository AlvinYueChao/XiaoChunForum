USE sampledb;

DROP TABLE IF EXISTS t_login_log;

CREATE TABLE t_login_log (
    login_log_id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT NOT NULL DEFAULT 0,
    ip VARCHAR(30) NULL,
    login_datetime datetime NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;