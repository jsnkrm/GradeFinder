package com.example.jsnkrm.project1;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by jsnkrm on 8/5/17.
 */

public class SimpleFragmentPagerAdapter extends FragmentPagerAdapter {

    public SimpleFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    private String tabTitles[] = new String[] { "Add Grade", "List Grade", "Settings"};

    @Override
    public Fragment getItem(int position) {
        if (position == 0)
        {
            return new AddGradeFragment();
        }
        else if (position == 1)
        {
            return new ListGradeFragment();
        }
        else
        {
            return new SettingsFragment();
        }
    }

    @Override
    public int getCount() {
        return 3;
    }


    @Override
    public CharSequence getPageTitle(int position) {
        // Generate title based on item position
        return tabTitles[position];
    }



}
