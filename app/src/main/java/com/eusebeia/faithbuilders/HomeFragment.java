package com.eusebeia.faithbuilders;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {


    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onResume() {
        super.onResume();
        // Set title
        getActivity().setTitle(R.string.app_name);


        //navigationView.getMenu().getItem(0).setChecked(true);

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_home, container, false);

        LinearLayout navGroup = (LinearLayout) v.findViewById(R.id.locationGroup);
        LinearLayout webGroup = (LinearLayout) v.findViewById(R.id.websiteGroup);
        LinearLayout facebookGroup = (LinearLayout) v.findViewById(R.id.facebookGroup);

        navGroup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent navigation = new Intent(Intent.ACTION_VIEW, Uri.parse("http://maps.google.com/maps?daddr=Pacific+Lutheran+University"));
                startActivity(navigation);
            }
        });

        webGroup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.faithbuildersnw.com/"));
                startActivity(browserIntent);
            }
        });

        facebookGroup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/FaithBuilders2018/"));
                startActivity(browserIntent);
            }
        });

        // Inflate the layout for this fragment
        return v;
    }

}
