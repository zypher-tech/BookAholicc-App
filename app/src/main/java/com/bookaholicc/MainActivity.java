package com.bookaholicc;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.bookaholicc.Fragments.CartFragment;
import com.bookaholicc.Fragments.CategoriesFragment;
import com.bookaholicc.Fragments.HomeFragement;
import com.bookaholicc.Fragments.NotificationsFragment;
import com.bookaholicc.Fragments.ProfileFragment;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabReselectListener;
import com.roughike.bottombar.OnTabSelectListener;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, OnTabSelectListener, OnTabReselectListener {


    @BindView(R.id.toolbar)
    Toolbar toolbar;
//    @BindView(R.id.search_card)
//    CardView searchCard;


    @BindView(R.id.nav_view)
    NavigationView navView;
    @BindView(R.id.drawer_layout)
    DrawerLayout drawerLayout;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        setUpBottomar();
        showMainFrag();
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
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }



    private void setUpBottomar() {
        BottomBar bottomBar = (BottomBar) findViewById(R.id.bottomBar);
        bottomBar.setOnTabSelectListener(this);
        bottomBar.setOnTabReselectListener(this);
        bottomBar.setLongPressHintsEnabled(true);


    }



    private void showMainFrag() {
        getSupportFragmentManager().
                beginTransaction()
                .replace(R.id.frag_holder_main,new HomeFragement())
                .commit();
    }


    @Override
    public void onTabSelected(@IdRes int tabId) {
        Fragment mFragment = null;
        String transactionString = "none";
        switch (tabId){
            case R.id.tab_home:
                mFragment = new HomeFragement();
                transactionString = "home";

                break;
            case R.id.tab_categories:
                mFragment  = new CategoriesFragment();
                transactionString = "cat";
                break;
            case R.id.tab_notifications:
                mFragment = new NotificationsFragment();
                transactionString = "noti";
                break;
            case R.id.tab_profile:
                mFragment = new ProfileFragment();
                transactionString = "profile";
                break;
            case R.id.tab_cart:
                mFragment = new CartFragment();
                transactionString = "cart";
                break;
            default:
                return;

        }

        getSupportFragmentManager().
                beginTransaction()
                .replace(R.id.frag_holder_main,mFragment)
                .addToBackStack(transactionString)
                .commit();

    }

    @Override
    public void onTabReSelected(@IdRes int tabId) {

    }
}
