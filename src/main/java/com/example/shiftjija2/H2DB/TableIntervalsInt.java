package com.example.shiftjija2.H2DB;

import jakarta.persistence.*;

@Entity
@Table(name = "intervals_int")
public class TableIntervalsInt {
    @jakarta.persistence.Id
    @GeneratedValue
    @Column(name = "ID", nullable = false)
    private Long Id;
    @Column(name = "START", nullable = false)
    private Integer start;
    @Column(name = "ENDVALUE", nullable = false)
    private Integer end;

    public TableIntervalsInt(){
    }
    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
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


