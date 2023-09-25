package com.example.shiftjija2;

import com.example.shiftjija2.H2DB.IntervalsStringTable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IntervalsStringRepository extends CrudRepository<IntervalsStringTable, Long> {
}
