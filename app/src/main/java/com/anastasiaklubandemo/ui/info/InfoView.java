package com.anastasiaklubandemo.ui.info;

public interface InfoView {
    void showLoadingMode();

    void showLoadedData(String body);

    void showError(String message);
}
