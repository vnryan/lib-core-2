package vn.edupiamath.zaloclient.services;

import retrofit2.Call;
import retrofit2.http.*;

public interface CallAuthZaloClient {

    @FormUrlEncoded
    @POST("/v4/oa/access_token")
    Call<Object> getAccessTokenRetrofit(
            @Field("grant_type") String grantType,
            @Field("app_id") String appId,
            @Field("code") String code,
            @Header("secret_key") String secretKey
    );

    @FormUrlEncoded
    @POST("/v4/oa/access_token")
    Call<Object> getRefreshTokenRetrofit(
            @Field("grant_type") String grantType,
            @Field("app_id") String appId,
            @Field("refresh_token") String refreshToken,
            @Header("secret_key") String secretKey
    );
}
