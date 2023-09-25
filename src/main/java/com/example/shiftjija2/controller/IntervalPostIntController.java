package com.example.shiftjija2.controller;

import com.example.shiftjija2.algorithm.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

import static com.example.shiftjija2.algorithm.ArrayConverter.*;

@RestController
@RequestMapping("/api/v1/intervals")
public class IntervalPostIntController <T>{

    @Autowired
    private IntervalsIntService intervalsIntService;
    @Autowired
    private IntervalsStringService intervalsStringService;

    @RequestMapping(value = "/merge", method = RequestMethod.POST)
    public ResponseEntity<?> mergeIntervals(@RequestParam("kind") String kind, @RequestBody ArrayList<ArrayList<?>> intervalData) {
        if ("digits".equals(kind)) {
            ArrayList<ArrayList<Integer>> intArrays = convertToIntegerArrays(intervalData);
            sortAndCombine(intArrays);
            intervalsIntService.saveIntervalsFromArrays(intArrays);
            return ResponseEntity.ok(intArrays);
        } else if ("letters".equals(kind)) {
            ArrayList<ArrayList<String>> stringArrays = convertToStringArrays(intervalData);
            sortAndCombine(stringArrays);
            intervalsStringService.saveIntervalsFromArrays(stringArrays);
            return ResponseEntity.ok(stringArrays);
        }
        return null;
    }

    private <T extends Comparable<T>> ArrayList<ArrayList<T>> sortAndCombine(ArrayList<ArrayList<T>> intervalData){
        Sorter<T> sorter = new Sorter<>();
        intervalData = sorter.sortByFirstElements(intervalData);
        IntervalCombiner combiner = new IntervalCombiner();
        intervalData = combiner.combineIntervals(intervalData);
        return intervalData;
    }
}




