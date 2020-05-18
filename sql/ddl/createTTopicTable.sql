USE sampledb;

DROP TABLE IF EXISTS t_topic;

CREATE TABLE t_topic (
    topic_id INT AUTO_INCREMENT PRIMARY KEY,
    board_id INT NOT NULL,
    topic_title VARCHAR(100) NOT NULL DEFAULT '',
    user_id INT NOT NULL DEFAULT 0,
    create_time DATETIME NOT NULL,
    last_post DATETIME NOT NULL,
    topic_views INT NOT NULL DEFAULT 1,
    topic_replies INT NOT NULL DEFAULT 0,
    digest TINYINT(1) NOT NULL COMMENT '0: 不是精华话题; 1: 是精华话题'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

ALTER TABLE t_topic ADD INDEX t_topic_topic_title_user_id (topic_title, user_id);