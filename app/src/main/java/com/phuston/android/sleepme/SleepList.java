package com.phuston.android.sleepme;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * Created by phuston on 3/14/15.
 */
public class SleepList {
    private Calendar mInitTime = Calendar.getInstance();

    public ArrayList<Calendar> mSleepList;


    public SleepList(Calendar initTime){
        mInitTime = initTime;
        mInitTime.add(Calendar.MINUTE, -14);
    }

    public ArrayList<Calendar> getTimes(){

        ArrayList<Calendar> times = new ArrayList<Calendar>();
        times.add(mInitTime);

        for(int i = 0; i < 10; i++){
            mInitTime.add(Calendar.HOUR, -1);
            mInitTime.add(Calendar.MINUTE, -30);
            Calendar newTime = mInitTime;
            times.add(newTime);
        }

        return times;
    }


}
