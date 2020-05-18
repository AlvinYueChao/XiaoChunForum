USE sampledb;

DROP TABLE IF EXISTS t_board;

CREATE TABLE t_board (
    board_id INT AUTO_INCREMENT PRIMARY KEY,
    board_name VARCHAR(150) NOT NULL DEFAULT '',
    board_desc VARCHAR(255) NULL,
    topic_num INT NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8;