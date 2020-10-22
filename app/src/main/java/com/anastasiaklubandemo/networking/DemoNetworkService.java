package com.anastasiaklubandemo.networking;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface DemoNetworkService {
    @GET("api/{paragraphsAmount}")
    Call<String> geRandomText(@Path("paragraphsAmount") int paragraphsAmount);
}
