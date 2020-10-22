package com.anastasiaklubandemo.ui.info;

import androidx.appcompat.widget.AppCompatTextView;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.anastasiaklubandemo.R;

public class InfoFragment extends Fragment implements InfoView {

    private InfoViewModel infoViewModel;
    private View btnLoading;
    private View progressBar;
    private AppCompatTextView infoText;

    public static InfoFragment newInstance() {
        return new InfoFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.main_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        infoViewModel = new ViewModelProvider(this).get(InfoViewModel.class);
        infoViewModel.start(this);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        progressBar = view.findViewById(R.id.progress);
        infoText = (AppCompatTextView) view.findViewById(R.id.tvLoadedInfo);
        btnLoading = view.findViewById(R.id.btnLoadData);
        btnLoading.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                infoViewModel.loadData();
            }
        });
    }

    @Override
    public void showLoadingMode() {
        btnLoading.setEnabled(false);
        progressBar.setVisibility(View.VISIBLE);
        infoText.setText("");
    }

    @Override
    public void showLoadedData(String body) {
        btnLoading.setEnabled(true);
        progressBar.setVisibility(View.GONE);
        infoText.setText(body);
    }

    @Override
    public void showError(String message) {
        //unlock button for the ability to do it again
        btnLoading.setEnabled(true);
        progressBar.setVisibility(View.GONE);
        infoText.setText(message);
    }
}