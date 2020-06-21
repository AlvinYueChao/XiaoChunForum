package org.example.alvin.dao;

import org.example.alvin.domain.Board;
import org.example.alvin.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDao extends BaseDao<Board> {

    private BoardRepository boardRepository;

    @Autowired
    public void setBoardRepository(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    public int getBoardNum() {
        long count = this.boardRepository.count();
        return (int) count;
    }
}
