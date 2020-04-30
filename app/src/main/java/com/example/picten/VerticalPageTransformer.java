package com.example.picten;

import android.view.View;
import androidx.viewpager.widget.ViewPager;

public class VerticalPageTransformer implements ViewPager.PageTransformer {

    @Override
    public void transformPage(View view, float position) {

        if (position < -1) { // [-Infinity,-1)
            // This page is way off-screen to the left.
            view.setAlpha(0);
        } else if (position <= 0) { // [-1,1]
            view.setAlpha(1);

            // Counteract the default slide transition
            view.setTranslationX(view.getWidth() * -position);

            //set Y position to swipe in from top
            float yPosition = position * view.getHeight();
            view.setTranslationY(yPosition);

            view.setScaleX(1);
            view.setScaleY(1);
        } else if (position <= 1) { // (1,+Infinity]
            // This page is way off-screen to the right.
            view.setAlpha(1 - position);

            // Counteract the default slide transition
            view.setTranslationX(view.getWidth() * -position);
            view.setTranslationY(0);

            float scaleFactor = 0.65f + (1-0.65f)*(1-Math.abs(position));
            view.setScaleX(scaleFactor);
            view.setScaleY(scaleFactor);
        } else if (position > 1) { // (1,+Infinity]
            // This page is way off-screen to the right.
            view.setAlpha(0);
        }
    }
}