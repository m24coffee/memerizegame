package com.example.memerize;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;

public class Records extends TabActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.records);

        TabHost tabHost = getTabHost();


        TabHost.TabSpec timetab = tabHost.newTabSpec("Time");

        timetab.setIndicator("Best time", getResources().getDrawable(R.drawable.time));

        Intent timeIntent = new Intent(this, RecordTime.class);
        timetab.setContent(timeIntent);


        TabHost.TabSpec pointtab = tabHost.newTabSpec("Click");
        pointtab.setIndicator("Best taps", getResources().getDrawable(R.drawable.point));
        Intent pointIntent = new Intent(this, RecordClick.class);
        pointtab.setContent(pointIntent);

        tabHost.addTab(timetab);
        tabHost.addTab(pointtab);
    }
}
