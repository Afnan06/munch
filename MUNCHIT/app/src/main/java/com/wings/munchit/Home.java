package com.wings.munchit;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;

import static com.wings.munchit.R.id.recyclerview;


public class Home extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
   // ViewFlipper flipper;
    Toolbar toolbar;
    DrawerLayout drawerLayout;
   ContextMenu.ContextMenuInfo menuInfo;
    ContextMenu menu;
    View v;
    @Override
    public boolean onCreateOptionsMenu(Menu men) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menucat, men);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.category_menu:
                Toast.makeText(Home.this,"h",Toast.LENGTH_SHORT).show();
                return true;
            case R.id.category:
                startActivity(new Intent(this, Display1.class));
                return true;


            default:
                return super.onOptionsItemSelected(item);
        }


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        NavigationView navigationView=findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        //int images[]={R.drawable.slider1,R.drawable.slide2,R.drawable.slider3,R.drawable.slider4,R.drawable.slider5};

        //flipper=findViewById(R.id.vflipper);
        //for loop
        /*for (int i=0; i<images.length; i++){
            flipperimages(images[i]);

        }

         */
        //foreach
        //for (int image:images){
            //flipperimages(image);
        //}

        toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        toolbar.inflateMenu(R.menu.menucat);

        drawerLayout=findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle=new ActionBarDrawerToggle(this,drawerLayout,toolbar,
                R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        if (savedInstanceState==null){
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment, new HomeFragment()).commit();
        navigationView.setCheckedItem(R.id.nav_home);}


        /*final Deals[] deals = {
                new Deals("Germany", "currency of Germany is Euro."),
                new Deals("Denmark", "currency of Denmark is Danish Krone."),
                new Deals("Norway", "currency of Norway is Norwegian  Krone."),
                new Deals("Canada", "currency of Canada is Canadian Dollar."),
                new Deals("Pakistan", "currency of Pakistan is Rupee"),
                new Deals("Malaysia", "currency of Malaysia is Ringgit"),
                new Deals("India", "currency of India is Indian Rupee"),
                new Deals("South Africa", "currency of South Africa is Rand"),
                new Deals("Turkey", "currency of Turkey is Lira")
        };

         */
        /*final int[] dealtimages = {
                R.drawable.salty_vegie_pasta, R.drawable.cheese_pizza,
                R.drawable.creme_caamel, R.drawable.jalapeno_beef, R.drawable.chocolicious_donuts,
                R.drawable.double_zinger,
                R.drawable.sand_beef_bacon,
                R.drawable.peri_peri_chicken, R.drawable.sand_loaded_chicken};
        ArrayAdapter<Deals> projectAdapter =
                new ArrayAdapter<Deals>(this, 0, (deals)) {
                    @Override
                    public View getView(int position, View convertView, ViewGroup parent) {
                        Deals currentproject = deals[position];

                        // Inflate only once
                        if (convertView == null) {
                            convertView = getLayoutInflater()
                                    .inflate(R.layout.activity_home, null, false);
                        }
                        TextView projectName =
                                (TextView) convertView.findViewById(R.id.textView3);
                        ImageView projectimage = (ImageView) convertView.findViewById(R.id.imageView);

                        projectName.setText(currentproject.name);
                        projectimage.setImageResource(dealtimages[position]);
                        return convertView;
                    }
                };

         */
       /* ListView projectList = new ListView(this);
        setContentView(projectList);
        projectList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long rowId) {
                Deals currentproject = deals[position];
                String message = currentproject.price;
                Snackbar.make(adapterView, message, Snackbar.LENGTH_LONG)
                        .show();


            }

        });

        */
        //projectList.setAdapter(projectAdapter);





    }
    /*public  void flipperimages(int img){
        ImageView imageView=new ImageView(this);
        imageView.setBackgroundResource(img);

        flipper.addView(imageView);
        flipper.setFlipInterval(3000);
        flipper.startFlipping();

        //flipper.setInAnimation(this,android.R.anim.slide_in_left);
        //flipper.setOutAnimation(this,android.R.anim.slide_in_left);
    }

     */



    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        switch (menuItem.getItemId()) {
            case R.id.nav_home:
                Toast.makeText(this,"hieelllo",Toast.LENGTH_LONG).show();
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment, new HomeFragment()).commit();
                break;
            case R.id.nav_cart:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment, new CartFragment()).commit();
                break;
            case R.id.nav_categories:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment, new CategoriesFragment()).commit();
                break;
            case R.id.nav_contact:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment, new ContactFragment()).commit();
                break;
            case R.id.nav_about:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment, new AboutFragment()).commit();
                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);

        return true;
    }





    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else{
            super.onBackPressed();}
    }

}
