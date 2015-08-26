package com.myzyd.freeride.secondActivity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.myzyd.freeride.R;

/**
 * Created by xiehehe on 15/8/4.
 */
public class SortAct3  extends Fragment{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.sort_aquatic, container, false);
        return v;
    }
}
