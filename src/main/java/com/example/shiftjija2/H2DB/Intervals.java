package com.example.shiftjija2.H2DB;

import jakarta.persistence.*;

@Entity
@Table(name = "INTERVALS")
public class Intervals{
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private Long Id;
    @Column(name = "start", nullable = false)
    private String start;
    @Column(name = "`end`", nullable = false)
    private String end;

    public Intervals(){
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
