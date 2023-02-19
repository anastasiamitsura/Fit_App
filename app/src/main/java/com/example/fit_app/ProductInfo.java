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
import com.example.fit_app.databinding.FragmentProductInfoBinding;
import com.example.fit_app.databinding.ItemProductBinding;

public class ProductInfo extends Fragment {
    private FragmentProductInfoBinding binding;
    String name;
    String money;
    String kall;
    String bel;
    String jir;
    String ugl;
    String sostaw;
    int img;
    boolean dieet;
    String goden;
    public final static String milkdiet = "013652";
    public final static String sirokdiet = "0";
    public final static String chololadediet = "0";
    public static int check = 0;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState
    ) {
        binding = FragmentProductInfoBinding.inflate(inflater, container, false);
        testid();
        setInfo();
        binding.save.setOnClickListener(view -> {
            check = 1;
            getParentFragmentManager().
                    beginTransaction().
                    replace(R.id.container, new HomeSc())
                    .commit();
        });
        binding.newersave.setOnClickListener(view -> {
            getParentFragmentManager().
                    beginTransaction().
                    replace(R.id.container, new HomeSc())
                    .commit();
        });
        return binding.getRoot();


    }

    public void setInfo(){
        binding.TowarImg.setBackgroundResource(img);
        binding.nameti.setText(name);
        binding.moneyti.setText(money);
        binding.kall.setText(kall);
        binding.belk.setText(bel);
        binding.jir.setText(jir);
        binding.ugl.setText(ugl);
        binding.goden.setText(goden);
        binding.sostaw.setText(sostaw);
    }

    public void testid(){
        switch (ScanerFragment.name) {
            case "сырок чудо":
                if(sirokdiet.contains(SettingFr.diet)) binding.okeyy.setChecked(true);
                name = "Сырок Чудо ваниль";
                money = "40 руб";
                img = R.drawable.chudo;
                kall = "396 ккал";
                bel = "9 грамма (9%)";
                jir = "26 грамма (58%)";
                ugl = "33 грамма (33%)";
                goden = "30 дней";
                sostaw = "Творожная основа творог, масло сливочное, сахар, загуститель – E1414, стабилизатор - альгинат натрия, ароматизатор Ваниль, консервант-сорбат калия, глазурь сахар, какао-порошок, заменитель масла какао, заменитель молочного жира растительные масла, эмульгатор моно- и диглицериды жирных кислот, антиокислитель – E306, краситель – каротины, эмульгатор 0 соевый лецитин, ароматизатор";
                break;
            case "молоко простоквашино":
                if(milkdiet.contains(SettingFr.diet)) binding.okeyy.setChecked(true);
                name = "Молоко простоквашино";
                money = "75 руб";
                img = R.drawable.milk;
                kall = "53 ккал";
                bel = "3 грамм (23%)";
                jir = "3 грамм (42%)";
                ugl = "5 грамм (35%)";
                goden = "14 дней";
                sostaw = "цельное молоко, молоко нормализованное";
                break;
            case "шоколад милка":
                if(chololadediet.contains(SettingFr.diet)) binding.okeyy.setChecked(true);
                name = "Шоколад \"Милка\"";
                money = "192 руб";
                img = R.drawable.milka;
                kall = "521 ккал";
                bel = "5 грамм (4%)";
                jir = "30 грамм (52%)";
                ugl = "59 грамм (45%)";
                goden = "275 дней";
                sostaw = "Сахар, жир растительный (масло пальмовое), мука пшеничная, сыворотка сухая молочная, масло какао, молоко сухое обезжиренное, сироп глюкозный, какао тертое, жир молочный, пюре клубничное (1,5%), порошок мягкого сыра (1%), агент влагоудерживающий (глицерин), эмульгатор (лецитин соевый), концентрат лимонного сока, йогуртовый порошок, паста ореховая (фундук), концентрат сока чёрной смородины, ароматизаторы, соль, разрыхлители (гидрокарбонат натрия, гидрокарбонат аммония).";
                break;
        }
    }
}