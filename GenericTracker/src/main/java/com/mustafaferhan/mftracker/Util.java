package com.mustafaferhan.mftracker;

import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 * @author Mustafa Ferhan Akman
 * @since 22 Mar 2014 - 13:34
 */
public class Util {

    static GenericTrackerConfig aTracker = new GenericTrackerConfig();

    public static Class getRunningMode(){
        return GenericTrackerConfig.TRACKER_MODE;
    }

    static ArrayList<Implementer> getActiveTrackers(Class mode){

        ArrayList<Implementer> activeTrackers = new ArrayList<Implementer>();

        for (Method method : GenericTrackerConfig.class.getDeclaredMethods()){

            if(method.isAnnotationPresent(mode)){
                System.out.println("GenericTracker running for '"+ mode.getSimpleName() +"' case ");

                Implementer implementer = invokeTracker(method, mode);
                activeTrackers.add(implementer);
            }
        }

        return activeTrackers;
    }

    public static Implementer invokeTracker(Method method, Class mode){

        if(method == null)
            return null;

        try {
            Method aMethod = GenericTrackerConfig.class.getDeclaredMethod(method.getName(), null);
            aMethod.setAccessible(true);

            Implementer implementer = (Implementer) aMethod.invoke(aTracker, null);

            //    System.out.println("mfa GenericTrackerConfig method getName():" + method.getName());
            //    System.out.println("mfa aTracker toString() invoke:" + implementer.toString());

            return implementer;

        }catch (Exception e){e.printStackTrace();}

        return null;
    }
}