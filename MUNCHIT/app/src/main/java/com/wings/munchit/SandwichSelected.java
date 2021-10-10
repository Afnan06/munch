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

import static com.wings.munchit.Tab4.EXTRA_UR;
import static com.wings.munchit.Tab4.EXTRA_bdesc;
import static com.wings.munchit.Tab4.EXTRA_burger;
import static com.wings.munchit.Tab4.EXTRA_bprice;

public class SandwichSelected extends AppCompatActivity {

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
        setContentView(R.layout.activity_sandwich_selected);
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




        Intent it=getIntent();


        final String FOODNAME=it.getStringExtra(EXTRA_burger);
        final String FOODDESC=it.getStringExtra(EXTRA_bdesc);
         FOODPRICE=it.getIntExtra(EXTRA_bprice,0);
        FOODQUANTITY=number.getText().toString();

        TextView fn=findViewById(R.id.FN);
        TextView fp=findViewById(R.id.FP);
        final int z=numb*FOODPRICE;
        tprice.setText("Total Price: RS "+(numb*FOODPRICE));

        fn.setText(FOODNAME);
        fp.setText(FOODDESC);
        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean rate = cartdb.insertData(FOODNAME,FOODQUANTITY,numb*FOODPRICE);


                if (rate == true) {


                    Toast.makeText(SandwichSelected.this, "success", Toast.LENGTH_LONG).show();

                }
                else{
                    Toast.makeText(SandwichSelected.this, "data is not  inserted", Toast.LENGTH_LONG).show();}


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
