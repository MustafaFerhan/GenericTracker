package com.mustafaferhan.test;

import com.mustafaferhan.mftracker.GenericTracker;
import com.mustafaferhan.mftracker.GenericTrackerConfig;
import com.mustafaferhan.mftracker.Mode;
import com.mustafaferhan.mftracker.Util;

import junit.framework.TestCase;

import java.lang.reflect.Method;

/**
 * @author Mustafa Ferhan Akman
 * @since 22 Mar 2014 - 12:26
 */
public class GenericTrackerTest extends TestCase {

    Class mode = null;

    @Override
    protected void setUp() throws Exception {
        super.setUp();

        //mode = GenericTrackerConfig.getRunningMode();
        mode =  Mode.MODE_TEST;
    }

    public void testInvokeMFTracker() throws Exception {

        Method testMethod = GenericTrackerConfig.class.getMethod("trackGoogleAnalyticsRelease");

        assertNotNull(Util.invokeTracker(testMethod, mode));
    }


    public void testInvokeMFTracker4All() throws Exception {
        Method[] testMethods = GenericTrackerConfig.class.getDeclaredMethods();

        for (Method m : testMethods){

            if(m.isAnnotationPresent(mode)){
                assertNotNull(Util.invokeTracker(m, mode));
            }

        }
    }

    public void testInit() throws Exception {
        assertEquals(true, GenericTracker.init());
    }

    public void testSessionStart() throws Exception {

    }

    public void testTrackPageView() throws Exception {

    }

    public void testGetConfigMethods() throws Exception {
    }


}
