package com.example.shiftjija2.algorithm;



import com.example.shiftjija2.H2DB.IntervalsInt;
import com.example.shiftjija2.H2DB.IntervalsIntRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class IntervalsIntService {

    private final IntervalsIntRepository intervalsRepository;

    @Autowired
    public IntervalsIntService(IntervalsIntRepository intervalsRepository) {
        this.intervalsRepository = intervalsRepository;
    }
    public void saveIntervalsFromArrays(ArrayList<ArrayList<Integer>> intervalsList) {
        for (List<Integer> intervalValues : intervalsList) {
            Integer startValue = intervalValues.get(0);
            Integer endValue = intervalValues.get(1);

            IntervalsInt intervals = new IntervalsInt();
            intervals.setStart(startValue);
            intervals.setEnd(endValue);

            intervalsRepository.save(intervals);
        }
    }
}