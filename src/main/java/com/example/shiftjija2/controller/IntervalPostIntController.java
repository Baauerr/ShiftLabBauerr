package com.example.shiftjija2.controller;

import com.example.shiftjija2.algorithm.IntervalCombiner;
import com.example.shiftjija2.algorithm.IntervalsService;
import com.example.shiftjija2.algorithm.Sorter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

import static com.example.shiftjija2.algorithm.ArrayConverter.convertIntArrayToStringArray;

@RestController
@RequestMapping("/api/v1/intervals")
public class IntervalPostIntController {

    @Autowired
    private IntervalsService intervalsService;
    @RequestMapping(value = "/merge", method = RequestMethod.POST)
    public ResponseEntity<?> mergeIntervals(@RequestParam("kind") String kind, @RequestBody ArrayList<ArrayList<?>> intervalData) {
        if ("digits".equals(kind)) {
            doSomething(intervalData);
            return ResponseEntity.ok(intervalData);
        } else if ("letters".equals(kind)) {
            doSomething(intervalData);
            return ResponseEntity.ok(intervalData);
        }
        return null;
    }

    private void doSomething(ArrayList<ArrayList<?>> intervalData){
        ArrayList<ArrayList<String>> intervalStringData = convertIntArrayToStringArray(intervalData);
        intervalStringData = Sorter.sortByFirstElements(intervalStringData);
        IntervalCombiner combiner = new IntervalCombiner();
        combiner.combineIntervals(intervalData);
        intervalsService.saveIntervalsFromArrays(intervalStringData);
    }
}




