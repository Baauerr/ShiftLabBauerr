package com.example.shiftjija2.H2DB;

import com.example.shiftjija2.H2DB.Intervals;
import org.antlr.v4.runtime.misc.Interval;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IntervalsRepository extends CrudRepository<Intervals, Long> {
   // Optional<Interval> findFirstByKindOrderByStartAscEndAsc(String kind);
}
