package com.example.shiftjija2.H2DB;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Table;

@Entity
@Table(name = "INTERVALS_STRING")
public class TableIntervalsString {
    @jakarta.persistence.Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private Long Id;
    @Column(name = "start", nullable = false)
    private String start;
    @Column(name = "`end`", nullable = false)
    private String end;

    public TableIntervalsString() {
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
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
