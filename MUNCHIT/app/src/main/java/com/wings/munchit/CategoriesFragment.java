package com.wings.munchit;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class CategoriesFragment extends Fragment {
    Activity context;
    View v;
    Button visitt;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        context=getActivity();
        v=inflater.inflate(R.layout.fragment_categories,container,false);
        visitt=v.findViewById(R.id.visit);
        set();


        return v;
    }
    public void set(){
        visitt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent u = new Intent(context, Display1.class);
                startActivity(u);


            }
        });

    }

}
