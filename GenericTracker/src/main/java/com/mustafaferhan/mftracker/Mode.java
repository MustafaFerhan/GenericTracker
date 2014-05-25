package com.mustafaferhan.mftracker;

import android.support.v7.appcompat.BuildConfig;

import com.mustafaferhan.annotation.Dev;
import com.mustafaferhan.annotation.Release;
import com.mustafaferhan.annotation.Test;

/**
 * @author Mustafa Ferhan Akman
 * @since 22 Mar 2014 - 02:54
 */
public class Mode {

    public static final Class MODE_TEST     = Test.class;
    public static final Class MODE_RELEASE  = Release.class;
    public static final Class MODE_DEV      = Dev.class;


    /**
     * @return Dev mode OR test mode
     */
    public static Class getAutoMode(){

        if(BuildConfig.DEBUG){
            return MODE_DEV;
        }else {
            return MODE_TEST;
        }
    }
}
