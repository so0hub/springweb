package example.day11.todo.repository;


import example.day11.todo.entity.TodoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends JpaRepository<TodoEntity,Integer> {
    // 1] JpaRepositroy 로부터 상속받으면 .save(),find(),delete() 등등 제공받는다.
} // class END
