package com.example.penerapanfragment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {
    //mendeklarasikan bottom navigation
    BottomNavigationView bottomNavigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //menghubungkan bottom navigation dengan id dari bottom navigation
        bottomNavigation = findViewById(R.id.bottom_navigation);
        //memberikan aksi ketika suatu bottom di click

        //membuat default ketika aplikasi di jalankan
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new Beranda()).commit();

        bottomNavigation.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                Fragment selectedFragment = null; //membuat objek fragmen dan di beri nilai null.

                switch (item.getItemId()){ //membuat sebuah kondisi dengan switch case
                    case R.id.nav_home:
                        selectedFragment= new Beranda();
                        break;
                    case R.id.nav_riwayat:
                        selectedFragment = new RiwayatFragment();
                        break;
                    case R.id.nav_profile:
                        selectedFragment = new Profil();
                        break;
                }
                //untuk mengubah setiap fragment
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();
                return true;
            }
            });
    };
}