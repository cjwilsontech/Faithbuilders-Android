package com.eusebeia.faithbuilders;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    NavigationView navigationView = null;
    Toolbar toolbar = null;
    public static List<Speaker> SpeakerList = new ArrayList<Speaker>();
    public static ArrayList<ScheduleItem> ScheduleList = new ArrayList<ScheduleItem>();
    public CharSequence mTitle = "Faithbuilders";

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
            SpeakerList.add(new Speaker("Anthony Wilson", "Graham, WA", getResources().getString(R.string.description_anthonywilson), R.drawable.anthonywilson));
            SpeakerList.add(new Speaker("Caleb O'Hara", "Ripon, CA", getResources().getString(R.string.description_calebohara), R.drawable.calebohara));
            SpeakerList.add(new Speaker("Charlie McClendon", "Jacksonville, FL", getResources().getString(R.string.description_charliemcclendon), R.drawable.charliemcclendon));
            SpeakerList.add(new Speaker("Jay Lockhart", "Whitehouse, TX", getResources().getString(R.string.description_jaylockhart), R.drawable.jaylockhart));
            SpeakerList.add(new Speaker("Keith Parker", "Hendersonville, TN", getResources().getString(R.string.description_keithparker), R.drawable.keithparker));
            SpeakerList.add(new Speaker("Ken Wilson", "Puyallup, WA", getResources().getString(R.string.description_kenwilson), R.drawable.kenwilson));
            SpeakerList.add(new Speaker("Kerry Williams", "Jonesboro, AR", getResources().getString(R.string.description_kerrywilliams), R.drawable.kerrywilliams));
            SpeakerList.add(new Speaker("Kevin Jensen", "Yakima, WA", getResources().getString(R.string.description_kevinjensen), R.drawable.kevinjensen));
            SpeakerList.add(new Speaker("Mark K. Jamieson, Sr.", "Puyallup, WA", getResources().getString(R.string.description_markjamieson), R.drawable.markjamieson));
            SpeakerList.add(new Speaker("Pamela Stewart", "Denver, CO", getResources().getString(R.string.description_pamelastewart), R.drawable.pamelastewart));
            SpeakerList.add(new Speaker("Rudy Wray", "Portland, OR", getResources().getString(R.string.description_rudywray), R.drawable.rudywray));
            SpeakerList.add(new Speaker("Samuel E. Garner", "Seattle, WA", getResources().getString(R.string.description_samuelgarner), R.drawable.samuelgarner));
            SpeakerList.add(new Speaker("Sam Jones", "Jackson, TN", getResources().getString(R.string.description_samueljones), R.drawable.samueljones));

            // Initialize list of classes.
            ScheduleList.add(new ScheduleItem("Announcements/Singing", "Auditorium", "8:30 AM", "9:00 AM", 0, null));
            ScheduleList.add(new ScheduleItem("An Evangelistic Church Pt. 1", "Auditorium", "9:15 AM", "10:15 AM", 0, SpeakerList.get(4)));
            ScheduleList.add(new ScheduleItem("Women's Most Effective Ministry Pt. 1", "Admin 101", "9:15 AM", "10:15 AM", 0, SpeakerList.get(9)));
            ScheduleList.add(new ScheduleItem("The Church Begins", "Xavier", "9:15 AM", "10:15 AM", 0, SpeakerList.get(3)));
            ScheduleList.add(new ScheduleItem("The Glorious Church Pt. 1", "Auditorium", "10:30 AM", "11:30 AM", 0, SpeakerList.get(8)));
            ScheduleList.add(new ScheduleItem("Reaching Young Families Pt. 1", "Admin 101", "10:30 AM", "11:30 AM", 0, SpeakerList.get(6)));
            ScheduleList.add(new ScheduleItem("Seeking the Lost Pt. 1", "Xavier", "10:30 AM", "11:30 AM", 0, SpeakerList.get(2)));
            ScheduleList.add(new ScheduleItem("Congregational Recharge", "Auditorium", "1:30 PM", "2:30 PM", 0, SpeakerList.get(1)));
            ScheduleList.add(new ScheduleItem("Raising Children Pt. 1", "Auditorium", "2:45 PM", "3:45 PM", 0, SpeakerList.get(12)));
            ScheduleList.add(new ScheduleItem("Hispanic Missions", "Admin 101", "2:45 PM", "3:45 PM", 0, SpeakerList.get(10)));
            ScheduleList.add(new ScheduleItem("A Character Focused Ministry Pt. 1", "Xavier", "2:45 PM", "3:45 PM", 0, SpeakerList.get(11)));
            ScheduleList.add(new ScheduleItem("Reaching Millenials Pt. 1", "Auditorium", "4:00 PM", "5:00 PM", 0, SpeakerList.get(1)));
            ScheduleList.add(new ScheduleItem("Money and Faith Pt. 1", "Admin 101", "4:00 PM", "5:00 PM", 0, SpeakerList.get(7)));
            ScheduleList.add(new ScheduleItem("Principles of Unity Pt. 1", "Xavier", "4:00 PM", "5:00 PM", 0, SpeakerList.get(0)));
            ScheduleList.add(new ScheduleItem("Congregational Singing", "Auditorium", "6:30 PM", "7:00 PM", 0, null));
            ScheduleList.add(new ScheduleItem("Counter-Cultural Christianity", "Auditorium", "7:00 PM", "8:00 PM", 0, SpeakerList.get(6)));

            ScheduleList.add(new ScheduleItem("Announcements/Singing", "Auditorium", "8:30 AM", "9:00 AM", 1, null));
            ScheduleList.add(new ScheduleItem("An Evangelistic Church Pt. 2", "Auditorium", "9:15 AM", "10:15 AM", 1, SpeakerList.get(4)));
            ScheduleList.add(new ScheduleItem("Women's Most Effective Ministry Pt. 2", "Admin 101", "9:15 AM", "10:15 AM", 1, SpeakerList.get(9)));
            ScheduleList.add(new ScheduleItem("Opposition to the Church", "Xavier", "9:15 AM", "10:15 AM", 1, SpeakerList.get(3)));
            ScheduleList.add(new ScheduleItem("The Glorious Church Pt. 2", "Auditorium", "10:30 AM", "11:30 AM", 1, SpeakerList.get(8)));
            ScheduleList.add(new ScheduleItem("Reaching Young Families Pt. 2", "Admin 101", "10:30 AM", "11:30 AM", 1, SpeakerList.get(6)));
            ScheduleList.add(new ScheduleItem("Seeking the Lost Pt. 2", "Xavier", "10:30 AM", "11:30 AM", 1, SpeakerList.get(2)));
            ScheduleList.add(new ScheduleItem("Future of the Church", "Auditorium", "1:30 PM", "2:30 PM", 1, SpeakerList.get(3)));
            ScheduleList.add(new ScheduleItem("Raising Children Pt. 2", "Auditorium", "2:45 PM", "3:45 PM", 1, SpeakerList.get(12)));
            ScheduleList.add(new ScheduleItem("Missions: Cuba Pt. 1", "Admin 101", "2:45 PM", "3:45 PM", 1, SpeakerList.get(10)));
            ScheduleList.add(new ScheduleItem("A Character Focused Ministry Pt. 2", "Xavier", "2:45 PM", "3:45 PM", 1, SpeakerList.get(11)));
            ScheduleList.add(new ScheduleItem("Reaching Millenials Pt. 2", "Auditorium", "4:00 PM", "5:00 PM", 1, SpeakerList.get(1)));
            ScheduleList.add(new ScheduleItem("Money and Faith Pt. 2", "Admin 101", "4:00 PM", "5:00 PM", 1, SpeakerList.get(7)));
            ScheduleList.add(new ScheduleItem("Principles of Unity Pt. 2", "Xavier", "4:00 PM", "5:00 PM", 1, SpeakerList.get(0)));
            ScheduleList.add(new ScheduleItem("Congregational Singing", "Auditorium", "6:30 PM", "7:00 PM", 1, null));
            ScheduleList.add(new ScheduleItem("The Power of Truth Seekers", "Auditorium", "7:00 PM", "8:00 PM", 1, SpeakerList.get(4)));

            ScheduleList.add(new ScheduleItem("Announcements/Singing", "Auditorium", "8:30 AM", "9:00 AM", 2, null));
            ScheduleList.add(new ScheduleItem("An Evangelistic Church Pt. 3", "Auditorium", "9:15 AM", "10:15 AM", 2, SpeakerList.get(4)));
            ScheduleList.add(new ScheduleItem("Women's Most Effective Ministry Pt. 3", "Admin 101", "9:15 AM", "10:15 AM", 2, SpeakerList.get(9)));
            ScheduleList.add(new ScheduleItem("Internal Threat to the Church", "Xavier", "9:15 AM", "10:15 AM", 2, SpeakerList.get(3)));
            ScheduleList.add(new ScheduleItem("The Glorious Church Pt. 3", "Auditorium", "10:30 AM", "11:30 AM", 2, SpeakerList.get(8)));
            ScheduleList.add(new ScheduleItem("Reaching Young Families Pt. 3", "Admin 101", "10:30 AM", "11:30 AM", 2, SpeakerList.get(6)));
            ScheduleList.add(new ScheduleItem("Seeking the Lost Pt. 3", "Xavier", "10:30 AM", "11:30 AM", 2, SpeakerList.get(2)));
            ScheduleList.add(new ScheduleItem("Visionary Leadership", "Auditorium", "1:30 PM", "2:30 PM", 2, SpeakerList.get(12)));
            ScheduleList.add(new ScheduleItem("Raising Children Pt. 3", "Auditorium", "2:45 PM", "3:45 PM", 2, SpeakerList.get(12)));
            ScheduleList.add(new ScheduleItem("Missions: Cuba Pt. 2", "Admin 101", "2:45 PM", "3:45 PM", 2, SpeakerList.get(10)));
            ScheduleList.add(new ScheduleItem("A Character Focused Ministry Pt. 3", "Xavier", "2:45 PM", "3:45 PM", 2, SpeakerList.get(11)));
            ScheduleList.add(new ScheduleItem("Congregational Singing", "Auditorium", "4:30 PM", "5:00 PM", 2, null));
            ScheduleList.add(new ScheduleItem("The Unknown God", "Auditorium", "5:00 PM", "6:00 PM", 2, SpeakerList.get(2)));

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
        //} else if (id == R.id.nav_maps) {
        //    changeFragment(new MapsFragment());
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
