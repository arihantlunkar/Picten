package com.example.picten;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class VerticalSectionsPagerAdapter extends FragmentPagerAdapter {

    public VerticalSectionsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        // getItem is called to instantiate the fragment for the given page.
        // Return a HorizontalPlaceholderFragment (defined as a static inner class below).
        return VerticalPlaceholderFragment.newInstance(position + 1);
    }

    @Override
    public int getCount() {
        // Show 10 total pages.
        return 10;
    }
}