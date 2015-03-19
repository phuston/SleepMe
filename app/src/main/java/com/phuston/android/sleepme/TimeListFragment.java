package com.phuston.android.sleepme;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Calendar;

/**
 * Created by phuston on 3/9/15.
 */
public class TimeListFragment extends Fragment {
    public static final String EXTRA_SLEEP_TYPE = "com.phuston.android.sleepme.sleep_type";
    public static final String EXTRA_INIT_TIME = "com.phuston.android.sleepme.init_time";
    private TextView mListTitle;
    private Calendar mInitTime;
    private int mType;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActivity().setTitle(R.string.time_list_title);

        mType = (int)getActivity().getIntent().getSerializableExtra(EXTRA_SLEEP_TYPE);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_time_list, parent, false);
        mListTitle = (TextView)v.findViewById(R.id.ListTitle);
        if(mType == 0 || mType == 1){
            mListTitle.setText("You should aim to wake up at:");
        }
        else if(mType == 2){
            mListTitle.setText("You should aim to sleep at:");
        }

        return v;
    }
}
