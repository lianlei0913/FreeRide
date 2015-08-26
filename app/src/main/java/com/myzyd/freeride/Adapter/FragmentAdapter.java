package com.myzyd.freeride.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.myzyd.freeride.FirstPageActivity;
import com.myzyd.freeride.ForthPageActivity;
import com.myzyd.freeride.MainActivity;
import com.myzyd.freeride.SecondPageActivity;
import com.myzyd.freeride.ThirdPageActivity;

/**
 * Created by xiehehe on 15/8/5.
 */
public class FragmentAdapter extends FragmentPagerAdapter {
    public final static int TAB_COUNT = 4;

    public FragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int id) {
        switch (id) {
            case MainActivity.TAB_HOME:
                FirstPageActivity firstFragment = new FirstPageActivity();
                return firstFragment;
            case MainActivity.TAB_CATAGORY:
                SecondPageActivity categoryFragment = new SecondPageActivity();
                return categoryFragment;
            case MainActivity.TAB_CAR:
                ThirdPageActivity carFragment = new ThirdPageActivity();
                return carFragment;
            case MainActivity.TAB_MY:
                ForthPageActivity buyFragment = new ForthPageActivity();
                return buyFragment;

        }
        return null;
    }

    @Override
    public int getCount() {
        return TAB_COUNT;
    }
}
