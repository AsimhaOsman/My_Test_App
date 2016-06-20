package com.asim.nolimt.mytestapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button mainB, formB,cameraB,audioB,wifiB,sqlB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();
    }

    private void initialize(){
        mainB=(Button)findViewById(R.id.btn1);
        formB=(Button)findViewById(R.id.btn2);
        cameraB= (Button) findViewById(R.id.btn3);
        audioB= (Button) findViewById(R.id.btn4);
        wifiB= (Button) findViewById(R.id.btn5);
        sqlB= (Button) findViewById(R.id.btn6);

        mainB.setOnClickListener(this);
        formB.setOnClickListener(this);
        cameraB.setOnClickListener(this);
        audioB.setOnClickListener(this);
        wifiB.setOnClickListener(this);
        sqlB.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn1:
                Intent op = new Intent(this,MainFragment.class);
                    startActivity(op);
                break;
            case R.id.btn2:
                Intent i = new Intent(this,FurmlarActivity.class);
                startActivity(i);
                break;
            case R.id.btn3:
                Intent ca = new Intent(this,CameraActivity.class);
                startActivity(ca);
                break;
            case R.id.btn4:
                Intent au = new Intent(this,AudoiActivity.class);
                startActivity(au);
                break;
            case R.id.btn5:
                Intent wf = new Intent(this,ContactActivity.class);
                startActivity(wf);
                break;
            case R.id.btn6:

                Intent sq = new Intent(this,SQliteActivity.class);
                startActivity(sq);
                break;


        }
    }
}
