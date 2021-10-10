package com.wings.munchit;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.AbsListView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import static android.os.Build.ID;
import static android.provider.Telephony.Carriers.PASSWORD;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DatabaseName="customer.db";
    public static final String TableName="customertable";
    public static final String CustomerId="ID";
    public static final String CustomerName="NAME";

    public static final String CustomerPassword="PASSWORD";
    public static final String CustomerPhone="PHONE";

    public DatabaseHelper(@Nullable Context context) {
        super(context, DatabaseName, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TableName + "(ID INTEGER PRIMARY KEY AUTOINCREMENT,NAME TEXT, PASSWORD INTEGER,PHONE INTEGER )");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " +TableName);
        onCreate(db);

    }
    public  boolean insertData(String name,String phone,String password){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentvalues=new ContentValues();
        contentvalues.put(CustomerName,name);

        contentvalues.put(CustomerPassword,password);
        contentvalues.put(CustomerPhone,phone);
        long result= db.insert(TableName,null,contentvalues);
        if (result== -1)

            return false;
        else
            return true;

    }
    public Cursor getAllData(){
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor res=db.rawQuery("select * from "+TableName,null);

        return res;



    }
    //update data
    public boolean update(String id,String name,String phone,String password){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentvalues=new ContentValues();
        contentvalues.put(CustomerId,id);
        contentvalues.put(CustomerName,name);

        contentvalues.put(CustomerPassword,password);
        contentvalues.put(CustomerPhone,phone);
        db.update(TableName,contentvalues,"ID=?",new String[]{id});
        return true;
    }
    //delete data int give no of data deleted 0 or 1
    public Integer deleteData(String id){
        SQLiteDatabase db=this.getWritableDatabase();
        return  db.delete(TableName,"ID=?",new String[]{id});


    }
    public String search(String uname){
        SQLiteDatabase dbm=this.getReadableDatabase();
        String d=null;
        String query=" select NAME , PASSWORD from "+TableName;
        Cursor cursor  = dbm.rawQuery(query .toString(),null);


        String a,b ;
        a="s";
        b="not found";
        if (cursor.moveToFirst()){
            do {

                a=cursor.getString(0).toString();
                if (a.equals(uname)) {
                    b=cursor.getString(1).toString();
                    return  b;
                }

            }

            while (cursor.moveToNext());



        }

        return  b;

    }
}
