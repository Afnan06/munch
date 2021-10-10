package com.wings.munchit;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import static com.wings.munchit.Tab1.EXTRA_URL;
import static com.wings.munchit.Tab1.EXTRA_bdesc;
import static com.wings.munchit.Tab1.EXTRA_name;
import static com.wings.munchit.Tab1.EXTRA_price;

public class Pizza_Selected extends AppCompatActivity {
    String num,FOODQUANTITY;
    int numb;
    int FOODPRICE;
    ImageButton plus,minus;
    ImageView img;
    Button cart,lg;
    DatabaseCart cartdb;
    TextView number,tprice;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pizza__selected);
        img=findViewById(R.id.imageView2);
        cart=findViewById(R.id.cart1);
        //lg=findViewById(R.id.button3);
        number=findViewById(R.id.number);
        cartdb=new DatabaseCart(this);
        plus=findViewById(R.id.imageButton);
        minus=findViewById(R.id.imageButton2);
        plus.setImageResource(R.drawable.plus);
        minus.setImageResource(R.drawable.minus);
        Bundle bundle=getIntent().getExtras();
        if (bundle!=null) {
            int resid=bundle.getInt(EXTRA_URL);
            img.setImageResource(resid);


        }
        tprice=findViewById(R.id.textView5);

        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                increment(v);
            }
        });
        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                decrement(v);
            }
        });


        Intent it=getIntent();

        final String FOODDESC=it.getStringExtra(EXTRA_bdesc);
        final String FOODNAME=it.getStringExtra(EXTRA_name);
        FOODPRICE=it.getIntExtra(EXTRA_price,0);

        TextView fn=findViewById(R.id.FN);
        TextView fp=findViewById(R.id.FP);
        final int z=numb*FOODPRICE;

        tprice.setText("Total Price: RS "+(numb*FOODPRICE));
        FOODQUANTITY=number.getText().toString();


        fn.setText(FOODNAME);
        fp.setText(FOODDESC);


        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean rate = cartdb.insertData(FOODNAME,FOODQUANTITY,numb*FOODPRICE);


                if (rate == true) {


                                Toast.makeText(Pizza_Selected.this, "success", Toast.LENGTH_LONG).show();

                            }
                else{
                                Toast.makeText(Pizza_Selected.this, "data is not  inserted", Toast.LENGTH_LONG).show();}


                };
    });
        //Viewdata();
    }
    public void Viewdata(){
        lg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor result= cartdb.getAllData();
                if( result.getCount()== 0){
                    //no sata available
                    Message("Error","No data found");
                    return;
                }
                else{
                    //SHOW ALL DATA
                    StringBuffer buffer=new StringBuffer();
                    while(result.moveToNext()){
                        buffer.append("ID :"+ result.getString(0)+"\n");
                        buffer.append("NAME :"+ result.getString(1)+"\n");
                        buffer.append("PRICE :"+ result.getString(2)+"\n\n");

                    }
                    Message("Data is",buffer.toString());
                }
            }
        });
    }
    public  void Message(String title ,String message){
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();

    }




    public void increment(View view){
        num=number.getText().toString();
        numb=Integer.parseInt(num);
        numb=numb+1;
        number.setText(String.valueOf(numb));
        tprice.setText("Total Price: RS "+(numb*FOODPRICE));
        FOODQUANTITY=number.getText().toString();

    }
    public void decrement(View view){
        num=number.getText().toString();
        numb=Integer.parseInt(num);
        numb=numb-1;
        number.setText(String.valueOf(numb));
        tprice.setText("Total Price: RS "+(numb*FOODPRICE));
        FOODQUANTITY=number.getText().toString();

    }



}
