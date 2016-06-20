package com.asim.nolimt.mytestapp;


import android.app.FragmentManager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainFragment extends AppCompatActivity implements Communicator{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_fragment);
    }

    @Override
    public void respond(String data) {
        FragmentManager manager = getFragmentManager();
       FragementB f2= (FragementB) manager.findFragmentById(R.id.fragment2);
        f2.changeText(data);
    }
}
