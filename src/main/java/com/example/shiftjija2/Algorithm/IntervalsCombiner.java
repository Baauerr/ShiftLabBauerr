package com.example.shiftjija2.Algorithm;

import java.util.ArrayList;
import java.util.Iterator;

public class IntervalsCombiner<T extends Comparable<T>> {
    public ArrayList<ArrayList<T>> combineIntervals(ArrayList<ArrayList<T>> intervals) {
        Iterator<ArrayList<T>> intervalsList = intervals.iterator();
        ArrayList<T> prevInterval = intervalsList.next();
        while (intervalsList.hasNext()) {
            ArrayList<T> currentInterval = intervalsList.next();
            if (currentInterval.get(0).compareTo(prevInterval.get(1)) > 0) {
                prevInterval = currentInterval;
            } else if (currentInterval.get(0).compareTo(prevInterval.get(0)) > 0 && currentInterval.get(1).compareTo(prevInterval.get(1)) >= 0) {
                prevInterval.set(1, currentInterval.get(1));
                intervalsList.remove();
            } else {
                intervalsList.remove();
            }
        }
        return intervals;
    }
}
