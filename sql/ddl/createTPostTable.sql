USE sampledb;

DROP TABLE IF EXISTS t_post;

CREATE TABLE t_post (
    post_id INT AUTO_INCREMENT PRIMARY KEY,
    board_id INT NOT NULL DEFAULT 0,
    topic_id INT NOT NULL DEFAULT 0,
    user_id INT NOT NULL DEFAULT 0,
    post_type TINYINT NOT NULL DEFAULT 2 COMMENT '帖子类型。1: 主题帖子; 2: 回复帖子',
    post_title VARCHAR(50) NOT NULL COMMENT '帖子标题',
    post_text TEXT NOT NULL COMMENT '帖子内容',
    create_time DATETIME NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

ALTER TABLE t_post ADD INDEX t_post_topic_id (topic_id);