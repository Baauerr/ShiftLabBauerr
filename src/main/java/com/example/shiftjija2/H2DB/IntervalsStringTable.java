package com.example.shiftjija2.H2DB;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Table;

@Entity
@Table(name = "intervals_string")
public class IntervalsStringTable {
    @jakarta.persistence.Id
    @GeneratedValue
    @Column(name = "ID", nullable = false)
    private Long Id;
    @Column(name = "Start", nullable = false)
    private String start;
    @Column(name = "End_value", nullable = false)
    private String end;

    public IntervalsStringTable() {
    }

    public Long getId() {
        return Id;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }
}
