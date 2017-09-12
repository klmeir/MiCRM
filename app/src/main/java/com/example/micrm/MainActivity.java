package com.example.micrm;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.example.micrm.fragments.ActividadFragment;
import com.example.micrm.fragments.HomeFragment;
import com.example.micrm.fragments.NegocioFragment;
import com.example.micrm.fragments.OrganizacionFragment;
import com.example.micrm.fragments.PersonaFragment;

public class MainActivity extends AppCompatActivity implements
        NavigationView.OnNavigationItemSelectedListener {

    private final String TAG_D = "MainActivity";

    // UI references.
    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.setDrawerListener(toggle);
        toggle.syncState();

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.content_frame, new HomeFragment())
                .commit();
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        boolean fragmentTransaction = false;
        Fragment fragment = null;

        switch (item.getItemId()) {
            case R.id.drawer_nav1:
                fragment = new HomeFragment();
                fragmentTransaction = true;
                break;
            case R.id.drawer_nav2:
                fragment = new PersonaFragment();
                fragmentTransaction = true;
                break;
            case R.id.drawer_nav3:
                fragment = new OrganizacionFragment();
                fragmentTransaction = true;
                break;
            case R.id.drawer_nav4:
                fragment = new NegocioFragment();
                fragmentTransaction = true;
                break;
            case R.id.drawer_nav5:
                fragment = new ActividadFragment();
                fragmentTransaction = true;
                break;
        }

        if (fragmentTransaction) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.content_frame, fragment)
                    .commit();

            item.setChecked(true);
            if (item.getItemId() == R.id.drawer_nav1)
                getSupportActionBar().setTitle(R.string.app_name);
            else
                getSupportActionBar().setTitle(item.getTitle());
        }

        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

}
