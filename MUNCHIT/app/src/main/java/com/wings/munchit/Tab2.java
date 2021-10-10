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
 * {@link Tab2.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Tab2#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Tab2 extends Fragment implements BurgerAdapter.OnItemClickListner {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    Activity context2;

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
    private List<TabsHelper> burgers;

    private OnFragmentInteractionListener mListener;

    public Tab2() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Tab2.
     */
    // TODO: Rename and change types and number of parameters
    public static Tab2 newInstance(String param1, String param2) {
        Tab2 fragment = new Tab2();
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
        burgers=new ArrayList<>();
        burgers.add(new TabsHelper ("Beef Buster",399,"New addition to the beef range, juicy beef burger with sriracha sauce, fried onion rings and lettuce",R.drawable.beef_buster));
        burgers.add(new  TabsHelper("Classic Zinger",299,"Crispy chicken topped with lettuce, fiery hot mayo and buffalo sauce",R.drawable.classic_zinger));
        burgers.add(new  TabsHelper("Crispy Fish",699,"Crispy fish fillet topped with lettuce, tomatoes and hot sauce.",R.drawable.crispy_fish));
        burgers.add(new  TabsHelper("Triplet Patty",799,"3 smashed beef patties with melted cheese topped with crispy onion rings, grilled mushrooms, smoke and BBQ sauces.",R.drawable.triplet_patty));
        burgers.add(new  TabsHelper("Double Zinger",699,"Double crispy chicken topped with cheese, mayo, chilli garlic sauce and lettuce.",R.drawable.double_zinger));

        burgers.add(new  TabsHelper("Double Cheese Burger",499,"Double the cheese, double the fun! Double grilled chicken patty and two slices of delicious cheddar cheese, along with tomatoes, onions, mayo, and lettuce." ,R.drawable.double_cheese_burger));
        burgers.add(new  TabsHelper("Jalapeno Beef",799,"Juicy Jalapeno Beef Burger with jalapenos, Tabasco sauce, onions, lettuce and tomatoes.",R.drawable.jalapeno_beef));
        burgers.add(new  TabsHelper("Loaded Beef",699,"The old school double beef burger with BBQ sauce, mustard sauce, beef bacon strips, fresh onions, gherkins, lettuce and tomatoes.",R.drawable.loaded_beef));

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        context2=getActivity();
        v= inflater.inflate(R.layout.fragment_tab2, container, false);
        myrecycle1 = (RecyclerView) v.findViewById(recyclerview);
        BurgerAdapter recycle1=new BurgerAdapter(getContext(),burgers);
        myrecycle1.setLayoutManager(new LinearLayoutManager(getActivity()));
        myrecycle1.setAdapter(recycle1);
        recycle1.setOnItemClickListner(Tab2.this);
        return v;
    }

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
        Intent i=new Intent(context2, BurgerSelected.class);
        TabsHelper clickitem= burgers.get(position);

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
