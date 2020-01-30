package com.ensar.EmployeeAttendance.repository;

import com.ensar.EmployeeAttendance.pojo.Hours;
import com.ensar.EmployeeAttendance.pojo.HoursId;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.List;

public interface HoursRepository extends CrudRepository<Hours, HoursId> {
    Hours findOneByIdEmployeeidAndIdRecdate(Integer employeeId, LocalDate recDate);
    Hours save(Hours hours);
    List<Hours> findAll();
    List<Hours> findAllByIdEmployeeid(Integer employeeId);
    List<Hours> findAllByMonthAndYearAndIdEmployeeid(Integer month, Integer year, Integer employeeId);
}
