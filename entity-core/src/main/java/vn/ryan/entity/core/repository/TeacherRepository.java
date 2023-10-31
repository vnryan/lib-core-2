package vn.ryan.entity.core.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.ryan.entity.core.entities.Teacher;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {
    Page<Teacher> findByIsActive(Integer active, Pageable pageable);
}
