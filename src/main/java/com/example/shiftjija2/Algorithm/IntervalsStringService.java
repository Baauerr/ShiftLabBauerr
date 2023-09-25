package com.example.shiftjija2.Algorithm;

import com.example.shiftjija2.H2DB.IntervalsStringTable;
import com.example.shiftjija2.IntervalsStringRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
//Добавление значений в string БД
@Service
public class IntervalsStringService {

    private final IntervalsStringRepository intervalsRepository;

    @Autowired
    public IntervalsStringService(IntervalsStringRepository intervalsRepository) {
        this.intervalsRepository = intervalsRepository;
    }

    public void saveIntervalsToDataBase(ArrayList<ArrayList<String>> intervalsList) {
        for (List<String> intervalValues : intervalsList) {
            String startValue = intervalValues.get(0);
            String endValue = intervalValues.get(1);

            IntervalsStringTable intervals = new IntervalsStringTable();
            intervals.setStart(startValue);
            intervals.setEnd(endValue);

            intervalsRepository.save(intervals);
        }
    }
}
