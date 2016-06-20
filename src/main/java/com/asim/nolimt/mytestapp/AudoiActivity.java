package com.asim.nolimt.mytestapp;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class AudoiActivity extends AppCompatActivity implements View.OnClickListener {
    private MediaPlayer mp;
    ImageButton play, stop,pause;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audoi);
        initaltion();
    }

    public void initaltion() {
        play = (ImageButton) findViewById(R.id.ibtn_play);
        stop = (ImageButton) findViewById(R.id.ibtn_stop);
        pause= (ImageButton) findViewById(R.id.ibtn_pause);

        play.setOnClickListener(this);
        stop.setOnClickListener(this);
        pause.setOnClickListener(this);
        mp= MediaPlayer.create(AudoiActivity.this, R.raw.track10);
    }

    @Override
    public void onClick(View v) {
        if (v == play) {
           mp.start();

        }
        if(v== pause){
        mp.pause();
        }


        if (v==stop){
        mp.stop();
        AudoiActivity.this.finish();
        }
    }
}
