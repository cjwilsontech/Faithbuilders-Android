package com.eusebeia.faithbuilders;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link BiographyFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class BiographyFragment extends DialogFragment {

    private Speaker currentSpeaker;

    public BiographyFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(STYLE_NO_FRAME, android.R.style.Theme_Holo_Light);

        Bundle bundle = this.getArguments();
        int speakerIndex = bundle.getInt("SpeakerIndex", 0);
        currentSpeaker = MainActivity.SpeakerList.get(speakerIndex);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_biography, container, false);
        Toolbar toolbar = (Toolbar) v.findViewById(R.id.bio_toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Close the fragment.
                getActivity().getSupportFragmentManager().beginTransaction().remove(BiographyFragment.this).commit();
            }
        });


        // Photo
        ImageView imageView = (ImageView) v.findViewById(R.id.bio_photo);
        imageView.setImageResource(currentSpeaker.getPhoto());

        // Name
        TextView textView = (TextView) v.findViewById(R.id.bio_name);
        textView.setText(currentSpeaker.getName());

        // Location
        textView = (TextView) v.findViewById(R.id.bio_location);
        textView.setText(currentSpeaker.getLocation());

        // Description
        textView = (TextView) v.findViewById(R.id.bio_description);
        textView.setText(currentSpeaker.getDescription());

        // Inflate the layout for this fragment
        return v;
    }
}
