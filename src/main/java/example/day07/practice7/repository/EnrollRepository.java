package example.day07.practice7.repository;

import example.day07.practice7.entity.EnrollEntity;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnrollRepository extends JpaRepository<EnrollEntity,Integer> {
}
