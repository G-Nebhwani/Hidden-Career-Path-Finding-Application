package com.example.elite;

import static androidx.core.app.PendingIntentCompat.getActivity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import androidx.appcompat.widget.Toolbar;
import android.widget.FrameLayout;

import android.widget.Toast;
import com.example.elite.Fragment.CategoryFragment;
import com.example.elite.Fragment.ExploreFragment;
import com.example.elite.Fragment.HomeFragment;
import com.example.elite.Fragment.OfferFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class DashboardActivity extends BasicActivity {

    BottomNavigationView bottomNavigationView;
    FrameLayout frameLayout;

    DrawerLayout drawerLayout;

    Toolbar toolbar;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        bottomNavigationView=findViewById(R.id.bottomnevigation);
        toolbar=findViewById(R.id.myToolBar);
        setSupportActionBar(toolbar);


        // Set default fragment when activity is created
        if (savedInstanceState == null) {
            // Check to ensure fragment is only set once (not recreated on orientation change)
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.dash_framelayout, new HomeFragment()) // Set your default fragment here
                    .commit();
        }
        HomeFragment homeFragment=new HomeFragment();
        CategoryFragment categoryFragment=new CategoryFragment();
        ExploreFragment exploreFragment=new ExploreFragment();
        OfferFragment offerFragment=new OfferFragment();

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if(item.getItemId()==R.id.dash_home){
                    getSupportFragmentManager().beginTransaction().replace(R.id.dash_framelayout,homeFragment).commit();
                    hideActionBar();
                    return true;
                }
                if(item.getItemId()==R.id.dash_category){
                    getSupportFragmentManager().beginTransaction().replace(R.id.dash_framelayout,categoryFragment).commit();
                    showActionBar();
                    return true;
                }
                if(item.getItemId()==R.id.dash_explore){
                    getSupportFragmentManager().beginTransaction().replace(R.id.dash_framelayout,exploreFragment).commit();
                    showActionBar();
                    return true;
                }
                if(item.getItemId()==R.id.dash_offer){
                    getSupportFragmentManager().beginTransaction().replace(R.id.dash_framelayout,offerFragment).commit();
                    showActionBar();
                    return true;
                }
                return true;
            }
        });

    }
    private void hideActionBar() {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
    }

    private void showActionBar() {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.show();
        }

    }
}