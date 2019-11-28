package com.example.myapplication.adpter;



import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class GuideAdapter extends FragmentPagerAdapter {
    private boolean isCanScroll = false ;
    private List<Fragment> fragmentList = new ArrayList<Fragment>();


    public void setScanScroll(boolean isCanScroll) {
        this.isCanScroll = isCanScroll;
    }


    public GuideAdapter(FragmentManager fm, List<Fragment> fragmentList ) {
        super(fm);
        this.fragmentList = fragmentList;
    }




    @Override
    public int getCount() {
        return fragmentList.size();
    }

    public int getc(){
       int i=fragmentList.size();
        return i;
    }

    @Override
    public   Fragment getItem(int arg0) {
        return fragmentList.get( arg0 );
    }



    /*@Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view == o;
    }*/


}
