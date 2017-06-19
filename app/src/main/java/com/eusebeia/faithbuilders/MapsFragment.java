package com.eusebeia.faithbuilders;

import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageView;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;


/**
 * A simple {@link Fragment} subclass.
 */
public class MapsFragment extends Fragment {


    public MapsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onResume() {
        super.onResume();
        getActivity().setTitle(R.string.label_maps);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_maps, container, false);

        // Show the map image in a WebView to avoid OutOfMemory issues.
        WebView webView = (WebView) v.findViewById(R.id.campusmap);
        String html = "<html><body style='margin: 0px; background-color: black'><img src='campusmap.png'/></body></html>";
        webView.loadDataWithBaseURL("file:///android_res/drawable/campusmap.png", html, "text/html", "UTF-8", null);
        webView.getSettings().setBuiltInZoomControls(true);
        webView.setInitialScale(-1);

        // Inflate the layout for this fragment
        return v;
    }

}