package com.phuston.android.sleepme;


import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class SleepOptionsFragment extends Fragment {
    private static final String TAG = "SleepOptionsFragment";
    private Button mSleepNowButton;
    private Button mBedtimeButton;
    private Button mWakeupButton;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActivity().setTitle(R.string.options_title);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_sleep_options, parent, false);

        mSleepNowButton = (Button)v.findViewById(R.id.sleep_now_button);
        mSleepNowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), TimeListActivity.class);
                i.putExtra(TimeListFragment.EXTRA_SLEEP_TYPE, 0);
                startActivity(i);
            }
        });

        mBedtimeButton = (Button)v.findViewById(R.id.know_bedtime_button);
        mBedtimeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), TimeSelectActivity.class);
                i.putExtra(TimeListFragment.EXTRA_SLEEP_TYPE, 1);
                startActivity(i);
            }
        });

        mWakeupButton = (Button)v.findViewById(R.id.know_waketime_button);
        mWakeupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), TimeSelectActivity.class);
                i.putExtra(TimeListFragment.EXTRA_SLEEP_TYPE, 2);
                startActivity(i);
            }
        });

        return v;
    }

}
