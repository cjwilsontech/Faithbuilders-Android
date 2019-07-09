package com.eusebeia.faithbuilders;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    NavigationView navigationView = null;
    Toolbar toolbar = null;
    public static List<Speaker> SpeakerList = new ArrayList<>();
    public static ArrayList<ScheduleItem> ScheduleList = new ArrayList<>();

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putCharSequence("title", getTitle());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState != null) {
            setTitle(savedInstanceState.getCharSequence("title"));
        } else {
            // Initialize list of speakers.
            SpeakerList.add(new Speaker("Brandon Edwards", "Nashville, TN", getResources().getString(R.string.description_brandonedwards), R.drawable.brandonedwards));
            SpeakerList.add(new Speaker("Dan Winkler", "Huntingdon, TN", getResources().getString(R.string.description_danwinkler), R.drawable.danwinkler));
            SpeakerList.add(new Speaker("Dennis Baker", "Tacoma, WA", getResources().getString(R.string.description_dennisbaker), R.drawable.dennisbaker));
            SpeakerList.add(new Speaker("Don Jacobs", "Olympia, WA", getResources().getString(R.string.description_donjacobs), R.drawable.donjacobs));
            SpeakerList.add(new Speaker("John DeBerry", "Memphis, TN", getResources().getString(R.string.description_johndeberry), R.drawable.johndeberry));
            SpeakerList.add(new Speaker("Julian Webster", "Nashville, TN", getResources().getString(R.string.description_julianwebster), R.drawable.julianwebster));
            SpeakerList.add(new Speaker("Kenney Johnson", "Seattle, WA", getResources().getString(R.string.description_kenneyjohnson), R.drawable.kenneyjohnson));
            SpeakerList.add(new Speaker("Lee Jamieson", "Tallahassee, FL", getResources().getString(R.string.description_leejamieson), R.drawable.leejamieson));
            SpeakerList.add(new Speaker("Mike Greene", "Nashville, TN", getResources().getString(R.string.description_michaelgreene), R.drawable.michaelgreene));
            SpeakerList.add(new Speaker("Ronnie Morrison", "Tacoma, WA", getResources().getString(R.string.description_ronniemorrison), R.drawable.ronniemorrison));
            SpeakerList.add(new Speaker("Sheila Butt", "Columbia, TN", getResources().getString(R.string.description_sheilabutt), R.drawable.sheilabutt));
            SpeakerList.add(new Speaker("Thomas Morse", "Renton, WA", getResources().getString(R.string.description_thomasmorse), R.drawable.thomasmorse));

            // Initialize list of classes.
            ScheduleList.add(new ScheduleItem("Registration and Displays", "Foyer", "8:30 AM", "9:00 AM", 0, null));
            ScheduleList.add(new ScheduleItem("By the Blood of the Cross", "Auditorium", "9:00 AM", "10:00 AM", 0, SpeakerList.get(7)));
            ScheduleList.add(new ScheduleItem("The Fear of the Lord", "Room #1", "9:00 AM", "10:00 AM", 0, SpeakerList.get(9)));
            ScheduleList.add(new ScheduleItem("Fostering Reconciliation", "Room #2", "9:00 AM", "10:00 AM", 0, SpeakerList.get(3)));
            ScheduleList.add(new ScheduleItem("Forgiving Myself", "Auditorium", "10:15 AM", "11:15 AM", 0, SpeakerList.get(1)));
            ScheduleList.add(new ScheduleItem("What is Family Ministry?", "Room #1", "10:15 AM", "11:15 AM", 0, SpeakerList.get(2)));
            ScheduleList.add(new ScheduleItem("Fellowship Conundrum", "Room #2", "10:15 AM", "11:15 AM", 0, SpeakerList.get(6)));
            ScheduleList.add(new ScheduleItem("The Relationship of 2 Corinthians to 1 Corinthians", "Auditorium", "1:30 PM", "2:30 PM", 0, SpeakerList.get(8)));
            ScheduleList.add(new ScheduleItem("Brother to Brother", "Auditorium", "2:45 PM", "3:45 PM", 0, SpeakerList.get(8)));
            ScheduleList.add(new ScheduleItem("The Beauty of Reconciliation", "Room #1", "2:45 PM", "3:45 PM", 0, SpeakerList.get(10)));
            ScheduleList.add(new ScheduleItem("Joseph and his Brothers", "Room #2", "2:45 PM", "3:45 PM", 0, SpeakerList.get(5)));
            ScheduleList.add(new ScheduleItem("World Through Eyes of Faith (Part 1)", "Auditorium", "4:00 PM", "5:00 PM", 0, SpeakerList.get(4)));
            ScheduleList.add(new ScheduleItem("A Christian Online Community", "Room #1", "4:00 PM", "5:00 PM", 0, SpeakerList.get(0)));
			ScheduleList.add(new ScheduleItem("Reconciliation in the Home - Lamplighters (Part 1)", "Room #2", "4:00 PM", "5:00 PM", 0, SpeakerList.get(11)));
            ScheduleList.add(new ScheduleItem("Reconciled in Glory", "Auditorium", "7:30 PM", "8:30 PM", 0, SpeakerList.get(7)));
            
            ScheduleList.add(new ScheduleItem("Registration and Displays", "Foyer", "8:30 AM", "9:00 AM", 1, null));
            ScheduleList.add(new ScheduleItem("For the Glory of God", "Auditorium", "9:00 AM", "10:00 AM", 1, SpeakerList.get(7)));
            ScheduleList.add(new ScheduleItem("The Love of Christ", "Room #1", "9:00 AM", "10:00 AM", 1, SpeakerList.get(9)));
            ScheduleList.add(new ScheduleItem("Adoption Reconciliation", "Room #2", "9:00 AM", "10:00 AM", 1, SpeakerList.get(3)));
            ScheduleList.add(new ScheduleItem("Forgiving Others", "Auditorium", "10:15 AM", "11:15 AM", 1, SpeakerList.get(1)));
            ScheduleList.add(new ScheduleItem("The Goal of Family Ministry", "Room #1", "10:15 AM", "11:15 AM", 1, SpeakerList.get(2)));
            ScheduleList.add(new ScheduleItem("Race Reconciliation (Part 1)", "Room #2", "10:15 AM", "11:15 AM", 1, SpeakerList.get(6)));
            ScheduleList.add(new ScheduleItem("Connecting People to God", "Auditorium", "1:30 PM", "2:30 PM", 1, SpeakerList.get(5)));
            ScheduleList.add(new ScheduleItem("Leadership to Members", "Auditorium", "2:45 PM", "3:45 PM", 1, SpeakerList.get(8)));
            ScheduleList.add(new ScheduleItem("Jesus and Reconciliation", "Room #1", "2:45 PM", "3:45 PM", 1, SpeakerList.get(10)));
            ScheduleList.add(new ScheduleItem("David and the Lord", "Room #2", "2:45 PM", "3:45 PM", 1, SpeakerList.get(5)));
            ScheduleList.add(new ScheduleItem("World Through Eyes of Faith (Part 2)", "Auditorium", "4:00 PM", "5:00 PM", 1, SpeakerList.get(4)));
			ScheduleList.add(new ScheduleItem("Evangelizing through Social Media", "Room #1", "4:00 PM", "5:00 PM", 1, SpeakerList.get(0)));
			ScheduleList.add(new ScheduleItem("Reconciliation in the Home - Lamplighters (Part 2)", "Room #2", "4:00 PM", "5:00 PM", 1, SpeakerList.get(11)));
            ScheduleList.add(new ScheduleItem("Need to Reconcile", "Auditorium", "7:30 PM", "8:30 PM", 1, SpeakerList.get(4)));

            ScheduleList.add(new ScheduleItem("Registration and Displays", "Foyer", "8:30 AM", "9:00 AM", 2, null));
            ScheduleList.add(new ScheduleItem("For the World to See", "Auditorium", "9:00 AM", "10:00 AM", 2, SpeakerList.get(7)));
            ScheduleList.add(new ScheduleItem("The Commission of Christ", "Room #1", "9:00 AM", "10:00 AM", 2, SpeakerList.get(9)));
            ScheduleList.add(new ScheduleItem("Return Home Reconciliation", "Room #2", "9:00 AM", "10:00 AM", 2, SpeakerList.get(3)));
            ScheduleList.add(new ScheduleItem("Forgiving God", "Auditorium", "10:15 AM", "11:15 AM", 2, SpeakerList.get(1)));
            ScheduleList.add(new ScheduleItem("Effective Family Ministry", "Room #1", "10:15 AM", "11:15 AM", 2, SpeakerList.get(2)));
            ScheduleList.add(new ScheduleItem("Race Reconciliation (Part 2)", "Room #2", "10:15 AM", "11:15 AM", 2, SpeakerList.get(6)));
            ScheduleList.add(new ScheduleItem("Racial Reconciliation", "Auditorium", "1:30 PM", "2:30 PM", 2, SpeakerList.get(5)));
            ScheduleList.add(new ScheduleItem("Members to Leadership", "Auditorium", "2:45 PM", "3:45 PM", 2, SpeakerList.get(8)));
            ScheduleList.add(new ScheduleItem("Hannah", "Room #1", "2:45 PM", "3:45 PM", 2, SpeakerList.get(10)));
            ScheduleList.add(new ScheduleItem("Saul and Jesus", "Room #2", "2:45 PM", "3:45 PM", 2, SpeakerList.get(5)));
            ScheduleList.add(new ScheduleItem("World Through Eyes of Faith (Part 3)", "Auditorium", "4:00 PM", "5:00 PM", 2, SpeakerList.get(4)));
            ScheduleList.add(new ScheduleItem("The Art of Creative Ministry", "Room #1", "4:00 PM", "5:00 PM", 2, SpeakerList.get(0)));
			ScheduleList.add(new ScheduleItem("Grace: Reconciled to God", "Auditorium", "5:30 PM", "6:30 PM", 2, SpeakerList.get(1)));
            
            changeFragment(new HomeFragment(), false);
        }

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();

            // Correct the selected item in the NavigationView.
            Fragment currentFragment = getSupportFragmentManager().findFragmentById(R.id.fragment_container);
            if (currentFragment instanceof HomeFragment) {
                navigationView.setCheckedItem(R.id.nav_home);
            } else if (currentFragment instanceof SpeakersFragment) {
                navigationView.setCheckedItem(R.id.nav_speakers);
            } else if (currentFragment instanceof ScheduleFragment) {
                navigationView.setCheckedItem(R.id.nav_schedule);
            } else if (currentFragment instanceof MapsFragment) {
                navigationView.setCheckedItem(R.id.nav_maps);
            } else if (currentFragment instanceof AboutFragment) {
                navigationView.setCheckedItem(R.id.nav_about);
            }
        }
    }

    private void changeFragment(Fragment fragment) {
        android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, fragment).addToBackStack(null).commit();
    }

    private void changeFragment(Fragment fragment, boolean addToBackStack) {
        android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, fragment);
        if (addToBackStack)
            fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            changeFragment(new HomeFragment());
        } else if (id == R.id.nav_speakers) {
            changeFragment(new SpeakersFragment());
        } else if (id == R.id.nav_schedule) {
            changeFragment(new ScheduleFragment());
        } else if (id == R.id.nav_maps) {
            changeFragment(new MapsFragment());
        //} else if (id == R.id.nav_donate) {
        //    changeFragment(new DonateFragment());
        } else if (id == R.id.nav_about) {
            changeFragment(new AboutFragment());
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
