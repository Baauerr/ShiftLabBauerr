package com.example.shiftjija2.algorithm;

import com.example.shiftjija2.H2DB.Intervals;
import com.example.shiftjija2.H2DB.IntervalsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class IntervalsService {

    private final IntervalsRepository intervalsRepository;

    @Autowired
    public IntervalsService(IntervalsRepository intervalsRepository) {
        this.intervalsRepository = intervalsRepository;
    }
    public void saveIntervalsFromArrays(ArrayList<ArrayList<String>> intervalsList) {
        for (List<String> intervalValues : intervalsList) {
                String startValue = intervalValues.get(0);
                String endValue = intervalValues.get(1);

                Intervals intervals = new Intervals();
                intervals.setStart(startValue);
                intervals.setEnd(endValue);

                intervalsRepository.save(intervals);
        }
    }
}