package vn.ryan.entity.core.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.ryan.entity.core.entities.Unit;

import java.util.Date;
import java.util.List;

@Repository
public interface UnitRepository extends JpaRepository<Unit, Long> {

    List<Unit> findByCourseId(Long courseId);

    /**
     * @param courseId courseId
     * @param isActive 1 -> active, 0 -> inActive
     * @return
     */

    List<Unit> findByCourseIdAndIsActive(Long courseId, Integer isActive);

    List<Unit> findByCourseIdAndNumAndIsActive(Long courseId, Integer position, Integer isActive);

    List<Unit> findByCourseIdAndIsActiveOrderByNumDesc(Long courseId, Integer isActive);

    List<Unit> findByCourseIdAndIsActiveOrderByNumAsc(Long courseId, Integer isActive);

    /**
     * @param isFree   1 -> free, 0 -> not free
     * @param isActive 1 -> active, 0 -> inActive
     * @return
     */
    List<Unit> findByIsFreeAndIsActive(Integer isFree, Integer isActive);

    List<Unit> findByIdInAndIsActive(List<Long> ids, Integer isActive);

    List<Unit> findByCourseIdAndIsFreeAndIsActive(Long courseId, Integer isFree, Integer isActive);

    Page<Unit> findByUpdatedAtGreaterThan(Date date, Pageable pageable);
}
