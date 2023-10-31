package vn.ryan.token.core.service;

public interface AccessKeyService {

    Boolean checkAccessKeyKeyUser(
            String userName, String accessKey
    );

    String generateAccessKey(
            String accessUser
    );
}
