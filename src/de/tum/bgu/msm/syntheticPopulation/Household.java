package de.tum.bgu.msm.syntheticPopulation;

import org.apache.log4j.Logger;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * Ontario Provincial Model
 * Class to store synthetic households
 * Author: Rolf Moeckel, Technical University of Munich (TUM), rolf.moeckel@tum.de
 * Date: 22 April 2016
 * Version 1
 *
 */

public class Household {

    static Logger logger = Logger.getLogger(Household.class);

    private static final Map<Integer, Household> householdMap = new HashMap<>();
    private int id;
    private int hhSize;
    private int hhInc;
    private int ddType;
    private int numWrks;
    private int numKids;
    private Person[] persons;


    public Household(int id, int hhSize, int hhInc, int ddType, int numWrks, int numKids) {
        this.id      = id;
        this.hhSize  = hhSize;
        this.hhInc   = hhInc;
        this.ddType  = ddType;
        this.numWrks = numWrks;
        this.numKids = numKids;
        persons = new Person[hhSize];
        householdMap.put(id,this);
    }


    public static Household[] getHouseholdArray() {
        return householdMap.values().toArray(new Household[householdMap.size()]);
    }


    public static Household getHouseholdFromId(int householdId) {
        return householdMap.get(householdId);
    }


    public static int getHouseholdCount() {
        return householdMap.size();
    }


    public static Collection<Household> getHouseholds() {
        return householdMap.values();
    }

}
