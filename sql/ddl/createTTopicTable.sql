USE sampledb;

DROP TABLE IF EXISTS t_topic;

CREATE TABLE t_topic (
    topic_id INT AUTO_INCREMENT PRIMARY KEY,
    topic_name VARCHAR(255) NULL,
    createdBy VARCHAR(30) NULL,
    createdAt datetime NULL
) ENGINE=InnoDB;