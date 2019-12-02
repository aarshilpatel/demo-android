package com.example.demo;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

class MyPagerAdapter extends FragmentStatePagerAdapter {

    int tabCount;
    FragmentManager supportFragmentManager;

    public MyPagerAdapter(FragmentManager supportFragmentManager, int tabCount) {
        super(supportFragmentManager);

        this.tabCount = tabCount;
        this.supportFragmentManager = supportFragmentManager;

    }

    @Override
    public Fragment getItem(int i) {
        switch (i) {

            case 0:
                Allorders allorders = new Allorders();
                return allorders;

            case 1:
                Openorders openorders = new Openorders();
                return openorders;

            case 2:
                Canclledorders canclledorders = new Canclledorders();
                return canclledorders;

            default:
                return null;
        }


    }

    @Override
    public int getCount() {
        return tabCount;
    }
}