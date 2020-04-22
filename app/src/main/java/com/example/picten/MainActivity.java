package com.example.picten;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import com.example.picten.ui.main.SectionsPagerAdapter;

import static android.graphics.PorterDuff.Mode.SRC_IN;

public class MainActivity extends AppCompatActivity {

    private int[] mTabIcons = {
        R.drawable.ic_movie_white_24dp,
        R.drawable.ic_tv_white_24dp
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);

        setupTabIcons(tabs);
    }

    private void setupTabIcons(TabLayout tabs) {
        for(int i=0;i<tabs.getTabCount();++i) {
            tabs.getTabAt(i).setIcon(mTabIcons[i]);
        }

        tabs.setTabRippleColorResource(R.color.colorPrimary);

        tabs.getTabAt(0).getIcon().setColorFilter(getResources().getColor(R.color.colorOnSelection), SRC_IN);
        tabs.getTabAt(1).getIcon().setColorFilter(getResources().getColor(R.color.colorOnDeselection), SRC_IN);

        tabs.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                tab.getIcon().setColorFilter(getResources().getColor(R.color.colorOnSelection), SRC_IN);

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                tab.getIcon().setColorFilter(getResources().getColor(R.color.colorOnDeselection), SRC_IN);
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
}