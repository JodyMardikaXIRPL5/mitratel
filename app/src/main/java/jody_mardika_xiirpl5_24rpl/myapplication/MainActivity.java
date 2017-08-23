package jody_mardika_xiirpl5_24rpl.myapplication;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        changePage(R.id.nav_home);
        navigationView.setCheckedItem(R.id.nav_home);
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


        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        changePage(id);

        return true;
    }

    private void changePage(int id) {
        Fragment fragment = null;

        if (id == R.id.nav_home) {
            fragment = new HomeFragment();
            setTitle("Welcome");

        } else if (id == R.id.nav_simop) {
            fragment = new SimopFragment();
            setTitle("SIMOP");

        } else if (id == R.id.nav_simpro) {
            fragment = new SimproFragment();
            setTitle("SIMPRO");

        } else if (id == R.id.nav_pokemon) {
            fragment = new PokemonFragment();
            setTitle("PoKeMON");

        } else if (id == R.id.nav_panda) {
            fragment = new PandaFragment();
            setTitle("PANDA");

        } else if (id == R.id.nav_sppd) {
            fragment = new SppdFragment();
            setTitle("SPPD");

        } else if (id == R.id.nav_jaguar) {
            fragment = new JaguarFragment();
            setTitle("JAGUAR");

        } else if (id == R.id.nav_ventura1) {
            fragment = new Ventura1Fragment();
            setTitle("PMO Ventura B2S");

        } else if (id == R.id.nav_ventura2) {
            fragment = new Ventura2Fragment();
            setTitle("PMO Ventura");

        } else if (id == R.id.nav_pmo) {
            fragment = new PmoFragment();
            setTitle("PMO");

        } else if (id == R.id.nav_eoffice) {
            fragment = new EofficeFragment();
            setTitle("E-OFFICE");

        }

        getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).commitNow();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
    }
}
