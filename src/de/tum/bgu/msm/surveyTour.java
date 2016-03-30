package de.tum.bgu.msm;

import org.apache.log4j.Logger;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Class to hold tour object of the TSRC survey
 *
 * @author Rolf Moeckel
 * Created on 17 Mar. 2016 in Munich
 *
 **/

public class surveyTour implements Serializable {

    static Logger logger = Logger.getLogger(surveyTour.class);

    private static final Map<Integer, surveyTour> tourMap = new HashMap<>();
    int tourId;

    int origProvince;
    int destProvince;
    private int mainMode;
    int homeCma;
    int tripPurp;
    int numIdentical;
    ArrayList<int[]> tourStops;

    public surveyTour(int tourId, int pumfId, int origProvince, int destProvince, int mainMode, int homeCma,
                      int tripPurp, int numIdentical) {
        // constructor of new survey tour

        this.tourId = util.createTourId(pumfId, tourId);
        this.origProvince = origProvince;
        this.destProvince = destProvince;
        this.mainMode = mainMode;
        this.homeCma = homeCma;
        this.tripPurp = tripPurp;
        this.numIdentical = numIdentical;
        tourStops = new ArrayList<>();
        tourMap.put(this.tourId,this);
    }


    public void addTripDestinations(int cmarea, int nights) {
        int[] stopData = {cmarea, nights};
        tourStops.add(stopData);

    }

    public static surveyTour getTourFromId(int id) {
        return tourMap.get(id);
    }

    public int getOrigProvince() {
        return origProvince;
    }

    public int getDestProvince() {
        return destProvince;
    }

    public int getMainMode() {
        return mainMode;
    }

    public int getHomeCma() {
        return homeCma;
    }

    public int getTripPurp() {
        return tripPurp;
    }

    public int getNumIdentical() {
        return numIdentical;
    }

    public int getNumberOfStop () {
        return tourStops.size();
    }
}
