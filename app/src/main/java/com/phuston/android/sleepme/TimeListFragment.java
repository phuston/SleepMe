package com.phuston.android.sleepme;


import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * Created by phuston on 3/9/15.
 */
public class TimeListFragment extends ListFragment {
    public static final String EXTRA_SLEEP_TYPE = "com.phuston.android.sleepme.sleep_type";
    public static final String EXTRA_INIT_TIME = "com.phuston.android.sleepme.init_time";
    private TextView mListTitle;
    private Calendar mInitTime;
    private int mType;
    private ArrayList<Calendar> mTimeList;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActivity().setTitle(R.string.time_list_title);

        mType = (int)getActivity().getIntent().getSerializableExtra(EXTRA_SLEEP_TYPE);
        mInitTime = (Calendar)getActivity().getIntent().getSerializableExtra(EXTRA_INIT_TIME);

        if(mType == 0 || mType == 1){
            WakeList mWakeList = new WakeList(mInitTime);
            mTimeList = mWakeList.getTimes();
        }

        else if(mType == 2){
            SleepList mSleepList = new SleepList(mInitTime);
            mTimeList = mSleepList.getTimes();
        }

        TimeAdapter adapter = new TimeAdapter (mTimeList);
        setListAdapter(adapter);
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


    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        Calendar t = ((TimeAdapter)getListAdapter()).getItem(position);

        //TODO: Make an alarm here
    }


    private class TimeAdapter extends ArrayAdapter<Calendar> {
        public TimeAdapter(ArrayList<Calendar> times) {
            super(getActivity(), 0, times);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if(convertView == null) {
                convertView = getActivity().getLayoutInflater().inflate(R.layout.list_item_time, null);
            }

            Calendar t = getItem(position);

            TextView titleTextView = (TextView)convertView.findViewById(R.id.time_list_item_titleTextView);
            titleTextView.setText(t.getTime().toString());
            Button setAlarm = (Button)convertView.findViewById(R.id.set_alarm_button);

            return convertView;
        }
    }

}
