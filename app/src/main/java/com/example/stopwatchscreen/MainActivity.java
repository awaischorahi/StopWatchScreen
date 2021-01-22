package com.example.stopwatchscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    Button start,stop;
    ImageView needle;
    Chronometer chronometer;
    Animation animation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        start=findViewById(R.id.start);
        stop=findViewById(R.id.stop);
        needle=findViewById(R.id.needle);
        chronometer=findViewById(R.id.chronometer);
        animation=AnimationUtils.loadAnimation(this,R.anim.rotate);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                needle.startAnimation(animation);
                start.animate().alpha(0).setDuration(1000).start();
                stop.animate().alpha(1).translationY(-80).setDuration(1000).start();
                chronometer.setBase(SystemClock.elapsedRealtime());
                chronometer.start();
            }
        });


        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                needle.clearAnimation();
                chronometer.stop();
            }
        });
    }

}