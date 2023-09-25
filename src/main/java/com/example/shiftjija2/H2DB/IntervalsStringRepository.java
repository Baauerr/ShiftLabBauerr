package com.example.shiftjija2.H2DB;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IntervalsStringRepository extends CrudRepository<TableIntervalsString, Long> {
}
