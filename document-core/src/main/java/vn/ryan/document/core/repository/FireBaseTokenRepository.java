package vn.ryan.document.core.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import vn.ryan.document.core.document.FireBaseToken;

import java.util.List;

@Repository
public interface FireBaseTokenRepository extends MongoRepository<FireBaseToken, String> {
    List<FireBaseToken> findByDeviceIdAndUserNameIsNull(String deviceId);
    List<FireBaseToken> findByDeviceIdAndUserName(String deviceId, String userName);
    List<FireBaseToken> findByDeviceId(String deviceId);
    List<FireBaseToken> findByUserName(String userName);
    List<FireBaseToken> findByUserId(Long userId);
}
