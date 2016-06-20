package com.asim.nolimt.mytestapp;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;

public class CameraActivity extends AppCompatActivity implements View.OnClickListener {
    Button camera,back;
    ImageView iv;
    private File imagFile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);

        camera=(Button)findViewById(R.id.btn_camera);
        back=(Button)findViewById(R.id.btn_back);
        iv=(ImageView)findViewById(R.id.iv_btn);

        camera.setOnClickListener(this);
        back.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.btn_camera:
                Intent i=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                imagFile= new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES),
                        "foto.jpg");
                Uri tempuri=Uri.fromFile(imagFile);
                i.putExtra(MediaStore.EXTRA_OUTPUT,tempuri);
                i.putExtra(MediaStore.EXTRA_VIDEO_QUALITY,1);
                startActivityForResult(i,0);
                break;
            case R.id.btn_back:
                Intent b=new Intent(this,MainActivity.class);
                startActivity(b);
                break;


        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
       if (requestCode==0)
       {
            switch (requestCode){
                    case Activity.RESULT_OK:
                        if (imagFile.exists())
                        {
                            Toast.makeText(this,"Das Photo wurde in " + imagFile.getAbsolutePath()+" gespeichert",
                                    Toast.LENGTH_LONG).show();
                        }else
                        {
                            Toast.makeText(this," Es gibt eine Fehler beim Speichern ..!",
                                    Toast.LENGTH_LONG).show();
                        }


                        break;
                case  Activity.RESULT_CANCELED:
                    break;

            }
       }
        else {

       }
    }

}
