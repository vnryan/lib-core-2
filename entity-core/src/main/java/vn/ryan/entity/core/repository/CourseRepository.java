package vn.ryan.entity.core.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.ryan.entity.core.entities.Course;

import java.util.Date;
import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    List<Course> findByIsActive(Integer active);
    List<Course> findByGradeIdAndIsActive(Integer gradeId, Integer active);
    Course findFirstByGradeIdAndLevelIdAndIsActive(Integer gradeId, Integer levelId, Integer active);
    Page<Course> findByUpdatedAtGreaterThan(Date date, Pageable pageable);
    Course findFirstByGradeIdAndLevelIdAndIsActiveOrderByCreatedAtDesc(Integer gradeId, Integer levelId, Integer active);
}
