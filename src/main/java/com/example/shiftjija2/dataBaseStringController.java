package com.example.shiftjija2;


import com.example.shiftjija2.H2DB.IntervalsString;
import com.example.shiftjija2.H2DB.IntervalsStringRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequestMapping(value = "", produces = "application/json")
public class dataBaseStringController {
    @Autowired
    private IntervalsStringRepository intervalsStringRepository;

    @RequestMapping("create-string-interval")
    public IntervalsString createInterval(){
        return intervalsStringRepository.save(new IntervalsString());
    }
}

