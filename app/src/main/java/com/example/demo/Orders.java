package com.example.demo;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.Button;

public class Orders extends AppCompatActivity implements TabLayout.OnTabSelectedListener{

    Toolbar toolbar;
    TabLayout tabLayout;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orders);

       /* toolbar =(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
*/
        tabLayout =(TabLayout)findViewById(R.id.tablayout);
        viewPager = (ViewPager)findViewById(R.id.viewpager);

        tabLayout.addTab(tabLayout.newTab().setText("all orders"));
        tabLayout.addTab(tabLayout.newTab().setText("open orders"));
        tabLayout.addTab(tabLayout.newTab().setText("cancelled orders"));

        tabLayout.setOnTabSelectedListener(this);

        MyPagerAdapter myPagerAdapter = new MyPagerAdapter(getSupportFragmentManager(),tabLayout.getTabCount());
        viewPager.setAdapter(myPagerAdapter);


    }
    @Override
    public void onTabSelected(TabLayout.Tab tab) {

        viewPager.setCurrentItem(tab.getPosition());

    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }
}
