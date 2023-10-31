package vn.ryan.retrofit.configuration;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import okhttp3.logging.HttpLoggingInterceptor.Level;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitCoreConfig {
  
  public static Retrofit getRetrofit(String baseUrl, String logLevel) {
    OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
    HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
    logging.setLevel(Level.valueOf(logLevel));
    httpClient.addInterceptor(logging);
  
    OkHttpClient client = httpClient.build();
    return new Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(new NullOnEmptyConverterFactory())
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build();
  }
  
  public static <T> T create(String baseUrl, Class<T> clazz, String logLevel) {
    Retrofit retrofit = getRetrofit(baseUrl, logLevel);
    return retrofit.create(clazz);
  }
  
}
