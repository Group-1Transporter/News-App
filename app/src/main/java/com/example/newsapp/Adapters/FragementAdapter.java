package com.example.newsapp.Adapters;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentTransaction;

import com.example.newsapp.Fragements.FullNewsFragment;
import com.example.newsapp.Fragements.TopHeadlineFragement;

public class FragementAdapter extends FragmentPagerAdapter {
    private TopHeadlineFragement topHeadlineFragement;
    private FullNewsFragment fullNewsFragment;
  
    
    public FragementAdapter(FragmentManager fm) {
        super(fm);

            topHeadlineFragement = new TopHeadlineFragement();


            fullNewsFragment = new FullNewsFragment();

    }


    @NonNull

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return topHeadlineFragement;
            case 1:
                return fullNewsFragment;
            default:
                return topHeadlineFragement;
        }
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        String title = null;
        if (position == 0) {
            title = "Top News";
        }
        if (position == 1) {
            title = "Full News";
        }
        return title;
    }
}
