package com.mustafaferhan.thirdParty;

import com.google.analytics.tracking.android.Fields;
import com.google.analytics.tracking.android.GoogleAnalytics;
import com.google.analytics.tracking.android.MapBuilder;
import com.google.analytics.tracking.android.Tracker;
import com.mustafaferhan.mftracker.Implementer;
import com.mustafaferhan.mftracker.Util;


/**
 * @author Mustafa Ferhan Akman
 * @since 21 Mar 2014 - 19:10
 */
public class GoogleAnalyticsAdapter extends Implementer {

    Tracker mTracker;

    @Override
    public String getKey() {
        return "YOUR-GOOGLE-ANALYTICS-TRACKING-ID";
    }

    @Override
    public String getDescription() {
        return "Google Analytics implementation for " + Util.getRunningMode().getSimpleName();
    }

    @Override
    public void onStartSession() {
        mTracker = GoogleAnalytics.getInstance(getContext()).getTracker(getKey());
    }

    @Override
    public void onStopSession() {

        //not applicable for GoolgeAnalytics
    }

    @Override
    public void trackPageView(String pageName) {
        mTracker.set(Fields.SCREEN_NAME, pageName);
    }


    /**
     * <p>for GoogleAnalytics, follow this order; </p>
     * <p>1- Event category (required)</p>
     * <p>2- Event action (required)</p>
     * <p>3- Event label</p>
     * <p>4- Event value </p>
     *
     * @param params
     * @see <a href="https://developers.google.com/analytics/devguides/collection/android/v3/events">
     * GoogleAnalytics Getting Started</a
     */
    @Override
    public boolean trackEvents(String... params) {

        if(params.length < 3) {
            throw new NullPointerException(" Must send at least 2 params for GoogleAnalytics ");
        }

        Long value = null;
        try {
            value = Long.parseLong(params[3]);
        } catch (Exception e) {
            return false;
        }

        mTracker.send(MapBuilder.createEvent(params[0], params[1], params[2], value).build());

        return true;
    }
}

