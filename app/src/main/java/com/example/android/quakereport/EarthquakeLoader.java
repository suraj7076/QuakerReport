package com.example.android.quakereport;

import android.content.Context;

import android.content.AsyncTaskLoader;

import java.util.List;

/**
 * Loads a list of earthquakes by using an AsyncTask to perform the network
 * request to the given URL.
 */

public class EarthquakeLoader extends AsyncTaskLoader<List<Earthquake>> {
    private String mUrl;

    /**
     * Constructors a new {@link EarthquakeLoader}.
     * @param context of the activity
     * @param url to load data from
     */
    public EarthquakeLoader(Context context, String url) {
        super(context);
        mUrl = url;
    }
    @Override
    protected void onStartLoading(){
        forceLoad();
    }

    /**
     * This is on a background thread.
     */
    @Override
    public List<Earthquake> loadInBackground() {
    if (mUrl==null)
        return null;
    // Perform the network request, parse the response, and extract a list
    List<Earthquake> earthquakes = QueryUtils.fetchEarthquakeData(mUrl);
    return earthquakes;
    }
}
