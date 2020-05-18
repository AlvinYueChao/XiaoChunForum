USE sampledb;

DROP TABLE IF EXISTS t_board_manager;

CREATE TABLE t_board_manager (
    board_id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;