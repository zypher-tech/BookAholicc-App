package com.bookaholicc;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bookaholicc.CustomUI.CircleImageView;
import com.bookaholicc.CustomUI.OpenSansTextView;
import com.bookaholicc.CustomUI.WhitenyBooksFont;
import com.sothree.slidinguppanel.SlidingUpPanelLayout;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    //        implements NavigationView.OnNavigationItemSelectedListener, OnTabSelectListener, OnTabReselectListener {
//
//
    private static final String TAG = "DemoActivity";
    @BindView(R.id.main)
    TextView main;
    @BindView(R.id.drawer_profile_img)
    CircleImageView drawerProfileImg;
    @BindView(R.id.drawer_profile_name)
    WhitenyBooksFont drawerProfileName;
    @BindView(R.id.drawer_your_p_text)
    WhitenyBooksFont drawerYourPText;
    @BindView(R.id.profile_container)
    CardView profileContainer;
    @BindView(R.id.d_pro_c)
    RelativeLayout dProC;
    @BindView(R.id.d_h_img)
    ImageView dHImg;
    @BindView(R.id.d_home_tt)
    OpenSansTextView dHomeTt;
    @BindView(R.id.d_home_c)
    RelativeLayout dHomeC;
    @BindView(R.id.d_categ_img)
    ImageView dCategImg;
    @BindView(R.id.d_cat_tt)
    OpenSansTextView dCatTt;
    @BindView(R.id.d_cat_c)
    RelativeLayout dCatC;
    @BindView(R.id.d_wish_img)
    ImageView dWishImg;
    @BindView(R.id.d_wish_tt)
    OpenSansTextView dWishTt;
    @BindView(R.id.whitenyBooksFont)
    WhitenyBooksFont whitenyBooksFont;
    @BindView(R.id.d_wish_c)
    RelativeLayout dWishC;
    @BindView(R.id.d_cart_img)
    ImageView dCartImg;
    @BindView(R.id.d_cart_tt)
    OpenSansTextView dCartTt;
    @BindView(R.id.d_cart_amouunt)
    WhitenyBooksFont dCartAmouunt;
    @BindView(R.id.d_cart_c)
    RelativeLayout dCartC;
    @BindView(R.id.d_dontate_img)
    ImageView dDontateImg;
    @BindView(R.id.d_donate_tt)
    OpenSansTextView dDonateTt;
    @BindView(R.id.d_rent_books)
    RelativeLayout dRentBooks;
    @BindView(R.id.dragView)
    LinearLayout dragView;
    @BindView(R.id.sliding_layout)
    SlidingUpPanelLayout slidingLayout;

    private SlidingUpPanelLayout mLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app_bar_main);
        ButterKnife.bind(this);

//        setSupportActionBar((Toolbar) findViewById(R.id.main_toolbar));

//        ListView lv = (ListView) findViewById(R.id.list);
//        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Toast.makeText(MainActivity.this, "onItemClick", Toast.LENGTH_SHORT).show();
//            }
//        });
//
//        List<String> your_array_list = Arrays.asList(
//                "This",
//                "Is",
//                "An",
//                "Example",
//                "ListView",
//                "That",
//                "You",
//                "Can",
//                "Scroll",
//                ".",
//                "It",
//                "Shows",
//                "How",
//                "Any",
//                "Scrollable",
//                "View",
//                "Can",
//                "Be",
//                "Included",
//                "As",
//                "A",
//                "Child",
//                "Of",
//                "SlidingUpPanelLayout"
//        );
//
//        // This is the array adapter, it takes the context of the activity as a
//        // first parameter, the type of list view as a second parameter and your
//        // array as a third parameter.
//        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
//                this,
//                android.R.layout.simple_list_item_1,
//                your_array_list );
//
//        lv.setAdapter(arrayAdapter);

        mLayout = (SlidingUpPanelLayout) findViewById(R.id.sliding_layout);


        mLayout.addPanelSlideListener(new SlidingUpPanelLayout.PanelSlideListener() {
            @Override
            public void onPanelSlide(View panel, float slideOffset) {
                Log.i(TAG, "onPanelSlide, offset " + slideOffset);
            }


            @Override
            public void onPanelStateChanged(View panel, SlidingUpPanelLayout.PanelState previousState, SlidingUpPanelLayout.PanelState newState) {
                Log.i(TAG, "onPanelStateChanged " + newState);
            }
        });
        mLayout.setFadeOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mLayout.setPanelState(SlidingUpPanelLayout.PanelState.COLLAPSED);
            }
        });

