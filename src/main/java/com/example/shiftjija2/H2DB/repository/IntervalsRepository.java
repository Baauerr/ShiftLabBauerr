package com.example.shiftjija2.H2DB.repository;

import com.example.shiftjija2.H2DB.Intervals;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IntervalsRepository extends CrudRepository<Intervals, Long> {
}
