package com.example.fit_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.fit_app.databinding.ActivityMainBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;

    private ActivityMainBinding binding;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_toolbar, menu);
        return true;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportFragmentManager().
                beginTransaction().
                replace(R.id.container, new HomeSc())
                .commit();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.homebt:
                getSupportFragmentManager().
                        beginTransaction().
                        replace(R.id.container, new HomeSc())
                        .commit();
                return true;
            case R.id.settingbt:
                getSupportFragmentManager().
                        beginTransaction().
                        replace(R.id.container, new SettingFr())
                        .commit();
                return true;
            case R.id.profilebt:
                getSupportFragmentManager().
                        beginTransaction().
                        replace(R.id.container, new ProfileFr())
                        .commit();
                return true;
            case R.id.skanbt:
                getSupportFragmentManager().
                        beginTransaction().
                        replace(R.id.container, new ScanerFragment())
                        .commit();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}

