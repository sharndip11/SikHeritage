package com.example.sharndip.sikheritage;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
//import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{

    private ActionBarDrawerToggle actionBarDrawerToggle;
    public ActionBar actionBar;
    private DrawerLayout drawerLayout;
    private ListView navList;
    public FragmentTransaction fragmentTransaction;
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        drawerLayout = (DrawerLayout)findViewById(R.id.drawerLayout);
        navList = (ListView)findViewById(R.id.navList);
        ArrayList<String>navArray = new ArrayList<>();
        navArray.add("Home");
        navArray.add("Gursikh Jeevan");
        navArray.add("Histoire");
        navArray.add("Fakre Kaum");
        navArray.add("FAQ");
        navArray.add("Gurdwara");
        navArray.add("Biographie");
        navArray.add("Quizz");
        navList.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_activated_1,navArray);
        navList.setAdapter(adapter);
        navList.setOnItemClickListener(this);

        actionBarDrawerToggle = new ActionBarDrawerToggle(this,drawerLayout,R.string.openDrawer,R.string.closeDrawer);
        drawerLayout.setDrawerListener(actionBarDrawerToggle);

        actionBar = getSupportActionBar();
        //actionBar.setDisplayShowHomeEnabled(true);
        //actionBar.setDisplayHomeAsUpEnabled(true);

        fragmentManager = getSupportFragmentManager();

        loadSelection(0);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG).setAction("Action", null).show();
            }
        });
    }

    private void loadSelection(int i) {
        navList.setItemChecked(i, true);

        switch(i){
            case 0:
                HomeFragment homeFragment = new HomeFragment();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragmentHolder,homeFragment);
                fragmentTransaction.commit();
                break;

            case 1:
                MyFragment1 myFragment1 = new MyFragment1();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragmentHolder,myFragment1);
                fragmentTransaction.commit();
                break;

            case 2:
                MyFragment2 myFragment2 = new MyFragment2();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragmentHolder,myFragment2);
                fragmentTransaction.commit();
                break;

            case 3:
                MyFragment3 myFragment3 = new MyFragment3();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragmentHolder,myFragment3);
                fragmentTransaction.commit();
                break;

            case 4:
                break;

            case 5:
                break;

            case 6:
                break;

            case 7:
                break;
        }


    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        actionBarDrawerToggle.syncState();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
        } else if (id == android.R.id.home){
            if (drawerLayout.isDrawerOpen(navList)){
                drawerLayout.closeDrawer(navList);
            } else {
                drawerLayout.openDrawer(navList);
            }
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        loadSelection(position);

        drawerLayout.closeDrawer(navList);
    }
}
