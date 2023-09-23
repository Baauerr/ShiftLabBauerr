package com.example.shiftjija2.algorithm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IntervalCombiner<T extends Comparable<T>> {
    public ArrayList<ArrayList<T>> combineIntervals(ArrayList<ArrayList<T>> intervals) {
        Iterator<ArrayList<T>> iterator = intervals.iterator();
        ArrayList<T> prevInterval = iterator.next();
        while (iterator.hasNext()) {
            ArrayList<T> currentInterval = iterator.next();
            if (currentInterval.get(0).compareTo(prevInterval.get(1)) > 0) {
                prevInterval = currentInterval;
            } else if (currentInterval.get(0).compareTo(prevInterval.get(0)) > 0 && currentInterval.get(1).compareTo(prevInterval.get(1)) >= 0) {
                prevInterval.set(1, currentInterval.get(1));
                iterator.remove();
            } else {
                iterator.remove();
            }
        }
        return intervals;
    }
}
