package vn.ryan.entity.core.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.ryan.entity.core.entities.News;

import java.util.List;

@Repository
public interface NewsRepository extends JpaRepository<News, Long> {
    List<News> findByStatus(Integer status);

    Page<News> findByTypeAndStatus(Integer type, Integer status, Pageable pageable);

    Page<News> findByTypeAndStatusAndHomePage(Integer type, Integer status, Integer homePage, Pageable pageable);

    Page<News> findByTypeAndStatusAndIsHot(Integer type, Integer status, Integer isHot, Pageable pageable);

    Page<News> findByIdNotAndTypeAndStatusAndCategoryId(Long newsId, Integer type, Integer status, Integer categoryId, Pageable pageable);
}
