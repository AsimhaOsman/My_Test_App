package com.asim.nolimt.mytestapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Furmal2 extends AppCompatActivity implements View.OnClickListener {
    Button back;
    TextView tx_name,tv_nachname,tv_email,tv_phone;
    String myName,mynachname,myemail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_furmal2);
        back=(Button)findViewById(R.id.btn_back);
        tx_name=(TextView)findViewById(R.id.tv_red_name);
        tv_nachname=(TextView)findViewById(R.id.tv_red_nachname);
        tv_email=(TextView)findViewById(R.id.tv_red_email);
       Intent g= this.getIntent();
       myName = g.getStringExtra("name");
        mynachname = g.getStringExtra("nachname");
        myemail = g.getStringExtra("email");
        tx_name.setText(myName);
        tv_nachname.setText(mynachname);
        tv_email.setText(myemail);


        back.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent i = new Intent(this,MainActivity.class);
        startActivity(i);
    }
}
