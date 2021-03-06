package com.xutao.xutaodemo.activity;

import java.util.ArrayList;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.PagerTitleStrip;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;

import com.xutao.xutaodemo.R;

public class ViewPagerDemo extends Activity {
    private ViewPager mViewPager;
    private PagerTitleStrip mPagerTitleStrip;
   
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewpager);
        mViewPager = (ViewPager) findViewById(R.id.viewpager);
        mPagerTitleStrip = (PagerTitleStrip) findViewById(R.id.pagertitle);
       
        LayoutInflater mLi = LayoutInflater.from(this);
        View view1 = mLi.inflate(R.layout.view_viewpager1, null);
        View view2 = mLi.inflate(R.layout.view_viewpager1, null);
        View view3 = mLi.inflate(R.layout.view_viewpager1, null);
        View view4 = mLi.inflate(R.layout.view_viewpager1, null);
       
        final ArrayList<View> views = new ArrayList<View>();
        views.add(view1);
        views.add(view2);
        views.add(view3);
        views.add(view4);
       
        final ArrayList<String> titles = new ArrayList<String>();
        titles.add("tab1");
        titles.add("tab2");
        titles.add("tab3");
        titles.add("tab4");
       
        PagerAdapter mPagerAdapter = new PagerAdapter() {
            public boolean isViewFromObject(View arg0, Object arg1) {
                return arg0 == arg1;
            };
           
            public int getCount() {
                return views.size();
            };
           
            public void destroyItem(View container, int position, Object object) {
                ((ViewPager)container).removeView(views.get(position));
            };
           
            public CharSequence getPageTitle(int position) {
                return titles.get(position);
            }
           
            public Object instantiateItem(View container, int position) {
                ((ViewPager)container).addView(views.get(position));
                return views.get(position);
            };
        };
       
        mViewPager.setAdapter(mPagerAdapter);
       
        ActionBar actionBar = getActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
       
    }


}

