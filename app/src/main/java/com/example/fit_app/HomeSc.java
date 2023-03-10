package com.example.fit_app;

import static com.example.fit_app.ProductInfo.podhodit;
import static com.example.fit_app.SettingFr.ogrr;

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
        itemProduct.imgfood.setBackgroundResource(0);
        switch (ScanerFragment.name) {
            case "?????????? ????????":
                name = "?????????? ???????? ????????????";
                money = "40 ??????";
                img = R.drawable.chudo;
                if (!podhodit) color = Color.RED;
                else color = 0;
                break;
            case "???????????? ??????????????????????????":
                name = "???????????? ??????????????????????????";
                money = "75 ??????";
                img = R.drawable.milk;
                if (!podhodit) color = Color.RED;
                else color = 0;
                break;
            case "?????????????? ??????????":
                name = "?????????????? \"??????????\"";
                money = "192 ??????";
                img = R.drawable.milka;
                if (!podhodit) color = Color.RED;
                else color = 0;
                break;
        }
    }
}

