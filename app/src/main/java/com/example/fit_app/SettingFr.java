package com.example.fit_app;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.fit_app.databinding.FragmentSettingBinding;


public class SettingFr extends Fragment {
    private FragmentSettingBinding binding;
    public static String diet = "0";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState
    ) {
        binding = FragmentSettingBinding.inflate(inflater, container, false);
        binding.mishz.setOnClickListener(view -> {
            diet = "1";
        });
        binding.lowygl.setOnClickListener(view -> {
            diet = "2";
        });
        binding.lowbel.setOnClickListener(view -> {
            diet = "3";
        });
        binding.lowjir.setOnClickListener(view -> {
            diet = "4";
        });
        binding.balansed.setOnClickListener(view -> {
            diet = "5";
        });
        binding.lowkk.setOnClickListener(view -> {
            diet = "6";
        });
        return binding.getRoot();

    }
}