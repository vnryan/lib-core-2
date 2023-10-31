package vn.ryan.document.core.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import vn.ryan.core.constants.NotificationStatus;
import vn.ryan.document.core.document.NotificationLogs;

@Repository
public interface NotificationLogsRepository extends MongoRepository<NotificationLogs, String> {
    Page<NotificationLogs> findByUserNameAndStatusOrderByCreatedAtDesc(String userName, NotificationStatus status, Pageable pageable);
    Page<NotificationLogs> findByPhoneAndStatusOrderByCreatedAtDesc(String phone, NotificationStatus status, Pageable pageable);
    Page<NotificationLogs> findByDeviceIdsAndStatusOrderByCreatedAtDesc(String deviceIds, NotificationStatus status, Pageable pageable);
    NotificationLogs findByUuid(String uuid);
}
