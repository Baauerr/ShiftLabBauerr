package com.example.shiftjija2.H2DB;

import jakarta.persistence.*;

@Entity
@Table(name = "INTERVALSINT")
public class IntervalsInt{
    @jakarta.persistence.Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private Long Id;
    @Column(name = "start", nullable = false)
    private Integer start;
    @Column(name = "`end`", nullable = false)
    private Integer end;

    public IntervalsInt(){
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


