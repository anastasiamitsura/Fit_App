package com.example.fit_app;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.fit_app.databinding.FragmentHomeScBinding;
import com.example.fit_app.databinding.ItemProductBinding;

import java.util.Arrays;

public class HomeSc extends Fragment {
    private final ProductsRepository repo = new ProductsRepository();
    private FragmentHomeScBinding binding;
    private ItemProductBinding itemProduct;
    String name;
    String money;
    int img;
    int color;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState
    ) {
        binding = FragmentHomeScBinding.inflate(inflater, container, false);
        itemProduct = ItemProductBinding.inflate(getLayoutInflater());
        binding.btSc.setOnClickListener(view -> goscan());
        fillItems();
        if(ProductInfo.check == 1){
            clickAddContact();
        }
        ProductInfo.check = 0;
        return binding.getRoot();

    }

    private void fillItems() {
        binding.container.removeAllViews();
        for (Item item : repo.getContacts()) {
            createItem((Product) item);
        }
    }
    private void createItem(Product product) {
        itemProduct = ItemProductBinding.inflate(getLayoutInflater());
        itemProduct.nametow.setText(product.getName());
        itemProduct.moneytow.setText(product.getMoney());
        itemProduct.imgfood.setBackgroundResource(product.getPict());
        itemProduct.back.setBackgroundColor(product.getColor());
        itemProduct.getRoot().setOnClickListener(view -> product.onClick(binding.getRoot()));
        binding.container.addView(itemProduct.getRoot());
    }

    public void goscan(){
        getParentFragmentManager().
                beginTransaction().
                replace(R.id.container, new ScanerFragment())
                .commit();
    }
    private void clickAddContact() {
        testid();
        repo.addProduct(name, money, img, color);
        fillItems();
    }


    public void testid(){
        switch (ScanerFragment.name) {
            case "сырок чудо":
                name = "Сырок Чудо ваниль";
                money = "40 руб";
                img = R.drawable.chudo;
                if (!ProductInfo.sirokdiet.contains(SettingFr.diet)) color = R.color.redl;
                else color = 0;
                break;
            case "молоко простоквашино":
                name = "Молоко простоквашино";
                money = "75 руб";
                img = R.drawable.milk;
                if (!ProductInfo.milkdiet.contains(SettingFr.diet)) color = R.color.redl;
                else color = 0;
                break;
            case "шоколад милка":
                name = "Шоколад \"Милка\"";
                money = "192 руб";
                img = R.drawable.milka;
                if (!ProductInfo.chololadediet.contains(SettingFr.diet)) color = R.color.redl;
                else color = 0;
                break;
        }
    }
}

