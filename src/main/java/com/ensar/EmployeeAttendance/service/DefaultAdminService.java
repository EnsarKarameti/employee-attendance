package com.ensar.EmployeeAttendance.service;

import com.ensar.EmployeeAttendance.pojo.*;
import com.ensar.EmployeeAttendance.repository.AdminRepository;
import com.ensar.EmployeeAttendance.repository.EmployeeRepository;
import com.ensar.EmployeeAttendance.repository.HoursRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;

public class DefaultAdminService implements AdminService {

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private HoursRepository hoursRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Admin login(Login login) {
        return adminRepository.findOneByEmailAndPassword(login.getEmail(), login.getPassword());
    }

    @Override
    public Admin signUp(SignUp signUp) {
        Admin admin = adminRepository.findOneByEmailAndPhone(signUp.getEmail(), signUp.getPhone());
        if(admin == null) {
            admin = new Admin(signUp.getName(), signUp.getSurname(), signUp.getEmail(), signUp.getPassword(), signUp.getPhone());
            return adminRepository.save(admin);
        }
        return null;
    }

    @Override
    public List<Hours> getAll(Login login) {
        Admin admin = this.login(login);
        if(admin != null)
            return hoursRepository.findAll();
        return null;
    }

    @Override
    public HashMap<String, List<Hours>> getAllEmployees(Login login) {
        Admin admin = this.login(login);
        HashMap<String, List<Hours>> emp_hours = new HashMap<>();
        if(admin != null) {
            List<Employee> employees = employeeRepository.findAll();
            if(employees != null)
            for (Employee employee:
                    employees) {
                List<Hours> hours = hoursRepository.findAllByIdEmployeeid(employee.getId());
                emp_hours.put(employee.getEmail(), hours);
            }
        }
        return  emp_hours;
    }
}
