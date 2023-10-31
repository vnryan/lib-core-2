package vn.ryan.document.core.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import vn.ryan.document.core.document.ZaloOaUser;

import java.util.List;

@Repository
public interface ZaloOaUserRepository extends MongoRepository<ZaloOaUser, String> {
    List<ZaloOaUser> findByZaloId(String zaloId);
    ZaloOaUser findFirstByZaloIdAndUserName(String zaloId, String userName);
}
