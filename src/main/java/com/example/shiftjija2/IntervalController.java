package com.example.shiftjija2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
@RestController
@RequestMapping("/api/v1/intervals")
public class IntervalController {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public IntervalController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

        @GetMapping(value = "/min")
    public ResponseEntity<ArrayList<String>> getMinInterval(@RequestParam(name = "kind") String kind) {
        String sql = "SELECT MIN(CASE WHEN ? = 'digits' THEN CAST(start AS SIGNED) ELSE start END) AS min_start, " +
                "MIN(CASE WHEN ? = 'letters' THEN end ELSE CAST(end AS SIGNED) END) AS min_end " +
                "FROM INTERVALS";
        Map<String, String> result = jdbcTemplate.queryForObject(sql, new Object[]{kind, kind}, (rs, rowNum) -> {
            Map<String, String> response = new HashMap<>();
            response.put("minStart", rs.getString("min_start"));
            response.put("minEnd", rs.getString("min_end"));
            return response;
        });
        return ResponseEntity.ok((ArrayList<String>) result);
    }
}

//РЕШИТЬ ПРОБЛЕМУ

//КОГДА ПРОСИШЬ LETTERS, ОН МОЖЕТ ПОПЫТАТЬСЯ ВЫДАТЬ ЦИФРЫ И НАОБОРОТ

//МОЖНО ЛИ СДЕЛАТЬ 2 ТАБЛИЦЫ. ОДНА ДЛЯ СТРОК, ДРУГАЯ ДЛЯ ЧИСЕЛ