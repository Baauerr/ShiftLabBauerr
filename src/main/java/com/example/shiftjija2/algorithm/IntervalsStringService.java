package com.example.shiftjija2.algorithm;

import com.example.shiftjija2.H2DB.TableIntervalsString;
import com.example.shiftjija2.H2DB.IntervalsStringRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class IntervalsStringService {

    private final IntervalsStringRepository intervalsRepository;

    @Autowired
    public IntervalsStringService(IntervalsStringRepository intervalsRepository) {
        this.intervalsRepository = intervalsRepository;
    }

    public void saveIntervalsFromArrays(ArrayList<ArrayList<String>> intervalsList) {
        for (List<String> intervalValues : intervalsList) {
            String startValue = intervalValues.get(0);
            String endValue = intervalValues.get(1);

            TableIntervalsString intervals = new TableIntervalsString();
            intervals.setStart(startValue);
            intervals.setEnd(endValue);

            intervalsRepository.save(intervals);
        }
    }
}