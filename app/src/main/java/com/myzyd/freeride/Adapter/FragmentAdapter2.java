package com.myzyd.freeride.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.myzyd.freeride.SecondPageActivity;
import com.myzyd.freeride.secondActivity.SortAct1;
import com.myzyd.freeride.secondActivity.SortAct2;
import com.myzyd.freeride.secondActivity.SortAct3;
import com.myzyd.freeride.secondActivity.SortAct4;

/**
 * Created by xiehehe on 15/8/7.
 */
public class FragmentAdapter2 extends FragmentPagerAdapter {
    public final static int TAB_COUNTS = 4;

    public FragmentAdapter2(FragmentManager m) {
        super(m);
    }
    @Override
    public Fragment getItem(int id) {
        switch (id) {
            case SecondPageActivity.VEGETABLE:
                SortAct1 sortAct1 = new SortAct1();
                return sortAct1;
            case SecondPageActivity.FRESH:
                SortAct2 sortAct2 = new SortAct2();
                return sortAct2;
            case SecondPageActivity.AQUATIC:
                SortAct3 sortAct3 = new SortAct3();
                return sortAct3;
            case SecondPageActivity.OTHER:
                SortAct4 sortAct4 = new SortAct4();
                return sortAct4;

        }
        return null;
    }
    @Override
    public int getCount() {
        return TAB_COUNTS;
    }
}
