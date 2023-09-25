package com.example.shiftjija2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
@RestController
@RequestMapping("/api/v1/intervals")
public class IntervalController {
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public IntervalController(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @GetMapping("/min")
    public ResponseEntity<Object[]> getMinStartAndEnd(@RequestParam("kind") String kind) {
        if ("digits".equals(kind)) {
            String sql = "SELECT MIN(start) as min_start, MIN(endValue) as min_end FROM INTERVALS_INT";
            Map<String, Object> paramMap = new HashMap<>();
            Integer[] result = namedParameterJdbcTemplate.queryForObject(sql, paramMap, (rs, rowNum) -> {
                Integer minStart = rs.getInt("min_start");
                Integer minEnd = rs.getInt("min_end");
                return new Integer[]{minStart, minEnd};
            });
            return ResponseEntity.ok(result);
        }
        else if ("letters".equals(kind)) {
            String sql = "SELECT MIN(start) as min_start, MIN(endValue) as min_end FROM INTERVALS_STRING";
            Map<String, Object> paramMap = new HashMap<>();
            String[] result = namedParameterJdbcTemplate.queryForObject(sql, paramMap, (rs, rowNum) -> {
                String minStart = rs.getString("min_start");
                String minEnd = rs.getString("min_end");
                return new String[]{minStart, minEnd};
            });
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().build();
    }
}

