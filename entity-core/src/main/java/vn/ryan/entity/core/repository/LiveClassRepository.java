package vn.ryan.entity.core.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.ryan.core.constants.LiveClassStatus;
import vn.ryan.entity.core.entities.LiveClass;

import java.util.List;

@Repository
public interface LiveClassRepository extends JpaRepository<LiveClass, Long> {
    List<LiveClass> findByIsActiveAndStatus(Integer isActive, LiveClassStatus status);
    List<LiveClass> findByIsActiveAndStatusOrderByCreatedAtDesc(Integer isActive, LiveClassStatus status);
    List<LiveClass> findByIsActiveAndStatusIn(Integer isActive, List<LiveClassStatus> status);
    List<LiveClass> findByIsActiveInAndStatusIn(List<Integer> isActive, List<LiveClassStatus> status);
    LiveClass findByUuid(String uuid);
    Page<LiveClass> findByIsActiveAndStatus(Integer isActive, LiveClassStatus status, Pageable pageable);
    Page<LiveClass> findByIsActiveAndStatusIn(Integer isActive, List<LiveClassStatus> status, Pageable pageable);
    Page<LiveClass> findByIsActiveInAndStatusIn(List<Integer> isActive, List<LiveClassStatus> status, Pageable pageable);
    Page<LiveClass> findByIsActive(Integer isActive, Pageable pageable);
    Page<LiveClass> findByIsActiveOrderByCreatedAtDesc(Integer isActive, Pageable pageable);
    Page<LiveClass> findByGradeIdAndIsActiveAndStatus(Long gradeId, Integer isActive, LiveClassStatus status, Pageable pageable);
    Page<LiveClass> findByGradeIdAndIsActiveAndStatusIn(Long gradeId, Integer isActive, List<LiveClassStatus> status, Pageable pageable);
    Page<LiveClass> findByGradeIdAndIsActiveInAndStatusIn(Long gradeId, List<Integer> isActive, List<LiveClassStatus> status, Pageable pageable);
    Page<LiveClass> findByGradeIdAndIsActiveOrderByCreatedAtDesc(Long gradeId, Integer isActive, Pageable pageable);
}
