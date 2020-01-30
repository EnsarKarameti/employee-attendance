package com.ensar.EmployeeAttendance.repository;

import com.ensar.EmployeeAttendance.pojo.Employee;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmployeeRepository extends CrudRepository<Employee, String> {
    Employee save(Employee employee);
    Employee findOneByEmailAndPassword(String email, String password);
    Employee findOneByEmailAndPhone(String email, String phone);
    List<Employee> findAll();
}
