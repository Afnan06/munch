package com.wings.munchit;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import static com.wings.munchit.R.id.recyclerview;
import static com.wings.munchit.R.id.tab1;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Tab1.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Tab1#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Tab1 extends Fragment implements PizzaAdapter.OnItemClickListner {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER;
    Activity context;

    public static final String EXTRA_URL="imageUrl";
    public static final String EXTRA_name=" foodName";
    public static final String EXTRA_price=" doodPrice";
    public static final String EXTRA_bdesc=" fooddesc";
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";




    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    View v;
    private RecyclerView myrecycle1;
    private List<TabsHelper> pizzas;

    private OnFragmentInteractionListener mListener;

    public Tab1() {

        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Tab1.
     */
    // TODO: Rename and change types and number of parameters
    public static Tab1 newInstance(String param1, String param2) {
        Tab1 fragment = new Tab1();
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
        pizzas=new ArrayList<>();
        pizzas.add(new TabsHelper ("Beef Stuffed ",1699,"An irresistible combo of beef, pepperoni, sausages, mushrooms, green peppers & onions.",R.drawable.beef_stuffed));
        pizzas.add(new  TabsHelper("Cheese Pizza",1599,"A fine blend of cheddar and mozzarella cheese. Layers of cheese and cheese with some more cheese.",R.drawable.cheese_pizza));
        pizzas.add(new  TabsHelper("Fajita Slician",1699,"A delicious blend of fajita chicken, onions, green peppers, green chilies & lots of cheese ",R.drawable.fajita_slician));
        pizzas.add(new  TabsHelper("Legend ranch",1699,"A tantalizing blend of grilled chicken, sliced cheese, oregano & onions topped with ranch sauce.",R.drawable.legend_ranch));
        pizzas.add(new  TabsHelper("Pepporini",1499,"Enjoy the extra layers of pepperoni & cheese.",R.drawable.pepporini));
        pizzas.add(new  TabsHelper("Peri Peri Chicken",1699,"An exotic combination of Peri Peri Chicken, Onions, Tomatoes, green pepper topped with Peri Peri Sauce",R.drawable.peri_peri_chicken));
        pizzas.add(new  TabsHelper("Pine Loaded",1399,"Loaded with Pineapples, Chicken Kickers, Chicken Tikka, Chicken Legend, Onion, Green Peppers, Black Olives and BBQ Seasoning",R.drawable.pine_loaded));
        pizzas.add(new  TabsHelper("Spicy Beef",1699,"A classic blend of beef, pepperoni, onions, green peppers, jalapenos, mushrooms & black olives.",R.drawable.spicy_beef));



    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        context=getActivity();
        // Inflate the layout for this fragment
        v= inflater.inflate(R.layout.fragment_tab1, container, false);
        myrecycle1 = (RecyclerView) v.findViewById(recyclerview);
        PizzaAdapter recycle1=new PizzaAdapter(getContext(),pizzas);
        myrecycle1.setLayoutManager(new LinearLayoutManager(getActivity()));
       myrecycle1.setAdapter(recycle1);
       recycle1.setOnItemClickListner(Tab1.this);
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

        Intent is=new Intent(context , Pizza_Selected.class);
        TabsHelper clickeditem= pizzas.get(position);

        is.putExtra(EXTRA_URL,clickeditem.getPhoto());

        is.putExtra(EXTRA_name,clickeditem.getFoodname());
        is.putExtra(EXTRA_price,clickeditem.getFoodprice());
        is.putExtra(EXTRA_bdesc,clickeditem.getDescrption());
        startActivity(is);



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
