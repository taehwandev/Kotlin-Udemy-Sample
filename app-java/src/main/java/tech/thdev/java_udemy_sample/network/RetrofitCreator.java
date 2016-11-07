package tech.thdev.java_udemy_sample.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by tae-hwan on 11/7/16.
 */

public class RetrofitCreator {

    public static Retrofit createRetrofit() {
        return new Retrofit.Builder()
                .baseUrl("https://api.flickr.com/services/rest/")
                .addConverterFactory(GsonConverterFactory.create())
//                .client(createOkHttpClient())
                .build();
    }

    /**
     * TODO Http 로그가 궁금하다면 다음을 확인하세요.
     * OkHttp에 HttpLoggingInterceptor을 추가하여 Log을 출력한다
     * <a href="http://square.github.io/okhttp/">OkHttp</a>
     * <a href="https://github.com/square/okhttp/tree/master/okhttp-logging-interceptor">Okhttp</a>
     */
//    private static OkHttpClient createOkHttpClient() {
//        OkHttpClient.Builder builder = new OkHttpClient.Builder();
//        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
//        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
//        builder.addInterceptor(interceptor);
//        return builder.build();
//    }
}
