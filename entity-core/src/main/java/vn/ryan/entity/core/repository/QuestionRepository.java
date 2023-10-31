package vn.ryan.entity.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.ryan.entity.core.entities.Question;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {
}
