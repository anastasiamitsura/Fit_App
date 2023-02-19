package com.example.fit_app;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fit_app.databinding.ActivityMainBinding;

public class ProductInfo extends Fragment {
    private ActivityMainBinding binding;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_product_info, container, false);
    }
}