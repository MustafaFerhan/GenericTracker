package com.mustafaferhan.mftracker;

import android.content.Context;

import java.util.ArrayList;

/**
 * @author Mustafa Ferhan Akman
 * @since 21 Mar 2014 - 18:02
 */
public class GenericTracker {

    private static Context mContext;
    private static ArrayList<Implementer> activeTrackers;

    public static boolean sessionStart(Context context){
        mContext = context;

        return init();
    }

    public static boolean init(){

        activeTrackers = Util.getActiveTrackers(Util.getRunningMode());

        return activeTrackers.size() > 0;
    }

    public static void trackPageView(String pageName){

        for (Implementer t: activeTrackers ){
            t.trackPageView(pageName);
        }
    }


    /**
     * <br>
     * if you use GoogleAnalytics;
     * {@link com.mustafaferhan.thirdParty.GoogleAnalyticsAdapter#trackEvents(String...)}
     *</br>
     * <br>
     * if you use FLurryAnalytics;
     * {@link com.mustafaferhan.thirdParty.FlurryAnalyticsAdapter#trackEvents(String...)}
     * </br>
     */
    public static void trackEvents(String... params){

        for (Implementer t: activeTrackers ){
            t.trackEvents(params);
        }
    }

}