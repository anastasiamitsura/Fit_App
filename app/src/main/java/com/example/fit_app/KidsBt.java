package com.example.fit_app;

import static com.example.fit_app.SettingFr.ogrr;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fit_app.databinding.FragmentKidsBtBinding;
import com.example.fit_app.databinding.FragmentSportBinding;

public class KidsBt extends Fragment {

    private FragmentKidsBtBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState
    ) {
        binding = FragmentKidsBtBinding.inflate(inflater, container, false);
        onCheckk();
        binding.ots.setChecked(true);
        binding.ots.setOnClickListener(view -> {
            ogrr = 30;
            onCheckk();
        });
        binding.zelic.setOnClickListener(view -> {
            ogrr = 31;
            onCheckk();
        });
        binding.lact.setOnClickListener(view -> {
            ogrr = 32;
            onCheckk();
        });
        binding.orech.setOnClickListener(view -> {
            ogrr = 33;
            onCheckk();
        });
        binding.morepr.setOnClickListener(view -> {
            ogrr = 34;
            onCheckk();
        });
        binding.soy.setOnClickListener(view -> {
            ogrr = 35;
            onCheckk();
        });
        binding.openbt.setOnClickListener(view -> openO());
        binding.zelbt.setOnClickListener(view -> openZ());
        binding.lactbt.setOnClickListener(view -> openL());
        binding.orechbt.setOnClickListener(view -> openOR());
        binding.moreprbt.setOnClickListener(view -> openM());
        binding.soybt.setOnClickListener(view -> openS());
        return binding.getRoot();
    }

    private void openO(){
        if (binding.textopis.getVisibility() == View.VISIBLE) {
            binding.textopis.setVisibility(View.GONE);
            binding.openbt.setBackgroundResource(R.drawable.down);
        }
        else {
            binding.textopis.setVisibility(View.VISIBLE);
            binding.openbt.setBackgroundResource(R.drawable.up);
        }
    }
    private void openZ(){
        if (binding.zelop.getVisibility() == View.VISIBLE) {
            binding.zelop.setVisibility(View.GONE);
            binding.zelbt.setBackgroundResource(R.drawable.down);
        }
        else {
            binding.zelop.setVisibility(View.VISIBLE);
            binding.zelbt.setBackgroundResource(R.drawable.up);
        }
    }
    private void openL(){
        if (binding.lacttx.getVisibility() == View.VISIBLE) {
            binding.lacttx.setVisibility(View.GONE);
            binding.lactbt.setBackgroundResource(R.drawable.down);
        }
        else {
            binding.lacttx.setVisibility(View.VISIBLE);
            binding.lactbt.setBackgroundResource(R.drawable.up);
        }
    }
    private void openOR(){
        if (binding.orechtx.getVisibility() == View.VISIBLE) {
            binding.orechtx.setVisibility(View.GONE);
            binding.orechbt.setBackgroundResource(R.drawable.down);
        }
        else {
            binding.orechtx.setVisibility(View.VISIBLE);
            binding.orechbt.setBackgroundResource(R.drawable.up);
        }
    }
    private void openM(){
        if (binding.moreprtx.getVisibility() == View.VISIBLE) {
            binding.moreprtx.setVisibility(View.GONE);
            binding.moreprbt.setBackgroundResource(R.drawable.down);
        }
        else {
            binding.moreprtx.setVisibility(View.VISIBLE);
            binding.moreprbt.setBackgroundResource(R.drawable.up);
        }
    }
    private void openS(){
        if (binding.soytx.getVisibility() == View.VISIBLE) {
            binding.soytx.setVisibility(View.GONE);
            binding.soybt.setBackgroundResource(R.drawable.down);
        }
        else {
            binding.soytx.setVisibility(View.VISIBLE);
            binding.soybt.setBackgroundResource(R.drawable.up);
        }
    }

    public void onCheckk(){
        if (ogrr == 30){
            binding.lact.setChecked(false);
            binding.orech.setChecked(false);
            binding.zelic.setChecked(false);
            binding.morepr.setChecked(false);
            binding.soy.setChecked(false);
        }
        else if (ogrr == 31){
            binding.lact.setChecked(false);
            binding.orech.setChecked(false);
            binding.ots.setChecked(false);
            binding.morepr.setChecked(false);
            binding.soy.setChecked(false);
        }
        else if (ogrr == 32){
            binding.ots.setChecked(false);
            binding.orech.setChecked(false);
            binding.zelic.setChecked(false);
            binding.morepr.setChecked(false);
            binding.soy.setChecked(false);
        }
        else if (ogrr == 33){
            binding.lact.setChecked(false);
            binding.ots.setChecked(false);
            binding.zelic.setChecked(false);
            binding.morepr.setChecked(false);
            binding.soy.setChecked(false);
        }
        else if (ogrr == 34){
            binding.lact.setChecked(false);
            binding.orech.setChecked(false);
            binding.zelic.setChecked(false);
            binding.ots.setChecked(false);
            binding.soy.setChecked(false);
        }
        else if (ogrr == 35){
            binding.lact.setChecked(false);
            binding.orech.setChecked(false);
            binding.zelic.setChecked(false);
            binding.morepr.setChecked(false);
            binding.ots.setChecked(false);
        }
    }
}