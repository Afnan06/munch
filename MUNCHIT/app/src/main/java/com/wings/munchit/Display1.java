package com.wings.munchit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.tabs.TabLayout;

public class Display1 extends AppCompatActivity implements Tab1.OnFragmentInteractionListener,
        Tab2.OnFragmentInteractionListener,Tab3.OnFragmentInteractionListener,Tab4.OnFragmentInteractionListener,
        Tab5.OnFragmentInteractionListener,Tab6.OnFragmentInteractionListener{
    TabLayout tabLayout;
    ViewPager viewpager;
    PagerAdapter adapter;
    Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display1);
        toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        tabLayout =findViewById(R.id.tablayout);
        tabLayout.addTab(tabLayout.newTab().setText("PIZZAS"));
        tabLayout.addTab(tabLayout.newTab().setText("BURGERS"));
        tabLayout.addTab(tabLayout.newTab().setText("PASTAS"));
        tabLayout.addTab(tabLayout.newTab().setText("SANDWICHES"));
        tabLayout.addTab(tabLayout.newTab().setText("CHINESE"));
        tabLayout.addTab(tabLayout.newTab().setText("DESSERTS"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        viewpager=findViewById(R.id.pager);
        adapter=new PagerAdapter(getSupportFragmentManager(),tabLayout.getTabCount());
        viewpager.setAdapter(adapter);
        viewpager.setOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewpager.setCurrentItem(tab.getPosition());


            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }




    });}
        @Override
        public void onFragmentInteraction(Uri uri) {

        }
    @Override
    public boolean onPrepareOptionsMenu(Menu men) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menucat, men);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.category_menu:
                startActivity(new Intent(this, Display1.class));
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }}


}
