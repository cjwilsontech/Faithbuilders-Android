package com.eusebeia.faithbuilders;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.DialogFragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.Toolbar;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * Created by CJ on 7/6/2016.
 */
public class ScheduleDetailFragment extends DialogFragment implements OnMapReadyCallback, GoogleMap.OnMapLoadedCallback, LocationListener {
    private ScheduleItem scheduleItem;
    private SupportMapFragment mapFragment;
    private GoogleMap map;
    private LocationManager locationManager;
    private LatLng destinationLatLng;
    private LatLng currentLatLng;
    private boolean mapIsLoaded;
    private boolean locationRequested;
    private static View view;

    public ScheduleDetailFragment() {
        mapIsLoaded = false;
        locationRequested = false;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(STYLE_NO_FRAME, android.R.style.Theme_Holo_Light);

        Bundle bundle = this.getArguments();
        int index = bundle.getInt("ClassIndex", 0);
        scheduleItem = MainActivity.ScheduleList.get(index);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the view.
        if (view != null) {
            ViewGroup parent = (ViewGroup) view.getParent();
            if (parent != null)
                parent.removeView(view);
        }
        try {
            view = inflater.inflate(R.layout.fragment_schedule_detail, container, false);
            // Configure the toolbar.
            Toolbar toolbar = (Toolbar) view.findViewById(R.id.schedule_detail_toolbar);
            toolbar.setNavigationIcon(R.drawable.ic_arrow_back);
            toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Back button - close the fragment.
                    getActivity().getSupportFragmentManager().beginTransaction().remove(ScheduleDetailFragment.this).commit();
                }
            });

            // Set the view's data.
            TextView speakerTextView = (TextView) view.findViewById(R.id.schedule_detail_speaker_name);
            ImageView imageView = (ImageView) view.findViewById(R.id.schedule_detail_speaker_image);
            if (scheduleItem.getSpeaker() != null) {
                // Photo
                imageView.setImageResource(scheduleItem.getSpeaker().getPhoto());

                // Speaker Name
                speakerTextView.setText(scheduleItem.getSpeaker().getName());
            } else {
                speakerTextView.setText(R.string.speaker_unavailable);
                imageView.setImageResource(R.drawable.profile);
            }

            // Item Name
            TextView textView = (TextView) view.findViewById(R.id.schedule_detail_name);
            textView.setText(scheduleItem.getName());

            // Location
            textView = (TextView) view.findViewById(R.id.schedule_detail_location);
            textView.setText(scheduleItem.getLocation());

            // Date
            textView = (TextView) view.findViewById(R.id.schedule_detail_date);
            String date;
            switch (scheduleItem.getDay()) {
                case 0:
                    date = getString(R.string.label_day1_full);
                    break;
                case 1:
                    date = getString(R.string.label_day2_full);
                    break;
                default:
                    date = getString(R.string.label_day3_full);
                    break;
            }
            textView.setText(date);

            // Time
            textView = (TextView) view.findViewById(R.id.schedule_detail_time);
            String time = scheduleItem.getTimeStart() + " - " + scheduleItem.getTimeEnd();
            textView.setText(time);

            // Set the toolbar title.
            //toolbar.setTitle(currentSpeaker.getName());

            mapFragment = (SupportMapFragment) getActivity().getSupportFragmentManager().findFragmentById(R.id.schedule_detail_map);
            mapFragment.getMapAsync(this);

        } catch (InflateException e) {
            // Map is already there, just return the view as it is.
        }

        return view;
    }

    public void onDestroyView() {
        if (mapFragment != null && mapFragment.isResumed()) {
            getFragmentManager().beginTransaction().remove(mapFragment).commit();
        }
        if (locationManager != null && ContextCompat.checkSelfPermission(getContext(), android.Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            locationManager.removeUpdates(this);
        }
        super.onDestroyView();
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        map = googleMap;

        // Find which building we need to show coordinates for.
        switch (scheduleItem.getLocation()) {
            case "Auditorium":
                destinationLatLng = new LatLng(47.14609, -122.441857);
                break;
            case "Xavier":
                destinationLatLng = new LatLng(47.146528, -122.441342);
                break;
            default: /* Admin */
                destinationLatLng = new LatLng(47.147106, -122.441691);
                break;
        }

        // Configure the map.
        map.addMarker(new MarkerOptions().position(destinationLatLng).title(scheduleItem.getLocation()));
        map.moveCamera(CameraUpdateFactory.newLatLng(destinationLatLng));
        map.setBuildingsEnabled(true);
        map.setMapType(GoogleMap.MAP_TYPE_HYBRID);

        map.setOnMapLoadedCallback(this);

        // Check for location permission before attempting to access it.
        onLocationGranted();

        // Show the campus view.
        map.moveCamera(CameraUpdateFactory.newLatLng(destinationLatLng));
        map.animateCamera(CameraUpdateFactory.zoomTo(16));
    }

    private boolean requestLocation() {
        if (ContextCompat.checkSelfPermission(getContext(), android.Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            onLocationGranted();
            return true;
        } else if (!locationRequested) {
            // Request location, but only do so once per screen.
            ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);
            locationRequested = true;
        }
        return false;
    }

    private void onLocationGranted() {
        if (map != null) {
            try {
                map.setMyLocationEnabled(true);

                // Configure location.
                if (locationManager == null) {
                    locationManager = (LocationManager) getActivity().getSystemService(getActivity().LOCATION_SERVICE);
                }

                Criteria criteria = new Criteria();
                String bestProvider = locationManager.getBestProvider(criteria, true);
                Location location = locationManager.getLastKnownLocation(bestProvider);
                if (location != null) {
                    onLocationChanged(location);
                }
                locationManager.requestLocationUpdates(bestProvider, 20000, 0, this);
            } catch (SecurityException e) {

            }
        }
    }

    private void setMapViewToBounds(LatLng first, LatLng second) {
        // Move the camera to fit both the destination and the current location.
        LatLngBounds bounds = new LatLngBounds.Builder().include(first).include(second).build();
        map.moveCamera(CameraUpdateFactory.newLatLngBounds(bounds, 50));

        if (map.getCameraPosition().zoom > 17) {
            map.animateCamera(CameraUpdateFactory.zoomTo(17));
        }
    }

    @Override
    public void onLocationChanged(Location location) {
        boolean isNull = currentLatLng == null;
        currentLatLng = new LatLng(location.getLatitude(), location.getLongitude());

        // If we just got our first location and the map is ready, set the bounded view.
        if (mapIsLoaded) {
            setMapViewToBounds(currentLatLng, destinationLatLng);
        }
    }

    @Override
    public void onMapLoaded() {
        mapIsLoaded = true;

        if (currentLatLng != null) {
            setMapViewToBounds(currentLatLng, destinationLatLng);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case 1: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // Permission was granted.
                    onLocationGranted();
                }
                return;
            }
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        if (locationManager != null && ContextCompat.checkSelfPermission(getContext(), android.Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            locationManager.removeUpdates(this);
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        requestLocation();
    }

    @Override
    public void onStatusChanged(String s, int i, Bundle bundle) {
    }

    @Override
    public void onProviderEnabled(String s) {
    }

    @Override
    public void onProviderDisabled(String s) {
    }

}