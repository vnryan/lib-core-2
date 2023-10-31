package vn.ryan.entity.core.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.ryan.entity.core.entities.Lesson;

import java.util.Date;
import java.util.List;

@Repository
public interface LessonRepository extends JpaRepository<Lesson, Long> {
    List<Lesson> findByUnitIdAndIsActive(Long unitId, Integer isActive);
    List<Lesson> findByUnitIdAndIsActiveOrderByPositionAsc(Long unitId, Integer isActive);
    List<Lesson> findByUnitIdInAndIsFreeAndIsActive(List<Long> unitIds, Integer isFree, Integer isActive);
    Lesson findFirstByUnitIdAndPositionAndIsActive(Long unitId, Integer position, Integer isActive);
    List<Lesson> findByUnitId(Long unitId);

    List<Lesson> findByUnitIdAndIsActiveInOrderByPositionAsc(Long unitId, List<Integer> status);
    Page<Lesson> findByUpdatedAtGreaterThan(Date date, Pageable pageable);
}
