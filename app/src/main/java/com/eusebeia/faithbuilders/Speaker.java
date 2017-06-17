package com.eusebeia.faithbuilders;

import android.media.Image;

/**
 * Created by CJ on 6/9/2016.
 */
public class Speaker {
    private String name, location, description;
    private int photo;

    public Speaker(String name, String location, String description, int photo) {
        this.name = name;
        this.location = location;
        this.description = description;
        this.photo = photo;
    }


    public int getPhoto() {
        return photo;
    }

    public String getDescription() {
        return description;
    }

    public String getLocation() {
        return location;
    }

    public String getName() {

        return name;
    }
}
