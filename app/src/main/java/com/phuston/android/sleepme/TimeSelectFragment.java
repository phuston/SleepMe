package com.phuston.android.sleepme;


import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TimePicker;

import java.util.Calendar;


public class TimeSelectFragment extends Fragment implements TimePicker.OnTimeChangedListener{
    private static final String TAG = "TimeSelectFragment";
    private Button mContinueButton;
    private Calendar mTime = Calendar.getInstance();
    private int mType;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActivity().setTitle(R.string.options_title);

        mType = (int)getActivity().getIntent().getSerializableExtra(TimeListFragment.EXTRA_SLEEP_TYPE);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_time_select, parent, false);

        TimePicker picker= (TimePicker)v.findViewById(R.id.picker);
        picker.setOnTimeChangedListener(this);

        Button mContinueButton = (Button)v.findViewById(R.id.next_button);
        mContinueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), TimeListActivity.class);
                i.putExtra(TimeListFragment.EXTRA_SLEEP_TYPE, mType);
                i.putExtra(TimeListFragment.EXTRA_INIT_TIME, mTime);
                startActivity(i);
            }
        });

        return v;
    }

    @Override
    public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
        Calendar then=Calendar.getInstance();
        then.set(Calendar.HOUR_OF_DAY, hourOfDay);
        then.set(Calendar.MINUTE, minute);
        then.set(Calendar.SECOND, 0);

        mTime.set(Calendar.HOUR_OF_DAY, hourOfDay);
        mTime.set(Calendar.MINUTE, minute);
        mTime.set(Calendar.SECOND, 0);
    }
}
