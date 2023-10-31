package vn.ryan.entity.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import vn.ryan.entity.core.entities.Config;

import javax.transaction.Transactional;

@Repository
public interface ConfigRepository extends JpaRepository<Config, Long> {
    Config findFirstByKey(String configKey);
    @Transactional
    @Modifying
    @Query(value = "UPDATE Config c SET c.value = :value WHERE id = :id")
    void updateValue(@Param("id") Long id, @Param("value") String value);
}
