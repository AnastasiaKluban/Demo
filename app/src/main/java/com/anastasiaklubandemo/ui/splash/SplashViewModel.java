package com.anastasiaklubandemo.ui.splash;

import androidx.lifecycle.ViewModel;

public class SplashViewModel extends ViewModel {
    public void start(final SplashView view) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);//delay for splash screen
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    view.goToNextScreen();
                }
            }
        }).start();
    }

}