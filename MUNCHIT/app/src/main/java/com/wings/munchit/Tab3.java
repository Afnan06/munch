package com.wings.munchit;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import static com.wings.munchit.R.id.recyclerview;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Tab3.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Tab3#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Tab3 extends Fragment implements PastasAdapter.OnItemClickListner{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    Activity context3;

    public static final String EXTRA_UR="imageUrl";
    public static final String EXTRA_burger=" foodName";
    public static final String EXTRA_bprice=" doodPrice";
    public static final String EXTRA_bdesc=" fooddesc";
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    View v;
    private RecyclerView myrecycle1;
    private List<TabsHelper> pastas;


    private OnFragmentInteractionListener mListener;

    public Tab3() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Tab3.
     */
    // TODO: Rename and change types and number of parameters
    public static Tab3 newInstance(String param1, String param2) {
        Tab3 fragment = new Tab3();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
        pastas=new ArrayList<>();
        pastas.add(new TabsHelper ("Alfredo Pasta",299,"Long, flat noodles/Alfredo Pasta with a creamy, cheesy white sauce, topped with fresh herbs",R.drawable.alfredo_pasta));
        pastas.add(new  TabsHelper("Arabbiata Pasta",299,"Penne with a fresh vegetable medley of broccoli, carrots, red peppers, mushrooms & artichoke hearts, topped with arrabbiata sauce and fresh herbs.",R.drawable.arabbiata_pasta));
        pastas.add(new  TabsHelper("Fettuccine Pasta",299,"cooked in a hot Tabasco sauce, with roasted red peppers, mushrooms, olives and broccoli, topped with fresh herbs.",R.drawable.fettuccine_pasta));
        pastas.add(new TabsHelper ("MeatBall",459,"Juicy meatballs with spaghetti, alongside Bolognese sauce, fresh basil and parmesan cheese, topped with fresh herbs",R.drawable.meatball));
        pastas.add(new  TabsHelper("Chilli Sauce",299,"Penne Pasta cooked in a hot Tabasco sauce, with roasted red peppers, mushrooms, olives and broccoli, topped with fresh herbs.",R.drawable.chilli_sauce));
        pastas.add(new  TabsHelper("Salty Vegie Pasta",299,"Penne pasta with black olives, artichoke hearts, capers, mushrooms, tortellini, feta cheese, pesto & marinara sauce.",R.drawable.salty_vegie_pasta));
        pastas.add(new  TabsHelper("Spicy Prawn Pasta",599,"Macaroni along with a mouth-watering blend of prawns, broccoli, roasted red peppers & mushrooms in a hot marinara sauce, topped with fresh herbs.",R.drawable.spicy_prawn_pasta));

        pastas.add(new  TabsHelper("Jalapeno Gravy Pasta",349,"Penne pasta with jalapenos, olives, mushrooms, roasted red peppers, and a sprinkle of mozzarella cheese, topped with fresh herbs.",R.drawable.jalapeno_gravy_pasta));


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        context3=getActivity();
        v= inflater.inflate(R.layout.fragment_tab3, container, false);
        myrecycle1 = (RecyclerView) v.findViewById(recyclerview);
        PastasAdapter recycle1=new PastasAdapter(getContext(),pastas);
        myrecycle1.setLayoutManager(new LinearLayoutManager(getActivity()));
        myrecycle1.setAdapter(recycle1);
        recycle1.setOnItemClickListner(Tab3.this);
        return v;}

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onItemClick(int position) {

        Intent i=new Intent(context3, PastaSelected.class);
        TabsHelper clickitem= pastas.get(position);

        i.putExtra(EXTRA_UR,clickitem.getPhoto());

        i.putExtra(EXTRA_burger,clickitem.getFoodname());
        i.putExtra(EXTRA_bprice,clickitem.getFoodprice());
        i.putExtra(EXTRA_bdesc,clickitem.getDescrption());
        startActivity(i);

    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
