package com.example.shiftjija2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static com.example.shiftjija2.algorithm.ArrayConverter.convertToIntegerArrays;
import static com.example.shiftjija2.algorithm.ArrayConverter.convertToStringArrays;

@SpringBootApplication
@RestController
@RequestMapping("/api/v1/intervals")
public class IntervalController {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public IntervalController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @GetMapping("/min")
    public ResponseEntity<IntervalResult> getMinStartAndEnd(@RequestParam("kind") String kind) {
        if ("digits".equals(kind)) {
            String sql = "SELECT MIN(`start`) , MIN(`end`) FROM INTERVALS_INT";
            IntervalResult result = jdbcTemplate.queryForObject(sql, (rs, rowNum) -> {
                IntervalResult intervalResult = new IntervalResult();
                intervalResult.setStart(rs.getInt("min_start"));
                intervalResult.setEnd(rs.getInt("min_end"));
                return intervalResult;
            });
            return ResponseEntity.ok(result);
        }
        else if ("letters".equals(kind)){
            String sql = "SELECT MIN(`start`), MIN(`end`) FROM INTERVALS_STRING";
            IntervalResult result = jdbcTemplate.queryForObject(sql, (rs, rowNum) -> {
                IntervalResult intervalResult = new IntervalResult();
                intervalResult.setStart(rs.getInt("min_start"));
                intervalResult.setEnd(rs.getInt("min_end"));
                return intervalResult;
            });
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().build();
    }
}

