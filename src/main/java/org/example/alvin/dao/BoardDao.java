package org.example.alvin.dao;

import org.example.alvin.domain.Board;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDao extends BaseDao<Board> {
    private static final String GET_BOARD_NUM = " SELECT COUNT(board_id) FROM t_board ";

    public int getBoardNum() {
        Integer count = getJdbcTemplate().query(GET_BOARD_NUM, resultSet -> {
            return resultSet.getInt(0);
        });
        return count == null ? 0 : count;
    }
}
