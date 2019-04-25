package com.wjn.viewlistdemo.activity.viewpagerfragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

public class MyFragmentPagerAdapter extends FragmentPagerAdapter {

    private final int PAGER_COUNT = 4;
    private MyFragment1 myFragment1 = null;
    private MyFragment2 myFragment2 = null;
    private MyFragment3 myFragment3 = null;
    private MyFragment4 myFragment4 = null;


    public MyFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
        myFragment1 = new MyFragment1();
        myFragment2 = new MyFragment2();
        myFragment3 = new MyFragment3();
        myFragment4 = new MyFragment4();
    }


    @Override
    public int getCount() {
        return PAGER_COUNT;
    }

    @Override
    public Object instantiateItem(ViewGroup vg, int position) {
        return super.instantiateItem(vg, position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        super.destroyItem(container, position, object);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position) {
            case MainVFActivity.PAGE_ONE:
                if(null==fragment){
                    fragment = myFragment1;
                }
                break;
            case MainVFActivity.PAGE_TWO:
                if(null==fragment){
                    fragment = myFragment2;
                }
                break;
            case MainVFActivity.PAGE_THREE:
                if(null==fragment){
                    fragment = myFragment3;
                }
                break;
            case MainVFActivity.PAGE_FOUR:
                if(null==fragment){
                    fragment = myFragment4;
                }
                break;
        }
        return fragment;
    }


}
