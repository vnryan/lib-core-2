package vn.ryan.document.core.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import vn.ryan.document.core.document.LogsRating;

import java.util.List;

@Repository
public interface LogsRatingRepository  extends MongoRepository<LogsRating, String> {
    List<LogsRating> findByUsername(String username);
}
