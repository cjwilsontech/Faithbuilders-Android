package com.eusebeia.faithbuilders;



import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TabHost;
import android.widget.AdapterView;
import android.widget.TextView;

import se.emilsjolander.stickylistheaders.StickyListHeadersListView;


/**
 * A simple {@link Fragment} subclass.
 *
 */
public class ScheduleFragment extends Fragment implements AdapterView.OnItemClickListener, StickyListHeadersListView.OnHeaderClickListener, StickyListHeadersListView.OnStickyHeaderOffsetChangedListener, StickyListHeadersListView.OnStickyHeaderChangedListener {

    private StickyListHeadersListView stickyList1, stickyList2, stickyList3;
    private ScheduleListAdapter mAdapter1, mAdapter2, mAdapter3;
    private TabHost mTabHost;

    public ScheduleFragment() {
        // Required empty public constructor
    }

    @Override
    public void onResume() {
        super.onResume();
        // Set title
        getActivity().setTitle(R.string.label_schedule);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        super.onCreateView(inflater, container, savedInstanceState);
        View v = inflater.inflate(R.layout.fragment_schedule, container, false);

        // Configure tabs.
        mTabHost = (TabHost) v.findViewById(R.id.testtabhost1);
        mTabHost.setup();

        mTabHost.addTab(mTabHost.newTabSpec("tab_test1").setIndicator("Thu. June 7").setContent(R.id.view_tab1));
        mTabHost.addTab(mTabHost.newTabSpec("tab_test2").setIndicator("Fri. June 8").setContent(R.id.view_tab2));
        mTabHost.addTab(mTabHost.newTabSpec("tab_test3").setIndicator("Sat. June 9").setContent(R.id.view_tab3));
        mTabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String s) {
                stickyList1.setSelectionFromTop(0,0);
                stickyList2.setSelectionFromTop(0,0);
                stickyList3.setSelectionFromTop(0,0);
            }
        });

        // Set the color of the tab text.
        for(int i=0;i<mTabHost.getTabWidget().getChildCount();i++)
        {
            TextView tv = (TextView) mTabHost.getTabWidget().getChildAt(i).findViewById(android.R.id.title);
            tv.setTextColor(ContextCompat.getColor(getContext(), android.R.color.primary_text_light));
        }

        mTabHost.setCurrentTab(0);

        // Find list objects.
        stickyList1 = (StickyListHeadersListView) v.findViewById(R.id.schedule_list1);
        stickyList2 = (StickyListHeadersListView) v.findViewById(R.id.schedule_list2);
        stickyList3 = (StickyListHeadersListView) v.findViewById(R.id.schedule_list3);

        // Set listeners.
        stickyList1.setOnItemClickListener(this);
        stickyList2.setOnItemClickListener(this);
        stickyList3.setOnItemClickListener(this);
        stickyList1.setOnHeaderClickListener(this);
        stickyList2.setOnHeaderClickListener(this);
        stickyList3.setOnHeaderClickListener(this);
        stickyList1.setOnStickyHeaderChangedListener(this);
        stickyList2.setOnStickyHeaderChangedListener(this);
        stickyList3.setOnStickyHeaderChangedListener(this);
        stickyList1.setOnStickyHeaderOffsetChangedListener(this);
        stickyList2.setOnStickyHeaderOffsetChangedListener(this);
        stickyList3.setOnStickyHeaderOffsetChangedListener(this);

        // Create list adapters.
        mAdapter1 = new ScheduleListAdapter(getContext(), MainActivity.ScheduleList, 0);
        mAdapter2 = new ScheduleListAdapter(getContext(), MainActivity.ScheduleList, 1);
        mAdapter3 = new ScheduleListAdapter(getContext(), MainActivity.ScheduleList, 2);

        // Configure list options.
        stickyList1.setDrawingListUnderStickyHeader(false);
        stickyList1.setAreHeadersSticky(true);
        stickyList1.setAdapter(mAdapter1);
        stickyList1.setFastScrollEnabled(true);
        stickyList2.setDrawingListUnderStickyHeader(false);
        stickyList2.setAreHeadersSticky(true);
        stickyList2.setAdapter(mAdapter2);
        stickyList3.setDrawingListUnderStickyHeader(false);
        stickyList3.setAreHeadersSticky(true);
        stickyList3.setAdapter(mAdapter3);

        return v;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        int indexBase, day = mTabHost.getCurrentTab();
        for (indexBase = 0; indexBase < MainActivity.ScheduleList.size() && MainActivity.ScheduleList.get(indexBase).getDay() != day; indexBase++);

        DialogFragment newFragment = new ScheduleDetailFragment();
        newFragment.show(getFragmentManager(), "scheduledetail");
        Bundle bundle = new Bundle();
        bundle.putInt("ClassIndex", indexBase + position);
        newFragment.setArguments(bundle);
    }

    @Override
    public void onHeaderClick(StickyListHeadersListView l, View header, int itemPosition, long headerId, boolean currentlySticky) {}

    @Override
    public void onStickyHeaderChanged(StickyListHeadersListView l, View header, int itemPosition, long headerId) {}

    @Override
    public void onStickyHeaderOffsetChanged(StickyListHeadersListView l, View header, int offset) {}
}
