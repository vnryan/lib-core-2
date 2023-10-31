package vn.ryan.entity.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.ryan.entity.core.entities.LessonExercise;

import java.util.List;

@Repository
public interface LessonExerciseRepository extends JpaRepository<LessonExercise, Long> {
    List<LessonExercise> findByLessonIdOrderByPositionAsc(
            Long lessonId
    );

    List<LessonExercise> findByLessonId(
            Long lessonId
    );
}
