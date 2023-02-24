package com.example.fit_app;

import android.graphics.Color;
import android.graphics.PorterDuff;
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
    public static int ogrr = 0;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState
    ) {
        binding = FragmentSettingBinding.inflate(inflater, container, false);
        isTruee();
        binding.healthbt.setOnClickListener(view -> {
            ogrr = ogrr % 10 + 10;
            getParentFragmentManager().
                    beginTransaction().
                    replace(R.id.container, new HealthFr())
                    .commit();
        });
        binding.sportbt.setOnClickListener(view -> {
            ogrr = ogrr % 10 + 20;
            getParentFragmentManager().
                    beginTransaction().
                    replace(R.id.container, new SportFr())
                    .commit();
        });
        binding.kidsbt.setOnClickListener(view -> {
            ogrr = ogrr % 10 + 30;
            getParentFragmentManager().
                    beginTransaction().
                    replace(R.id.container, new KidsBt())
                    .commit();
        });
        return binding.getRoot();
    }

    public void isTruee(){
        if(ogrr < 20 && ogrr > 9){
            binding.healthbt.setBackgroundColor(Color.GREEN);
            binding.sportbt.setBackgroundColor(Color.GRAY);
            binding.kidsbt.setBackgroundColor(Color.GRAY);
        }
        else if(ogrr < 30 && ogrr > 19){
            binding.healthbt.setBackgroundColor(Color.GRAY);
            binding.sportbt.setBackgroundColor(Color.GREEN);
            binding.kidsbt.setBackgroundColor(Color.GRAY);
        }
        else if(ogrr > 29){
            binding.healthbt.setBackgroundColor(Color.GRAY);
            binding.sportbt.setBackgroundColor(Color.GRAY);
            binding.kidsbt.setBackgroundColor(Color.GREEN);
        }
    }
}