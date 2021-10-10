package com.wings.munchit;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import static androidx.core.content.ContextCompat.startActivity;

public class PizzaAdapter extends RecyclerView.Adapter<PizzaAdapter.MyViewHolder> {
    Context mcontext;
    List<TabsHelper> mdata;

    public static  OnItemClickListner mListner;
    public interface OnItemClickListner{
        void onItemClick(int position );
    }
    public void setOnItemClickListner(OnItemClickListner listner){
        mListner=listner;

    }

    public PizzaAdapter(Context mcontext,List<TabsHelper> mdata ) {
        this.mcontext=mcontext;
        this.mdata=mdata;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        v= LayoutInflater.from(mcontext).inflate(R.layout.alltabshelper,parent,false);
        final MyViewHolder vholder=new MyViewHolder(v);
        //final Intent is=new Intent(mcontext, FoodSelected.class);

        // going on database activity

        /*vholder.allTabsHelper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String b="pizza selected" +vholder.getAdapterPosition();
                Toast.makeText(mcontext,b,Toast.LENGTH_LONG).show();
                startActivity(mcontext,is,Bundle.EMPTY);


            }
        });

         */



        return vholder;
    }
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.foodimage.setImageResource(mdata.get(position).getPhoto());

    }

    @Override
    public int getItemCount() {
        return mdata.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        private ImageView foodimage;
        private LinearLayout allTabsHelper;
        //private ConstraintLayout tab1;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            foodimage=(ImageView) itemView.findViewById(R.id.imageView2);
            allTabsHelper =(LinearLayout) itemView.findViewById(R.id.allTabsHelper);
            //tab1 =(ConstraintLayout) itemView.findViewById(R.id.tab1);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mListner !=null){
                        int position=getAdapterPosition();
                        if ( position !=RecyclerView.NO_POSITION){
                            mListner.onItemClick(position);
                        }

                    }
                }
            });
        }
    }
}
