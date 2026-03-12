package example.종합.예제10.board.repository;

import example.종합.예제10.board.entity.ReplyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReplyRepository extends JpaRepository<ReplyEntity,Integer> {

}
