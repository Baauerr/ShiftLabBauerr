package com.example.shiftjija2;

import com.example.shiftjija2.H2DB.Intervals;
import com.example.shiftjija2.H2DB.repository.IntervalsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequestMapping(value = "", produces = "application/json")
public class dataBaseController {
    @Autowired
    private IntervalsRepository intervalsRepository;

    @RequestMapping("create-interval")
    public Intervals createInterval(){
        return intervalsRepository.save(new Intervals());
    }
}
