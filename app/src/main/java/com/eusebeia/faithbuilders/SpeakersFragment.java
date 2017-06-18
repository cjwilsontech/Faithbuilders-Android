package com.eusebeia.faithbuilders;


import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 */
public class SpeakersFragment extends Fragment {

    public SpeakersFragment() {
        // Required empty public constructor
    }

    @Override
    public void onResume() {
        super.onResume();
        // Set title
        getActivity().setTitle(R.string.label_speakers);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_speakers, container, false);
        populateListView(v);
        registerClickCallback(v);

        // Inflate the layout for this fragment
        return v;
    }

    private void populateListView(View v) {
        ArrayAdapter<Speaker> adapter = new MyListAdapter();
        ListView list = (ListView) v.findViewById(R.id.ListViewSpeakers);
        list.setAdapter(adapter);
    }

    private void registerClickCallback(final View v) {
        ListView list = (ListView) v.findViewById(R.id.ListViewSpeakers);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View viewClicked, int position, long id) {

                DialogFragment newFragment = new BiographyFragment();
                newFragment.show(getFragmentManager(), "biography");
                Bundle bundle = new Bundle();
                bundle.putInt("SpeakerIndex", position);
                newFragment.setArguments(bundle);
            }
        });
    }

    private class MyListAdapter extends ArrayAdapter<Speaker> {
        public MyListAdapter() {
            super(getActivity(), R.layout.speaker_list_item, MainActivity.SpeakerList);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View itemView = convertView;
            if (itemView == null)
                itemView = getActivity().getLayoutInflater().inflate(R.layout.speaker_list_item, null);

            // Find the speaker to work with.
            Speaker currentSpeaker = MainActivity.SpeakerList.get(position);

            // Fill the view.
            // Photo
            ImageView imageView = (ImageView) itemView.findViewById(R.id.itemIcon);
            imageView.setImageResource(currentSpeaker.getPhoto());

            // Name
            TextView textView = (TextView) itemView.findViewById(R.id.itemName);
            textView.setText(currentSpeaker.getName());

            // Location
            textView = (TextView) itemView.findViewById(R.id.itemLocation);
            textView.setText(currentSpeaker.getLocation());

            return itemView;
        }
    }
}
