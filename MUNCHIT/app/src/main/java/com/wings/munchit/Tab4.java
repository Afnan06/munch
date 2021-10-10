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
 * {@link Tab4.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Tab4#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Tab4 extends Fragment implements SandwichAdapter.OnItemClickListner {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    Activity context4;

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
    private List<TabsHelper> sandwiches;

    private OnFragmentInteractionListener mListener;

    public Tab4() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Tab4.
     */
    // TODO: Rename and change types and number of parameters
    public static Tab4 newInstance(String param1, String param2) {
        Tab4 fragment = new Tab4();
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
        sandwiches=new ArrayList<>();
        sandwiches.add(new TabsHelper ("Arabian Grill Sandwich",159,"Wrapped in pita bread, and stuffed with chicken cubes, along with lettuce, tomatoes, onions, and garlic mayonnaise and mustard, topped with olive oil.",R.drawable.sand_arabian_grill));
        sandwiches.add(new  TabsHelper("Beef Bacon Sandwich",249,"Stuffed with thinly cut slices of fried beef bacon, along with onions, lettuce, tomatoes, and topped with Honey Mustard and Thousand Island sauce.",R.drawable.sand_beef_bacon));
        sandwiches.add(new  TabsHelper("Cheese Grilled Sandwich",259,"To be topped with bacon, cheddar, Swiss, spring mix, tomatoes, mayo and our own Honey Mustard. It’s a party between three pieces of sliced wheat bread.",R.drawable.sand_cheese_grilled));
        sandwiches.add(new  TabsHelper("Chicken Mayo Sandwich",189,"Stuffed with pieces of spicy chicken, along with lettuce, onions, tomatoes, jalapenos, and gherkins, topped with mustard and olive oil.",R.drawable.sand_chicken_mayo));
        sandwiches.add(new  TabsHelper("Fried Fish Sandwich",259,"A fried fish fillet, along with onions, capsicums and topped with tartar sauce. Experience flavour that's as fresh as an ocean breeze. Submerge yourself in its waves of unique taste!",R.drawable.sand_fried_fish));

        sandwiches.add(new  TabsHelper("Loaded Chicken Sandwich",199,"Stuffed with strips of tender chicken, along with cheese, onions, tomatoes, jalapenos, and olives, topped with mustard and BBQ sauce.",R.drawable.sand_loaded_chicken));
        sandwiches.add(new  TabsHelper("Roasted Beef Sandwich",159,"Stuffed with thick slices of roast beef, along with onions, capsicums, lettuce, tomatoes, and topped with olive oil and Thousand Island sauce.",R.drawable.sand_roast_beef));

        sandwiches.add(new  TabsHelper("Turk Special Sandwich",149,"Turkey breast along with avocado, spinach, tomatoes and onions, seasoned with salt & pepper, Thousand Island sauce and olive oil vinaigrette.",R.drawable.sand_turk_special));

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        context4=getActivity();
        v=inflater.inflate(R.layout.fragment_tab4, container, false);
        myrecycle1 = (RecyclerView) v.findViewById(recyclerview);
        SandwichAdapter recycle1=new SandwichAdapter(getContext(),sandwiches);
        myrecycle1.setLayoutManager(new LinearLayoutManager(getActivity()));
        myrecycle1.setAdapter(recycle1);
        recycle1.setOnItemClickListner(Tab4.this);
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
        Intent i=new Intent(context4, SandwichSelected.class);
        TabsHelper clickitem= sandwiches.get(position);

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
