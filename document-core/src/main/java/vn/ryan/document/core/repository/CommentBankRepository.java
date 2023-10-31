package vn.ryan.document.core.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import vn.ryan.document.core.document.CommentBank;

@Repository
public interface CommentBankRepository extends MongoRepository<CommentBank, String> {
    Page<CommentBank> findAll(Pageable pageable);
    Page<CommentBank> findByGroupAndGrade(Integer group, Integer grade, Pageable pageable);
}
