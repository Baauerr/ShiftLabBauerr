package com.example.shiftjija2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

public class MinIntervalResponse {
    private String minStart;
    private String minEnd;

    public String getMinStart() {
        return minStart;
    }

    public void setMinStart(String minStart) {
        this.minStart = minStart;
    }

    public String getMinEnd() {
        return minEnd;
    }

    public void setMinEnd(String minEnd) {
        this.minEnd = minEnd;
    }
}


