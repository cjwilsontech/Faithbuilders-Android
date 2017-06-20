package com.eusebeia.faithbuilders;



import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 *
 */
public class ScheduleFragment extends Fragment {

    public ScheduleFragment() {
        // Required empty public constructor
    }

    @Override
    public void onResume() {
        super.onResume();
        getActivity().setTitle(R.string.label_schedule);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        super.onCreateView(inflater, container, savedInstanceState);
        View v = inflater.inflate(R.layout.fragment_schedule, container, false);

        final ViewPager viewPager = (ViewPager) v.findViewById(R.id.schedule_pager);
        viewPager.setAdapter(new SchedulePagerAdapter(getChildFragmentManager()));

        // Give the TabLayout the ViewPager
        final TabLayout tabLayout = (TabLayout) v.findViewById(R.id.sliding_tabs);
        tabLayout.setupWithViewPager(viewPager);

        return v;
    }


    private class SchedulePagerAdapter extends FragmentPagerAdapter {
        private final int PAGE_COUNT = 3;
        private final String tabTitles[] = new String[] { getString(R.string.label_day1), getString(R.string.label_day2), getString(R.string.label_day3) };

        public SchedulePagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int pos) {
            return ScheduleViewFragment.newInstance(pos);
        }

        @Override
        public int getCount() {
            return PAGE_COUNT;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            // Generate title based on item position
            return tabTitles[position];
        }
    }
}

