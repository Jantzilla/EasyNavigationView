package com.creativesourceapps.android.app;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.creativesourceapps.android.simpledrawerlayout.SimpleDrawerLayout;

public class MainActivity extends AppCompatActivity {

    private View navigation;
    private TextView option_1, option_2, option_3, option_4;
    public static Fragment restoreFragment;
    private Fragment fragment;
    private SimpleDrawerLayout drawerLayout;
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        option_1 = findViewById(R.id.tv_option1);
        option_2 = findViewById(R.id.tv_option2);
        option_3 = findViewById(R.id.tv_option3);
        option_4 = findViewById(R.id.tv_option4);
        drawerLayout = findViewById(R.id.simple_drawer_layout);

        fragmentManager = getSupportFragmentManager();

        option_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animateNavigation(option_1);
                drawerLayout.closeDrawers();
                fragment = new FirstFragment();
                MainActivity.restoreFragment = fragment;
                fragmentManager.beginTransaction().replace(R.id.fl_content_main, fragment).commit();
            }
        });
        option_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animateNavigation(option_2);
                drawerLayout.closeDrawers();
                fragment = new SecondFragment();
                MainActivity.restoreFragment = fragment;
                fragmentManager.beginTransaction().replace(R.id.fl_content_main, fragment).commit();
            }
        });
        option_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animateNavigation(option_3);
                drawerLayout.closeDrawers();
                fragment = new ThirdFragment();
                MainActivity.restoreFragment = fragment;
                fragmentManager.beginTransaction().replace(R.id.fl_content_main, fragment).commit();
            }
        });
        option_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animateNavigation(option_4);
                drawerLayout.closeDrawers();
                fragment = new FourthFragment();
                MainActivity.restoreFragment = fragment;
                fragmentManager.beginTransaction().replace(R.id.fl_content_main, fragment).commit();
            }
        });

    }

    private void animateNavigation(View view) {

        if(navigation == null) {
            navigation = view;
            navigation.setBackgroundColor(Color.WHITE);
        }
        else {
            navigation.setBackgroundColor(Color.DKGRAY);
            view.setBackgroundColor(Color.WHITE);
            navigation = view;
        }
    }
}
