package com.anastasiaklubandemo.networking;

import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * it is better to use DI instead
 */
public class APIClient {
    private static DemoNetworkService networkService = null;

    public static DemoNetworkService getApiService() {
        if (networkService == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("https://litipsum.com/")
                    .addConverterFactory(ScalarsConverterFactory.create())
                    .build();
            networkService = retrofit.create(DemoNetworkService.class);
        }

        return networkService;
    }

}
