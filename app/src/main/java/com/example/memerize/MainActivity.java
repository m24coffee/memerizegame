package com.example.memerize;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Chronometer;
import android.widget.GridView;
import android.widget.TextView;

public class MainActivity extends Activity {
    private GridView Grid;
    private GridAdapter Adapter;
    private TextView StepScreen;
    private Chronometer TimeScreen;

    private Integer StepCount;
    int GRID_SIZE = 6;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TimeScreen = findViewById(R.id.timeview);
        StepScreen = findViewById(R.id.stepview);

        StepCount = 0;
        StepScreen.setText (StepCount.toString());

        TimeScreen.start();

        Grid = findViewById(R.id.field);
        View root = Grid.getRootView();
        Grid.setEnabled(true);

        Adapter = new GridAdapter(this, GRID_SIZE, GRID_SIZE);
        Grid.setAdapter(Adapter);

        Grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v,int position, long id) {

                Adapter.checkOpenCells ();
                if (Adapter.openCell (position)) {
                    StepCount ++;
                    StepScreen.setText (StepCount.toString());
                }

                if (Adapter.checkGameOver())
                {
                    TimeScreen.stop();
                    ShowGameOver();
                }
            }
        });
    }


    private void ShowGameOver () {

        String time = TimeScreen.getText().toString();

        RecordAdapter ra = new RecordAdapter (this);
        ra.addPoint(StepCount);
        ra.addTime(time);
        ra.WriteRecords();

        AlertDialog.Builder alertbox = new AlertDialog.Builder(this);

        alertbox.setTitle("Congratulations!");
        String TextToast = "Game is over in \nTaps: " + StepCount.toString() + "\nTime: " + time;
        alertbox.setMessage(TextToast);

        alertbox.setNeutralButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface arg0, int arg1) {
                finish();
            }
        });

        alertbox.show();

    }

}
