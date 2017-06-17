package com.eusebeia.faithbuilders;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.SectionIndexer;
import android.widget.TextView;

import java.util.ArrayList;

import se.emilsjolander.stickylistheaders.StickyListHeadersAdapter;

/**
 * Created by CJ on 7/5/2016.
 */
public class ScheduleListAdapter extends BaseAdapter implements StickyListHeadersAdapter, SectionIndexer {
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
        ViewHolder nameHolder, locationHolder, speakerHolder;

        //if (convertView == null) {
            convertView = mInflater.inflate(R.layout.schedule_list_item, parent, false);

            nameHolder = new ViewHolder();
            nameHolder.text = (TextView) convertView.findViewById(R.id.schedule_list_name);
            convertView.setTag(nameHolder);

            locationHolder = new ViewHolder();
            locationHolder.text = (TextView) convertView.findViewById(R.id.schedule_list_location);
            convertView.setTag(locationHolder);

            speakerHolder = new ViewHolder();
            speakerHolder.text = (TextView) convertView.findViewById(R.id.schedule_list_speaker);
            convertView.setTag(speakerHolder);
        //} else {
            //nameHolder = (ViewHolder) convertView.getTag();
            //locationHolder = (ViewHolder) convertView.getTag();
            //speakerHolder = (ViewHolder) convertView.getTag();
        //}

        nameHolder.text.setText(mScheduleItems.get(position).getName());
        locationHolder.text.setText(mScheduleItems.get(position).getLocation());
        if (mScheduleItems.get(position).getSpeaker() != null)
            speakerHolder.text.setText(mScheduleItems.get(position).getSpeaker().getName());
        else
            speakerHolder.text.setText(R.string.speaker_unavailable);
// AIzaSyBrIBk3YJy-LYzz5YDjgWTPxG8QWGSrjkM
        return convertView;
    }

    @Override
    public View getHeaderView(int position, View convertView, ViewGroup parent) {
        HeaderViewHolder holder;

        if (convertView == null) {
            holder = new HeaderViewHolder();
            convertView = mInflater.inflate(R.layout.header, parent, false);
            holder.text = (TextView) convertView.findViewById(R.id.header_text);
            convertView.setTag(holder);
        } else {
            holder = (HeaderViewHolder) convertView.getTag();
        }

        // set header text as first char in name
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
