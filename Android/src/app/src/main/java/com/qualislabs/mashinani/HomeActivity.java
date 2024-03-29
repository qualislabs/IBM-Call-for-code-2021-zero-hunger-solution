package com.qualislabs.mashinani;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

import com.qualislabs.mashinani.Common.Common;
import com.qualislabs.mashinani.Models.FarmerRequisition;

import java.sql.Driver;

public class HomeActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    TextView mTextViewSeeAllEntries, mTextViewHomeUserName, mTextViewHeaderUsername, mTextViewHeaderEmail;
    ImageView mImageViewNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        toggle.getDrawerArrowDrawable().setColor(getResources().getColor(R.color.secondary_text));
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        //name for the user
        View headerview = navigationView.getHeaderView(0);

        mTextViewSeeAllEntries = (TextView)findViewById(R.id.txt_sell_all_schedule);
        mTextViewHomeUserName = (TextView)findViewById(R.id.txt_username_home);
        mTextViewHeaderUsername =(TextView)headerview.findViewById(R.id.txt_header_username);
        mTextViewHeaderEmail =(TextView)headerview.findViewById(R.id.txt_header_email);

        mImageViewNext = (ImageView)findViewById(R.id.img_next);


        mTextViewHomeUserName.setText(Common.currentUser.getUserName());
        mTextViewHeaderUsername.setText(Common.currentUser.getUserName());
        mTextViewHeaderEmail.setText(Common.currentUser.getEmail());

        mTextViewSeeAllEntries.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =  new Intent(HomeActivity.this, HistoryActivity.class);
                startActivity(intent);
            }
        });

        mImageViewNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = null;
                if (Common.currentUser.getUserType().equals("farmer"))
                    intent =  new Intent(HomeActivity.this, FarmerRequisitionActivity.class);
                else if (Common.currentUser.getUserType().equals("trader"))
                    intent =  new Intent(HomeActivity.this, TraderRequisitionActivity.class);
                else
                    intent =  new Intent(HomeActivity.this, DriverTripActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }




    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {

        }  else if (id == R.id.nav_metrics) {

        } else if (id == R.id.nav_account) {
            Intent intent =  new Intent(HomeActivity.this, UserProfileActivity.class);
            startActivity(intent);

        } else if (id == R.id.nav_payment) {

        } else if (id == R.id.nav_settings) {

        } else if (id == R.id.nav_help) {

        } else if (id == R.id.nav_logout) {
            // Log out
            Intent signIn = new Intent (HomeActivity.this, IntroActivity.class);
            signIn.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            SharedPreferences sharedPreferences = this.getSharedPreferences("com.qualislabs.mashinani", Context.MODE_PRIVATE);
            sharedPreferences.edit().clear().apply();
            startActivity(signIn);

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }



}