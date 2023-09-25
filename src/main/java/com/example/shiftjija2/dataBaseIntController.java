package com.example.shiftjija2;

import com.example.shiftjija2.H2DB.IntervalsInt;
import com.example.shiftjija2.H2DB.IntervalsIntRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequestMapping(value = "", produces = "application/json")
public class dataBaseIntController {
    @Autowired
    private IntervalsIntRepository intervalsIntRepository;

    @RequestMapping("create-int-interval")
    public IntervalsInt createInterval() {
        return intervalsIntRepository.save(new IntervalsInt());
    }
}
