package com.asim.nolimt.mytestapp;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by NO Limt on 28.05.2016.
 */

public class FragementB extends Fragment {
    TextView text;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_b,container,false);

    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
       text = (TextView) getActivity().findViewById(R.id.tv_fragment_b);


    }
    public void changeText (String data){
        text.setText(data);


    }
}
