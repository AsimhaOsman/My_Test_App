package com.asim.nolimt.mytestapp;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by NO Limt on 01.06.2016.
 */
public class Messge {
    public static void messege (Context context, String messege){

        Toast.makeText(context,messege,Toast.LENGTH_LONG).show();
    }
}
