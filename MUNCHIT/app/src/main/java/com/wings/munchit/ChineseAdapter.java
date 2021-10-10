package com.wings.munchit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ChineseAdapter extends RecyclerView.Adapter<ChineseAdapter.MyViewHolder>  {
    Context ccontext;
    List<TabsHelper> cdata;

    public static ChineseAdapter.OnItemClickListner mListner;
    public interface OnItemClickListner{
        void onItemClick(int position );
    }
    public void setOnItemClickListner(OnItemClickListner listner){
        mListner=listner;

    }
    public ChineseAdapter(Context ccontext,List<TabsHelper> cdata ) {
        this.ccontext=ccontext;
        this.cdata=cdata;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        v= LayoutInflater.from(ccontext).inflate(R.layout.alltabshelper,parent,false);
        final MyViewHolder vholder=new MyViewHolder(v);
        return vholder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.foodimage.setImageResource(cdata.get(position).getPhoto());
    }





    @Override
    public int getItemCount() {

        return cdata.size();
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

