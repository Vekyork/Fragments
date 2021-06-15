package com.android.lesson7.fragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.container, new FragmentOne(), "FragmentOne")
//                .addToBackStack(null)
                .commit();

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.container, new FragmentTwo(), "FragmentTwo")
//                .addToBackStack(null)
                .commit();

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.container, new FragmentThree(), "FragmentThree")
//                .addToBackStack(null)
                .commitNow();

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.container, new FragmentFour(), "FragmentFour")
//                .addToBackStack(null)
                .commit();

        Fragment fragment = getSupportFragmentManager().findFragmentByTag("FragmentThree");
        if (fragment instanceof FragmentThree){
            ((FragmentThree)fragment).doSomethingUseful();

            getSupportFragmentManager()
                    .beginTransaction()
                    .hide(fragment)
//                .addToBackStack(null)
                    .commitNow();

            getSupportFragmentManager()
                    .beginTransaction()
                    .show(fragment)
//                .addToBackStack(null)
                    .commitNow();

//            getSupportFragmentManager().popBackStack("Fragment Two", 0);
        }
    }
}