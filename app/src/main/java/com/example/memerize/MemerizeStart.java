package com.example.memerize;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MemerizeStart extends Activity {

    Button Start;
    Button Score;
    Button Exit;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start);

        Start = findViewById(R.id.butStart);
        Score = findViewById(R.id.butScore);
        Exit = findViewById(R.id.butExit);

        Start.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startGame();
            }
        });


        Score.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startRecords();
            }
        });

        Exit.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    private void startGame () {
        Intent i = new Intent(this, MainActivity.class);
        startActivity (i);
    }


    private void startRecords () {
        Intent i = new Intent(this, Records.class);
        startActivity (i);
    }
}
