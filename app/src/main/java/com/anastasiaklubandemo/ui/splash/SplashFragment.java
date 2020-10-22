package com.anastasiaklubandemo.ui.splash;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.anastasiaklubandemo.R;
import com.anastasiaklubandemo.ui.info.InfoFragment;

public class SplashFragment extends Fragment implements SplashView {

    public static SplashFragment newInstance() {
        return new SplashFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.splash_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        SplashViewModel splashViewModel = new ViewModelProvider(this).get(SplashViewModel.class);
        splashViewModel.start(this);
    }

    @Override
    public void goToNextScreen() {
        if (getActivity() == null) {
            return;
        }
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                getParentFragmentManager().beginTransaction().replace(R.id.container, InfoFragment.newInstance()).commitNow();
            }
        });

    }
}