//        TextView t = (TextView) findViewById(R.id.name);
//        t.setText(Html.fromHtml(getString(R.string.hello)));
//        final Button f = (Button) findViewById(R.id.follow);
//        f.setText(Html.fromHtml(getString(R.string.follow)));
//        f.setMovementMethod(LinkMovementMethod.getInstance());
//        f.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                closeDrawer();
//            }
//        });
    }

    private void closeDrawer() {
        Log.d(TAG, "closeDrawer: Button Pressed");
        mLayout.setPanelState(SlidingUpPanelLayout.PanelState.COLLAPSED);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
//        MenuItem item = menu.findItem(R.id.action_settings);
//        if (mLayout != null) {
//            if (mLayout.getPanelState() == SlidingUpPanelLayout.PanelState.HIDDEN) {
//                item.setTitle(R.string.action_show);
//            } else {
//                item.setTitle(R.string.action_hide);
//            }
//        }
        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
//        switch (item.getItemId()){
////            case R.id.action_toggle: {
////                if (mLayout != null) {
////                    if (mLayout.getPanelState() != PanelState.HIDDEN) {
////                        mLayout.setPanelState(PanelState.HIDDEN);
////                        item.setTitle(R.string.action_show);
////                    } else {
////                        mLayout.setPanelState(PanelState.COLLAPSED);
////                        item.setTitle(R.string.action_hide);
////                    }
//////                }
////                return true;
////            }
////            case R.id.action_anchor: {
////                if (mLayout != null) {
////                    if (mLayout.getAnchorPoint() == 1.0f) {
////                        mLayout.setAnchorPoint(0.7f);
////                        mLayout.setPanelState(PanelState.ANCHORED);
////                        item.setTitle(R.string.action_anchor_disable);
////                    } else {
////                        mLayout.setAnchorPoint(1.0f);
////                        mLayout.setPanelState(PanelState.COLLAPSED);
////                        item.setTitle(R.string.action_anchor_enable);
////                    }
////                }
//                return true;
//            }
//
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        if (mLayout != null &&
                (mLayout.getPanelState() == SlidingUpPanelLayout.PanelState.EXPANDED || mLayout.getPanelState() == SlidingUpPanelLayout.PanelState.ANCHORED)) {
            mLayout.setPanelState(SlidingUpPanelLayout.PanelState.COLLAPSED);
        } else {
            super.onBackPressed();
        }
    }
}


//    private static final String TAG = "MAIN: ";
////    @BindView(R.id.toolbar)
////    Toolbar toolbar;
//////    @BindView(R.id.search_card)
//////    CardView searchCard;
////
////
////    @BindView(R.id.nav_view)
////    NavigationView navView;
////    @BindView(R.id.drawer_layout)
////    DrawerLayout drawerLayout;
//
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.app_bar_main);
//
/*        ImageView mToolbarIcon  = (ImageView) findViewById(R.id.toolbar_image);
        Picasso.with(this)
                .load(R.mipmap.logo_icon)
                .resize(50,50)
                .centerCrop().into(mToolbarIcon);
//*/


//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//
//    }
//}
////        ButterKnife.bind(this);

//
//
//        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
//        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
//                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
//        drawer.setDrawerListener(toggle);
//        toggle.syncState();
//
//        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
//        navigationView.setNavigationItemSelectedListener(this);
//
//
//        setUpBottomar();
//        showMainFrag();


//
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//
//        Log.d(TAG, "onActivityResult: ");
//        super.onActivityResult(requestCode, resultCode, data);
//        Fragment fragments = getSupportFragmentManager().findFragmentByTag("profile");
//        if(fragments != null){
//
//            fragments.onActivityResult(requestCode, resultCode, data);
//
//        }
//        else{
//            Log.d(TAG, "onActivityResult: Null Fragment");
//        }
//    }
//
//    @Override
//    public void onBackPressed() {
//        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
//        if (drawer.isDrawerOpen(GravityCompat.START)) {
//            drawer.closeDrawer(GravityCompat.START);
//        } else {
//            super.onBackPressed();
//        }
//    }
//
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.main, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }
//
//    @SuppressWarnings("StatementWithEmptyBody")
//    @Override
//    public boolean onNavigationItemSelected(MenuItem item) {
//        // Handle navigation view item clicks here.
//        int id = item.getItemId();
//
//        if (id == R.id.nav_camera) {
//            // Handle the camera action
//        } else if (id == R.id.nav_gallery) {
//
//        } else if (id == R.id.nav_slideshow) {
//
//        } else if (id == R.id.nav_manage) {
//
//        } else if (id == R.id.nav_share) {
//
//        } else if (id == R.id.nav_send) {
//
//        }
//
//        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
//        drawer.closeDrawer(GravityCompat.START);
//        return true;
//    }
//
//
//
//    private void setUpBottomar() {
//        BottomBar bottomBar = (BottomBar) findViewById(R.id.bottomBar);
//        bottomBar.setOnTabSelectListener(this);
//        bottomBar.setOnTabReselectListener(this);
//        bottomBar.setLongPressHintsEnabled(true);
//
//
//    }
//
//
//
//    private void showMainFrag() {
//        getSupportFragmentManager().
//                beginTransaction()
//                .replace(R.id.frag_holder_main,new HomeFragement())
//                .commit();
//    }
//
//
//    @Override
//    public void onTabSelected(@IdRes int tabId) {
//        Fragment mFragment = null;
//        String transactionString = "none";
//        switch (tabId){
//            case R.id.tab_home:
//                mFragment = new HomeFragement();
//                transactionString = "home";
//
//                break;
//            case R.id.tab_categories:
//                mFragment  = new CategoriesFragment();
//                transactionString = "cat";
//                break;
//            case R.id.tab_notifications:
//                mFragment = new NotificationsFragment();
//                transactionString = "noti";
//                break;
//            case R.id.tab_profile:
//                mFragment = new ProfileFragment();
//                transactionString = "profile";
//                break;
//            case R.id.tab_cart:
//                mFragment = new CartFragment();
//                transactionString = "cart";
//                break;
//            default:
//                return;
//
//        }
//
//        getSupportFragmentManager().
//                beginTransaction()
//                .replace(R.id.frag_holder_main,mFragment,transactionString)
//
//                .addToBackStack(transactionString)
//                .commit();
//
//    }
//
//    @Override
//    public void onTabReSelected(@IdRes int tabId) {
//
//    }
//}
