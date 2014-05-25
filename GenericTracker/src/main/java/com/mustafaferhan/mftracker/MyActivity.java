package com.mustafaferhan.mftracker;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

/**
 * @author Mustafa Ferhan Akman
 * @since 21 Mar 2014 - 20:08
 */
public class MyActivity extends Activity{

    Context _context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        GenericTracker.sessionStart(_context);
        //GenericTracker.trackPageView();

        GenericTracker.trackEvents("","","");

        GenericTracker.trackPageView("welcome page/activity");

    }

}
