package vn.ryan.document.core.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import vn.ryan.document.core.document.CommentMessage;

@Repository
public interface CommentMessageRepository extends MongoRepository<CommentMessage, String> {
}
