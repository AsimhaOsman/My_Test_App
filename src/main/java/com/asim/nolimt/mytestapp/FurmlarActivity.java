package com.asim.nolimt.mytestapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class FurmlarActivity extends AppCompatActivity implements View.OnClickListener {
    Button submit;
    EditText et_name, et_nachname, et_email,et_phone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_furmlar);
        initialize();


    }

        public void initialize() {
            submit= (Button) findViewById(R.id.btn_submit);
            et_name=(EditText)findViewById(R.id.et_name);
            et_nachname=(EditText)findViewById(R.id.et_nachname);
            et_email=(EditText)findViewById(R.id.et_Email);

            submit.setOnClickListener(this);

        }
    @Override
    public void onClick(View v) {

        Intent i = new Intent(this,Furmal2.class);
       i.putExtra("name",et_name.getText().toString());
        i.putExtra("nachname",et_nachname.getText().toString());
        i.putExtra("email",et_email.getText().toString());

        startActivity(i);
    }


}
