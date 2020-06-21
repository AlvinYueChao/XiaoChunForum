package org.example.alvin.repository;

import org.example.alvin.domain.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Integer> {
    Integer countByBoardId(int boardId);
}
