package com.asim.nolimt.mytestapp;

import android.app.LocalActivityManager;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ContactActivity extends AppCompatActivity implements View.OnClickListener {
    EditText  nametxt, phonetxt,emailtxt,addresstxt;
    Button add;
    ListView contactListView;
    List<Contact> contacts= new ArrayList<Contact>();
    android.app.LocalActivityManager mlam;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        mlam = new LocalActivityManager(this, false);
       mlam.dispatchCreate(savedInstanceState);

        nametxt=  (EditText)findViewById(R.id.et_name_contact);
        phonetxt=(EditText)findViewById(R.id.et_phone_contact);
        emailtxt=(EditText)findViewById(R.id.et_email_contact);
        addresstxt=(EditText)findViewById(R.id.et_address_contact);
        add=(Button)findViewById(R.id.btn_contact);
        contactListView=(ListView)findViewById(R.id.lv_contact);
        TabHost tabHost=(TabHost)findViewById(R.id.tabHost);
        tabHost.setup(mlam);
        TabHost.TabSpec tabSpec= tabHost.newTabSpec("creator");
        tabSpec.setContent(R.id.tab_creator);
        tabSpec.setIndicator("Creator");
        tabHost.addTab(tabSpec);

        tabSpec= tabHost.newTabSpec("list");
        tabSpec.setContent(R.id.tab_list);
        tabSpec.setIndicator("Contact List");
        tabHost.addTab(tabSpec);

        add.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {

        Toast.makeText(getApplicationContext(),"A New User Has been Added ",Toast.LENGTH_LONG).show();

        addContact(nametxt.getText().toString(),phonetxt.getText().toString(),
                emailtxt.getText().toString(),addresstxt.getText().toString());
            populateList();
    }

    public void populateList() {
        ArrayAdapter<Contact>  adapter = new ContactListAdapter();
        contactListView.setAdapter(adapter);


    }


    private void addContact(String name, String phone, String email, String address) {
        contacts.add(new Contact(name,phone,email,address));
    }




    private class ContactListAdapter extends ArrayAdapter<Contact> {
        public ContactListAdapter(){
            super(ContactActivity.this,R.layout.list_item, contacts);

        }

        @Override
        public View getView(int position, View view, ViewGroup parent) {
            if (view == null)

            view=getLayoutInflater().inflate(R.layout.list_item,parent,false);
            Contact currentContact = contacts.get(position);

            TextView name= (TextView) view.findViewById(R.id.tv_list_item_neme);
            name.setText(currentContact.getName());

            TextView phone =(TextView) view.findViewById(R.id.tv_list_item_phone);
            phone.setText(currentContact.getPhone());

            TextView email= (TextView)view.findViewById(R.id.tv_list_item_email);
            email.setText(currentContact.getEmail());

            TextView address= (TextView) view.findViewById(R.id.tv_list_item_address);
            address.setText(currentContact.getAddress());

            return super.getView(position, view, parent);
        }
    }

}
