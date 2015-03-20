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
        times.add(mInitTime);

        for(int i = 1; i < 8; i++){
            Calendar newTime = mInitTime;
            newTime.add(Calendar.HOUR, i);
            newTime.add(Calendar.MINUTE, i*30);
            times.add(newTime);
        }


        return times;
    }


}
