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
 * {@link Tab5.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Tab5#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Tab5 extends Fragment implements ChineseAdapter.OnItemClickListner{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    Activity context5;

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
    private List<TabsHelper> chinese;

    private OnFragmentInteractionListener mListener;

    public Tab5() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Tab5.
     */
    // TODO: Rename and change types and number of parameters
    public static Tab5 newInstance(String param1, String param2) {
        Tab5 fragment = new Tab5();
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
        chinese=new ArrayList<>();
        chinese.add(new TabsHelper ("Chinese Roll",459,"Stuffed with fresh vegetables including spring onions, capsicums, lettuce, cabbage and boiled egg. Complemented with pieces of fired shrimp and our famous Vege sauce.  ",R.drawable.ch_roll));
        chinese.add(new  TabsHelper("Chicken Fried Rice",299,"A fine blend of steamed rice, mixed with sautéed vegetables including spring onions, carrots, capsicums, green peas and cabbage.",R.drawable.ch_fried_rice));
        chinese.add(new  TabsHelper("Hot And Sour Soup",1600,"Our signature soup, a spicy blend of tomatoes, carrots, cabbage and chicken. Guaranteed to leave your mouth watering.",R.drawable.ch_hot_soup));
        //chinese.add(new  TabsHelper("Chicken Corn Soup",499,"Traditional soup with a fine blend of chicken pieces and sweet corn.",R.drawable.ch_corn_soup));
        chinese.add(new  TabsHelper("Corn Crab Soup",1800,"A soup filled with pieces of fresh crab meat, served with a fine blend of corn and egg",R.drawable.sand_fried_fish));

        chinese.add(new  TabsHelper("Cherry Chickeen Chille Gravy",1800,"An amalgamation of fresh cherries, with our famous red sauce served with chunks of chicken and vegetables as well.",R.drawable.chi_chick_gravy));
        chinese.add(new  TabsHelper("Prawn Tempura",1800,"Friend king size prawns in a light and tasty tempura batter, served with Peri-Peri dip.",R.drawable.ch_prawn_tempura));

        //chinese.add(new  TabsHelper("Chinese BBQ Sticks",1800,"BBQ-ed chicken chunks, along with tasty sautéed capsicums and tomatoes held together on a stick. Each plate consists of two sticks.",R.drawable.sand_turk_special));

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        context5=getActivity();
        v=inflater.inflate(R.layout.fragment_tab5, container, false);
        myrecycle1 = (RecyclerView) v.findViewById(recyclerview);
        ChineseAdapter recycle1=new ChineseAdapter(getContext(),chinese);
        myrecycle1.setLayoutManager(new LinearLayoutManager(getActivity()));
        myrecycle1.setAdapter(recycle1);
        recycle1.setOnItemClickListner(Tab5.this);
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
        Intent i=new Intent(context5, ChineseSelected.class);
        TabsHelper clickitem= chinese.get(position);

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
