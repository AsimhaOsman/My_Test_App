package com.asim.nolimt.mytestapp;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by NO Limt on 28.05.2016.
 */
public class FragmentA extends Fragment implements View.OnClickListener{

    Button cklick;
    int counter =0;
    Communicator comm;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_s,container,false);


    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        cklick =(Button)getActivity().findViewById(R.id.btn_frgment_a);
        comm= (Communicator) getActivity();
        cklick.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        counter ++;
        comm.respond("Die Click Nummer "+counter);
    }
}
