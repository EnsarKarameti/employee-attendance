package com.ensar.EmployeeAttendance.repository;

import com.ensar.EmployeeAttendance.pojo.Admin;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AdminRepository extends CrudRepository<Admin, String> {
    Admin save(Admin admin);
    List<Admin> findAll();
    Admin findOneByEmailAndPhone(String email, String phone);
    Admin findOneByEmailAndPassword(String email, String password);
}
