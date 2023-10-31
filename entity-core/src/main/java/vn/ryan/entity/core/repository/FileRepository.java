package vn.ryan.entity.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.ryan.entity.core.entities.File;

import java.util.List;

@Repository
public interface FileRepository extends JpaRepository<File, Long> {
    List<File> findByIsActive(Integer isActive);
    List<File> findByTypeAndIsActive(Integer type, Integer isActive);
}
