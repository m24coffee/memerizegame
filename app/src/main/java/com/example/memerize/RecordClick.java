package com.example.memerize;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

public class RecordClick extends ListActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.click_tab);

        RecordAdapter ra = new RecordAdapter (this);
        ArrayList<String> arr = ra.getRecPoint();

        ArrayAdapter<String> mAdapter = new ArrayAdapter<String>(this, R.layout.item, arr);
        setListAdapter(mAdapter);
    }
}
