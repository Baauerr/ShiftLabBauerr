package com.example.shiftjija2.Controller;

import com.example.shiftjija2.Algorithm.IntervalsCombiner;
import com.example.shiftjija2.Algorithm.Sorter;

import java.util.ArrayList;

public class AlgorithmChain<T> {
    public static <T extends Comparable<T>> ArrayList<ArrayList<T>> sortAndCombine(ArrayList<ArrayList<T>> intervalData) {
        Sorter<T> sorter = new Sorter<>();
        intervalData = sorter.sortByFirstElements(intervalData);
        IntervalsCombiner combiner = new IntervalsCombiner();
        intervalData = combiner.combineIntervals(intervalData);
        return intervalData;
    }
}
