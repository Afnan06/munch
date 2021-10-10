package com.wings.munchit;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class HomeFragment extends Fragment {
    ViewFlipper v_flipper;
    View v;
    Activity context;
    public static final String EXTRA_URL="imageUrl";
    public static final String EXTRA_name=" foodName";
    public static final String EXTRA_price=" doodPrice";
    public static final String EXTRA_bdesc=" fooddesc";

    ImageButton deal_1,deal_2,deal_3,deal_4,deal_5,deal_6,deal_7,deal_8;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v= inflater.inflate(R.layout.fragment_home,container,false);
        context=getActivity();
        int Images[]={R.drawable.welcome,R.drawable.slider1,R.drawable.slide2,R.drawable.slider3,R.drawable.slider4,R.drawable.slider5};
        v_flipper =v.findViewById(R.id.v_flipper);
        for (int img: Images){
            flipperimages(img);
        }
        deal_1=(ImageButton)v.findViewById(R.id.deal1) ;
        deal_2=(ImageButton)v.findViewById(R.id.deal2) ;
        deal_3=(ImageButton)v.findViewById(R.id.deal3) ;
        deal_4=(ImageButton)v.findViewById(R.id.deal4) ;
        deal_5=(ImageButton)v.findViewById(R.id.deal5) ;
        deal_6=(ImageButton)v.findViewById(R.id.deal6) ;
        deal_7=(ImageButton)v.findViewById(R.id.deal7) ;
        deal_8=(ImageButton)v.findViewById(R.id.deal8) ;
        final Intent is=new Intent(context , DealsSelected.class);
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.deal1:
                        is.putExtra(EXTRA_URL,R.drawable.deal1);
                        is.putExtra(EXTRA_name,"Burger Squared");
                        is.putExtra(EXTRA_price,999);
                        is.putExtra(EXTRA_bdesc,"Buy 1 Burger, and get another burger of equal or lesser price ABSOLUTELY FREE. *Taxes of both the burgers will be applicable."
                        );
                        startActivity(is);
                        break;
                    case R.id.deal2:
                        is.putExtra(EXTRA_URL,R.drawable.deal2);
                        is.putExtra(EXTRA_name,"Doublizza");
                        is.putExtra(EXTRA_price,1500);
                        is.putExtra(EXTRA_bdesc,"Buy 1 Pizza, and get another Pizza of equal or lesser price ABSOLUTELY FREE.\n" +
                                "*Taxes of both the Pizzas will be applicable.\n");
                        startActivity(is);
                        break;
                    case R.id.deal3:
                        is.putExtra(EXTRA_URL,R.drawable.deal3);
                        is.putExtra(EXTRA_name,"Chinese Maniac");
                        is.putExtra(EXTRA_price,2099);
                        is.putExtra(EXTRA_bdesc,"Get 20% off on the entire Chinese Menu!");
                        startActivity(is);
                        break;
                    case R.id.deal4:
                        is.putExtra(EXTRA_URL,R.drawable.deal4);
                        is.putExtra(EXTRA_name,"Multiple Of Sticks");
                        is.putExtra(EXTRA_price,1449);
                        is.putExtra(EXTRA_bdesc,"Buy 1 BBQ Chinese Stick Plate, and get two BBQ Chinese Stick Plates ABSOLUTELY FREE.\n" +
                                "*Taxes of all BBQ Chinese Stick Plates will be applicable.\n");
                        startActivity(is);
                        break;
                    case R.id.deal5:
                        is.putExtra(EXTRA_URL,R.drawable.deal5);
                        is.putExtra(EXTRA_name,"Royal Sandwiches");
                        is.putExtra(EXTRA_price,1099);
                        is.putExtra(EXTRA_bdesc,"Buy 1 Sandwich, and get another Sandwich of equal or lesser price ABSOLUTELY FREE.\n" +
                                "*Taxes of both the Sandwiches will be applicable.\n");
                        startActivity(is);
                        break;
                    case R.id.deal6:
                        is.putExtra(EXTRA_URL,R.drawable.deal6);
                        is.putExtra(EXTRA_name,"Pasta Fiesta");
                        is.putExtra(EXTRA_price,999);
                        is.putExtra(EXTRA_bdesc,"Buy 1 Pasta Dish, and get another Pasta Dish of equal or lesser price ABSOLUTELY FREE.\n" +
                                "*Taxes of both the Pasta Dishes will be applicable.\n");
                        startActivity(is);
                        break;
                    case R.id.deal7:
                        is.putExtra(EXTRA_URL,R.drawable.deal7);
                        is.putExtra(EXTRA_name,"Sweet Toothed");
                        is.putExtra(EXTRA_price,899);
                        is.putExtra(EXTRA_bdesc,"Get 25% off on the entire Desserts Menu!");
                        startActivity(is);
                        break;
                    case R.id.deal8:
                        is.putExtra(EXTRA_URL,R.drawable.deal8);
                        is.putExtra(EXTRA_name,"Kings Of Burgers");
                        is.putExtra(EXTRA_price,1490);
                        is.putExtra(EXTRA_bdesc,"A complete delightful deal of 2 beef burgers along with one cheese sandwiches and french fries");
                        startActivity(is);
                        break;
                }

            }
        };
        deal_1.setOnClickListener(listener);
        deal_2.setOnClickListener(listener);
        deal_3.setOnClickListener(listener);
        deal_4.setOnClickListener(listener);
        deal_5.setOnClickListener(listener);
        deal_6.setOnClickListener(listener);
        deal_7.setOnClickListener(listener);
        deal_8.setOnClickListener(listener);
        return v;
    }

    public  void flipperimages(int img){
        ImageView imageView=new ImageView(context);
        imageView.setBackgroundResource(img);

        v_flipper.addView(imageView);
        v_flipper.setFlipInterval(3000);
        v_flipper.setAutoStart(true);
        v_flipper.setInAnimation(context,android.R.anim.slide_in_left);
        v_flipper.setOutAnimation(context,android.R.anim.slide_in_left);
    }


}
