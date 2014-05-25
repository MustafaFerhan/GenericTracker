package com.mustafaferhan.mftracker;


import com.mustafaferhan.annotation.Dev;
import com.mustafaferhan.annotation.Release;
import com.mustafaferhan.annotation.Test;
import com.mustafaferhan.thirdParty.GoogleAnalyticsAdapter;

/**
 * @author Mustafa Ferhan Akman
 * @since 21 Mar 2014 - 19:08
 */
public class GenericTrackerConfig {

    static final Class TRACKER_MODE = Mode.MODE_RELEASE;

    @Test
    public Implementer trackGoogleAnalytics(){
        return new GoogleAnalyticsAdapter();
    }

    @Dev
    public Implementer trackGoogleAnalytics2(){
        return new GoogleAnalyticsAdapter();
    }

    @Release
    public Implementer trackGoogleAnalyticsRelease(){
        return new GoogleAnalyticsAdapter();
    }

}
