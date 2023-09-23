package com.example.shiftjija2.controller;

import com.example.shiftjija2.algorithm.ArrayConverter;
import com.example.shiftjija2.algorithm.IntervalCombiner;
import com.example.shiftjija2.algorithm.IntervalsService;
import com.example.shiftjija2.algorithm.Sorter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/intervals")
public class IntervalPostIntController {

    @PostMapping("/merge")
    public ArrayList<ArrayList<String>> mergeIntervals(@RequestBody ArrayList<ArrayList<Integer>> intervalData) {
        ArrayList<ArrayList<String>> intervalStringData;
        intervalStringData = ArrayConverter.convertIntArrayToStringArray(intervalData);
        intervalStringData = Sorter.sortByFirstElements(intervalStringData);
 //       IntervalsService dataBasePusher = new IntervalsService(intervalsRepository);
 //       dataBasePusher.saveIntervalsFromArrays(intervalStringData);
        return intervalStringData;
    }
}