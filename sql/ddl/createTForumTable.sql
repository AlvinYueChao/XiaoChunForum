USE sampledb;

DROP TABLE IF EXISTS t_forum;

CREATE TABLE t_forum (
    forum_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    forum_name VARCHAR(255) NULL,
    description VARCHAR(255) NULL,
    owner_id BIGINT NOT NULL,
    topic_id BIGINT NOT NULL,
    createdAt datetime NULL
) ENGINE=InnoDB;