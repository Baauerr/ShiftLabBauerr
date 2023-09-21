package com.example.shiftjija2.controller;

import com.example.shiftjija2.H2DB.Intervals;
import com.example.shiftjija2.H2DB.repository.IntervalsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequestMapping(value = "", produces = "application/json")
public class ShiftJija2Application {
    @Autowired
    private IntervalsRepository intervalsRepository;

    public static void main(String[] args) {
        SpringApplication.run(ShiftJija2Application.class, args);
    }
    @RequestMapping("create-interval")
    public Intervals createInterval(){
        return intervalsRepository.save(new Intervals());
    }
}
