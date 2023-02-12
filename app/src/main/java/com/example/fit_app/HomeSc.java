package com.example.fit_app;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fit_app.databinding.ActivityMainBinding;
import com.example.fit_app.databinding.FragmentHomeScBinding;

public class HomeSc extends Fragment {

    private FragmentHomeScBinding binding;

    public HomeSc() {
        super(R.layout.fragment_home_sc);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding = FragmentHomeScBinding.inflate(getLayoutInflater());
        binding.btSc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.txt.setText("dsrh");
            }
        });
    }

}