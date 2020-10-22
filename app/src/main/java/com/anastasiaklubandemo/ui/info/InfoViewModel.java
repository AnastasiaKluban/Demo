package com.anastasiaklubandemo.ui.info;

import androidx.lifecycle.ViewModel;

import com.anastasiaklubandemo.networking.APIClient;
import com.anastasiaklubandemo.networking.DemoNetworkService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class InfoViewModel extends ViewModel {
    private InfoView view;
    private DemoNetworkService service;

    void start(InfoView view) {
        this.view = view;
        this.service = APIClient.getApiService();
    }

    public void loadData() {
        if (view == null) {
            return;
        }
        view.showLoadingMode();
        //call API which generates random text block
        service.geRandomText(1).enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                view.showLoadedData(response.body());
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                view.showError(t.getMessage());
            }
        });
    }
}