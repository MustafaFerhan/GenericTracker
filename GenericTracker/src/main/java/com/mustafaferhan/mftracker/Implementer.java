package com.mustafaferhan.mftracker;

import android.content.Context;


/**
 * @author Mustafa Ferhan Akman
 * @since 21 Mar 2014 - 19:00
 */
public abstract class Implementer {
    Context mContext;
    String mKey = null;


    abstract public String getDescription();

    abstract public void onStartSession();

    abstract public void onStopSession();

    abstract public void trackPageView(String pageName);

    abstract public boolean trackEvents(String... params);

    @Override
    public String toString() {
        StringBuffer buffer = new StringBuffer();
        buffer.append(getClass().getSimpleName());

        return new String(buffer);
    }

    public Context getContext() {
        return mContext;
    }

    public void setContext(Context context){
        mContext = context;
    }

    // TODO: dev, test, debug, release'de anlık olarak
    // hangi trackerların çalıştığını göstersin
    String[] getRunningTrackers() {
        return null;
    }

    abstract public String getKey();


}
