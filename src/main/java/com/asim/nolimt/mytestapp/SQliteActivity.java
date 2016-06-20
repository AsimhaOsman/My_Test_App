package com.asim.nolimt.mytestapp;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class SQliteActivity extends AppCompatActivity {
    DatabaseAdapter databaseHelper;
    EditText name ,password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite);

        name=(EditText)findViewById(R.id.et_sql_name);
        password=(EditText)findViewById(R.id.et_sql_password);

        databaseHelper = new DatabaseAdapter(this);
    }

    public void ClickMe(View view)
    {
        String user =name.getText().toString();
        String pass= password.getText().toString();
        long id =databaseHelper.insertData(user,pass);

        if (id<0)
        {
            Messge.messege(this," Successfully Inset A Row");
    }else
        {
             Messge.messege(this,"Unsuccessful ");
        }
    }

}
