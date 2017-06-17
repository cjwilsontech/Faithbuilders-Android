package com.eusebeia.faithbuilders;

/**
 * Created by CJ on 7/6/2016.
 */
public class ScheduleItem {
    private String timeStart, timeEnd, name, location;
    private int day;
    private Speaker speaker;

    public ScheduleItem(String name, String location, String timeStart, String timeEnd, int day, Speaker speaker) {
        this.name = name;
        this.location = location;
        this.timeStart = timeStart;
        this.timeEnd = timeEnd;
        this.day = day;
        this.speaker = speaker;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public String getTimeStart() {
        return timeStart;
    }

    public String getTimeEnd() {
        return timeEnd;
    }

    public int getDay() {
        return day;
    }

    public Speaker getSpeaker() {
        return speaker;
    }

}
