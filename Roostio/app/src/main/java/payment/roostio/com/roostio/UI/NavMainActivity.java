package payment.roostio.com.roostio.UI;

import android.net.Uri;
import android.support.v4.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import org.w3c.dom.Text;

import payment.roostio.com.roostio.R;

public class NavMainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, FragmentProfile.OnFragmentInteractionListener {

    private NavigationView mNavigationView;
    private TextView mUserEmail;
    private TextView mUserMobile;
    private Fragment fragmentProfile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nav_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        mNavigationView = (NavigationView) findViewById(R.id.nav_view);
        mNavigationView.setNavigationItemSelectedListener(this);
        mNavigationView.setCheckedItem(R.id.nav_menu_profile);
        initLayout();
        Intent i = getIntent();
        mUserEmail.setText(i.getStringExtra("email"));
        mUserMobile.setText(i.getStringExtra("mobile"));
    }

    private void initLayout(){
        mUserEmail = (TextView) findViewById(R.id.txt_mobile_user);
        mUserMobile = (TextView) findViewById(R.id.txt_email_user);
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


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_menu_profile) {
            Log.d("Navmainactivity","Here comes");
            // Handle the profile action
            fragmentProfile = new FragmentProfile();
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            if(!fragmentProfile.isAdded())
                transaction.add(fragmentProfile, "loginF");
            else
                transaction.show(getSupportFragmentManager().findFragmentByTag("loginF"));
            transaction.replace(R.id.container, fragmentProfile);
            transaction.commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
