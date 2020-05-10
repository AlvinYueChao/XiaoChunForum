USE sampledb;

DROP TABLE IF EXISTS t_topic;

CREATE TABLE t_topic (
    topic_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    topic_name VARCHAR(255) NULL,
    owner_id BIGINT NOT NULL,
    createdAt datetime NULL
) ENGINE=InnoDB;