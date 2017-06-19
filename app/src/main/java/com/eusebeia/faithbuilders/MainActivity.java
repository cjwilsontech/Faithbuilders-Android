package com.eusebeia.faithbuilders;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
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
    public static List<Speaker> SpeakerList = new ArrayList<Speaker>();
    public static ArrayList<ScheduleItem> ScheduleList = new ArrayList<ScheduleItem>();

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
            SpeakerList.add(new Speaker("Bob Stump", "Puyallup, WA", getResources().getString(R.string.description_bobstump), R.drawable.bobstump));
            SpeakerList.add(new Speaker("Dennis Baker", "Tacoma, WA", getResources().getString(R.string.description_dennisbaker), R.drawable.dennisbaker));
            SpeakerList.add(new Speaker("Derrick Allen", "Ellensburg, WA", getResources().getString(R.string.description_derrickallen), R.drawable.derrickallen));
            SpeakerList.add(new Speaker("Evertt Huffard", "Memphis, TN", getResources().getString(R.string.description_evertthuffard), R.drawable.evertthuffard));
            SpeakerList.add(new Speaker("Jimmy Hurd", "Seattle, WA", getResources().getString(R.string.description_jimmyhurd), R.drawable.jimmyhurd));
            SpeakerList.add(new Speaker("Keith Kasarjian", "Denver, CO", getResources().getString(R.string.description_keithkasarjian), R.drawable.keithkasarjian));
            SpeakerList.add(new Speaker("Keith Parker", "Hendersonville, TN", getResources().getString(R.string.description_keithparker), R.drawable.keithparker));
            SpeakerList.add(new Speaker("Ken Wilson", "Puyallup, WA", getResources().getString(R.string.description_kenwilson), R.drawable.kenwilson));
            SpeakerList.add(new Speaker("Lee Jamieson", "Tallahassee, FL", getResources().getString(R.string.description_leejamieson), R.drawable.leejamieson));
            SpeakerList.add(new Speaker("Lori Boyd", "Murfreesboro, TN", getResources().getString(R.string.description_loriboyd), R.drawable.loriboyd));
            SpeakerList.add(new Speaker("Mark Jamieson", "Puyallup, WA", getResources().getString(R.string.description_markjamieson), R.drawable.markjamieson));
            SpeakerList.add(new Speaker("Mark Johnson", "Olympia, WA", getResources().getString(R.string.description_markjohnson), R.drawable.markjohnson));
            SpeakerList.add(new Speaker("Wes Hanson", "Scappoose, OR", getResources().getString(R.string.description_weshanson), R.drawable.weshanson));
            SpeakerList.add(new Speaker("Wissam Al-Aethawi", "Metro Detroit, MI", getResources().getString(R.string.description_wissamalaethawi), R.drawable.wissamalaethawi));

            // Initialize list of classes.
            ScheduleList.add(new ScheduleItem("Registration and Displays", "Auditorium", "9:00 AM", "9:30 AM", 0, null));
            ScheduleList.add(new ScheduleItem("Concern for the Lost", "Auditorium", "9:30 AM", "10:30 AM", 0, SpeakerList.get(6)));
            ScheduleList.add(new ScheduleItem("The Power of the Pulpit", "Admin 101", "9:30 AM", "10:30 AM", 0, SpeakerList.get(5)));
            ScheduleList.add(new ScheduleItem("What is the Anointing?", "Xavier", "9:30 AM", "10:30 AM", 0, SpeakerList.get(11)));
            ScheduleList.add(new ScheduleItem("The Quran, or Bible", "Auditorium", "10:45 AM", "11:45 AM", 0, SpeakerList.get(13)));
            ScheduleList.add(new ScheduleItem("Preaching the Word", "Admin 101", "10:45 AM", "11:45 AM", 0, SpeakerList.get(5)));
            ScheduleList.add(new ScheduleItem("Conquering Fear Through Righteousness", "Xavier", "10:45 AM", "11:45 AM", 0, SpeakerList.get(9)));
            ScheduleList.add(new ScheduleItem("Embracing Apostolic Authority", "Auditorium", "1:30 PM", "2:30 PM", 0, SpeakerList.get(8)));
            ScheduleList.add(new ScheduleItem("The Power of Hope", "Auditorium", "2:45 PM", "3:45 PM", 0, SpeakerList.get(10)));
            ScheduleList.add(new ScheduleItem("Preaching that Convicts", "Admin 101", "2:45 PM", "3:45 PM", 0, SpeakerList.get(5)));
            ScheduleList.add(new ScheduleItem("Principles of Leadership", "Xavier", "2:45 PM", "3:45 PM", 0, SpeakerList.get(3)));
            ScheduleList.add(new ScheduleItem("Families in Crisis", "Auditorium", "4:00 PM", "5:00 PM", 0, SpeakerList.get(4)));
            ScheduleList.add(new ScheduleItem("Preacher Training", "Admin 101", "4:00 PM", "5:00 PM", 0, SpeakerList.get(0)));
            ScheduleList.add(new ScheduleItem("Casting Out the Fear of Life", "Xavier", "4:00 PM", "5:00 PM", 0, SpeakerList.get(2)));
            ScheduleList.add(new ScheduleItem("I am Arab and Christian", "Auditorium", "7:00 PM", "8:00 PM", 0, SpeakerList.get(13)));

            ScheduleList.add(new ScheduleItem("Registration and Displays", "Auditorium", "9:00 AM", "9:30 AM", 1, null));
            ScheduleList.add(new ScheduleItem("Youth Challenge", "University Center", "9:00 AM", "4:00 PM", 1, SpeakerList.get(12)));
            ScheduleList.add(new ScheduleItem("Walking in the Light", "Auditorium", "9:30 AM", "10:30 AM", 1, SpeakerList.get(6)));
            ScheduleList.add(new ScheduleItem("We Have the Message", "Admin 101", "9:30 AM", "10:30 AM", 1, SpeakerList.get(8)));
            ScheduleList.add(new ScheduleItem("What is Testing the Spirits?", "Xavier", "9:30 AM", "10:30 AM", 1, SpeakerList.get(11)));
            ScheduleList.add(new ScheduleItem("Abraham, Muhammed, Golden Butterfly", "Auditorium", "10:45 AM", "11:45 AM", 1, SpeakerList.get(13)));
            ScheduleList.add(new ScheduleItem("We Have the Method", "Admin 101", "10:45 AM", "11:45 AM", 1, SpeakerList.get(8)));
            ScheduleList.add(new ScheduleItem("Conquering Fear Through Knowledge", "Xavier", "10:45 AM", "11:45 AM", 1, SpeakerList.get(9)));
            ScheduleList.add(new ScheduleItem("Who is the Antichrist?", "Auditorium", "1:30 PM", "2:30 PM", 1, SpeakerList.get(3)));
            ScheduleList.add(new ScheduleItem("Learning to Conquer Sin", "Auditorium", "2:45 PM", "3:45 PM", 1, SpeakerList.get(10)));
            ScheduleList.add(new ScheduleItem("We Have the Motive", "Admin 101", "2:45 PM", "3:45 PM", 1, SpeakerList.get(8)));
            ScheduleList.add(new ScheduleItem("Leadership of the Church", "Xavier", "2:45 PM", "3:45 PM", 1, SpeakerList.get(3)));
            ScheduleList.add(new ScheduleItem("Permanence of Marriage", "Auditorium", "4:00 PM", "5:00 PM", 1, SpeakerList.get(4)));
            ScheduleList.add(new ScheduleItem("Electronic Classrooms", "Admin 101", "4:00 PM", "5:00 PM", 1, SpeakerList.get(0)));
            ScheduleList.add(new ScheduleItem("Casting Out the Fear of Fellowship", "Xavier", "4:00 PM", "5:00 PM", 1, SpeakerList.get(2)));
            ScheduleList.add(new ScheduleItem("Conquering Fear of the Judgement", "Auditorium", "7:00 PM", "8:00 PM", 1, SpeakerList.get(6)));

            ScheduleList.add(new ScheduleItem("Registration and Displays", "Auditorium", "9:00 AM", "9:30 AM", 2, null));
            ScheduleList.add(new ScheduleItem("Loving One Another", "Auditorium", "9:30 AM", "10:30 AM", 2, SpeakerList.get(6)));
            ScheduleList.add(new ScheduleItem("Insights into Ministry", "Admin 101", "9:30 AM", "10:30 AM", 2, SpeakerList.get(1)));
            ScheduleList.add(new ScheduleItem("What is Sin That Leads to Death?", "Xavier", "9:30 AM", "10:30 AM", 2, SpeakerList.get(11)));
            ScheduleList.add(new ScheduleItem("For We Do Not Wrestle", "Auditorium", "10:45 AM", "11:45 AM", 2, SpeakerList.get(13)));
            ScheduleList.add(new ScheduleItem("The Power of Youth", "Admin 101", "10:45 AM", "11:45 AM", 2, SpeakerList.get(1)));
            ScheduleList.add(new ScheduleItem("Conquering Fear Through Love", "Xavier", "10:45 AM", "11:45 AM", 2, SpeakerList.get(9)));
            ScheduleList.add(new ScheduleItem("Do Not Love the World", "Auditorium", "1:30 PM", "2:30 PM", 2, SpeakerList.get(5)));
            ScheduleList.add(new ScheduleItem("The Three Witnesses", "Auditorium", "2:45 PM", "3:45 PM", 2, SpeakerList.get(10)));
            ScheduleList.add(new ScheduleItem("Youth Ministry", "Admin 101", "2:45 PM", "3:45 PM", 2, SpeakerList.get(1)));
            ScheduleList.add(new ScheduleItem("Leadership of the Home", "Xavier", "2:45 PM", "3:45 PM", 2, SpeakerList.get(3)));
            ScheduleList.add(new ScheduleItem("No Fear in Love", "Auditorium", "4:30 PM", "5:30 PM", 2, SpeakerList.get(10)));

            changeFragment(new HomeFragment(), false);
        }

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
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

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
