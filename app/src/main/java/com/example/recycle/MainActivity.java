package com.example.recycle;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView rv_Content;
    ArrayList<Car> car = new ArrayList<>();
    BottomNavigationView bnv_bottomNavigation;

    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;

    private static Resources resources;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        preferences = getSharedPreferences("recycle", Context.MODE_PRIVATE);
        Fragment fr = null;
        if (preferences.getString("mode", "").equals("")) {
            editor = preferences.edit();
            editor.putString("mode", "grid");
            editor.apply();
        }
        if (preferences.getString("mode", null).equals("grid")) {
            fr = new SecondFragment();
        } else if (preferences.getString("mode", null).equals("list")) {
            fr = new HomeFragment();
        }

        getSupportFragmentManager().beginTransaction().replace(R.id.fl_fragment_container, fr).commit();

        bnv_bottomNavigation = findViewById(R.id.bnv_bottom_nav);
        bnv_bottomNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment = null;

                switch (item.getItemId()) {
                    case R.id.nav_bottom_grid :
                        fragment = new SecondFragment();
                        editor = preferences.edit();
                        editor.putString("mode", "grid");
                        editor.apply();
                        break;
                    case R.id.nav_bottom_list :
                        fragment = new HomeFragment();
                        editor = preferences.edit();
                        editor.putString("mode", "list");
                        editor.apply();
                        break;
                }

                getSupportFragmentManager().beginTransaction().replace(R.id.fl_fragment_container, fragment).commit();
                return true;
            }
        });

    }

    public static Resources getResource() {
        return  resources;
    }

    private static Fragment getMode(String mode) {
        Fragment fragment = null;
        return (mode.equals("grid") ? new HomeFragment() : new SecondFragment());
    }
}