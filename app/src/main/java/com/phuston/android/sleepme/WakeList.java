package com.phuston.android.sleepme;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * Created by phuston on 3/14/15.
 */
public class WakeList {
    private Calendar mInitTime = Calendar.getInstance();

    public ArrayList<Calendar> mTimeList;


    public WakeList(Calendar initTime){
        mInitTime = initTime;
        mInitTime.add(Calendar.MINUTE, 14);
    }

    public ArrayList<Calendar> getTimes(){

        ArrayList<Calendar> times = new ArrayList<>();

        for(int i = 1; i < 8; i++){
            Calendar newTime = Calendar.getInstance();
            newTime.set(Calendar.DATE, mInitTime.DATE);
            newTime.set(Calendar.DAY_OF_WEEK, mInitTime.DAY_OF_WEEK);
            newTime.set(Calendar.HOUR, mInitTime.HOUR);
            newTime.set(Calendar.MINUTE, mInitTime.MINUTE);
            newTime.add(Calendar.HOUR, i);
            newTime.add(Calendar.MINUTE, i*30);
            times.add(newTime);
        }


        return times;
    }


}
