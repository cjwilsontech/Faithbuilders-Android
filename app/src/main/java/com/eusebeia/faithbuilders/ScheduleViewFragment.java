package com.eusebeia.faithbuilders;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import se.emilsjolander.stickylistheaders.StickyListHeadersListView;

public class ScheduleViewFragment extends Fragment implements AdapterView.OnItemClickListener, StickyListHeadersListView.OnHeaderClickListener, StickyListHeadersListView.OnStickyHeaderOffsetChangedListener, StickyListHeadersListView.OnStickyHeaderChangedListener {
    private StickyListHeadersListView stickyList;
    private ScheduleListAdapter mAdapter;
    private int day;

    public ScheduleViewFragment() {}

    public static ScheduleViewFragment newInstance(int day) {

        Bundle args = new Bundle();
        args.putInt("day", day);

        ScheduleViewFragment fragment = new ScheduleViewFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void setArguments(Bundle args) {
        day = args.getInt("day");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.schedule_list, container, false);

        // Find list objects.
        stickyList = (StickyListHeadersListView) v.findViewById(R.id.schedule_list);

        // Set listeners.
        stickyList.setOnItemClickListener(this);
        stickyList.setOnHeaderClickListener(this);
        stickyList.setOnStickyHeaderChangedListener(this);
        stickyList.setOnStickyHeaderOffsetChangedListener(this);

        mAdapter = new ScheduleListAdapter(getContext(), MainActivity.ScheduleList, day);

        // Configure list options.
        stickyList.setDrawingListUnderStickyHeader(false);
        stickyList.setAreHeadersSticky(true);
        stickyList.setAdapter(mAdapter);

        return v;
    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        int indexBase;
        for (indexBase = 0; indexBase < MainActivity.ScheduleList.size() && MainActivity.ScheduleList.get(indexBase).getDay() != day; indexBase++);

        DialogFragment newFragment = new ScheduleDetailFragment();
        newFragment.show(getChildFragmentManager(), "scheduledetail");
        Bundle bundle = new Bundle();
        bundle.putInt("ClassIndex", indexBase + position);
        newFragment.setArguments(bundle);
    }


    @Override
    public void onResume() {
        super.onResume();
        getActivity().setTitle(R.string.label_schedule);
    }


    @Override
    public void onHeaderClick(StickyListHeadersListView l, View header, int itemPosition, long headerId, boolean currentlySticky) {
    }

    @Override
    public void onStickyHeaderChanged(StickyListHeadersListView l, View header, int itemPosition, long headerId) {
    }

    @Override
    public void onStickyHeaderOffsetChanged(StickyListHeadersListView l, View header, int offset) {
    }
}
