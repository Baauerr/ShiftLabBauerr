package com.example.shiftjija2.H2DB;

import jakarta.persistence.*;

@Entity
@Table(name = "intervals_int")
public class IntervalsIntTable {
    @jakarta.persistence.Id
    @GeneratedValue
    @Column(name = "Id", nullable = false)
    private Long Id;
    @Column(name = "Start", nullable = false)
    private Integer start;
    @Column(name = "End_value", nullable = false)
    private Integer end;

    public IntervalsIntTable(){
    }
    public Long getId() {
        return Id;
    }
    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public Integer getEnd() {
        return end;
    }

    public void setEnd(Integer end) {
        this.end = end;
    }
}


