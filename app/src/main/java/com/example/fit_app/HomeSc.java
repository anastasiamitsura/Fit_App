package com.example.fit_app;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.fit_app.databinding.FragmentHomeScBinding;
import com.example.fit_app.databinding.ItemProductBinding;

import java.util.Arrays;

public class HomeSc extends Fragment {
    private static Product[] products = new Product[0];
    private FragmentHomeScBinding binding;
    private ItemProductBinding itemProduct;
    String name;
    String money;
    int img;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState
    ) {
        binding = FragmentHomeScBinding.inflate(inflater, container, false);
        itemProduct = ItemProductBinding.inflate(getLayoutInflater());
        binding.btSc.setOnClickListener(view -> goscan());
        if(ScanerFragment.name.equals("сырок чудо") || ScanerFragment.name.equals("молоко простоквашино") || ScanerFragment.name.equals("шоколад милка")){
            createItem();
        }
        return binding.getRoot();

    }

    public void goscan(){
        getParentFragmentManager().
                beginTransaction().
                replace(R.id.container, new ScanerFragment())
                .commit();
    }

    public void createItem(){
        testid();
        itemProduct.nametow.setText(this.name);
        itemProduct.moneytow.setText(this.money);
        itemProduct.imgfood.setBackgroundResource(img);
        binding.container.addView(itemProduct.getRoot());
    }


    public void testid(){
        if(ScanerFragment.name.equals("сырок чудо")){
            name = "Сырок Чудо ваниль";
            money = "40 руб";
            img = R.drawable.chudo;
        }
        else if(ScanerFragment.name.equals("молоко простоквашино")){
            name = "Молоко простоквашино";
            money = "75 руб";
            img = R.drawable.milk;
        }
        else if(ScanerFragment.name.equals("шоколад милка")){
            name = "Шоколад молочный \"Милка\"";
            money = "192 руб";
            img = R.drawable.milka;
        }
    }
}

