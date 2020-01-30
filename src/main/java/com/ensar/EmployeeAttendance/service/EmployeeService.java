package com.ensar.EmployeeAttendance.service;

import com.ensar.EmployeeAttendance.pojo.Employee;
import com.ensar.EmployeeAttendance.pojo.Login;
import com.ensar.EmployeeAttendance.pojo.SignUp;

import java.util.HashMap;

public interface EmployeeService {
    Employee login(Login login);
    Employee signUp(SignUp signUp);
    HashMap<String, Object> getAllHours(Login login);
    HashMap<String, Object> getHoursPerMonth(Login login, Integer month, Integer year);
}
