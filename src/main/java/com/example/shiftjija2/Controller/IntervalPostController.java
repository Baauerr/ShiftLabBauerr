package com.example.shiftjija2.Controller;

import com.example.shiftjija2.Algorithm.IntervalsIntService;
import com.example.shiftjija2.Algorithm.IntervalsStringService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

import static com.example.shiftjija2.Algorithm.ArrayConverter.convertToIntegerArray;
import static com.example.shiftjija2.Algorithm.ArrayConverter.convertToStringArray;
import static com.example.shiftjija2.Controller.AlgorithmChain.sortAndCombine;


@RestController
@RequestMapping("/api/v1/intervals")
public class IntervalPostController<T> {

    @Autowired
    private IntervalsIntService intervalsIntService;
    @Autowired
    private IntervalsStringService intervalsStringService;

    @RequestMapping(value = "/merge", method = RequestMethod.POST)
    public ResponseEntity<?> mergeIntervals(@RequestParam("kind") String kind, @RequestBody ArrayList<ArrayList<?>> intervalData) {
        if ("digits".equals(kind)) {
            ArrayList<ArrayList<Integer>> intArrays = convertToIntegerArray(intervalData);
            sortAndCombine(intArrays);
            intervalsIntService.saveIntervalsToDataBase(intArrays);
            return ResponseEntity.ok(intArrays);
        }
        else if ("letters".equals(kind)) {
            ArrayList<ArrayList<String>> stringArrays = convertToStringArray(intervalData);
            sortAndCombine(stringArrays);
            intervalsStringService.saveIntervalsToDataBase(stringArrays);
            return ResponseEntity.ok(stringArrays);
        }
        return null;
    }
}



