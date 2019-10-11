package model;


import java.util.Hashtable;

/**
 * Please Note that : Only the orginator class can create and access the cellMemento object.
 */

public class CellMemento {

    private Hashtable savedState = new Hashtable();

    //Give some protection
    protected CellMemento() {
    }


    protected void setState(String stateName, Object stateValue) {
        savedState.put(stateName, stateValue);
    }


    protected Object getState(String stateName) {
        return savedState.get(stateName);
    }


    protected Object getState(String stateName, Object defaultValue) {
        if (savedState.containsKey(stateName))
            return savedState.get(stateName);
        else
            return defaultValue;
    }
}
