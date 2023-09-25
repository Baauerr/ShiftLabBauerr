package com.example.shiftjija2.Algorithm;

import com.example.shiftjija2.H2DB.IntervalsIntTable;
import com.example.shiftjija2.IntervalsIntRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


//Добавление значений в Integer БД
@Service
public class IntervalsIntService {

    private final IntervalsIntRepository intervalsRepository;

    @Autowired
    public IntervalsIntService(IntervalsIntRepository intervalsRepository) {
        this.intervalsRepository = intervalsRepository;
    }
    public void saveIntervalsToDataBase(ArrayList<ArrayList<Integer>> intervalsList) {
        for (List<Integer> intervalValues : intervalsList) {
            Integer startValue = intervalValues.get(0);
            Integer endValue = intervalValues.get(1);

            IntervalsIntTable intervals = new IntervalsIntTable();
            intervals.setStart(startValue);
            intervals.setEnd(endValue);

            intervalsRepository.save(intervals);
        }
    }
}