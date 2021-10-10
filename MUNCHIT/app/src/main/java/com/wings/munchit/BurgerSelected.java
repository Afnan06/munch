package com.wings.munchit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import static com.wings.munchit.Tab1.EXTRA_name;
import static com.wings.munchit.Tab2.EXTRA_UR;
import static com.wings.munchit.Tab2.EXTRA_bdesc;
import static com.wings.munchit.Tab2.EXTRA_burger;
import static com.wings.munchit.Tab2.EXTRA_bprice;

public class BurgerSelected extends AppCompatActivity {

    String num;
    int numb;
    int FOODPRICE;
    String FOODQUANTITY;
    ImageButton plus,minus;
    ImageView img;
    Button cart,lg;
    DatabaseCart cartdb;
    TextView number,tprice;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_burger_selected);
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
            int resid=bundle.getInt(EXTRA_UR);
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

        Intent i=getIntent();

        final String FOODDESC=i.getStringExtra(EXTRA_bdesc);
        final String FOODNAME=i.getStringExtra(EXTRA_burger);
         FOODPRICE=i.getIntExtra(EXTRA_bprice,0);
         FOODQUANTITY=number.getText().toString();

        TextView fn=findViewById(R.id.FN);
        TextView fp=findViewById(R.id.FP);
        final int z=numb*FOODPRICE;
        tprice.setText("Total Price: RS "+(numb*z));


        fn.setText(FOODNAME);
        fp.setText(FOODDESC);
        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean rate = cartdb.insertData(FOODNAME,FOODQUANTITY,numb*FOODPRICE);


               /* if (rate == true) {


                    Toast.makeText(BurgerSelected.this, "success", Toast.LENGTH_LONG).show();

                }
                else{
                    Toast.makeText(BurgerSelected.this, "data is not  inserted", Toast.LENGTH_LONG).show();}


                */

            };
        });
        //Viewdata();
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
