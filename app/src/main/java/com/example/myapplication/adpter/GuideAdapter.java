package com.example.myapplication.adpter;



import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class GuideAdapter extends FragmentStatePagerAdapter {
    private List<Fragment> mlist;

    public GuideAdapter(FragmentManager fm,List<Fragment> mlist) {
        super(fm);
        this.mlist=mlist;
    }

    public void getDate(List<Fragment> mlist) {
        this.mlist = mlist;
    }

    @Override
    public Fragment getItem(int i) {
        return mlist.get(i);
    }

    @Override
    public int getCount() {
        return mlist.size();
    }

}
