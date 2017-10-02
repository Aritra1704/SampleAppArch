package com.cn29.aac.ui.viewpager;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import com.cn29.aac.R;
import com.cn29.aac.ui.viewpager.vm.PagerAgentViewModel;


public class PagerActivity extends AppCompatActivity{
    /**
     * The pager widget, which handles animation and allows swiping horizontally to access previous
     * and next wizard steps.
     */
    private ViewPager mPager;
    private PagerAgentViewModel pagerAgentViewModel;
    /**
     * The pager adapter, which provides the pages to the view pager widget.
     */
    private PagerAdapter mPagerAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pager);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(view -> Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show());
        mPager = findViewById(R.id.pager);
        mPagerAdapter = new ScreenSlidePagerAdapter(getSupportFragmentManager());
        mPager.setAdapter(mPagerAdapter);
        pagerAgentViewModel = ViewModelProviders.of(this).get(PagerAgentViewModel.class);
        pagerAgentViewModel.init();
    }

    /**
     * A simple pager adapter that represents 5 ScreenSlidePageFragment objects, in
     * sequence.
     */
    private class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {
        public static final int FRAGMENT_A_POS = 0;
        public static final int FRAGMENT_B_POS = 1;
        public static final int FRAGMENT_COUNT = 2;
        public ScreenSlidePagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position)
            {
                case FRAGMENT_A_POS :
                    return BlankFragmentA.newInstance("Test","Test1");
                case FRAGMENT_B_POS:
                    return BlankFragmentB.newInstance("Test","Test2");
                default:
                    break;
            }
            return null;
        }

        @Override
        public int getCount() {
            return FRAGMENT_COUNT;
        }
    }

}