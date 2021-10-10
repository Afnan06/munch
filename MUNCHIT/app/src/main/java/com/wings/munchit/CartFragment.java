package com.wings.munchit;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;


public class CartFragment extends Fragment {
    Activity context;
    Button confirm1;
    DatabaseCart cartdb;
    View v;
    static class Items{
        String name;
        String quantity;
        String price;
        public Items(String name) {
            this.name = name;

        }
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        context=getActivity();
v=inflater.inflate(R.layout.fragment_cart,container,false);
        confirm1=v.findViewById(R.id.order);
        cartdb=new DatabaseCart(context);


        Viewdata();
        map();
        return v;
    }
    public void Viewdata(){

                Cursor result= cartdb.getAllData();
                if( result.getCount()== 0){
                    //no sata available
                    Message("Error","Cart Is Empty");
                    return;
                }
                else {
                    //SHOW ALL DATA
                    StringBuffer buffer = new StringBuffer();
                    ArrayAdapter<Items> itemAdapter = null;
                    while (result.moveToNext()) {
                      buffer.append("S.no: :"+ result.getString(0)+"\n");
                        buffer.append("NAME :"+ result.getString(1)+"\n");
                        buffer.append("QUANTITY :"+ result.getString(2)+"\n");
                        buffer.append("PRICE :"+ result.getString(3)+"\n\n");


                       /* final Items[] items = {
                                new Items(buffer.toString())
                        };

                        itemAdapter = new ArrayAdapter<Items>(context, 0, items) {
                            @Override
                            public View getView(int position,
                                                View convertView,
                                                ViewGroup parent) {
                                Items currentDino = items[position];
// Inflate only once
                                if (convertView == null) {
                                    convertView = getLayoutInflater()
                                            .inflate(R.layout.fragment_cart, null, false);


                                }


                                TextView itemName =
                                        (TextView) convertView.findViewById(R.id.cartid);
                                TextView itemquantity =
                                        (TextView) convertView.findViewById(R.id.cartnum);
                                TextView itemprice =
                                        (TextView) convertView.findViewById(R.id.cartprice);

                                itemName.setText(currentDino.name);
                                itemquantity.setText(currentDino.quantity);
                                itemprice.setText(currentDino.price);
                                return convertView;


                            }
                        };


                    }
                    ;
                    ListView dinoGrid = new ListView(context);
                    context.setContentView(dinoGrid);
                    dinoGrid.setAdapter(itemAdapter);

                        */



                }
                    Message("Data is", buffer.toString());

    }}
    public  void Message(String title ,String message){
        AlertDialog.Builder builder=new AlertDialog.Builder(context);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();

    }
    public void map(){
        confirm1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(context,"q",Toast.LENGTH_SHORT).show();
                clear();
                //Intent op=new Intent(context,MapsActivity.class);
               // startActivity(op);
            }
        });
    }
    public  void clear(){
        Cursor result= cartdb.getAllData();
        while (result.moveToNext()) {
             String h=result.getString(0);

             Integer dr=cartdb.deleteData(h);
        }
    }








}



