package com.eusebeia.faithbuilders;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.widget.Toolbar;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by CJ on 7/6/2016.
 */
public class ScheduleDetailFragment extends DialogFragment {
    private ScheduleItem scheduleItem;
    private static View view;

    public ScheduleDetailFragment() {}

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

        } catch (InflateException e) {
            // Map is already there, just return the view as it is.
        }

        return view;
    }
}