package com.eusebeia.faithbuilders;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.SectionIndexer;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

import se.emilsjolander.stickylistheaders.StickyListHeadersAdapter;

/**
 * Created by CJ on 7/5/2016.
 */
class ScheduleListAdapter extends BaseAdapter implements StickyListHeadersAdapter, SectionIndexer {
    private final Context mContext;
    private ArrayList<ScheduleItem> mScheduleItems;
    private ArrayList<Integer> mSectionIndices;
    private ArrayList<String> mSectionHeaders;
    private LayoutInflater mInflater;
    private int day;

    public ScheduleListAdapter(Context context, ArrayList<ScheduleItem> schedule, int day) {
        mContext = context;
        mInflater = LayoutInflater.from(context);
        this.day = day;

        mScheduleItems = new ArrayList<ScheduleItem>();
        for (int i = 0; i < schedule.size(); i++) {
            if (day == schedule.get(i).getDay()) {
                mScheduleItems.add(schedule.get(i));
            }
        }

        mSectionIndices = getSectionIndices();
        mSectionHeaders = getSectionHeaders();
    }

    private ArrayList<Integer> getSectionIndices() {
        ArrayList<Integer> sectionIndices = new ArrayList<Integer>();
        String lastFirstChar = mScheduleItems.get(0).getTimeStart();
        sectionIndices.add(0);
        for (int i = 1; i < mScheduleItems.size(); i++) {
            if (!mScheduleItems.get(i).getTimeStart().equals(lastFirstChar)) {
                lastFirstChar = mScheduleItems.get(i).getTimeStart();
                sectionIndices.add(i);
            }
        }

        return sectionIndices;
    }

    private ArrayList<String> getSectionHeaders() {
        ArrayList<String> sectionHeaders = new ArrayList<String>();
        for (int i = 0; i < mSectionIndices.size(); i++) {
            sectionHeaders.add(i, mScheduleItems.get(mSectionIndices.get(i)).getTimeStart());
        }
        return sectionHeaders;
    }

    @Override
    public int getCount() {
        return mScheduleItems.size();
    }

    @Override
    public Object getItem(int position) {
        return mScheduleItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.schedule_list_item, parent, false);
        }

        // Create the schedule items.
        ScheduleItem scheduleItem = mScheduleItems.get(position);

        TextView name = (TextView) convertView.findViewById(R.id.schedule_list_name);
        TextView location = (TextView) convertView.findViewById(R.id.schedule_list_location);
        TextView speaker = (TextView) convertView.findViewById(R.id.schedule_list_speaker);
        TextView startTime = (TextView) convertView.findViewById(R.id.schedule_list_startTime);
        TextView endTime = (TextView) convertView.findViewById(R.id.schedule_list_endTime);

        name.setText(scheduleItem.getName());
        location.setText(scheduleItem.getLocation());
        startTime.setText(scheduleItem.getTimeStart());
        endTime.setText(scheduleItem.getTimeEnd());

        if (scheduleItem.getSpeaker() != null) {
            speaker.setText(scheduleItem.getSpeaker().getName());
        } else {
            speaker.setText(R.string.speaker_unavailable);
        }

        return convertView;
    }

    @Override
    public View getHeaderView(int position, View convertView, ViewGroup parent) {
        HeaderViewHolder holder;

        if (convertView == null) {
            holder = new HeaderViewHolder();
            convertView = mInflater.inflate(R.layout.schedule_list_section_header, parent, false);
            holder.text = (TextView) convertView.findViewById(R.id.header_text);
            convertView.setTag(holder);
        } else {
            holder = (HeaderViewHolder) convertView.getTag();
        }

        // set schedule_list_section_header text as first char in name
        CharSequence headerChar = mScheduleItems.get(position).getTimeStart();
        holder.text.setText(headerChar);

        return convertView;
    }

    /**
     * Remember that these have to be static, postion=1 should always return
     * the same Id that is.
     */
    @Override
    public long getHeaderId(int position) {
        // return the first character of the country as ID because this is what
        // headers are based upon
        int i;
        for (i = 0; i < mSectionHeaders.size() && !mSectionHeaders.get(i).equals(mScheduleItems.get(position).getTimeStart()); i++);
        return i;
    }

    public int getPositionForSection(int section) {
        if (mSectionIndices.size() == 0) {
            return 0;
        }

        if (section >= mSectionIndices.size()) {
            section = mSectionIndices.size() - 1;
        } else if (section < 0) {
            section = 0;
        }
        return mSectionIndices.get(section);
    }

    public int getSectionForPosition(int position) {
        for (int i = 0; i < mSectionIndices.size(); i++) {
            if (position < mSectionIndices.get(i)) {
                return i - 1;
            }
        }
        return mSectionIndices.size() - 1;
    }

    public Object[] getSections() {
        return mSectionHeaders.toArray();
    }

    class HeaderViewHolder {
        TextView text;
    }

    class ViewHolder {
        TextView text;
    }
}
