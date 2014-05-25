package com.mustafaferhan.thirdParty;

import com.flurry.android.FlurryAgent;
import com.mustafaferhan.mftracker.Implementer;
import com.mustafaferhan.mftracker.Util;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Mustafa Ferhan Akman
 * @since 24 Mar 2014 - 17:39
 */
public class FlurryAnalyticsAdapter extends Implementer {


    @Override
    public String getKey() {
        return "YOUR-FLURRY-KEY";
    }

    @Override
    public String getDescription() {
        return "Flurry Analytics implementation for " + Util.getRunningMode().getSimpleName();
    }

    @Override
    public void onStartSession() {
        FlurryAgent.onStartSession(getContext(), getKey());
    }

    @Override
    public void onStopSession() {
        FlurryAgent.onEndSession(getContext());
    }

    @Override
    public void trackPageView(String pageName) {
        Map<String,String> mp = new HashMap<String, String>();
        mp.put("PageView",pageName);

        FlurryAgent.onPageView();
        FlurryAgent.logEvent(pageName);
    }


    /***
     *
     * <p>for FlurryAnalytics, follow this order; </p>
     *
     * 1st way:
     * <p>Send only one event param.</p>
     *
     * 2nd way:
     * <p>1. param: Event name (required)</p>
     *
     * <p>2. param: first key (required)</p>
     * <p>3. param: first valeu (required)</p>
     *
     * <p>4. param: second key </p>
     * <p>5. param: second value </p>
     *
     * <p>5. param: third key </p>
     * <p>5. param: third value </p>
     * <p> ... </p>
     *
     *
     * @see <a href="http://support.flurry.com/index.php?title=Analytics/GettingStarted/Events/Android">
     *     FlurryAnalytics Custom Events</a
     *
     * @param params
     */
    @Override
    public boolean trackEvents(String... params) {

        if(params.length == 1){
            trackEvent(params[0]);
            return true;
        }

        if(params.length < 4){
            throw new NullPointerException(" Wrong params count (" + params.length + "). Read javadoc.");
        }

        Map<String, String> eventParams = new HashMap<String, String>();

        for (int i = 1; i < params.length; i=i+2) {
            eventParams.put(params[i], params[1 + 1]);
        }

        FlurryAgent.logEvent(params[0], eventParams);

        return true;

    }

    private void trackEvent(String event){
        FlurryAgent.logEvent(event);
    }


 /*  @Override
    public void trackEvents(String eventName, HashMap<String, String> events) {
        FlurryAgent.logEvent(eventName, events);
    }
*/
}