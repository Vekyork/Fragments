package com.android.lesson7.fragments;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.widget.Toolbar;

import com.google.android.material.navigation.NavigationView;

public class NavDrawerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nav_drawer);

        DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);
        Toolbar toolbar = findViewById(R.id.toolbar);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this,
                drawerLayout,
                toolbar,
                R.string.app_name,
                R.string.app_name
        );
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                drawerLayout.closeDrawer(GravityCompat.START);
                if (item.getItemId() == R.id.option_one){
                    getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.nested_container, new FragmentOne())
                            .commit();
                    return  true;
                }
                if (item.getItemId() == R.id.option_two) {
                    getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.nested_container, new FragmentTwo())
                            .commit();
                    return true;
                }
                if (item.getItemId() == R.id.option_Three) {
                    getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.nested_container, new FragmentThree())
                            .commit();
                    return true;
                }
                return false;
            }
        });
    }
}