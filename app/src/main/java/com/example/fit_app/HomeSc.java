package com.example.fit_app;

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
        if(ScanerFragment.name.equals("сырок чудо") || ScanerFragment.name.equals("молоко простоквашино") || ScanerFragment.name.equals("шоколад милка")){
            clickAddContact();
        }
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
        repo.addProduct(name, money, img);
        fillItems();
    }


    public void testid(){
        switch (ScanerFragment.name) {
            case "сырок чудо":
                name = "Сырок Чудо ваниль";
                money = "40 руб";
                img = R.drawable.chudo;
                break;
            case "молоко простоквашино":
                name = "Молоко простоквашино";
                money = "75 руб";
                img = R.drawable.milk;
                break;
            case "шоколад милка":
                name = "Шоколад \"Милка\"";
                money = "192 руб";
                img = R.drawable.milka;
                break;
        }
    }
}

