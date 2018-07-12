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
            SpeakerList.add(new Speaker("Behailu Endeshaw", "Kent, WA", getResources().getString(R.string.description_behailuendeshaw), R.drawable.behailuendeshaw));
            SpeakerList.add(new Speaker("Carrell Dennis", "Renton, WA", getResources().getString(R.string.description_carrelldennis), R.drawable.carrelldennis));
            SpeakerList.add(new Speaker("Jack Keller", "Ferndale, WA", getResources().getString(R.string.description_jackkeller), R.drawable.jackkeller));
            SpeakerList.add(new Speaker("Jody Apple", "Knoxville, TN", getResources().getString(R.string.description_jodyapple), R.drawable.jodyapple));
            SpeakerList.add(new Speaker("Kevin Bethea", "Baltimore, MD", getResources().getString(R.string.description_kevinbethea), R.drawable.kevinbethea));
            SpeakerList.add(new Speaker("Lori Boyd", "Murfreesboro, TN", getResources().getString(R.string.description_loriboyd), R.drawable.loriboyd));
            SpeakerList.add(new Speaker("Mark Jamieson", "Puyallup, WA", getResources().getString(R.string.description_markjamieson), R.drawable.markjamieson));
            SpeakerList.add(new Speaker("Michael Whitworth", "Fort Worth, TX", getResources().getString(R.string.description_michaelwhitworth), R.drawable.michaelwhitworth));
            SpeakerList.add(new Speaker("Rickie Hagan", "Red Boiling Springs, TN", getResources().getString(R.string.description_rickiehagan), R.drawable.rickiehagan));
            SpeakerList.add(new Speaker("Samuel Jones", "Jackson, TN", getResources().getString(R.string.description_samueljones), R.drawable.samueljones));
            SpeakerList.add(new Speaker("Wes Hanson", "Scappoose, OR", getResources().getString(R.string.description_weshanson), R.drawable.weshanson));
            SpeakerList.add(new Speaker("Wissam Al-Aethawi", "Metro Detroit, MI", getResources().getString(R.string.description_wissamalaethawi), R.drawable.wissamalaethawi));

            // Initialize list of classes.
            ScheduleList.add(new ScheduleItem("Registration and Displays", "Music Center", "8:30 AM", "9:00 AM", 0, null));
            ScheduleList.add(new ScheduleItem("It's Not Your Body!", "Music Center", "9:00 AM", "10:00 AM", 0, SpeakerList.get(3)));
            ScheduleList.add(new ScheduleItem("Are They Saved or Lost?", "Music 306A", "9:00 AM", "10:00 AM", 0, SpeakerList.get(6)));
            ScheduleList.add(new ScheduleItem("The Way We Walk", "Ingram 100", "9:00 AM", "10:00 AM", 0, SpeakerList.get(1)));
            ScheduleList.add(new ScheduleItem("Islam Myth Buster", "Music Center", "10:15 AM", "11:15 AM", 0, SpeakerList.get(11)));
            ScheduleList.add(new ScheduleItem("Radical Evangelism Pt. 1", "Music 306A", "10:15 AM", "11:15 AM", 0, SpeakerList.get(4)));
            ScheduleList.add(new ScheduleItem("Better Teachers Pt. 1", "Ingram 100", "10:15 AM", "11:15 AM", 0, SpeakerList.get(7)));
            ScheduleList.add(new ScheduleItem("Becoming a Two Mile Christian", "Music Center", "1:30 PM", "2:30 PM", 0, SpeakerList.get(9)));
            ScheduleList.add(new ScheduleItem("PTSD Pt. 1", "Music Center", "2:45 PM", "3:45 PM", 0, SpeakerList.get(8)));
            ScheduleList.add(new ScheduleItem("Beyond Our Boundaries", "Music 306A", "2:45 PM", "3:45 PM", 0, SpeakerList.get(5)));
            ScheduleList.add(new ScheduleItem("Equipping Families to Manage Life's Storms Pt. 1", "Ingram 100", "2:45 PM", "3:45 PM", 0, SpeakerList.get(9)));
            ScheduleList.add(new ScheduleItem("Uncomfortable Grace", "Music Center", "4:00 PM", "5:00 PM", 0, SpeakerList.get(2)));
            ScheduleList.add(new ScheduleItem("The Mission of the Church", "Music 306A", "4:00 PM", "5:00 PM", 0, SpeakerList.get(0)));
            ScheduleList.add(new ScheduleItem("The Cost of Being a Soldier", "Music Center", "7:00 PM", "8:00 PM", 0, SpeakerList.get(8)));

            ScheduleList.add(new ScheduleItem("Registration and Displays", "Music Center", "8:30 AM", "9:00 AM", 1, null));
            ScheduleList.add(new ScheduleItem("Youth Challenge", "University Center", "9:00 AM", "4:00 PM", 1, SpeakerList.get(10)));
            ScheduleList.add(new ScheduleItem("It's Not Your Money!", "Music Center", "9:00 AM", "10:00 AM", 1, SpeakerList.get(3)));
            ScheduleList.add(new ScheduleItem("Fan or Follower?", "Music 306A", "9:00 AM", "10:00 AM", 1, SpeakerList.get(6)));
            ScheduleList.add(new ScheduleItem("The Want We Have", "Ingram 100", "9:00 AM", "10:00 AM", 1, SpeakerList.get(1)));
            ScheduleList.add(new ScheduleItem("The Temple: The 3rd of the Two Sacred Places", "Music Center", "10:15 AM", "11:15 AM", 1, SpeakerList.get(11)));
            ScheduleList.add(new ScheduleItem("Radical Evangelism Pt. 2", "Music 306A", "10:15 AM", "11:15 AM", 1, SpeakerList.get(4)));
            ScheduleList.add(new ScheduleItem("Better Teachers Pt. 2", "Ingram 100", "10:15 AM", "11:15 AM", 1, SpeakerList.get(7)));
            ScheduleList.add(new ScheduleItem("Creating Contagious Faith", "Music Center", "1:30 PM", "2:30 PM", 1, SpeakerList.get(4)));
            ScheduleList.add(new ScheduleItem("PTSD Pt. 2", "Music Center", "2:45 PM", "3:45 PM", 1, SpeakerList.get(8)));
            ScheduleList.add(new ScheduleItem("Beyond Our Walls", "Music 306A", "2:45 PM", "3:45 PM", 1, SpeakerList.get(5)));
            ScheduleList.add(new ScheduleItem("Equipping Families to Manage Life's Storms Pt. 2", "Ingram 100", "2:45 PM", "3:45 PM", 1, SpeakerList.get(9)));
            ScheduleList.add(new ScheduleItem("Uncomfortable Mercy", "Music Center", "4:00 PM", "5:00 PM", 1, SpeakerList.get(2)));
            ScheduleList.add(new ScheduleItem("Passing the Gospel Torch", "Music 306A", "4:00 PM", "5:00 PM", 1, SpeakerList.get(0)));
            ScheduleList.add(new ScheduleItem("It's Not About You; It's All About God!", "Music Center", "7:00 PM", "8:00 PM", 1, SpeakerList.get(3)));

            ScheduleList.add(new ScheduleItem("Registration and Displays", "Music Center", "8:30 AM", "9:00 AM", 2, null));
            ScheduleList.add(new ScheduleItem("It's Not Your Time!", "Music Center", "9:00 AM", "10:00 AM", 2, SpeakerList.get(3)));
            ScheduleList.add(new ScheduleItem("Draw a Crowd or Make Disciples?", "Music 306A", "9:00 AM", "10:00 AM", 2, SpeakerList.get(6)));
            ScheduleList.add(new ScheduleItem("The Wreck We Face", "Ingram 100", "9:00 AM", "10:00 AM", 2, SpeakerList.get(1)));
            ScheduleList.add(new ScheduleItem("What I Learned (and Didn't Learn) From Muslims", "Music Center", "10:15 AM", "11:15 AM", 2, SpeakerList.get(11)));
            ScheduleList.add(new ScheduleItem("Radical Evangelism Pt. 3", "Music 306A", "10:15 AM", "11:15 AM", 2, SpeakerList.get(4)));
            ScheduleList.add(new ScheduleItem("Better Teachers Pt. 3", "Ingram 100", "10:15 AM", "11:15 AM", 2, SpeakerList.get(7)));
            ScheduleList.add(new ScheduleItem("Dealing With Grief", "Music Center", "1:30 PM", "2:30 PM", 2, SpeakerList.get(7)));
            ScheduleList.add(new ScheduleItem("PTSD Pt. 3", "Music Center", "2:45 PM", "3:45 PM", 2, SpeakerList.get(8)));
            ScheduleList.add(new ScheduleItem("Beyond Our Words", "Music 306A", "2:45 PM", "3:45 PM", 2, SpeakerList.get(5)));
            ScheduleList.add(new ScheduleItem("Equipping Families to Manage Life's Storms Pt. 3", "Ingram 100", "2:45 PM", "3:45 PM", 2, SpeakerList.get(9)));
            ScheduleList.add(new ScheduleItem("As a Light to the Muslims", "Music Center", "5:00 PM", "6:00 PM", 2, SpeakerList.get(11)));

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
