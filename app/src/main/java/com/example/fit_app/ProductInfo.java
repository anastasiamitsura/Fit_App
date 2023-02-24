package com.example.fit_app;

import static com.example.fit_app.SettingFr.ogrr;

import android.graphics.Color;
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
    String kall;
    String bel;
    String jir;
    String ugl;
    boolean gl = false;
    boolean lackt = false;
    boolean orech = false;
    boolean more = false;
    boolean soy = false;
    String sostaw;
    int img;
    String goden;
    public static boolean podhodit;
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
        binding.openenerg.setOnClickListener(view -> {
            if (binding.energ.getVisibility() == View.VISIBLE) {
                binding.energ.setVisibility(View.GONE);
                binding.openenerg.setBackgroundResource(R.drawable.down);
            }
            else {
                binding.energ.setVisibility(View.VISIBLE);
                binding.openenerg.setBackgroundResource(R.drawable.up);
            }
        });
        binding.opensostaw.setOnClickListener(view -> {
            if (binding.sostaw.getVisibility() == View.VISIBLE) {
                binding.sostaw.setVisibility(View.GONE);
                binding.opensostaw.setBackgroundResource(R.drawable.down);
            }
            else {
                binding.sostaw.setVisibility(View.VISIBLE);
                binding.opensostaw.setBackgroundResource(R.drawable.up);
            }
        });
        return binding.getRoot();


    }

    public void setInfo(){
        binding.TowarImg.setBackgroundResource(0);
        binding.TowarImg.setBackgroundResource(img);
        binding.nameti.setText(name);
        binding.kall.setText(kall);
        binding.belk.setText(bel);
        binding.jir.setText(jir);
        binding.ugl.setText(ugl);
        binding.goden.setText(goden);
        binding.sostaw.setText(sostaw);
        if (podhodit) {
            binding.bgg.setBackgroundColor(Color.GREEN);
            binding.okeyy.setChecked(true);
        }
        else{
            binding.bgg.setBackgroundColor(Color.RED);
            binding.okeyy.setChecked(false);
        }
    }

    public void testid(){
        switch (ScanerFragment.name) {
            case "сырок чудо":
                name = "Сырок Чудо ваниль";
                img = R.drawable.chudo;
                kall = "396 ккал";
                gl = true;
                lackt = true;
                orech = false;
                more = false;
                soy = true;
                bel = "9 грамма (9%)";
                jir = "26 грамма (58%)";
                ugl = "33 грамма (33%)";
                goden = "30 дней";
                sostaw = "Творожная основа творог, масло сливочное, сахар, загуститель – E1414, стабилизатор - альгинат натрия, ароматизатор Ваниль, консервант-сорбат калия, глазурь сахар, какао-порошок, заменитель масла какао, заменитель молочного жира растительные масла, эмульгатор моно- и диглицериды жирных кислот, антиокислитель – E306, краситель – каротины, эмульгатор 0 соевый лецитин, ароматизатор";
                testSostaw();
                break;
            case "молоко простоквашино":
                name = "Молоко простоквашино";
                img = R.drawable.milk;
                kall = "53 ккал";
                gl = true;
                lackt = true;
                orech = false;
                more = false;
                soy = false;
                bel = "3 грамм (23%)";
                jir = "3 грамм (42%)";
                ugl = "5 грамм (35%)";
                goden = "14 дней";
                sostaw = "цельное молоко, молоко нормализованное";
                testSostaw();
                break;
            case "шоколад милка":
                name = "Шоколад \"Милка\"";
                gl = true;
                lackt = false;
                img = R.drawable.milka;
                kall = "521 ккал";
                orech = true;
                more = false;
                soy = false;
                bel = "5 грамм (4%)";
                jir = "30 грамм (52%)";
                ugl = "59 грамм (45%)";
                goden = "275 дней";
                sostaw = "Сахар, жир растительный (масло пальмовое), мука пшеничная, сыворотка сухая молочная, масло какао, молоко сухое обезжиренное, сироп глюкозный, какао тертое, жир молочный, пюре клубничное (1,5%), порошок мягкого сыра (1%), агент влагоудерживающий (глицерин), эмульгатор (лецитин соевый), концентрат лимонного сока, йогуртовый порошок, паста ореховая (фундук), концентрат сока чёрной смородины, ароматизаторы, соль, разрыхлители (гидрокарбонат натрия, гидрокарбонат аммония).";
                testSostaw();
                break;
        }
    }
    public void testSostaw(){
        if (ogrr == 0){
            podhodit = true;
        }
        else if(ogrr < 20){
            if (!sostaw.contains("Е210") && !sostaw.contains("E102") && !sostaw.contains("E110") && !sostaw.contains("E129") && !sostaw.contains("E621")){
                if(ogrr == 10) podhodit = true;
                else if(ogrr == 11 && !gl) podhodit = true;
                else if(ogrr == 12 && !lackt) podhodit = true;
                else if(ogrr == 13 && !orech) podhodit = true;
                else if(ogrr == 14 && !more) podhodit = true;
                else if(ogrr == 15 && !soy) podhodit = true;
                else podhodit = false;
            }
            else podhodit = false;
        }
        else if(ogrr > 19 && ogrr < 30){
            if (!sostaw.contains("Е304") && !sostaw.contains("Е560")){
                if(ogrr == 20) podhodit = true;
                else if(ogrr == 21 && !gl) podhodit = true;
                else if(ogrr == 22 && !lackt) podhodit = true;
                else if(ogrr == 23 && !orech) podhodit = true;
                else if(ogrr == 24 && !more) podhodit = true;
                else if(ogrr == 25 && !soy) podhodit = true;
                else podhodit = false;
            }
            else podhodit = false;
        }
        else if(ogrr > 29 && ogrr < 40){
            if (!sostaw.contains("Е102") && !sostaw.contains("E110") && !sostaw.contains("E129") && !sostaw.contains("E133") && !sostaw.contains("Е211")){
                if(ogrr == 30) podhodit = true;
                else if(ogrr == 31 && !gl) podhodit = true;
                else if(ogrr == 32 && !lackt) podhodit = true;
                else if(ogrr == 33 && !orech) podhodit = true;
                else if(ogrr == 34 && !more) podhodit = true;
                else if(ogrr == 35 && !soy) podhodit = true;
                else podhodit = false;
            }
            else podhodit = false;
        }
    }
}