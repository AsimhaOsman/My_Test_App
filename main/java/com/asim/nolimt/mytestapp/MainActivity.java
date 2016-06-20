package com.asim.nolimt.mytestapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button bMap, bMail, bMarkt,b_call;
        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bMap = (Button) findViewById(R.id.bt_map);
        bMail = (Button) findViewById(R.id.bt_email);
        bMarkt = (Button) findViewById(R.id.bt_market);
        b_call = (Button) findViewById(R.id.bt_call);
        bMap.setOnClickListener(this);
        bMail.setOnClickListener(this);
        bMarkt.setOnClickListener(this);
        b_call.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = null, chooser = null;
        if (v.getId() == R.id.bt_map)
        {
           /* Log.d("Asim", "Bin Email Button");*/
            intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("geo:5204.552,13.40235"));
            chooser = Intent.createChooser(intent, "Maplauncher");
            startActivity(chooser);

        }
        if (v.getId() == R.id.bt_email) {
            Log.d("Asim", "Bin Map Market Button");
            intent= new Intent(Intent.ACTION_SEND);
            intent.setData(Uri.parse("mailto:"));
            String[] to={"asimha.osman@gmail.com"};
            intent.putExtra(intent.EXTRA_EMAIL,to);
            intent.putExtra(intent.EXTRA_SUBJECT,"Hey ya man");
            intent.putExtra(intent.EXTRA_TEXT,"Hey ya man das ist das erste email von my App Danke Asim");
            intent.setType("massge/rfc822");
            chooser = Intent.createChooser(intent, "MyEmail");
            startActivity(chooser);



        }
        if (v.getId() == R.id.bt_market) {
            Log.d("Asim", "Bin Market Button");
            intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("market://details?id=com.chudanqing.funnyimages&hl=de"));
            chooser = Intent.createChooser(intent, "Market");
            startActivity(chooser);
        }
        if (v.getId() == R.id.bt_call)
        {
           /* Log.d("Asim", "Bin Email Button");*/
            intent = new Intent(Intent.ACTION_CALL);
            intent.setData(Uri.parse("dail:0152155162664"));
           chooser = Intent.createChooser(intent, "Call");
            startActivity(chooser);

        }

    }


}
