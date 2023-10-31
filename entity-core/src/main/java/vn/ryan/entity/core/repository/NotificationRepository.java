package vn.ryan.entity.core.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.ryan.core.constants.NotificationStatus;
import vn.ryan.entity.core.entities.Notification;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long> {
    Page<Notification> findByStatusAndIsActive(NotificationStatus status, Integer isActive, Pageable pageable);
}
