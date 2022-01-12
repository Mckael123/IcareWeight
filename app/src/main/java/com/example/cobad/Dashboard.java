package com.example.cobad;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Dashboard extends AppCompatActivity {

    BottomNavigationView BottomNavigation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        BottomNavigationView BottomNavigation = findViewById(R.id.navbar);
        getSupportFragmentManager().beginTransaction().replace(R.id.container_fr, new HomeFragment()).commit();
        BottomNavigation.setOnItemSelectedListener(navListener);
    }
    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;
                    switch (item.getItemId()) {
                        case R.id.home:
                            selectedFragment = new HomeFragment();
                            break;
                        case R.id.wo:
                            selectedFragment = new WOFragment();
                            break;
                        case R.id.sc:
                            selectedFragment = new MealFragment();
                            break;
                        case R.id.set:
                            selectedFragment = new SetFragment();
                            break;

                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.container_fr, selectedFragment).commit();

                    return true;
                }
            };
}
