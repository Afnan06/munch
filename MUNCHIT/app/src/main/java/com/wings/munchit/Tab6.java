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
 * {@link Tab6.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Tab6#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Tab6 extends Fragment implements DessertAdapter.OnItemClickListner{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    Activity context6;

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
    private List<TabsHelper> dessert;

    private OnFragmentInteractionListener mListener;

    public Tab6() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Tab6.
     */
    // TODO: Rename and change types and number of parameters
    public static Tab6 newInstance(String param1, String param2) {
        Tab6 fragment = new Tab6();
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
        dessert=new ArrayList<>();
        dessert.add(new TabsHelper ("Creme Carmel",189,"A mouth-watering, sweet vanilla custard dessert, topped with a layer of clear thick and delicious caramel sauce",R.drawable.creme_caamel));
        dessert.add(new  TabsHelper("Chocolicious Donuts",210,"A classic donut, topped with a delicious chocolate glaze, and sprinkled chocolate shavings. ",R.drawable.chocolicious_donuts));
        dessert.add(new  TabsHelper("Waffles",150,"Two separate pleasures on one plate. French vanilla ice cream & strawberries topped with strawberry puree meet Venetian chocolate ice cream, bananas & chocolate syrup. A mouth-watering combination topped with whipped cream.",R.drawable.waffles));
        dessert.add(new  TabsHelper("Creamy Donuts",189,"Centre filled with delicious custard, topped with a mouth-watering white glaze, and with a dash of coloured sprinkles. ",R.drawable.creamy_donuts));
        dessert.add(new  TabsHelper("Chco Lava",150,"Chocolate cupcake baked with chocolate chips, cantered with pure chocolate ganache, topped with a fudgy ganache frosting, rolled in chocolate cookie crumbs, drizzled with pure dark chocolate",R.drawable.choco_lava));

        dessert.add(new  TabsHelper("Green Woods",85,"Our traditional Red Velvet turned green for St. Patrick’s Day, topped with a cream cheese frosting, sprinkled with edible green sanding sugar and sprinkled chocolate shavings.",R.drawable.green_woods));
        dessert.add(new  TabsHelper("Strawberry Cheese",110,"A good thick crust, super creamy, rich and heavenly vanilla cheesecake, covered in strawberry sauce and fresh strawberries.",R.drawable.strawberryu_cheese));

        dessert.add(new  TabsHelper("Red Valvet",180,"Traditional Southern red velvet cupcake topped with a cocoa cream cheese frosting.",R.drawable.red_velvet));

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        context6=getActivity();
        v=inflater.inflate(R.layout.fragment_tab6, container, false);
        myrecycle1 = (RecyclerView) v.findViewById(recyclerview);
        DessertAdapter recycle1=new DessertAdapter(getContext(),dessert);
        myrecycle1.setLayoutManager(new LinearLayoutManager(getActivity()));
        myrecycle1.setAdapter(recycle1);
        recycle1.setOnItemClickListner(Tab6.this);
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
        Intent i=new Intent(context6, DessertSelected.class);
        TabsHelper clickitem= dessert.get(position);

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
