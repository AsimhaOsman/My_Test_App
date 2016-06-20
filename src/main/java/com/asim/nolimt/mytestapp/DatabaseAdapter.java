package com.asim.nolimt.mytestapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseAdapter  {

    DatabaseHelper helper;
    public DatabaseAdapter (Context context){
        helper= new DatabaseHelper(context);
    }

    public long insertData(String name, String password){

        SQLiteDatabase db=helper.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(DatabaseHelper.NAME,name);
        contentValues.put(DatabaseHelper.Password,password);
      long id= db.insert(DatabaseHelper.TABLE_NAME,null,contentValues);
        return id;
    }

   static class DatabaseHelper extends SQLiteOpenHelper{
        private static final String DATABASE_NAME="mydatabase";
        private static final String TABLE_NAME="mytable";
        private static final int   DATABASE_VERSION=3 ;
        private static final String UID = "_id";
        private static final String NAME ="Name";
        private static final String Password ="Password";
        private Context context;
        private static final String CERATE_TABLE= "CERATE TABLE"+TABLE_NAME+"("+UID+" INTEGER PRIMARY KEY AUTOINCREMENT,"
                +NAME+" VARCHAR(255)"+Password+" VARCHAR(255));";
        private static final String DROP_TABLE= "DROAP TABLEIF EXISTS"+TABLE_NAME;

        public DatabaseHelper (Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
            this.context=context;
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            // CERATE TABLE MYTABLE(_id INTEGER PRIMARY KEY AUTOINCREMENT,Name VARCHAR(255));
            try {
                db.execSQL(CERATE_TABLE);
                Messge.messege(context,"onCreat was called");
            }catch (SQLiteException e)
            {
                Messge.messege(context,""+e);
            }
        }
        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            // CERATE TABLE MYTABLE(_id INTEGER PRIMARY KEY AUTOINCREMENT,Name VARCHAR(255));
            try {
                Messge.messege(context,"onUpgrad was called");
                db.execSQL(DROP_TABLE);
                onCreate(db);
            }catch (SQLiteException e)
            {
                Messge.messege(context,""+e);

            }
        }

    }


}
