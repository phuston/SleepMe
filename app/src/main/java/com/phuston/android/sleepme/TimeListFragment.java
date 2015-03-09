package com.phuston.android.sleepme;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by phuston on 3/9/15.
 */
public class TimeListFragment extends Fragment {
    public static final String EXTRA_SLEEP_TYPE = "com.phuston.android.sleepme.sleep_type";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActivity().setTitle(R.string.time_list_title);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_time_list, parent, false);

        return v;
    }
}
