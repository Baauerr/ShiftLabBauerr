package com.example.shiftjija2;


import com.example.shiftjija2.H2DB.IntervalsIntTable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IntervalsIntRepository extends CrudRepository<IntervalsIntTable, Long> {
}
