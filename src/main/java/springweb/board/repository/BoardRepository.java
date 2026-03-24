package springweb.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import springweb.board.entity.BoardEntity;

@Repository
public interface BoardRepository extends JpaRepository<BoardEntity,Long> {
}
