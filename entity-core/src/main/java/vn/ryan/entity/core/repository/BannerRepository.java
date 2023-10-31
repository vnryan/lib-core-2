package vn.ryan.entity.core.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.ryan.entity.core.entities.Banner;

@Repository
public interface BannerRepository extends JpaRepository<Banner, Long> {
    Page<Banner> findByChannelAndTypeAndStatus(Integer channel, Integer type, Integer status, Pageable pageable);
}
