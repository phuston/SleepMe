package com.phuston.android.sleepme;

import android.app.Fragment;

/**
 * Created by phuston on 1/30/15.
 */
public class TimeListActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new TimeListFragment();
    }
}
