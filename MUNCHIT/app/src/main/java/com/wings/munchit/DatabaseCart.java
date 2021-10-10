package com.wings.munchit;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class DatabaseCart  extends SQLiteOpenHelper {
    public static final String DatabaseCart="cart.db";
    public static final String TableCart="carttable";
    public static final String CartId="ID";
    public static final String CartName="NAME";

    public static final String CartPrice="PRICE";
    public static final String CartQuantity="QUANTITY";

    public DatabaseCart(@Nullable Context context) {
        super(context, DatabaseCart, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TableCart + "("
                + CartId + " INTEGER PRIMARY KEY," + CartName + " TEXT,"
                + CartQuantity + " TEXT," + CartPrice + " TEXT" + ")");


    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TableCart);
        onCreate(db);
    }
    public  boolean insertData(String name,String quantity,int price){
        SQLiteDatabase db=this.getWritableDatabase();

        ContentValues values=new ContentValues();

        values.put(CartName,name);

        values.put(CartQuantity,quantity);
        values.put(CartPrice,price);
        long result= db.insert(TableCart,null,values);
        if (result== -1)
            return false;
        else
            return true;

    }
    public Cursor getAllData(){
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor res=db.rawQuery("select * from "+ TableCart,null);

        return res;



    }
    public Integer deleteData(String id){
        SQLiteDatabase db=this.getWritableDatabase();
        return  db.delete(TableCart,"ID=?",new String[]{id});


    }
}


