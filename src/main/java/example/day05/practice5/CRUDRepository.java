package example.day05.practice5;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CRUDRepository extends JpaRepository< CRUDEntity , Integer > {
}
