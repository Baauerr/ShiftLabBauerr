package com.example.shiftjija2.Controller;

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
public class IntervalGetController{
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public IntervalGetController(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @GetMapping("/min")
    public ResponseEntity<Object[]> getMinStartAndEnd(@RequestParam("kind") String kind) {
        if ("digits".equals(kind)) {
            String sql = "SELECT MIN(start) as min_start, MIN(End_value) as min_end FROM INTERVALS_INT";
            Map<String, Object> minValuesMap = new HashMap<>();
            Integer[] result = namedParameterJdbcTemplate.queryForObject(sql, minValuesMap, (resultSet, rowNum) -> {
                int minStart = resultSet.getInt("min_start");
                int minEnd = resultSet.getInt("min_end");
                return new Integer[]{minStart, minEnd};
            });
            if (result[0] != 0) {
                return ResponseEntity.ok(result);
            } else {
                throw new IllegalArgumentException("Таблица пуста или выполнен некорректный запрос ");
            }
        } else if ("letters".equals(kind)) {
            String sql = "SELECT MIN(start) as min_start, MIN(End_value) as min_end FROM INTERVALS_STRING";
            Map<String, Object> minValuesMap = new HashMap<>();
            String[] result = namedParameterJdbcTemplate.queryForObject(sql, minValuesMap, (rs, rowNum) -> {
                String minStart = rs.getString("min_start");
                String minEnd = rs.getString("min_end");

                return new String[]{minStart, minEnd};
            });
            if (result[0] != null) {
                return ResponseEntity.ok(result);
            } else {
                throw new IllegalArgumentException("Таблица пуста или выполнен некорректный запрос ");
            }
        }
        return ResponseEntity.badRequest().build();
    }
}

