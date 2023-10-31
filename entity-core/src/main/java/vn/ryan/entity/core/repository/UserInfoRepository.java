package vn.ryan.entity.core.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.ryan.entity.core.entities.UserInfo;

import java.util.Date;
import java.util.List;

@Repository
public interface UserInfoRepository extends JpaRepository<UserInfo, Long> {
    List<UserInfo> findByIsActive(Integer isActive);
    UserInfo findFirstByUserId(Long userId);
    UserInfo findFirstByUserName(String userName);
    UserInfo findFirstByUserName2(String userName);
    Page<UserInfo> findByUpdatedAtGreaterThan(Date date, Pageable pageable);
    UserInfo findFirstByPhoneAndUserNameIsNull(String phone);
    UserInfo findFirstByPhoneAndUserNameIsNotNull(String phone);
    Page<UserInfo> findByUserNameIsNull(Pageable pageable);
    Page<UserInfo> findByUserNameIsNotNull(Pageable pageable);
}
